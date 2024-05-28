package fx;

import game.Mahjong;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ActionButtonsPane implements Screens{
    String[] s=new String[]{"胡","杠","碰","吃","取消"};
    private static ActionButtonsPane button = new ActionButtonsPane();
    ActionButton[] buttons = new ActionButton[5];
    private ActionButtonsPane(){}
    public static ActionButtonsPane getButton(){
        return button;
    }
    @Override
    public void initialize(Pane p) {
        p=(Pane)p.lookup("#table").lookup("#buttons");
        for(int i=0;i<5;i++){
            buttons[i]=new ActionButton((Pane) p.lookup("#but"+i));
            Label l=new Label(s[i]);
            l.setLayoutX(30);
            l.setLayoutY(35);
            l.setFont(new Font("Arial",30));
            buttons[i].getPane().getChildren().add(l);
        }
        for(ActionButton b:buttons){
            b.getPane().setVisible(false);
            //b.getPane().setVisible(false);
            b.getPane().setOnMouseClicked(event -> {
                b.setChoice(true);
                for(ActionButton b1:buttons){
                    b1.getPane().setVisible(false);
                }
            });
        }
    }

    @Override
    public void updateCanvases() {
        int now=Mahjong.getMJ().getNowPlayer();
        for(int i=0;i<5;i++){
            if(Mahjong.getMJ().getPlayer(now).getStatus(i)){
                if(i==4){
                    buttons[1].getPane().setVisible(true);
                }else{
                    buttons[i].getPane().setVisible(true);
                }
            }
        }
        buttons[4].getPane().setVisible(true);
    }

    public int getChoice(){
        int i=0;
        while(!buttons[i%5].getChoice()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
        buttons[i%5].setChoice(false);
        return i%5;
    }

}
