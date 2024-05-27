package screen.cardsScreen.Bam;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

public class MJ12 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        new MJ10().draw(g, (x-17*a),y,a);
        new MJ10().draw(g,  (x+17*a),y,a);
    }
}
