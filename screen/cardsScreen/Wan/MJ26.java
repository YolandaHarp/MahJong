package screen.cardsScreen.Wan;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.drawPg;
import static screen.cardsScreen.CardScreen.white;
import static screen.cardsScreen.Wan.WanScreen.drawWan;

class MJ26 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-9,-3,-6,-16,-6,-3,-9};
        int[] y_coords = new int[]{-39,-30,-20,-9,-20,-30,-39};
        drawPg(g, x_coords, y_coords, x, y-1*a, a, white, Color.BLACK, 4.4f);

        drawWan(g,x,y,a);

        int[] x_coords5 = new int[]{-17,-6,8,8,9,8,2,4,20,16,16,16,16,20,4,2,8,9,8,8,-6,-17};
        int[] y_coords5 = new int[]{-29,-29,-34,-32,-32,-34,-19,-16,-16,-16,-23,-23,-16,-16,-16,-19,-34,-32,-32,-34,-29,-29};
        drawPg(g, x_coords5, y_coords5, x, y+1*a, a, white, Color.BLACK, 4.4f);
    }
}
