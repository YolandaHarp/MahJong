package screen.cardsScreen.Bam;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.Bam.BamScreen.drawBam;
import static screen.cardsScreen.CardScreen.green;

public class MJ11 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        drawBam(g, (x-15*a),y,a,green);
        drawBam(g, (x+15*a),y,a,green);
        drawBam(g,x, (y-45*a),a,green);
    }
}
