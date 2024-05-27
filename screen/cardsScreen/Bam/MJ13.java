package screen.cardsScreen.Bam;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.Bam.BamScreen.drawBam;
import static screen.cardsScreen.CardScreen.red;

public class MJ13 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        new MJ12().draw(g,x,y,a);
        drawBam(g,x, (y-22*a),a,red);
    }
}
