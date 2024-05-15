package net;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class EchoServer2c extends Thread {
    protected static boolean serverContinue = true;
    protected Socket clientSocket;
    protected static ArrayList<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(10008);
            System.out.println("Connection Socket Created");
            try {
                while (serverContinue) {
                    System.out.println("Waiting for Connection");
                    Socket socket = serverSocket.accept();
                    new EchoServer2c(socket);
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10008.");
            System.exit(1);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Could not close port: 10008.");
                System.exit(1);
            }
        }
    }

    private EchoServer2c(Socket clientSoc) {
        clientSocket = clientSoc;
        clientSockets.add(clientSocket);
        start();
    }

    public void run() {
        System.out.println("New Communication Thread Started");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);
                broadcastMessage(inputLine);

                if (inputLine.equals("Bye."))
                    break;

                if (inputLine.equals("End Server."))
                    serverContinue = false;
            }

            out.close();
            in.close();
            clientSocket.close();
            clientSockets.remove(clientSocket);
        } catch (IOException e) {
            System.err.println("Problem with Communication Server");
            System.exit(1);
        }
    }

    private void broadcastMessage(String message) {
        for (Socket socket : clientSockets) {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(message);
            } catch (IOException e) {
                System.err.println("Problem with broadcasting message");
            }
        }
    }
}
