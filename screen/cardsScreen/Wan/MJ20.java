package screen.cardsScreen.Wan;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.drawPg;
import static screen.cardsScreen.CardScreen.white;
import static screen.cardsScreen.Wan.WanScreen.drawWan;

public class MJ20 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-20, -15, 15, 18, 10, -15};
        int[] y_coords = new int[]{-15, -14, -18, -14, -16, -14};
        drawPg(g, x_coords, y_coords, x, y, a, white, Color.BLACK, 4.0f);

        drawWan(g,x,y,a);

        int[] x_coords5 = new int[]{-20, -14, 14, 16, 10, -14};
        int[] y_coords5 = new int[]{-53, -52, -56, -53, -54, -52};
        drawPg(g, x_coords5, y_coords5, x, y, 0.6*a, white, Color.BLACK, 7.0f);

        int[] x_coords6 = new int[]{-20, -14, 14, 17, 10, -14};
        int[] y_coords6 = new int[]{-47, -48, -50, -47, -48, -46};
        drawPg(g, x_coords6, y_coords6, x, y, 0.5*a, white, Color.BLACK, 7.0f);
    }
}
