package net;

import MainScreen.HostGame;
import game.Transmit;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

// Singleton pattern
public class EchoServer2c {
    private static EchoServer2c server = new EchoServer2c();
    private boolean serverContinue = true;
    protected ArrayList<ObjectOutputStream> clientSockets=new ArrayList<>();
    private EchoServer2c(){}
    public static EchoServer2c getServer(){
        return server;
    }

    public void startServer(int port)  {
        // Start the server

        serverContinue = true;
        new Thread(()->{
            try {
                ServerSocket serverSocket = new ServerSocket(port);

                // In order to properly close the client
                serverSocket.setSoTimeout(1000);
                System.out.println("Connection Socket Created");
                while (serverContinue) {
                    try {
                        Socket socket = serverSocket.accept();
                        handleClient(socket);
                    } catch (SocketTimeoutException e) {
                    }
                }

                // Stop the server after end the loop
                serverSocket.close();
                System.out.println("Sever close");
                clientSockets.clear();
            } catch (IOException e) {

                // This IP address has been a server
                serverContinue=false;
                System.err.println("Could not listen on port: " + port);
            }
        }).start();
    }

    private void handleClient(Socket clientSocket) {
        new Thread(() -> {
            try {

                // Only can have 4 players
                if (clientSockets.size() == 4) {
                    clientSocket.close();
                    return;
                }
                HostGame.addPlayer();
                System.out.println("New Communication Thread Started");
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                clientSockets.add(out);

                Object inputLine;
                while ((inputLine = in.readObject()) != null) {
                    broadcastMessage(inputLine,out);
                }
                out.close();
                in.close();
                clientSocket.close();
                serverContinue=false;
            } catch (IOException | ClassNotFoundException e) {

                // When one player disconnect let other player know
                broadcastMessage(null,null);
                serverContinue=false;
            }

        }).start();
    }

    // Send to all client
    private void broadcastMessage(Object message,ObjectOutputStream o) {
        for (int i=0;i<clientSockets.size();i++) {
            ObjectOutputStream out = clientSockets.get(i);
            if (out != o) {
                try {
                    Transmit t=null;
                    if(message!=null) {
                        t = (Transmit) message;

                        // Declare the number of every player
                        t.setPlayerNum(i);
                    }
                    out.reset();
                    out.writeObject(t);
                } catch (IOException e) {
                }
            }
        }
    }

    public boolean getServerContinue(){
        return serverContinue;
    }

    public void closeServer(){
        // Close the server

        serverContinue=false;
    }


    //public static void main(String[] args) throws IOException {
      //  startServer(10008);
    //}

}
