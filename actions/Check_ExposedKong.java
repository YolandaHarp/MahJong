package actions;

import model.Cards_in_hand;
import model.Discard_Pile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Check_ExposedKong extends Check_Pong implements Find_Action , Serializable {
    // One situation for Kong
    // Player have a triple in hand and other player play the last card which is same

    Check_ExposedKong(Cards_in_hand cards) {
        super(cards);
    }
    @Override
    public void findCards(){
        availableCards = findSameCards(cards.showCards(), 3);
    }

    @Override
    public void checkCard(int n) {
        if(availableCards.contains(n)) {
            actionCard = n;
            cards.setStatus(1);
        }
    }

    @Override
    public void removeCard(int n) {
        Discard_Pile.getDiscard().remove();
        cards.removeCard(new ArrayList<>(Arrays.asList(actionCard,actionCard,actionCard)),actionCard);
    }
}
