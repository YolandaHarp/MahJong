package GUI;

import game.Mahjong;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import language.LanguageChange;
import model.Cards_in_hand;
import screen.cardsScreen.CardScreen;
import screen.cardsScreen.tileFactory;

import java.util.ArrayList;

class PlayerCardPane extends Panes{
    // A part that a player has already shown

    int angle;
    Label l;

    PlayerCardPane(Pane p,int a) {
        // Rotate it and let it face to this player

        super(p);
        angle=a;
        gc.translate(p.getPrefWidth()/2,p.getPrefHeight()/2);
        gc.rotate(angle);
        l=new Label();
        p.getChildren().add(l);
        l.setFont(new Font(20));
        l.setTextFill(Color.WHITE);
    }

    void update(int i){
        // update the interface and add player name on it

        gc.clearRect(-500, -500, 1280,830);

        // If is your turn your name will be orange
        // Avoid revealing the current round when someone is making a selection
        if(i==Mahjong.getMJ().getNowPlayer()&&!Mahjong.getMJ().haveAction()){
            l.setTextFill(Color.ORANGE);
        }else{
            l.setTextFill(Color.WHITE);
        }
        l.setText(LanguageChange.getLanguage().getString("player") +(i+1));
        int x = -(int) Math.max(p.getPrefWidth()/2,p.getPrefHeight()/2)+45;
        Cards_in_hand player= Mahjong.getMJ().getPlayer(i);
        updateCardsUpper(player,x);
        updatePutAway(player,x);
    }

    private void updateCardsUpper(Cards_in_hand player,int x){
        // A card standing on a table

        for(int j=0;j<player.showCards().size();j++){
            CardScreen.getCard().drawCardUpper(gc,80+x +j*38,50,1);
        }
    }

    private void updatePutAway(Cards_in_hand player,int x){
        // Cards that show to the other player (after Chow, Pong, Kong)

        int space=0;
        for(ArrayList<Integer> putaway: player.getPutAway().show() ){
            for(int k=0;k<putaway.size();k++){
                CardScreen.getCard().drawCardFront(gc, x +space+35*k, 0, 0.5);
                tileFactory.getFac().getTile(putaway.get(k), gc, x +space+35*k, 0, 0.5);
            }
            space+=35*putaway.size()+10;
        }
    }

    /*void update1(ArrayList<Integer> cards1,ArrayList<ArrayList<Integer>>cards2){
        gc.clearRect(0, 0, 1280,830);
        gc.translate(p.getPrefWidth()/2,p.getPrefHeight()/2);
        int x = -(int) Math.max(p.getPrefWidth()/2,p.getPrefHeight()/2)+25;
        gc.rotate(angle);

        for(int j=0;j<cards1.size();j++){
            CardScreen.getCard().drawCardUpper(gc,80+x +j*38,50,1);
        }
        int space=0;
        for(ArrayList<Integer> putaway: cards2 ){
            for(int k=0;k<putaway.size();k++){
                CardScreen.getCard().drawCardFront(gc, x +space+35*k, 0, 0.5);
                tileFactory.getFac().getTile(putaway.get(k), gc, x +space+35*k, 0, 0.5);
            }
            space+=35*putaway.size()+10;
        }
        //gc.rotate(angle);

    }*/
}
