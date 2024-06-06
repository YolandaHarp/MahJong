package game;

import model.Cards_in_hand;
import model.Discard_Pile;
import model.Stack_of_cards;
import net.Client;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import static GUI.CardsController.*;

// Singleton pattern
// Proxy pattern
public class Mahjong implements Serializable {
    private static Mahjong MJ = new Mahjong();
    private int nowPlayer; // Player in turn
    private int playerNum; // This player's number
    private boolean win;
    private Cards_in_hand[] playerList = new Cards_in_hand[4];
    private Mahjong() {}
    public static Mahjong getMJ(){
        return MJ;
    }
    boolean findNextPlayer(boolean online){
        // Find next player have action
        // If not online change player number
        // If online change player number

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

        // If no action for any player
        // Change to next player
        for(int i=0;i<4;i++){
            if(playerList[i].getNext()){
                nowPlayer=i;
            }
        }
        if(!online){
            playerNum=nowPlayer;
        }
        return false;
        //boolean value represents whether the player has a special action
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
        //initialize the Game
        win=false;
        Stack_of_cards.getStack().newStack();
        Discard_Pile.getDiscard().clear();
        for(int i=0;i<4;i++){
            playerList[i]=new Cards_in_hand();
        }
        nowPlayer=new Random().nextInt(4);
        playerList[(nowPlayer+1)%4].setNext(true);
        updateScreen(7);
        //The player who initializes the game online must be the fourth player
        // The game data is published to all players when the game is initialized
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
        while(!win&&!getStop()){//Quit the game when game is running
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
            if(canPlay) {
                playStage();
            }
        }
    }
    private boolean turnStart(boolean haveAction,boolean online){
        boolean hide=!online;//Determines whether to display the board or the back when the interface is updated
        boolean waitToDraw = false;
        if(haveAction){
            updateGame(hide);
            updateScreen(1);
            int result=getChoice();
            if(result==4){//The player opts to cancel, and if the player himself is next, a normal round is played
                playerList[nowPlayer].clearStatus();
                if(playerList[nowPlayer].getNext()){
                    waitToDraw=true;
                }else {
                    return false;
                }
            }else if(result==0){//player win
                win=true;
                playerList[nowPlayer].addCard(Discard_Pile.getDiscard().getLast());
                updateScreen(5);
            }else if(result==1||result==2){//player pong or kong
                playerList[nowPlayer].getAction().removeAction(result,0);
                if(result==1){//if is kong, player should draw a card
                    waitToDraw=true;
                    Stack_of_cards.getStack().changeEnd();//After Player kong, one more card will be able to drawn in the game
                }
            }else if(result==3){//player chow
                int chowResult=0;
                if(playerList[nowPlayer].getAction().getChowChoice().size()!=1){//If there are multiple situations for the player to choose from
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
        //The player's actions after drawing a card
        while(playerList[nowPlayer].getStatus(0)||playerList[nowPlayer].getStatus(4)) {
            updateScreen(1);
            int result = getChoice();
            if (result == 4) {//player cancel
                playerList[nowPlayer].clearStatus();
                break;
            }else if (result == 0) {//player  win
                win = true;
                break;
            }else if(result==1){//player kong and draw card again
                int cKongResult=0;
                if(playerList[nowPlayer].getAction().getCKongChoice().size()!=1){
                    cKongResult=updateChoices(false);
                }
                playerList[nowPlayer].getAction().removeAction(4,cKongResult);
                playerList[nowPlayer].drawCard();
                Stack_of_cards.getStack().changeEnd();
                updateGame(false);
                if(online){
                    Client.getClient().sendMessage();
                }
            }
        }
    }
    private void playStage(){
        //After a player plays a card, other players react to that card
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
    //Check if this player has any special actions
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
    //Start a round of the online game
    //Players online will take turns starting the round
    public void startOnlineGame() throws IOException {
        updateScreen(7);
        if(Stack_of_cards.getStack().remainCardNum()==0){
            updateScreen(6);
            Client.getClient().endMessage();//End link
            return;
        }
        if(win){
            updateScreen(5);
            Client.getClient().endMessage();
            return;
        }
        if(playerNum==nowPlayer){
            showTurn(true);//show the "your turn" label
            boolean canPlay=turnStart(haveAction(),true);
            Client.getClient().sendMessage();//update data
            drawStage(true);
            Client.getClient().sendMessage();
            if(win){
                updateScreen(5);
                Client.getClient().endMessage();
                return;
            }
            if(canPlay) {
                playStage();
            }
            findNextPlayer(true);
            Client.getClient().sendMessage();
            showTurn(false);
        }
    }
}
