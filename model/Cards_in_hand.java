package model;

import actions.Actions;

import java.io.Serializable;
import java.util.*;

// Proxy pattern
public class Cards_in_hand implements Serializable {
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    private PutAwayCards putAwayCard=new PutAwayCards();
    private Actions action;
    private int cKongNum;
    private boolean[] status =new boolean[5];
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

    public void drawCard() {
        // Get one card from the stack

        int pick= Stack_of_cards.getStack().pick();
        cards.add(pick);
        action.checkCardAction_draw(pick);
    }

    public void playCard(int n) {
        // Player play a card and put it in the discard pile

        int card=cards.get(n);
        Discard_Pile.getDiscard().add(card);
        cards.remove(n);
        sortCards();
        action.findCardsAction();
    }

    public ArrayList<Integer> showCards() {
        return new ArrayList<Integer>(cards);
    }

    // Show some card to other player (Chow, Pong, Kong)
    public void removeCard(ArrayList<Integer> n, int k){
        for(Integer i:n) {
            cards.remove(i);
        }
        n.add(k);
        Collections.sort(n);
        putAwayCard.add(n);
    }

    public void removeCard(ArrayList<Integer> n){
        for(Integer i:n) {
            cards.remove(i);
        }
        n.remove(0);
        n.add(100);
        putAwayCard.add(n);
    }

    public void removeCKongCard(Integer i, int j){
        cards.remove(i);
        putAwayCard.addKongCard(j);
    }

    public PutAwayCards getPutAway(){
        return putAwayCard;
    }

    public Actions getAction(){
        return action;
    }

    public void setStatus(int n){
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

    public void setNext(boolean b) {
        next=b;
    }

    public void setCards(ArrayList<Integer> c){
        cards=c;
    }

    public void setcKongNum(){
        cKongNum++;
    }

    public boolean canWinByOther(){
        // If player have Chow, Pong or Kong, they can not win by other's card

        return cKongNum>=getPutAway().show().size();
    }

    public void addCard(int i){
        cards.add(i);
        }

}
