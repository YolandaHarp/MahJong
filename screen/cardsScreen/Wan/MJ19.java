package screen.cardsScreen.Wan;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.drawPg;
import static screen.cardsScreen.CardScreen.white;
import static screen.cardsScreen.Wan.WanScreen.drawWan;

public class MJ19 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-20, -15, 15, 18, 10, -15};
        int[] y_coords = new int[]{-17, -16, -20, -16, -18, -16};
        drawPg(g, x_coords, y_coords, x, y, a, white, Color.BLACK, 4.0f);

        drawWan(g,x,y,a);

        int[] x_coords5 = new int[]{-20, -14, 15, 16, 10, -14};
        int[] y_coords5 = new int[]{-41, -40, -44, -41, -42, -40};
        drawPg(g, x_coords5, y_coords5, x, y, 0.7*a, white, Color.BLACK, 6.0f);
    }
}
