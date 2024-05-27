package screen.cardsScreen.Wan;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.drawPg;
import static screen.cardsScreen.CardScreen.white;
import static screen.cardsScreen.Wan.WanScreen.drawWan;

public class MJ23 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-21, -16, 17, 20, 10, -16};
        int[] y_coords = new int[]{-29, -27, -32, -28, -30, -27};
        drawPg(g, x_coords, y_coords, x, y, 0.9*a, white, Color.BLACK, 4.2f);

        drawWan(g,x,y,a);

        int[] x_coords5 = new int[]{0,0,-2,0,3,0,0};
        int[] y_coords5 = new int[]{-28,-33,-35,-37,-34,-33,-28};
        drawPg(g, x_coords5, y_coords5, x, y, a, white, Color.BLACK, 4.0f);

        int[] x_coords6 = new int[]{-4,-9,-14,-9,-2,-4};
        int[] y_coords6 = new int[]{-21,-13,-10,-13,-19,-21};
        drawPg(g, x_coords6, y_coords6, x-1*a, y+1*a, a, white, Color.BLACK, 4.0f);

        int[] x_coords7 = new int[]{6,9,12,11,6};
        int[] y_coords7 = new int[]{-19,-18,-14,-13,-19};
        drawPg(g, x_coords7, y_coords7, x, y+3*a, 1.1*a, white, Color.BLACK, 4.2f);
    }
}
