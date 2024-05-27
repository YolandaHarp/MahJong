package screen.cardsScreen.Dot;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.green;
import static screen.cardsScreen.CardScreen.red;
import static screen.cardsScreen.Dot.DotScreen.drawDot;

public class MJ2 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        drawDot(g, x, y, 488, 491, 22, a, red, 6);
        drawDot(g, x, y, 474, 463, 22, a, green, 6);
        drawDot(g, x, y, 502, 519, 22, a, Color.BLACK, 6);
    }
}
