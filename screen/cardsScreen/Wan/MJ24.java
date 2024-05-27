package screen.cardsScreen.Wan;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.drawPg;
import static screen.cardsScreen.CardScreen.white;
import static screen.cardsScreen.Wan.WanScreen.drawWan;

public class MJ24 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-15,11,18,18,11,-13,-15};
        int[] y_coords = new int[]{-14,-31,-30,-29,-29,-14,-14};
        drawPg(g, x_coords, y_coords, x, y, a, white, Color.BLACK, 4.2f);

        drawWan(g,x,y,a);
        int[] x_coords5 = new int[]{-2,-2,-4,-2,1,-2,-2,1,13,13,1,-2,-2};
        int[] y_coords5 = new int[]{-28,-33,-35,-37,-34,-33,-18,-14,-14,-15,-15,-18,-28};
        drawPg(g, x_coords5, y_coords5, x, y, a, white, Color.BLACK, 4.2f);
    }
}
