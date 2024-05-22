package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Check_ConcealedKong extends Check_ExposedKong implements Find_Action {
    private ArrayList<Integer> availableCards2 = new ArrayList<>();
    boolean hand;

    Check_ConcealedKong(Cards_in_hand cards) {
        super(cards);
    }
    @Override
    public void findCards(){
        availableCards = findSameCards(cards.showCards(), 4);
        for(int i:cards.getPutAway().getPongIndex()){
            availableCards2.add(cards.getPutAway().show().get(i).get(0));
        }
    }
    @Override
    public void checkCard(int n){
        if(!availableCards.isEmpty()||!availableCards2.isEmpty()){
            cards.setStatus(4);
        }
    }
    @Override
    public ArrayList<Integer> getAvailableCards() {
        ArrayList<Integer> arrayList=new ArrayList<>(availableCards);
        arrayList.addAll(availableCards2);
        return arrayList;
    }

    @Override
    public void removeCard(int n){
        if(n>=availableCards.size()){
            cards.getPutAway().addKongCard(n-availableCards.size());
        }else {
            actionCard = availableCards.get(n);
            super.removeCard(n);
        }
    }
}
