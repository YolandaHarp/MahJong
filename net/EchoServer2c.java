package net;

import MainScreen.HostGame;
import game.Transmit;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class EchoServer2c {
    private static EchoServer2c server = new EchoServer2c();
    private boolean serverContinue = true;
    protected ArrayList<ObjectOutputStream> clientSockets=new ArrayList<>();
    private EchoServer2c(){}
    public static EchoServer2c getServer(){
        return server;
    }

    public void startServer(int port)  {
        serverContinue = true;
        new Thread(()->{
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.setSoTimeout(1000);
                System.out.println("Connection Socket Created");
                while (serverContinue) {
                    try {
                        Socket socket = serverSocket.accept();
                        handleClient(socket);
                    } catch (SocketTimeoutException e) {
                    }
                }
                serverSocket.close();
                System.out.println("Sever close");
                clientSockets.clear();
            } catch (IOException e) {
                serverContinue=false;
                System.err.println("Could not listen on port: " + port);
            }
        }).start();
    }

    private void handleClient(Socket clientSocket) {
        new Thread(() -> {
            try {
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
                    //System.out.println("Server: " + inputLine);
                    broadcastMessage(inputLine,out);

                }
                out.close();
                in.close();
                clientSocket.close();
                serverContinue=false;
            } catch (IOException | ClassNotFoundException e) {
                broadcastMessage(null,null);
                serverContinue=false;
            }

        }).start();
    }

    private void broadcastMessage(Object message,ObjectOutputStream o) {
        for (int i=0;i<clientSockets.size();i++) {
            ObjectOutputStream out = clientSockets.get(i);
            if (out != o) {
                try {
                    Transmit t=null;
                    if(message!=null) {
                        t = (Transmit) message;
                        t.setPlayerNum(i);
                    }
                    out.reset();
                    out.writeObject(t);
                } catch (IOException e) {
                    //System.err.println("Problem with broadcasting message");
                }
            }
        }
    }
    public boolean getServerContinue(){
        return serverContinue;
    }


    //public static void main(String[] args) throws IOException {
      //  startServer(10008);
    //}

}
