package screen.cardsScreen.Letter;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.*;

public class MJ30 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-16,-16,-25,-30,-25,-16,-16,-23,-27,-23,-16,-16,-19,-24,-19,-16,-16,-4,-16,-16};
        int[] y_coords = new int[]{24,11,20,18,20,11,6,4,1,4,6,-10,-13,-10,-13,-10,11,-6,11,24};
        drawPg(g, x_coords, y_coords, x+6*a, y+2*a, a, white, Color.BLACK, 4.4f);

        int[] x_coords5 = new int[]{-9,-5,-3,7,-3,-3,4,8,6,8,4,-3,-4,0,11,15,11,0,-4,-3,-3,-5,-9};
        int[] y_coords5 = new int[]{-21,-26,-21,-21,-21,5,3,1,-5,1,3,5,14,20,20,15,19,19,14,5,-21,-26,-21};
        drawPg(g, x_coords5, y_coords5, x+7*a, y, a, white, Color.BLACK, 5.2f);
    }
}
