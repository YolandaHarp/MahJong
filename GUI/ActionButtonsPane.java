package GUI;

import game.Mahjong;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import language.LanguageChange;

class ActionButtonsPane implements Screens{
    String[] s=new String[]{LanguageChange.getLanguage().getString("win"),LanguageChange.getLanguage().getString("kong"),LanguageChange.getLanguage().getString("pong"),LanguageChange.getLanguage().getString("chow"),LanguageChange.getLanguage().getString("cancel")};
    private static ActionButtonsPane button = new ActionButtonsPane();
    ActionButton[] buttons = new ActionButton[5];
    private ActionButtonsPane(){}
    protected static ActionButtonsPane getButton(){
        return button;
    }
    @Override
    public void initialize(Pane p) {
        p=(Pane)p.lookup("#table").lookup("#buttons");
        for(int i=0;i<5;i++){
            buttons[i]=new ActionButton((Pane) p.lookup("#but"+i));
            Label l=new Label(s[i]);
            l.setLayoutX(15);
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
        int now=Mahjong.getMJ().getPlayerNum();
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
