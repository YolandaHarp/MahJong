package MainScreen;

import game.Mahjong;

import java.io.IOException;

// Decorator pattern
class LocalGame extends StartGame{
    @Override
    void mode() throws IOException {
        // Start local game

        Mahjong.getMJ().startLocalGame();
    }
}
