package screen.cardsScreen.Wan;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.drawPg;
import static screen.cardsScreen.CardScreen.white;
import static screen.cardsScreen.Wan.WanScreen.drawWan;

public class MJ18 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] x_coords = new int[]{-20, -15, 15, 18, 10, -15};
        int[] y_coords = new int[]{-27, -26, -30, -26, -28, -26};
        drawPg(g, x_coords, y_coords, x, y, a, white, Color.BLACK, 4.0f);
        drawWan(g,x,y,a);
    }
}
