package screen.cardsScreen.Dot;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.green;
import static screen.cardsScreen.CardScreen.red;
import static screen.cardsScreen.Dot.DotScreen.draw3Dot;

public class MJ8 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        draw3Dot(g,x,y,a,red);
        draw3Dot(g,x, (y+27*a),a,Color.BLACK);
        draw3Dot(g,x,  (y-27*a),a,green);
    }
}
