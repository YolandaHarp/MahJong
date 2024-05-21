package screen.cardsScreen.Dot;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.CardScreen.red;
import static screen.cardsScreen.Dot.DotScreen.drawDot;

public class MJ4 implements Drawable {
    @Override
    public void draw(GraphicsContext g, int x, int y, double a) {
        drawDot(g, x, y, 490, 490, 20, a, red, 5);
        new MJ3().draw(g,x,y,a);
    }
}
