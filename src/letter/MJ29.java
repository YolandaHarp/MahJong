package screen.cardsScreen.Letter;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.*;

public class MJ29 implements Drawable {
    @Override
    public void draw(GraphicsContext g, int x, int y, double a) {
        int[] x_coords = new int[]{-11,-8,8,14,10,-8,-11};
        int[] y_coords = new int[]{-25,-25,-32,-28,-28,-24,-25};
        drawPg(g, x_coords, y_coords, x-2, y+4, 0.9*a, white, Color.BLACK, 4.0f);

        int[] x_coords2 = new int[]{-21,-18,-8,0,8,14,17,22,19,15,9,8,5,-7,-10,-10,-13,-21};
        int[] y_coords2 = new int[]{-28,-28,-31,-33,-34,-35,-32,-29,-28,-15,-9,-13,-15,-13,-11,-10,-12,-28};
        drawPg(g, x_coords2, y_coords2, x, y+35, 1.05*a, white, Color.BLACK, 5.2f);

        int[] x_coords3 = new int[]{0,2,4,2,2,12,8,0,4,2,2,0};
        int[] y_coords3 = new int[]{-12,-14,-11,-11,8,10,9,15,9,8,-11,-12};
        drawPg(g, x_coords3, y_coords3, x, y, a, white, Color.BLACK, 4.6f);

        int[] x_coords5 = new int[]{-14,-5,-7,-5,-5,-8,-5,-5,-14};
        int[] y_coords5 = new int[]{-1,-3,-9,-3,10,17,10,-3,-1};
        drawPg(g, x_coords5, y_coords5, x-2, y-1, a, white, Color.BLACK, 4.6f);
    }
}
