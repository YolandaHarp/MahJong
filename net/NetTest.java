package net;

import game.Mahjong;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NetTest {


    @Test
    public void connectTest() throws IOException, InterruptedException {
        EchoServer2c.getServer().startServer(10008);
        Client.getClient().startClient(GetIP.ip(),10008);
        Client.getClient().startClient(GetIP.ip(),10008);
        Client.getClient().startClient(GetIP.ip(),10008);
        Client.getClient().sendMessage();
        Thread.sleep(2500);
        assertEquals(Mahjong.getMJ().getPlayerNum(), 1);
        }
}
