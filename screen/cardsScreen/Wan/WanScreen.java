package screen.cardsScreen.Wan;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.ChooseDrawable;
import screen.cardsScreen.Drawable;

import static screen.cardsScreen.CardScreen.*;

// Singleton pattern
// Composite pattern
public class WanScreen implements ChooseDrawable {
    private static WanScreen wan=new WanScreen();
    private Drawable[] wans= new Drawable[]{new MJ18(),new MJ19(),new MJ20(),new MJ21(),new MJ22(),new MJ23(),new MJ24(),new MJ25(),new MJ26()};
    private WanScreen(){}
    public static WanScreen getWan(){
        return wan;
    }
    protected static void drawWan(GraphicsContext g, double x, double y, double a){
        int[] x_coords2 = new int[]{-16, -12};
        int[] y_coords2 = new int[]{23, 36};
        drawPg(g, x_coords2, y_coords2, x, y, a, white, red, 4.0f);

        int[] x_coords3 = new int[]{6, -10, -12, -2, 3, -7, -9, -7, -6, -7, -17, -7, 3, 6, 3, 6, 3, 13, 3, -2, 6, 10, 6};
        int[] y_coords3 = new int[]{17, 19, 10, 8, 0, 2, -5, 2, 6, 2, 3, 2, 0, -5, -8, -5, 0, -1, 0, 8, 7, 10, 18};
        drawPg(g, x_coords3, y_coords3, x, y, a, white, red, 4.0f);

        int[] x_coords4 = new int[]{10, 15, 18, 16, -1, -1, 8, 4, 8, 11, 8, -1, -10, -1, -1, -19, -1, -1, 4, -1, -8, -1, -1, -2, -1, -1, -1, 16, 18, 15, 10};
        int[] y_coords4 = new int[]{36, 37, 24, 22, 24, 29, 28, 25, 28, 32, 28, 29, 30, 29, 24, 28, 24, 13, 13, 13, 14, 13, 10, 8, 10, 13, 24, 22, 24, 37, 36};
        drawPg(g, x_coords4, y_coords4, x, y, a, white, red, 4.0f);
    }

    @Override
    public void chooseDraw(int i, GraphicsContext g, double x, double y, double a) {
        wans[i].draw(g,x,y,a);
    }
}
