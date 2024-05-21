package screen.cardsScreen.Dot;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.CardScreen.green;
import static screen.cardsScreen.CardScreen.red;
import static screen.cardsScreen.Dot.DotScreen.draw4Dot;
import static screen.cardsScreen.Dot.DotScreen.drawDot;

public class MJ5 implements Drawable {
    @Override
    public void draw(GraphicsContext g, int x, int y, double a) {
        draw4Dot(g,x,y,a,red);
        drawDot(g, x, y, 479, 463, 20, a, green, 5);
        drawDot(g, x, y, 500, 463, 20, a, green, 5);
    }
}
