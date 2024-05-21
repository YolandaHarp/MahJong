package screen.cardsScreen.Dot;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.*;
import static screen.cardsScreen.Dot.DotScreen.drawDot;

public class MJ1 implements Drawable {
    @Override
    public void draw(GraphicsContext g, int x, int y, double a) {
        drawO(g, x, y, 483, 464, 32, a, white, green, 4.2f);
        drawO(g, x, y, 483, 508, 32, a, white, Color.BLACK, 4.2f);
        drawDot(g, x, y, 489, 514, 20, a,  Color.BLACK, 5);
        drawDot(g, x, y, 489, 470, 20, a,  green, 5);
    }
}
