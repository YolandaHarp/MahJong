package screen.cardsScreen.Bam;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.CardScreen.*;
import static screen.cardsScreen.CardScreen.green;

public class MJ16 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        new MJ12().draw(g,x,y,a);
        int[] x_coords5 = new int[]{1,13,13,0,-12,-12,-1};
        int[] y_coords5 = new int[]{-26,-13,-6,-21,-6,-13,-26};
        drawPg(g, x_coords5, y_coords5, x, y, 1.1*a, white, green, 3.5f);

        int[] x_coords6 = new int[]{1,13,13,0,-12,-12,-1};
        int[] y_coords6 = new int[]{28,16,10,23,10,16,28};
        drawPg(g, x_coords6, y_coords6, x, y, 1.1*a, white, green, 3.5f);
    }
}
