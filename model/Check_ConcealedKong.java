package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Check_ConcealedKong extends Check_ExposedKong implements Find_Action {
    private ArrayList<Integer> availableCards2 = new ArrayList<>();

    Check_ConcealedKong(Cards_in_hand cards) {
        super(cards);
    }
    @Override
    public void findCards(){
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
    @Override
    public ArrayList<Integer> getAvailableCards() {
        ArrayList<Integer> arrayList=new ArrayList<>(availableCards);
        arrayList.addAll(availableCards2);
        return arrayList;
    }

    @Override
    public void removeCard(int n){
        if(n>=availableCards.size()){
            cards.removeCKongCard(availableCards2.get(n-availableCards.size()),n-availableCards.size());
        }else {
            actionCard = availableCards.get(n);
            cards.setcKongNum();
            Discard_Pile.getDiscard().remove();
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
