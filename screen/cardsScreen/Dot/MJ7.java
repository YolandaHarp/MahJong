package screen.cardsScreen.Dot;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.Dot.DotScreen.draw4Dot;

public class MJ7 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        draw4Dot(g,x, (y+5*a),a,Color.BLACK);
        draw4Dot(g,x, (y-37*a),a,Color.BLACK);
    }
}
