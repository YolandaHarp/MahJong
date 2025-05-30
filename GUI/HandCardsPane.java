package GUI;

import game.Mahjong;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

// Singleton pattern
// Null Object pattern
class HandCardsPane implements Screens{
    // Show the cards in one player's hand

    private static HandCardsPane handCardsPane = new HandCardsPane();
    CardPane[] panes=new CardPane[14];
    boolean playCard;
    int cardChoice;
    private HandCardsPane(){}

    public void initialize(Pane handcard){
        handcard=(Pane)handcard.lookup("#table").lookup("#handcard");

        // Get buttons for 14 cards
        for(int i=0;i<14;i++){
            panes[i]= new CardPane( (Pane)handcard.lookup("#card"+i),i);
        }

        // Achieve double click and highlight after selection
        for(CardPane p:panes) {
            p.getPane().setOnMouseClicked(event -> {
                if(p.getPane().getTranslateY()!=-15) {
                    p.getPane().setTranslateY(-15);
                }else {
                    if(playCard) {
                        p.getPane().setTranslateY(0);
                        cardChoice=p.getNum();
                        playCard=false;
                    }
                }
                for(CardPane p1: panes) {
                    if(p1!=p) {
                        p1.getPane().setTranslateY(0);
                    }
                }
            });
        }

    }
    protected static HandCardsPane getHandCardsPane() {
        return handCardsPane;
    }

    @Override
    public void updateCanvases() {
    }

    public void updateCards(boolean hide){
        // Get and update player's cards in hand
        // "hide" decide whether to face up or face down

        int now=Mahjong.getMJ().getPlayerNum();
        ArrayList<Integer> cards= Mahjong.getMJ().getPlayer(now).showCards();

        // Hide the needless button
        for (int i = 0; i < 14; i++) {
            if(i>=cards.size()){
                panes[i].getPane().setVisible(false);
                continue;
            }
            CardPane p = panes[i];
            p.getPane().setVisible(true);
            if(!hide) {
                p.update(cards.get(i));
            }else{
                p.update(100);
            }
        }
    }
    public void setPlayCard(){
        playCard=true;
    }

    public int getChoice(){
        while(playCard&&!CardsController.getStop()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return cardChoice;
    }
}
