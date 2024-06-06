package screen.cardsScreen.Dot;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.green;
import static screen.cardsScreen.Dot.DotScreen.drawDot;

class MJ3 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        drawDot(g, x, y, 473, 466, 20, a, green, 5);
        drawDot(g, x, y, 473, 516, 20, a, Color.BLACK, 5);
        drawDot(g, x, y, 505, 516, 20, a, green, 5);
        drawDot(g, x, y, 505, 466, 20, a, Color.BLACK, 5);
    }
}
