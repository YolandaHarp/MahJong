package screen.cardsScreen.Wan;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.drawPg;
import static screen.cardsScreen.CardScreen.white;
import static screen.cardsScreen.Wan.WanScreen.drawWan;

public class MJ25 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        drawWan(g,x,y,a);
        int[] x_coords6 = new int[]{-4,-6,-16,-6,-1,-4};
        int[] y_coords6 = new int[]{-25,-19,-10,-17,-20,-25};
        drawPg(g, x_coords6, y_coords6, x-5*a, y-5*a, 0.9*a, white, Color.BLACK, 4.0f);

        int[] x_coords7 = new int[]{-4,0,15,24,16,0,-4};
        int[] y_coords7 = new int[]{-31,-33,-11,-12,-15,-33,-31};
        drawPg(g, x_coords7, y_coords7, x-3*a, y-6*a, 0.9*a, white, Color.BLACK, 4.4f);
    }
}
