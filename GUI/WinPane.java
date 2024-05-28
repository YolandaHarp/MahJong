package fx;

import game.Mahjong;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class WinPane implements Screens{
    private static WinPane finished = new WinPane();
    Pane table;
    Label over;
    HBox wcard;
    HBox wcard1;

    private WinPane(){}
    public static WinPane getFinish(){
        return finished;
    }
    @Override
    public void initialize(Pane p) {
        table=(Pane)p.lookup("#table");
        over=(Label) p.lookup("#over");
        wcard=(HBox) p.lookup("#wcard");
        wcard1=(HBox) p.lookup("#wcard1");
        wcard1.setSpacing(10);

    }

    @Override
    public void updateCanvases() {
        table.setVisible(false);
        over.setVisible(true);
        ArrayList<Integer> cards= Mahjong.getMJ().getPlayer(Mahjong.getMJ().getNowPlayer()).showCards();
        for(int i=0;i<cards.size();i++){
            updateCard(wcard,i,cards.get(i));
        }
        ArrayList<ArrayList<Integer>> putAwayCards=Mahjong.getMJ().getPlayer(Mahjong.getMJ().getNowPlayer()).getPutAway().show();
        for(int i=0;i<putAwayCards.size(); i ++){
            HBox hbox =new HBox();
            for(int j:putAwayCards.get(i)){
                updateCard(hbox,i,j);
            }
            wcard1.getChildren().add(hbox);
        }
        wcard.setVisible(true);
        wcard1.setVisible(true);

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
