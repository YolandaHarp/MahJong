package GUI;

import game.Mahjong;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import language.LanguageChange;

import java.util.ArrayList;

class WinPane implements Screens{
    private static WinPane finished = new WinPane();
    Label winner;
    Pane p;

    private WinPane(){}
    protected static WinPane getFinish(){
        return finished;
    }
    @Override
    public void initialize(Pane p) {
        this.p=p;
        ((HBox) p.lookup("#wcard1")).setSpacing(10);
        winner=new Label();
        winner.setLayoutX(222);
        winner.setLayoutY(425);
        winner.setFont(new Font(40));
        winner.setVisible(false);
        p.getChildren().add(winner);
    }

    @Override
    public void updateCanvases() {
        if(p.lookup("#table").isVisible()) {
            DrawPane.getDrawPane().clearTable();
            winner.setText(LanguageChange.getLanguage().getString("player")+Mahjong.getMJ().getNowPlayer()+" "+LanguageChange.getLanguage().getString("win"));
            winner.setVisible(true);
            ArrayList<Integer> cards = Mahjong.getMJ().getPlayer(Mahjong.getMJ().getNowPlayer()).showCards();
            for (int i = 0; i < cards.size(); i++) {
                updateCard((HBox) p.lookup("#wcard"), i, cards.get(i));
            }
            ArrayList<ArrayList<Integer>> putAwayCards = Mahjong.getMJ().getPlayer(Mahjong.getMJ().getNowPlayer()).getPutAway().show();
            for (int i = 0; i < putAwayCards.size(); i++) {
                HBox hbox = new HBox();
                for (int j : putAwayCards.get(i)) {
                    updateCard(hbox, i, j);
                }
                ((HBox) p.lookup("#wcard1")).getChildren().add(hbox);
            }
            p.lookup("#wcard").setVisible(true);
            p.lookup("#wcard1").setVisible(true);
        }
    }
    static CardPane updateCard(HBox h,int i,int value){
        Pane pane =new Pane();
        pane.setPrefSize(70,98);
        h.getChildren().add(pane);
        CardPane card=new CardPane(pane,i);
        card.update(value);
        return card;
    }
}
