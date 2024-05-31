package net;

import game.Mahjong;
import game.Transmit;
import model.Discard_Pile;
import model.Stack_of_cards;

import java.io.*;
import java.net.*;

import static GUI.CardsController.updateGame;

public class Client {
    private static Client client = new Client();
    private Socket echoSocket = null;
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;
    private Client(){}
    public static Client getClient(){
        return client;
    }

    public void startClient(String serverHostname, int port) throws IOException {
        try {
            echoSocket = new Socket(serverHostname, port);
            out = new ObjectOutputStream(echoSocket.getOutputStream());
            in = new ObjectInputStream(echoSocket.getInputStream());
            // 创建一个新线程用于接收服务器的消息
            new Thread(() -> {
                receiveMessage();
            }).start();

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            throw new IOException("Unknown host: " + serverHostname, e);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + serverHostname);
            throw e;
        }
    }
    private void receiveMessage(){
        try {
            while (true) {
                Object serverMessage=in.readObject();
                if (serverMessage == null) {
                    continue;
                }
                Transmit transmite = (Transmit) serverMessage;
                Mahjong.getMJ().setMJ(transmite.getMJ());
                Mahjong.getMJ().setPlayerNum(transmite.getPlayerNum());
                Discard_Pile.getDiscard().setDiscard(transmite.getDiscards());
                Stack_of_cards.getStack().setStack(transmite.getStack());
                updateGame(false);
                Mahjong.getMJ().startOnlineGame();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() throws IOException {
        if (out != null) {
            Transmit t=new Transmit();
            out.reset();
            out.writeObject(t);
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

    /*public static void main(String[] args) throws IOException {
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
    }*/
}
