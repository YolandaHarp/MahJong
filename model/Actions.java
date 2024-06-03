package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Actions implements Serializable {
    private Find_Action[] actions;
    Cards_in_hand cards;
    Actions(Cards_in_hand c){
        cards=c;
        Check_Chow chowCards= new Check_Chow(c);
        Check_Pong pongCards=new Check_Pong(c);
        Check_Win winCards=new Check_Win(c);
        Check_ConcealedKong cKongCards=new Check_ConcealedKong(c);
        Check_ExposedKong eKongCards=new Check_ExposedKong(c);
        actions=new Find_Action[]{winCards,eKongCards,pongCards,chowCards,cKongCards};
    }
    void findCardsAction(){
        for(int i=0;i<4;i++){
            actions[i].findCards();
        }
    }
    public void checkCardAction(){
        if(cards.canWinByOther()){
            actions[0].checkCard(Discard_Pile.getDiscard().getLast());
        }
        for(int i=1;i<4;i++){
            actions[i].checkCard(Discard_Pile.getDiscard().getLast());
        }
    }
    void checkCardAction_draw(int n){
        cards.clearStatus();
        actions[4].findCards();
        actions[4].checkCard(0);//这个值没用
        actions[0].findCards();
        actions[0].checkCard(n);
    }
    public ArrayList<Integer[]> getChowChoice(){
        return ((Check_Chow)actions[3]).getActionPairs();
    }
    public ArrayList<Integer> getCKongChoice(){
        return ((Check_ConcealedKong)actions[4]).getAvailableCards();
    }
    ArrayList<Integer> getWinCards(){
        return ((Check_Win)actions[0]).getWinCards();
    }
    public void removeAction(int action, int n){
        actions[action].removeCard(n);
    }

}
