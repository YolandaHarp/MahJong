package net;

import game.Mahjong;
import game.Transmit;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private Socket echoSocket = null;
    private EchoServer2c.MyObjectOutputStream out = null;
    private EchoServer2c.MyObjectInputStream in = null;

    public void startClient(String serverHostname, int port) throws IOException {
        try {
            echoSocket = new Socket(serverHostname, port);
            out = new EchoServer2c.MyObjectOutputStream(echoSocket.getOutputStream());
            in = new EchoServer2c.MyObjectInputStream(echoSocket.getInputStream());

            // 创建一个新线程用于接收服务器的消息
            new Thread(() -> {
                try {
                    while (true) {
                        Transmit serverMessage = (Transmit) in.readObject();
                        if (serverMessage == null || serverMessage.equals("Bye.")) {
                            break;
                        }
                        System.out.println("Server: " + serverMessage.getMJ().getNowPlayer());
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            throw new IOException("Unknown host: " + serverHostname, e);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + serverHostname);
            throw e;
        }
    }

    public void sendMessage(Object message) throws IOException {
        if (out != null) {
            out.writeObject(message);
            out.flush();
        } else {
            throw new IOException("Output stream is not initialized.");
        }
    }

    public void stopClient() throws IOException {
        if (out != null) out.close();
        if (in != null) in.close();
        if (echoSocket != null) echoSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the IPV4 address: ");
        String input = scanner.next();
        String serverHostname = input;

        if (args.length > 0) {
            serverHostname = args[0];
        }
        System.out.println("Attempting to connect to host " + serverHostname + " on port 10008.");

        Client client = new Client();
        client.startClient(serverHostname, 10008);

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println("Type Message (\"Bye.\" to quit)");
        //client.sendMessage(new String[]{"*","y","4"});
        //Mahjong.getMJ().setNowPlayer(3);
        //client.sendMessage(new Transmit());
        while ((userInput = stdIn.readLine()) != null) {
            client.sendMessage(userInput);
            if (userInput.equals("Bye.")) {
                break;
            }
        }

        client.stopClient();
        stdIn.close();
        scanner.close();
    }
}
