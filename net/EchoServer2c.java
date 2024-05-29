package net;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class EchoServer2c {
    protected static boolean serverContinue = true;
    protected static ArrayList<Socket> clientSockets = new ArrayList<>();

    public static void startServer(int port) throws IOException {
        System.out.println(GetIP.ip());
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Connection Socket Created");
            try {
                while (serverContinue) {
                    System.out.println("Waiting for Connection");
                    Socket socket = serverSocket.accept();
                    handleClient(socket);
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.err.println("Could not close port: " + port);
                }
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        clientSockets.add(clientSocket);
        new Thread(() -> {
            try {
                System.out.println("New Communication Thread Started");
                MyObjectOutputStream out = new MyObjectOutputStream(clientSocket.getOutputStream());
                MyObjectInputStream in = new MyObjectInputStream(clientSocket.getInputStream());

                Object inputLine;

                while ((inputLine = in.readObject()) != null) {
                    //System.out.println("Server: " + inputLine);
                    broadcastMessage(inputLine);

                    if (inputLine.equals("Bye."))
                        break;

                    if (inputLine.equals("End Server.")) {
                        serverContinue = false;
                        break;
                    }
                }

                out.close();
                in.close();
                clientSocket.close();
                clientSockets.remove(clientSocket);
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Problem with Communication Server");
            }
        }).start();
    }

    private static void broadcastMessage(Object message) {
        for (Socket socket : clientSockets) {
            try {
                MyObjectOutputStream out = new MyObjectOutputStream(socket.getOutputStream());
                out.writeObject(message);
            } catch (IOException e) {
                System.err.println("Problem with broadcasting message");
            }
        }
    }

    static class MyObjectOutputStream extends ObjectOutputStream {
        public MyObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            super.reset();
        }
    }

    static class MyObjectInputStream extends ObjectInputStream {
        public MyObjectInputStream(InputStream in) throws IOException {
            super(in);
        }

        @Override
        protected void readStreamHeader() throws IOException {
            // No operation
        }
    }
    public static void main(String[] args) throws IOException {
        startServer(10008);
    }
}
