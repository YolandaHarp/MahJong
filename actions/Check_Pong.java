package actions;

import model.Cards_in_hand;
import model.Discard_Pile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Check_Pong implements Find_Action , Serializable {
    protected ArrayList<Integer> availableCards;
    Cards_in_hand cards;
    protected Integer actionCard; // The card ready to Pong
    Check_Pong(Cards_in_hand cards) {
        this.cards = cards;
        availableCards =new ArrayList<>();
    }

    protected static int[] countList(ArrayList<Integer> cardList){
        // Count for the cards in hand

        int[] countList = new int[34];
        for (int num : cardList) {
            if(num!=34) {
                countList[num]++;
            }
        }
        return countList;
    }

    protected static ArrayList<Integer> findSameCards(ArrayList<Integer> cardList, int n) {
        // Find cards how have more than n
        // Use for Pong and Kong

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

    // Null Object pattern
    // "n" is used for multiple choice
    @Override
    public void removeCard(int n) {
        Discard_Pile.getDiscard().remove();
        cards.removeCard(new ArrayList<>(Arrays.asList(actionCard,actionCard)),actionCard);
        cards.getPutAway().addPongCards();
    }

}
