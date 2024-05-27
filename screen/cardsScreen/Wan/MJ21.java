package screen.cardsScreen.Wan;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.drawPg;
import static screen.cardsScreen.CardScreen.white;
import static screen.cardsScreen.Wan.WanScreen.drawWan;

public class MJ21 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-20,-19,-8,0,8,14,17,20,18,14,9,8,5,-7,-10,-13,-20};
        int[] y_coords = new int[]{-27,-27,-31,-33,-34,-34,-32,-29,-28,-21,-17,-20,-22,-20,-18,-17,-27};
        drawPg(g, x_coords, y_coords, x, y, a, white, Color.BLACK, 4.5f);
        drawWan(g,x,y,a);

        int[] x_coords5 = new int[]{-8,0,6,1,-7,-8};
        int[] y_coords5 = new int[]{-31,-33,-34,-22,-20,-32};
        drawPg(g, x_coords5, y_coords5, x, y, a, white, Color.BLACK, 4.5f);
    }
}
