package MainScreen;

import game.Mahjong;
import net.Client;
import net.EchoServer2c;
import net.GetIP;

import java.io.IOException;

import static GUI.CardsController.setString;

// Decorator pattern
public class HostGame extends StartGame{
    static int players = 0;
    @Override
    void mode() throws IOException {
        players = 0;
        String ip= GetIP.ip();
        setString(ip);
        // Start the server

        EchoServer2c.getServer().startServer(10008);

        // Waiting for three player join in
        while(players!=3&&EchoServer2c.getServer().getServerContinue()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Create client, join into the server and initialize the game
        if(EchoServer2c.getServer().getServerContinue()) {
            try {
                Client.getClient().startClient(ip, 10008);
                Mahjong.getMJ().initializeGame(true);
            } catch (IOException e) {
                new MainScreen().startMainScreen();
            }
        }else{
            new MainScreen().startMainScreen();
        }
    }
    public static void addPlayer(){
        players++;
    }
}
