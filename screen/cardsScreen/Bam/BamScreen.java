package screen.cardsScreen.Bam;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.ChooseDrawable;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.*;

// Singleton pattern
// Composite pattern
public class BamScreen implements ChooseDrawable {
    private static BamScreen bam=new BamScreen();

    Drawable[] bams=new Drawable[]{new MJ9(),new MJ10(),new MJ11(),new MJ12(),new MJ13(),new MJ14(),new MJ15(),new MJ16(),new MJ17()};
    private BamScreen(){}
    public static BamScreen getBam(){
        return bam;
    }
    protected static void drawBam(GraphicsContext g, double x, double y, double a, Color color){
        int[] x_coords = new int[]{0, 3, 3, 0, -3, -3, 0};
        int[] y_coords = new int[]{37, 34, 10, 7, 10, 34, 37};
        drawPg(g, x_coords, y_coords, x, y, 1.1*a, white, color, 3.5f);
    }

    @Override
    public void chooseDraw(int i, GraphicsContext g, double x, double y, double a) {
        bams[i].draw(g,x,y,a);
    }
}
