package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PutAwayCards implements Serializable {
    private ArrayList<ArrayList<Integer>> putAwayCard= new ArrayList<>();
    private ArrayList<Integer> pongIndex =new ArrayList<>();
    protected void add(ArrayList<Integer> cards){
        putAwayCard.add(cards);
    }
    protected void addPongCards(){
        pongIndex.add(putAwayCard.size()-1);
    }
    protected void addKongCard(int i){
        int j =pongIndex.get(i);
        putAwayCard.get(j).add(putAwayCard.get(j).get(0));
        pongIndex.remove(i);
    }
    protected ArrayList<Integer> getPongIndex(){
        return new ArrayList<>(pongIndex);
    }
    public ArrayList<ArrayList<Integer>> show(){
        return new ArrayList<ArrayList<Integer>>(putAwayCard);
    }
}
