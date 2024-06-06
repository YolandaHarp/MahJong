package screen.cardsScreen.Wan;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.drawPg;
import static screen.cardsScreen.CardScreen.white;
import static screen.cardsScreen.Wan.WanScreen.drawWan;

class MJ22 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-9,-9,-13,-22,-13,-13,-13,-9,-9};
        int[] y_coords = new int[]{-39,-33,-28,-21,-28,-8,-28,-33,-39};
        drawPg(g, x_coords, y_coords, x, y, a, white, Color.BLACK, 4.2f);

        drawWan(g,x,y,a);

        int[] x_coords5 = new int[]{-4,6,8,3,0,-8,0,7,10,9,8,17,22,17,8,-5,-11,-5,0,3,-4};
        int[] y_coords5 = new int[]{-34,-37,-36,-36,-27,-25,-27,-28,-26,-26,-15,-16,-14,-16,-15,-14,-13,-14,-27,-36,-34};
        drawPg(g, x_coords5, y_coords5, x, y, a, white, Color.BLACK, 4.4f);
    }
}
