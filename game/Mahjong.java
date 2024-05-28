package game;

import GUI.*;
import model.Cards_in_hand;
import model.Stack_of_cards;

import java.util.Random;

import static GUI.CardsController.*;

public class Mahjong {
    private static Mahjong MJ = new Mahjong();
    private int nowPlayer;
    Random random = new Random();
    private Cards_in_hand[] playerList = new Cards_in_hand[4];
    private Mahjong() {}
    public static Mahjong getMJ(){
        return MJ;
    }
    boolean findNextPlayer(){
        for(int i=0;i<4;i++){
            for(int j=nowPlayer+1;j<nowPlayer+4;j++){
                if(playerList[j%4].getStatus(i)){
                    nowPlayer=j%4;
                    updateGame(true);
                    return true;
                }
            }
        }
        for(int i=0;i<4;i++){
            if(playerList[i].getNext()){
                nowPlayer=i;
            }
        }
        updateGame(true);
        return false;
    }
    void clearNext(){
        for(Cards_in_hand c:playerList){
            c.setNext(false);
        }
    }
    public Cards_in_hand getPlayer(int i){
        return playerList[i%4];
    }
    public int getNowPlayer(){
        return nowPlayer;
    }
    void initializeGame(){
        Stack_of_cards.getStack().newStack();
        for(int i=0;i<4;i++){
            playerList[i]=new Cards_in_hand();
        }
        nowPlayer=random.nextInt(4);
        updateGame(true);
        updateScreen(7);
    }
    public void startGame(){
        initializeGame();
        boolean win=false;
        boolean hide=true;
        while(!win){
            if(Stack_of_cards.getStack().remainCardNum()==0){
                updateScreen(6);
                break;
            }
            boolean waitToDraw = false;
            if(findNextPlayer()){
                updateScreen(1);
                int result=ActionButtonsPane.getButton().getChoice();
                if(result==4){
                    playerList[nowPlayer].clearStatus();
                    if(playerList[nowPlayer].getNext()){
                        waitToDraw=true;
                    }else {
                        continue;
                    }
                }else if(result==0){
                    win=true;
                    updateScreen(5);
                }else if(result==1||result==2){
                    playerList[nowPlayer].getAction().removeAction(result,0);
                    if(result==1){
                        waitToDraw=true;
                    }
                }else if(result==3){
                    int chowResult=0;
                    if(playerList[nowPlayer].getAction().getChowChoice().size()!=1){
                        chowResult=updateChoices(true);
                    }
                    playerList[nowPlayer].getAction().removeAction(result,chowResult);
                }
                playerList[nowPlayer].clearStatus();
                hide=false;
            }else{
                waitToDraw=true;
            }
            if(waitToDraw){
                playerList[nowPlayer].drawCard();
            }
            updateGame(hide);
            while(playerList[nowPlayer].getStatus(0)||playerList[nowPlayer].getStatus(4)) {
                updateScreen(1);
                int result = ActionButtonsPane.getButton().getChoice();
                if (result == 4) {
                    playerList[nowPlayer].clearStatus();
                    break;
                }else if (result == 0) {
                    win = true;
                    break;
                }else if(result==1){
                    int cKongResult=0;
                    if(playerList[nowPlayer].getAction().getCKongChoice().size()!=1){
                        cKongResult=updateChoices(false);
                    }
                    playerList[nowPlayer].getAction().removeAction(4,cKongResult);
                    playerList[nowPlayer].drawCard();
                    updateGame(false);
                }
            }
            if(win){
                updateScreen(5);
                break;
            }
            //出牌阶段
            HandCardsPane.getHandCardsPane().setPlayCard();
            int card=HandCardsPane.getHandCardsPane().getChoice();
            playerList[nowPlayer].playCard(card);
            clearNext();
            playerList[(nowPlayer+1)%4].setNext(true);
            for(int i=nowPlayer+1;i<nowPlayer+4;i++){
                playerList[i%4].getAction().checkCardAction();
            }
            hide=true;
        }
    }


}
