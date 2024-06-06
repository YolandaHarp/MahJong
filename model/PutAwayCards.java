package model;

import java.io.Serializable;
import java.util.ArrayList;

// Singleton pattern
public class PutAwayCards implements Serializable {
    private ArrayList<ArrayList<Integer>> putAwayCard= new ArrayList<>();
    private ArrayList<Integer> pongIndex =new ArrayList<>();
    protected void add(ArrayList<Integer> cards){
        putAwayCard.add(cards);
    }
    public void addPongCards(){
        // Record card has already Ponged
        // Use it to judge whether cna Kong

        pongIndex.add(putAwayCard.size()-1);
    }
    protected void addKongCard(int i){
        // Situation from a Pong to a Kong

        int j =pongIndex.get(i);
        putAwayCard.get(j).add(putAwayCard.get(j).get(0));
        pongIndex.remove(i);
    }
    public ArrayList<Integer> getPongIndex(){
        return new ArrayList<>(pongIndex);
    }

    public ArrayList<ArrayList<Integer>> show(){
        return new ArrayList<ArrayList<Integer>>(putAwayCard);
    }
}
