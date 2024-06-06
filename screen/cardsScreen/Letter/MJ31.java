package screen.cardsScreen.Letter;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.CardScreen.*;

class MJ31 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-21,-19,0,8,12,19,18,14,9,8,5,-7,-10,-13,-14,-21};
        int[] y_coords = new int[]{-27,-26,-30,-32,-32,-27,-27,-21,-17,-19,-19,-17,-16,-16,-15,-27};
        drawPg(g, x_coords, y_coords, x, y+15*a, a, white, red, 5f);

        int[] x_coords2 = new int[]{0,-1,-1,-5,-2,4,1,1,0};
        int[] y_coords2 = new int[]{38,35,-22,-22,-25,-22,-22,35,38};
        drawPg(g, x_coords2, y_coords2, x-3*a, y-8*a, a, white, red, 4.4f);
    }
}
