package actions;

import model.Cards_in_hand;

import java.io.Serializable;
import java.util.*;

import static actions.Check_Pong.*;

// Memento pattern
public class Check_Win implements Find_Action, Serializable {
    private ArrayList<Integer> winCards ;
    private int[] cardCount;
    private int[] cardCountOrigin;
    private int jokerInHandOrigin;
    private int jokerInHand;
    private ArrayList<Integer> check;
    Cards_in_hand cards;

    Check_Win(Cards_in_hand cards) {
        // Initialize

        this.cards = cards;
        winCards =new ArrayList<>();
    }

    boolean checkWin(int c) {
        check = new ArrayList<Integer>(cards.showCards());

        // Deal with some special situation (after Kong)
        if(cards.showCards().size()%3==2){
            check.remove(check.size()-1);
        }
        check.add(c);
        Collections.sort(check);
        cardCountOrigin=countList(check);
        findJokerNum();

        // Special type for win
        if(Check_Other_Win.getOtherWin().check(cardCountOrigin,jokerInHandOrigin)){
            return true;
        }

        // Normal type
        // Find pairs (3 situation about joker)
        for (int i=0; i<=33;i++) {
            if(cardCountOrigin[i]>=2){
                findTwice(i,false);
                if (allUsed()) {
                    return true;
                }
            }else if(cardCountOrigin[i]==1&&jokerInHandOrigin>=1){
                findTwice(i,true);
                if (allUsed()) {
                    return true;
                }
            }
        }
        if(jokerInHandOrigin>=2){
            findTwice(100,true);
            if (allUsed()) {
                return true;
            }
        }
        return false;
    }

    boolean allUsed(){
        // Whether all cards are combined

        int remainingCards=0;
        for (int i : cardCount) {
            remainingCards+=i;
        }
        return remainingCards==0;
    }

    void find_triplet(){
        // Find three same card in player hand

        for(int i=0; i<=33;i++){
            if(cardCount[i]>=3){
                cardCount[i]-=3;
            }
        }
    }

    void find_sequence() {
        // Find three card which can combine as a sequence in player hand

        for (int i = 0; i <27; i++) {
            if (i % 9 < 7) {
                while (cardCount[i] > 0 && cardCount[i + 1] > 0 && cardCount[i + 2] > 0) {
                    cardCount[i]--;
                    cardCount[i + 1]--;
                    cardCount[i + 2]--;
                }
            }
        }
    }

    void checkJokers(){
        // Use card that cannot be combined to combine with joker

        for (int i = 0; i <= 33&&jokerInHand>0; i++){
            if(cardCount[i]==2){
                cardCount[i]-=2;
                jokerInHand--;
            }else if(i < 27 && i % 9 < 7) {
                if (cardCount[i] > 0 && cardCount[i + 1] > 0) {
                    cardCount[i]--;
                    cardCount[i + 1]--;
                    jokerInHand--;
                } else if (cardCount[i] > 0 && cardCount[i + 2] > 0) {
                    cardCount[i]--;
                    cardCount[i + 2]--;
                    jokerInHand--;
                }
            }
        }
        if(jokerInHand>=2){
            for(int i = 0; i <= 33&&jokerInHand>=2;i++){
                if(cardCount[i]>0){
                    cardCount[i]--;
                    jokerInHand-=2;
                }
            }
        }
    }

    void find_triplet_and_sequence(int pair,boolean b,boolean hasJoker){
        // Find triple and sequence without joker

        cardCount=cardCountOrigin.clone();
        jokerInHand=jokerInHandOrigin;
        if(pair>33){//two joker
            jokerInHand-=2;
        }else if(hasJoker){
            jokerInHand--;
            cardCount[pair]--;
        }else{
            cardCount[pair]-=2;
        }
        if(b) {
            find_sequence();
            find_triplet();
        }else{
            find_triplet();
            find_sequence();
        }
        checkJokers();
    }

    void findTwice(int pair,boolean hasJoker){
        // Exchange the order of find triple and find sequence

        find_triplet_and_sequence(pair,true,hasJoker);
        if (!allUsed()) {
            find_triplet_and_sequence(pair,false,hasJoker);
        }
    }

    void findJokerNum(){
        // Find the number of joker in player hand

        jokerInHandOrigin=0;
        for(int i:check){
            if(i==34){
                jokerInHandOrigin++;
            }
        }
    }

    ArrayList<Integer> getWinCards(){
        return new ArrayList<Integer>(winCards);
    }

    @Override
    public void findCards() {
        winCards.clear();
        for (int i = 0; i < 35; i++) {
            if (checkWin(i)) {
                winCards.add(i);
            }
        }
    }

    @Override
    public void checkCard(int n) {
        if(winCards.contains(n)){
            cards.setStatus(0);
        }
    }

    // Null Object pattern
    @Override
    public void removeCard(int n) {
    }
}
