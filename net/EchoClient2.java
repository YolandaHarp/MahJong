package net;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the IPV4 address: ");
        String input = scanner.next();
        String serverHostname = new String (input);

        if (args.length > 0)
            serverHostname = args[0];
        System.out.println ("Attemping to connect to host " +
                serverHostname + " on port 10008.");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, 10008);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + serverHostname);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println ("Type Message (\"Bye.\" to quit)");

        // 创建一个新线程用于接收服务器的消息
        BufferedReader finalIn = in;
        new Thread(() -> {
            try {
                while (true) {
                    String serverMessage = finalIn.readLine();
                    if (serverMessage == null || serverMessage.equals("Bye.")) {
                        break;
                    }
                    System.out.println("Server: " + serverMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // 主线程用于发送消息给服务器
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            if (userInput.equals("Bye.")) {
                break;
            }
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
