package actions;

import model.Cards_in_hand;
import model.Discard_Pile;

import java.io.Serializable;
import java.util.ArrayList;

// Composite pattern
// Facade pattern
// Proxy pattern
public class Actions implements Serializable {
    private Find_Action[] actions; // Include 5 different action 0 -> Cards can make the player win,
                                   // 1 -> Cards can cause Kong, 2 -> Cards can cause Pong
                                   // 3 -> Cards cna cause Chow, 4 -> Cards cna cause Kong(in player his own turn)
    Cards_in_hand cards;
    public Actions(Cards_in_hand c){
        // Initialize

        cards=c;
        Check_Chow chowCards= new Check_Chow(c);
        Check_Pong pongCards=new Check_Pong(c);
        Check_Win winCards=new Check_Win(c);
        Check_ConcealedKong cKongCards=new Check_ConcealedKong(c);
        Check_ExposedKong eKongCards=new Check_ExposedKong(c);
        actions=new Find_Action[]{winCards,eKongCards,pongCards,chowCards,cKongCards};
    }

    public void findCardsAction(){
        // Update cards cna cause action after play a card

        for(int i=0;i<4;i++){
            actions[i].findCards();
        }
    }

    public void checkCardAction(){
        // Check the card ben played can cause action by other player

        cards.clearStatus();
        if(cards.canWinByOther()){
            actions[0].checkCard(Discard_Pile.getDiscard().getLast());
        }
        for(int i=1;i<4;i++){
            actions[i].checkCard(Discard_Pile.getDiscard().getLast());
        }
    }

    public void checkCardAction_draw(int n){
        // Situation may happen in player own turn

        cards.clearStatus();
        actions[4].findCards();
        actions[4].checkCard(0);
        actions[0].findCards();
        actions[0].checkCard(n);
    }

    public ArrayList<Integer[]> getChowChoice(){
        return ((Check_Chow)actions[3]).getActionPairs();
    }

    public ArrayList<Integer> getCKongChoice(){
        return ((Check_ConcealedKong)actions[4]).getAvailableCards();
    }

    public void removeAction(int action, int n){
        actions[action].removeCard(n);
    }
}
