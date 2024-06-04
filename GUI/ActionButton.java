package GUI;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.drawO;

class ActionButton extends Panes{
    // Single button for player action (Chow, Pong, Kong, Win or Nope)

    // choice use to judge whether player press the button
    boolean choice;

    ActionButton(Pane b){
        // initialize the button
        // draw the button

        super(b);
        drawO(gc, 23, 40, 479, 463, 93, 1, Color.rgb(200, 140, 40), Color.rgb(100, 50, 150), 5.5f);
    }
    boolean getChoice() {
        return choice;
    }
    void setChoice(boolean b){
        choice=b;
    }
}
