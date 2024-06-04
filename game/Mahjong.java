package game;

import model.Cards_in_hand;
import model.Discard_Pile;
import model.Stack_of_cards;
import net.Client;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import static GUI.CardsController.*;

public class Mahjong implements Serializable {
    private static Mahjong MJ = new Mahjong();
    private int nowPlayer;
    private int playerNum;
    private boolean win;
    private Cards_in_hand[] playerList = new Cards_in_hand[4];
    private Mahjong() {}
    public static Mahjong getMJ(){
        return MJ;
    }
    boolean findNextPlayer(boolean online){
        for(int i=0;i<4;i++){
            for(int j=nowPlayer+1;j<nowPlayer+4;j++){
                if(playerList[j%4].getStatus(i)){
                    nowPlayer=j%4;
                    if(!online){
                        playerNum=nowPlayer;
                    }
                    return true;
                }
            }
        }
        for(int i=0;i<4;i++){
            if(playerList[i].getNext()){
                nowPlayer=i;
            }
        }
        if(!online){
            playerNum=nowPlayer;
        }
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
    public int getPlayerNum(){
        return playerNum;
    }
    public int getNowPlayer(){
        return nowPlayer;
    }

    public void initializeGame(boolean online) throws IOException {
        win=false;
        Stack_of_cards.getStack().newStack();
        Discard_Pile.getDiscard().clear();
        for(int i=0;i<4;i++){
            playerList[i]=new Cards_in_hand();
        }
        nowPlayer=new Random().nextInt(4);
        playerList[(nowPlayer+1)%4].setNext(true);
        updateScreen(7);
        if(online){
            Client.getClient().sendMessage();
            playerNum=3;
            updateGame(false);
            startOnlineGame();
        }else{
            updateScreen(8);
        }
    }
    public void startLocalGame() throws IOException {
        initializeGame(false);
        while(!win&&!getStop()){
            if(Stack_of_cards.getStack().remainCardNum()==0){
                updateScreen(6);
                break;
            }
            boolean haveAction=findNextPlayer(false);
            boolean canPlay=turnStart(haveAction,false);
            drawStage(false);
            if(win){
                updateScreen(5);
                break;
            }
            //出牌阶段
            if(canPlay) {
                playStage();
            }
        }
    }
    private boolean turnStart(boolean haveAction,boolean online){
        boolean hide=!online;
        boolean waitToDraw = false;
        if(haveAction){
            updateGame(hide);
            updateScreen(1);
            int result=getChoice();
            if(result==4){
                playerList[nowPlayer].clearStatus();
                if(playerList[nowPlayer].getNext()){
                    waitToDraw=true;
                }else {
                    return false;
                }
            }else if(result==0){
                win=true;
                playerList[nowPlayer].addCard(Discard_Pile.getDiscard().getLast());
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
            updateGame(hide);
            waitToDraw=true;
        }
        if(waitToDraw){
            playerList[nowPlayer].drawCard();
        }
        updateGame(hide);
        return true;
    }
    private void drawStage(boolean online) throws IOException {
        while(playerList[nowPlayer].getStatus(0)||playerList[nowPlayer].getStatus(4)) {
            updateScreen(1);
            int result = getChoice();
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
                if(online){
                    Client.getClient().sendMessage();
                }
            }
        }
    }
    private void playStage(){
        playerList[nowPlayer].clearStatus();
        int card=playCard();
        playerList[nowPlayer].playCard(card);
        clearNext();
        playerList[(nowPlayer+1)%4].setNext(true);
        for(int i=nowPlayer+1;i<nowPlayer+4;i++) {
            playerList[i % 4].getAction().checkCardAction();
        }
        updateGame(false);
    }
    public void setMJ(Mahjong m){
        MJ=m;
    }
    public void setPlayerNum(int i){
        playerNum=i;
    }
    public boolean haveAction(){
        boolean haveAction=false;
        for(int i=0;i<4;i++){
            if(playerList[nowPlayer].getStatus(i)){
                haveAction = true;
                break;
            }
        }
        return haveAction;
    }
    public void startOnlineGame() throws IOException {
        updateScreen(7);
        if(Stack_of_cards.getStack().remainCardNum()==0){
            updateScreen(6);
            Client.getClient().endMessage();
            return;
        }
        if(win){
            updateScreen(5);
            Client.getClient().endMessage();
            return;
        }
        if(playerNum==nowPlayer){
            showTurn(true);
            boolean canPlay=turnStart(haveAction(),true);
            Client.getClient().sendMessage();
            drawStage(true);
            Client.getClient().sendMessage();
            if(win){
                updateScreen(5);
                Client.getClient().endMessage();
                return;
            }
            //出牌阶段
            if(canPlay) {
                playStage();
            }
            findNextPlayer(true);
            Client.getClient().sendMessage();
            showTurn(false);
        }
    }
}
