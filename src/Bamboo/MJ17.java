package screen.cardsScreen.Bam;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.Bam.BamScreen.drawBam;
import static screen.cardsScreen.CardScreen.green;
import static screen.cardsScreen.CardScreen.red;

public class MJ17 implements Drawable {
    @Override
    public void draw(GraphicsContext g, int x, int y, double a) {
        int[] xList=new int[]{-17,0,17};
        int[] yList=new int[]{10,-18,-46};
        for(int i:xList){
            for(int j:yList){
                if(i==0){
                    drawBam(g, (int) (x + i * a), (int) (y + j * a), 0.75 * a, red);
                }else {
                    drawBam(g, (int) (x + i * a), (int) (y + j * a), 0.75 * a, green);
                }
            }
        }
    }
}
