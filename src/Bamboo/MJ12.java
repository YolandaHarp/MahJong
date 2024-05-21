package screen.cardsScreen.Bam;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

public class MJ12 implements Drawable {
    @Override
    public void draw(GraphicsContext g, int x, int y, double a) {
        new MJ10().draw(g, (int) (x-17*a),y,a);
        new MJ10().draw(g, (int) (x+17*a),y,a);
    }
}
