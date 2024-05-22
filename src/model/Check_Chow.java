package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Check_Chow implements Find_Action {
    private Map<Integer, ArrayList<Integer[]>> chowCards;
    private ArrayList<Integer[]> actionPairs;
    private Integer actionCard;

    Cards_in_hand cards;
    Check_Chow(Cards_in_hand cards) {
        this.cards = cards;
        chowCards = new HashMap<>();
    }
    static Map<Integer, ArrayList<Integer[]>> findChowCards(ArrayList<Integer> cards) {
        Map<Integer, ArrayList<Integer[]>> result = new HashMap<>();
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i) > 26 || cards.get(i + 1) == cards.get(i)) {
                continue;
            }
            if (cards.get(i) + 1 == cards.get(i + 1) && cards.get(i) % 9 != 8) {
                if (cards.get(i) % 9 != 0) {
                    if (!result.containsKey(cards.get(i) - 1)) {
                        result.put(cards.get(i) - 1, new ArrayList<>());
                    }
                    result.get(cards.get(i) - 1).add(new Integer[]{cards.get(i), cards.get(i) + 1});
                }
                if ((cards.get(i) + 1) % 9 != 8) {
                    if (!result.containsKey(cards.get(i) + 2)) {
                        result.put(cards.get(i) + 2, new ArrayList<>());
                    }
                    result.get(cards.get(i) + 2).add(new Integer[]{cards.get(i), cards.get(i) + 1});
                }
            }
            if (cards.contains(cards.get(i) + 2) && cards.get(i) % 9 < 7) {
                if (!result.containsKey(cards.get(i) + 1)) {
                    result.put(cards.get(i) + 1, new ArrayList<>());
                }
                result.get(cards.get(i) + 1).add(new Integer[]{cards.get(i), cards.get(i) + 2});
            }
        }
        return result;
    }

    @Override
    public void findCards() {
        chowCards = findChowCards(cards.showCards());
    }

    @Override
    public void checkCard(int n) {
        if(chowCards.containsKey(n)&&cards.getNext()){
            actionPairs=chowCards.get(n);
            actionCard=n;
            cards.setStatus(3);
        }
    }
    @Override
    public void removeCard(int n) {
        ArrayList<Integer> x =new ArrayList<>(List.of(actionPairs.get(n)));
        Discard_Pile.getDiscard().remove();
        x.add(actionCard);
        cards.removeCard(x);
    }
    ArrayList<Integer[]> getActionPairs(){
        return new ArrayList<Integer[]>(actionPairs);
    }
}
