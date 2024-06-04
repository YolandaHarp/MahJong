package MainScreen;

import game.Mahjong;

import java.io.IOException;

class LocalGame extends StartGame{
    @Override
    void mode() throws IOException {
        Mahjong.getMJ().startLocalGame();
    }
}
