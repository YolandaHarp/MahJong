package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Discard_Pile implements Serializable {
    String[] table = new String[]{"一筒","二筒","三筒","四筒","五筒","六筒","七筒","八筒","九筒",
            "一条","二条","三条","四条","五条","六条","七条","八条","九条",
            "一万","二万","三万","四万","五万","六万","七万","八万","九万","东","南","西",
            "北","中","発","白","混"};
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
    public void clear(){
        cards = new ArrayList<Integer>();
    }
    public ArrayList<Integer> show(){
        return new ArrayList<Integer>(cards);
    }
    public void wenzi(){
        for(int i:cards){
            System.out.print(table[i]+" ");
        }
        System.out.println();
    }
    public void setDiscard(ArrayList<Integer> c){
        cards=c;
    }
}
