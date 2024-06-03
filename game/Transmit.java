package game;

import model.Discard_Pile;
import model.Stack_of_cards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;

public class Transmit implements Serializable {
    private Stack_of_cards stack;
    private Mahjong MJ;
    private ArrayList<Integer> Discards;
    private int playerNum;
    public Transmit(){
        stack= Stack_of_cards.getStack();
        MJ=Mahjong.getMJ();
        Discards=Discard_Pile.getDiscard().show();
    }
    public Stack_of_cards getStack() {
        return stack;
    }
    public Mahjong getMJ(){
        return MJ;
    }
    public ArrayList<Integer> getDiscards() {
        return Discards;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
    public int getPlayerNum(){
        return playerNum;
    }
}
