package model;

import java.util.ArrayList;

public class Discard_Pile {
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    private static Discard_Pile discard=new Discard_Pile();

    private Discard_Pile() {
    }
    public static Discard_Pile getDiscard(){
        return discard;
    }

    void add(int card){
        cards.add(card);
    }
    void remove(){
        cards.remove(cards.size() - 1);
    }
    int getLast(){
        return cards.get(cards.size() - 1);
    }
    void clear(){
        cards = new ArrayList<Integer>();
    }
    ArrayList<Integer> show(){
        return new ArrayList<Integer>(cards);
    }
}
