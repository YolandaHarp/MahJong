package model;

import java.util.*;

public class Cards_in_hand {
    String[] table = new String[]{"一筒","二筒","三筒","四筒","五筒","六筒","七筒","八筒","九筒",
            "一条","二条","三条","四条","五条","六条","七条","八条","九条",
            "一万","二万","三万","四万","五万","六万","七万","八万","九万","东","南","西",
            "北","中","発","白","混"};
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    private PutAwayCards putAwayCard=new PutAwayCards();
    private Actions action;
    private boolean[] status =new boolean[5];//在这个后面问
    private boolean next;

    public Cards_in_hand() {
        action=new Actions(this);
        for (int i = 0; i <= 12; i++) {
            drawCard();
        }
        sortCards();
        action.findCardsAction();
    }

    void sortCards() {
        Collections.sort(cards);
    }

    void drawCard() {
        int pick= Stack_of_cards.getStack().pick();
        cards.add(pick);
        action.checkCardAction_draw(pick);
    }

    void drawCardFromBottom() {
        int pick= Stack_of_cards.getStack().pickFromBottom();
        cards.add(pick);
        action.checkCardAction_draw(pick);
    }

    void playCard(int n) {//这里的n是第几张牌
        int card=cards.get(n);
        Discard_Pile.getDiscard().add(n);
        cards.remove(n);
        sortCards();
        action.findCardsAction();
    }

    public ArrayList<Integer> showCards() {
        return new ArrayList<Integer>(cards);
    }


    void removeCard(ArrayList<Integer> n){
        Collections.sort(n);
        for(Integer i:n){
            cards.remove(i);
        }
        putAwayCard.add(n);
    }
    public PutAwayCards getPutAway(){
        return putAwayCard;
    }
    void checkCards(){
        clearStatus();
        action.checkCardAction();
    }

    Actions getAction(){
        return action;
    }
    void setStatus(int n){
        status[n]=true;
    }
    public boolean getStatus(int n){
        return status[n];
    }
    public void clearStatus(){
        status =new boolean[5];
    }
    public boolean getNext(){
        return next;
    }
    public void setNext() {
        next=!next;
    }
    public void setCards(ArrayList<Integer> c){
        cards=c;
    }
    public void wenzi(){
        for(int i:cards){
            System.out.print(table[i]+" ");
        }
        System.out.println();
    }
    public String get(int n){
        return table[n];
    }


}
