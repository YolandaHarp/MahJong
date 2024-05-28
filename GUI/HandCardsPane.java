package fx;

import game.Mahjong;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class HandCardsPane implements Screens{
    private static HandCardsPane handCardsPane = new HandCardsPane();
    CardPane[] panes=new CardPane[14];
    boolean playCard;
    int cardChoice;
    private HandCardsPane(){}

    public void initialize(Pane handcard){
        handcard=(Pane)handcard.lookup("#table").lookup("#handcard");
        for(int i=0;i<14;i++){
            panes[i]= new CardPane( (Pane)handcard.lookup("#card"+i),i);
        }

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
    public static HandCardsPane getHandCardsPane() {
        return handCardsPane;
    }
    @Override
    public void updateCanvases() {
    }
    public void updateCards(boolean hide){
        int now=Mahjong.getMJ().getNowPlayer();
        ArrayList<Integer> cards= Mahjong.getMJ().getPlayer(now).showCards();
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
                p.update(100);//无意义的数
            }
        }
    }
    public void setPlayCard(){
        playCard=true;
    }
    public int getChoice(){
        while(playCard){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return cardChoice;
    }


}
