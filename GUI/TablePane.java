package GUI;

import game.Mahjong;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import language.LanguageChange;
import model.Stack_of_cards;

class TablePane implements Screens{
    private static TablePane tablePane=new TablePane();
    private PlayerCardPane[] players = new PlayerCardPane[4];
    Label l;

    private TablePane(){}

    protected static TablePane getTablePane() {
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
        l.setTextFill(Color.WHITE);
        p.getChildren().add(l);

    }

    @Override
    public void updateCanvases() {
        int i= Mahjong.getMJ().getPlayerNum();
        for(PlayerCardPane p: players) {
            p.update(i%4);
            i++;
        }
        l.setLayoutX(20);
        l.setText(LanguageChange.getLanguage().getString("remain")+" " + Stack_of_cards.getStack().remainCardNum());
    }
}
