package screen.cardsScreen.Letter;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.*;

class MJ33 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{20, 22, 22, 20, -20, -22, -22, -20};
        int[] y_coords = new int[]{-36, -34, 35, 37, 37, 35, -34, -36};
        drawPg(g, x_coords, y_coords, x, y, a, white, Color.BLACK, 4.0f);

        int[] x_coords2 = new int[]{17, 17, -17, -17};
        int[] y_coords2 = new int[]{-31, 32, 32, -31};
        drawPg(g, x_coords2, y_coords2, x, y, a, white, Color.BLACK, 3.0f);

        int[] x_coords3 = new int[]{17, 17, 8};
        int[] y_coords3 = new int[]{-31, -22, -31};
        drawPg(g, x_coords3, y_coords3, x, y, a, white, Color.BLACK, 2.0f);

        int[] x_coords4 = new int[]{-17, -17, -8};
        int[] y_coords4 = new int[]{-31, -22, -31};
        drawPg(g, x_coords4, y_coords4, x, y, a, white, Color.BLACK, 2.0f);

        int[] x_coords5 = new int[]{-17, -17, -8};
        int[] y_coords5 = new int[]{31, 22, 31};
        drawPg(g, x_coords5, y_coords5, x, y, a, white, Color.BLACK, 2.0f);

        int[] x_coords6 = new int[]{17, 17, 8};
        int[] y_coords6 = new int[]{31, 22, 31};
        drawPg(g, x_coords6, y_coords6, x, y, a, white, Color.BLACK, 2.0f);
    }
}
