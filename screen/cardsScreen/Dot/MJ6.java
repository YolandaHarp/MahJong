package screen.cardsScreen.Dot;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.CardScreen.green;
import static screen.cardsScreen.CardScreen.red;
import static screen.cardsScreen.Dot.DotScreen.draw4Dot;
import static screen.cardsScreen.Dot.DotScreen.drawDot;

class MJ6 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        draw4Dot(g,x,y,a,red);
        drawDot(g, x, y, 472, 461, 20, a, green, 5);
        drawDot(g, x, y, 490, 467, 20, a, green, 5);
        drawDot(g, x, y, 507, 473, 20, a, green, 5);
    }
}
