package screen.cardsScreen.Letter;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.*;

public class MJ27 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords2 = new int[]{-21,-17,-3,12,18,21,18,13,-12,-18,-20,-21};
        int[] y_coords2 = new int[]{-22,-21,-23,-25,-21,-20,-20,-2,0,-3,-18,-22};
        drawPg(g, x_coords2, y_coords2, x, y+4*a, 0.7*a, white, Color.BLACK, 6.8f);

        int[] x_coords = new int[]{-3,-6,1,-3,-3,-3,-14,-3,10,-3,-3,-9,-3,6,-3,-3,-5,-8,-3,-3};
        int[] y_coords = new int[]{-40,-35,-36,-40,-35,-27,-26,-27,-29,-27,-13,-12,-13,-14,-13,30,26,23,24,-40};
        drawPg(g, x_coords, y_coords, x, y+5*a, 0.9*a, white, Color.BLACK, 4.8f);

        int[] x_coords3 = new int[]{-23,-3,0,12,22,16,0,-3,-23};
        int[] y_coords3 = new int[]{21,1,2,14,18,20,2,1,21};
        drawPg(g, x_coords3, y_coords3, x, y+3*a, a, white, Color.BLACK, 4.6f);
    }
}
