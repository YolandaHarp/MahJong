package model;

import java.util.ArrayList;

public class PutAwayCards {
    private ArrayList<ArrayList<Integer>> putAwayCard= new ArrayList<>();
    private ArrayList<Integer> pongIndex =new ArrayList<>();
    void add(ArrayList<Integer> cards){
        putAwayCard.add(cards);
    }
    void addPongCards(){
        pongIndex.add(putAwayCard.size()-1);
    }
    void addKongCard(int i){
        int j =pongIndex.get(i);
        putAwayCard.get(j).add(putAwayCard.get(j).get(0));
        pongIndex.remove(i);
    }
    ArrayList<Integer> getPongIndex(){
        return new ArrayList<>(pongIndex);
    }
    public ArrayList<ArrayList<Integer>> show(){
        return new ArrayList<ArrayList<Integer>>(putAwayCard);
    }
}
