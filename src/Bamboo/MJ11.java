package screen.cardsScreen.Bam;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.Bam.BamScreen.drawBam;
import static screen.cardsScreen.CardScreen.green;

public class MJ11 implements Drawable {
    @Override
    public void draw(GraphicsContext g, int x, int y, double a) {
        drawBam(g, (int) (x-15*a),y,a,green);
        drawBam(g, (int) (x+15*a),y,a,green);
        drawBam(g,x, (int) (y-45*a),a,green);
    }
}
