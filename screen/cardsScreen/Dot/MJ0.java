package screen.cardsScreen.Dot;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.*;

public class MJ0 implements Drawable {

    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        Color white1 = Color.rgb(230, 250, 230);
        drawO(g, x, y, 470, 470, 60, a, white, green, 4.0f);
        drawO(g, x, y, 479, 479, 42, a, white, green, 10.0f);
        drawO(g, x, y, 489, 489, 22, a, white, red, 4.0f);
        drawO(g, x, y, 491, 491, 8, a, white, red, 4.0f);
        drawO(g, x, y, 501, 491, 8, a, white, red, 4.0f);
        drawO(g, x, y, 491, 500, 8, a, white, red, 4.0f);
        drawO(g, x, y, 501, 500, 8, a, white, red, 4.0f);
        drawO(g, x, y, 497, 477, 6, a, white, white1, 2.0f);
        drawO(g, x, y, 497, 516, 6, a, white, white1, 2.0f);
        drawO(g, x, y, 486, 481, 6, a, white, white1, 2.0f);
        drawO(g, x, y, 508, 481, 6, a, white, white1, 2.0f);
        drawO(g, x, y, 508, 513, 6, a, white, white1, 2.0f);
        drawO(g, x, y, 486, 513, 6, a, white, white1, 2.0f);
        drawO(g, x, y, 479, 491, 6, a, white, white1, 2.0f);
        drawO(g, x, y, 515, 491, 6, a, white, white1, 2.0f);
        drawO(g, x, y, 515, 504, 6, a, white, white1, 2.0f);
        drawO(g, x, y, 479, 503, 6, a, white, white1, 2.0f);
    }
}
