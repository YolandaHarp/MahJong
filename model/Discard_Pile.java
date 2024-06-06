package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

// Singleton pattern
public class Discard_Pile implements Serializable {
    private Stack<Integer> cards = new Stack<Integer>();
    private static Discard_Pile discard=new Discard_Pile();

    private Discard_Pile() {
    }
    public static Discard_Pile getDiscard(){
        return discard;
    }

    void add(int card){
        // Add one card into discard pile

        cards.push(card);
    }
    public void remove(){
        // Remove last card put into the discard pile

        cards.pop();
    }
    public int getLast(){
        // Get last card put into the discard pile

        return cards.peek();
    }
    public void clear(){
        // Clear the discard pile

        cards = new Stack<Integer>();
    }
    public Iterator<Integer> show(){
        // Show all cards in the discard pile

        return cards.iterator();
    }
    public void setDiscard(Discard_Pile d){
        discard=d;
    }
}
