package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Check_Pong implements Find_Action {
    protected ArrayList<Integer> availableCards;
    Cards_in_hand cards;
    protected Integer actionCard;
    Check_Pong(Cards_in_hand cards) {
        this.cards = cards;
        availableCards =new ArrayList<>();
    }
    static int[] countList(ArrayList<Integer> cardList){
        int[] countList = new int[34];
        for (int num : cardList) {
            if(num!=34) {
                countList[num]++;
            }
        }
        return countList;
    }
    static ArrayList<Integer> findSameCards(ArrayList<Integer> cardList, int n) {
        int[] countList = countList(cardList);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<=33;i++) {
            if (countList[i] >= n) {
                result.add(i);
            }
        }
        return result;
    }
    @Override
    public void findCards(){
        availableCards = findSameCards(cards.showCards(), 2);
    }
    @Override
    public void checkCard(int n) {
        if(availableCards.contains(n)) {
            actionCard = n;
            cards.setStatus(2);
        }
    }

    @Override
    public void removeCard(int n) {
        Discard_Pile.getDiscard().remove();
        cards.removeCard(new ArrayList<>(Arrays.asList(actionCard,actionCard)),actionCard);
        cards.getPutAway().addPongCards();
    }
    ArrayList<Integer> getAvailableCards(){
        return new ArrayList<>(availableCards);
    }

}
