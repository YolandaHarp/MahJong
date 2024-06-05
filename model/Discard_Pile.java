package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Discard_Pile implements Serializable {
    private Stack<Integer> cards = new Stack<Integer>();
    private static Discard_Pile discard=new Discard_Pile();

    private Discard_Pile() {
    }
    public static Discard_Pile getDiscard(){
        return discard;
    }

    void add(int card){
        cards.push(card);
    }
    void remove(){
        cards.pop();
    }
    public int getLast(){
        return cards.peek();
    }
    public void clear(){
        cards = new Stack<Integer>();
    }
    public Iterator<Integer> show(){
        return cards.iterator();
    }
    public void setDiscard(Discard_Pile d){
        discard=d;
    }
}
