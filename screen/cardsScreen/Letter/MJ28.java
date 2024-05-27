package screen.cardsScreen.Letter;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.*;

public class MJ28 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-7, -4, -11, -18, -11, -4, 6, 12, 8, -3, -3, 0, -4, -5, -5, -5, -6, -5, -4, -4, -7};
        int[] y_coords = new int[]{0, -15, -13, -13, -13, -15, -18, -17, -18, -16, -24, -25, -26, -29, -35, -29, -30, -31, -26, -17, 0};
        drawPg(g, x_coords, y_coords, x, y, 0.9 * a, white, Color.BLACK, 5f);

        int[] x_coords2 = new int[]{-6, -4, -6, -14, -6, 9, -6, -3, -15, -3, 8, -3, 3, 5, -7, -10, -19, -22, -17, -22, -23, -19, -22, -19, -10, -15, -10, -7, 5, 14, 20, 23, 20, 20, 20, 16, 8, 5};
        int[] y_coords2 = new int[]{15, 29, 15, 18, 15, 12, 15, 6, 10, 6, 5, 6, -4, -3, 0, 1, 4, 6, 29, 6, 4, 4, 6, 4, 1, -5, 1, 0, -2, -2, 1, 2, 3, 1, 2, 21, 29, 22};
        drawPg(g, x_coords2, y_coords2, x, y, 1 * a, white, Color.BLACK, 5f);
    }
}
