package game;

import model.Discard_Pile;
import model.Stack_of_cards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;

// Proxy pattern
// Observer pattern
// Transfer object pattern
public class Transmit implements Serializable {
    // Use to share all the data to the client

    private Stack_of_cards stack;
    private Mahjong MJ;
    private Discard_Pile Discards;
    private int playerNum;
    public Transmit(){
        stack= Stack_of_cards.getStack();
        MJ=Mahjong.getMJ();
        Discards=Discard_Pile.getDiscard();
    }
    public Stack_of_cards getStack() {
        return stack;
    }
    public Mahjong getMJ(){
        return MJ;
    }
    public Discard_Pile getDiscards() {
        return Discards;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
    public int getPlayerNum(){
        return playerNum;
    }
}
