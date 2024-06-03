package model;

import java.io.Serializable;
import java.util.*;

import static model.Check_Pong.*;

public class Check_Win implements Find_Action, Serializable {
    private ArrayList<Integer> winCards ;
    private int[] cardCount;
    private int[] cardCountOrigin;
    private int jokerInHandOrigin;
    private int jokerInHand;
    private ArrayList<Integer> check;
    Cards_in_hand cards;

    Check_Win(Cards_in_hand cards) {
        this.cards = cards;
        winCards =new ArrayList<>();
    }
    boolean checkWin(int c) {
        check = new ArrayList<Integer>(cards.showCards());
        if(cards.showCards().size()%3==2){
            check.remove(check.size()-1);
        }
        check.add(c);
        Collections.sort(check);
        cardCountOrigin=countList(check);
        findJokerNum();
        if(Check_Other_Win.getOtherWin().check(cardCountOrigin,jokerInHandOrigin)){
            return true;
        }
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
        int remainingCards=0;
        for (int i : cardCount) {
            remainingCards+=i;
        }
        return remainingCards==0;
    }
    void find_triplet(){
        for(int i=0; i<=33;i++){
            if(cardCount[i]>=3){
                cardCount[i]-=3;
            }
        }
    }
    void find_sequence() {
        for (int i = 0; i <27; i++) {
            if (i % 9 < 7) { // 尝试将第i张牌作为顺子
                while (cardCount[i] > 0 && cardCount[i + 1] > 0 && cardCount[i + 2] > 0) {
                    cardCount[i]--;
                    cardCount[i + 1]--;
                    cardCount[i + 2]--;
                }
            }
        }
    }
    void checkJokers(){
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
        find_triplet_and_sequence(pair,true,hasJoker);
        if (!allUsed()) {
            find_triplet_and_sequence(pair,false,hasJoker);
        }
    }
    void findJokerNum(){
        jokerInHandOrigin=0;
        for(int i:check){
            if(i==34){
                jokerInHandOrigin++;
            }
        }
    }
    public boolean ifWin(int n){
        return winCards.contains(n);
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
    @Override
    public void removeCard(int n) {
    }
}
