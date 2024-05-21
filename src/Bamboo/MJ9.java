package screen.cardsScreen.Bam;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.CardScreen.*;

public class MJ9 implements Drawable {
    @Override
    public void draw(GraphicsContext g, int x, int y, double a) {
        int[] x_coords = new int[]{-20, -8, -20, -8, -13, -8, -6, -8, 0, 0, 0, 8, 6, 8, 8, 0, -4, 4, 16, 4, -4, 0, -8, -20, -8, -8, -13, -10, 8, 9, 20, 9, 14, 8, 14, 9, 8, -8};
        int[] y_coords = new int[]{14, 0, -4, 0, -14, -16, -4, -16, -10, -4, -10, -16, -6, -16, -24, -30, -34, -31, -38, -31, -34, -30, -24, -26, -24, -16, -18, 0, -2, -4, -4, -4, -20, -16, -20, -4, -2, 0};
        drawPg(g, x_coords, y_coords, x, y, a, white, green, 3.0f);

        int[] x_coords2 = new int[]{-8, -3, -5, 6, -4, 2, 4, 9, 4, 8, -8};
        int[] y_coords2 = new int[]{0, 26, 2, 42, 0, 4, 0, 36, 14, -2, 0};
        drawPg(g, x_coords2, y_coords2, x, y, a, white, green, 3.0f);

        drawO(g, x, y, 495, 475, 6, a, white, red, 3.0f);
        drawO(g, x, y, 475, 492, 7, a, white, green, 4.0f);
        drawO(g, x, y, 517, 492, 7, a, white, green, 4.0f);
    }
}
