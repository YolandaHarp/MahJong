package screen.cardsScreen.Letter;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.CardScreen.*;

public class MJ32 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-15, -6, -6, 0, 8, 6, 8, 0, 6, 15, 13, 15, 6, 20, 26, 20, 6, 0, -6, -10, -18, -10, -13, -24, -13, -5, -6, -12, -6, -13, -6, -11, -16, -11, -6, -13, -6, -12, -6, -5, -13, -9, -6, -6, -15};
        int[] y_coords = new int[]{-20, -23, -19, -19, -24, -28, -24, -20, -15, -19, -23, -19, -15, -7, -7, -7, -15, -19, -19, -12, -13, -12, -4, 7, -4, -5, -1, 3, 3, 11, 10, 21, 16, 21, 10, 11, 3, 3, -1, -5, -4, -12, -19, -23, -20};
        drawPg(g, x_coords, y_coords, x, y, 1.15 * a, white, green, 4.0f);

        int[] x_coords2 = new int[]{1, 1, 9, 9, 14, 10, 0, 10, 8, -4, 8, -3, 8, 20, 8, 10, 0, 9, 9, 1};
        int[] y_coords2 = new int[]{3, -7, -9, -1, -3, -1, 7, 5, 15, 7, 15, 19, 15, 23, 15, 5, 7, -1, -9, -7};
        drawPg(g, x_coords2, y_coords2, x, y, 1.15 * a, white, green, 4.0f);
    }
}
