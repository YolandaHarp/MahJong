package fx;

import game.Mahjong;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import model.Stack_of_cards;

public class TablePane implements Screens{
    private static TablePane tablePane=new TablePane();
    private PlayerCardPane[] players = new PlayerCardPane[4];
    Label l;

    private TablePane(){}

    public static TablePane getTablePane() {
        return tablePane;
    }

    @Override
    public void initialize(Pane p) {
        p =(Pane)p.lookup("#table");
        for(int i=0;i<4;i++){
            players[i] = new PlayerCardPane((Pane) p.lookup("#player"+i),90*i);
        }
        l=new Label();
        l.setFont(new Font(20));
        p.getChildren().add(l);

    }

    @Override
    public void updateCanvases() {
        int i= Mahjong.getMJ().getNowPlayer();
        for(PlayerCardPane p: players) {
            p.update(i%4);
            i++;
        }
        l.setLayoutX(20);
        l.setText("remain cards: "+ Stack_of_cards.getStack().remainCardNum());
    }
}
