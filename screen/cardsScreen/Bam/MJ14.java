package screen.cardsScreen.Bam;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.Bam.BamScreen.drawBam;
import static screen.cardsScreen.CardScreen.green;

public class MJ14 implements Drawable {
    @Override
    public void draw(GraphicsContext g, double x, double y, double a) {
        int[] xList=new int[]{-15,0,15};
        int[] yList=new int[]{-45,0};
        for(int i:xList){
            for(int j:yList){
                drawBam(g, (x+i*a), (y+j*a),a,green);
            }
        }
    }
}
