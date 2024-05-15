import java.net.*;
import java.io.*;
import java.util.*;

public class connectTest1 {
    protected static boolean serverContinue = true;
    protected static ArrayList<PrintWriter> clientStreams = new ArrayList<>();
    protected static ArrayList<String> usernames = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(10008);
            System.out.println("Connection Socket Created");
            while (serverContinue) {
                System.out.println("Waiting for Connection");
                Socket clientSocket = serverSocket.accept();
                new ServerThread(clientSocket).start();
            }

            // Start a new thread to handle console input
            new Thread(() -> {
                mainThread();
            }).start();
        } catch (IOException e) {
            System.err.println("Accept failed.");
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

    private static class ServerThread extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ServerThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            System.out.println("New Communication Thread Started");
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String username = "User" + (usernames.size() + 1); // Generate a username for the client
                usernames.add(username);
                clientStreams.add(out); // Add client's output stream to the ArrayList

                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    System.out.println("[" + username + "]: " + inputLine);

                    if (inputLine.equals("Bye.")) {
                        break;
                    }

                    if (inputLine.equals("End Server.")) {
                        serverContinue = false;
                        break;
                    }

                    // Broadcast the message to all clients
                    broadcastMessage("[" + username + "]: " + inputLine);
                }

                // Remove client's output stream from the ArrayList when client disconnects
                clientStreams.remove(out);
                usernames.remove(username);

                out.close();
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Problem with Communication Server");
                System.exit(1);
            }
        }
    }

    private static void broadcastMessage(String message) {
        // Broadcast the message to all clients
        for (PrintWriter stream : clientStreams) {
            stream.println(message);
        }
    }

    public static void sendToAll(String message) {
        for (PrintWriter stream : clientStreams) {
            stream.println("[Server]: " + message);
        }
    }

    public static void mainThread() {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;
        try {
            while (serverContinue) {
                inputLine = consoleReader.readLine();
                if (inputLine.equals("End Server.")) {
                    serverContinue = false;
                    break;
                }
                broadcastMessage("[Server]: " + inputLine);
            }
        } catch (IOException e) {
            System.err.println("Error reading from console.");
        }
    }
}
