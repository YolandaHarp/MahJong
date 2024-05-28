package fx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.drawO;

public class ActionButton extends Panes{
    boolean choice;
    ActionButton(Pane b){
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
