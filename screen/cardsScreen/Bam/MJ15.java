package screen.cardsScreen.Bam;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.Bam.BamScreen.drawBam;
import static screen.cardsScreen.CardScreen.green;
import static screen.cardsScreen.CardScreen.red;

public class MJ15 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] xList=new int[]{-17,0,17};
        int[] yList=new int[]{10,-18};
        for(int i:xList){
            for(int j:yList){
                drawBam(g,  (x+i*a),  (y+j*a),0.75*a,green);
            }
        }
        drawBam(g,x,  (y-46*a),0.75*a,red);
    }
}
