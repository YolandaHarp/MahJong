package GUI;

import game.Mahjong;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import language.LanguageChange;

// Singleton pattern
// Composite pattern
// Null Object pattern
class ActionButtonsPane implements Screens{
    // A group of buttons for player action (Chow, Pong, Kong, Win and Nope)

    private static ActionButtonsPane button = new ActionButtonsPane();
    ActionButton[] buttons = new ActionButton[5];
    private ActionButtonsPane(){}
    protected static ActionButtonsPane getButton(){
        return button;
    }

    @Override
    public void initialize(Pane p) {

        // "s" is the array which store the character should on the button(related to the language change function)
        String[] s=new String[]{LanguageChange.getLanguage().getString("win"),LanguageChange.getLanguage().getString("kong"),LanguageChange.getLanguage().getString("pong"),LanguageChange.getLanguage().getString("chow"),LanguageChange.getLanguage().getString("cancel")};

        p=(Pane)p.lookup("#table").lookup("#buttons");

        // Initialize the five buttons in sequence
        for(int i=0;i<5;i++){
            buttons[i]=new ActionButton((Pane) p.lookup("#but"+i));
            Label l=new Label(s[i]);
            l.setLayoutX(15);
            l.setLayoutY(35);
            l.setFont(new Font("Arial",30));
            buttons[i].getPane().getChildren().add(l);
        }

        // All disappear when either button is pressed
        for(ActionButton b:buttons){
            b.getPane().setVisible(false);
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
        // Get which action can player act and show the button on the screen

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
        // Get players choice

        int i=0;
        while(!buttons[i%5].getChoice()&&!CardsController.getStop()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }

        // Reset the button
        buttons[i%5].setChoice(false);
        return i%5;
    }

}
