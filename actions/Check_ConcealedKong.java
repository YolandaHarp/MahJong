package actions;

import model.Cards_in_hand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Check_ConcealedKong extends Check_ExposedKong implements Find_Action, Serializable {
    // One situation for Kong
    // Player have a 4 same card in hand

    private ArrayList<Integer> availableCards2 = new ArrayList<>();

    Check_ConcealedKong(Cards_in_hand cards) {
        super(cards);
    }
    @Override
    public void findCards(){
        // Two situation 1. have 4 same cards 2. have a Pong and get the same card
        availableCards = findSameCards(cards.showCards(), 4);
        availableCards2 = new ArrayList<>();
        for(int i:cards.getPutAway().getPongIndex()){
            int j=cards.getPutAway().show().get(i).get(0);
            if(cards.showCards().contains(j)) {
                availableCards2.add(j);
            }
        }
    }
    @Override
    public void checkCard(int n){
        if(!availableCards.isEmpty()||checkContain()){
            cards.setStatus(4);
        }
    }

    public ArrayList<Integer> getAvailableCards() {
        ArrayList<Integer> arrayList=new ArrayList<>(availableCards);
        arrayList.addAll(availableCards2);
        return arrayList;
    }

    @Override
    public void removeCard(int n){
        // Two situation 1. remove 4 cards from player hand 2. remove one card and add it to the Pong

        if(n>=availableCards.size()){
            cards.removeCKongCard(availableCards2.get(n-availableCards.size()),n-availableCards.size());
        }else {
            actionCard = availableCards.get(n);
            cards.setcKongNum();
            cards.removeCard(new ArrayList<>(Arrays.asList(actionCard,actionCard,actionCard,actionCard)));
        }
    }
    boolean checkContain(){
        for(int i:availableCards2){
            if(cards.showCards().contains(i)){
                return true;
            }
        }
        return false;
    }
}
