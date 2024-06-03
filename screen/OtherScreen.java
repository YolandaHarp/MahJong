package screen;
import static screen.cardsScreen.CardScreen.drawPg;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class OtherScreen {
    public static void exitButton(GraphicsContext g, int x, int y, double a){

            int[] x_coords2 = new int[]{10,10,-10,-10,10,10,10,-10,-10,10,10};
            int[] y_coords2 = new int[]{-5,-13,-13,13,13,5,13,13,-13,-13,-5};
            drawPg(g, x_coords2, y_coords2, x, y, 1.5*a, Color.WHITE, Color.WHITE, 4.0f);

            int[] x_coords = new int[]{18,12,13,12,18};
            int[] y_coords = new int[]{0,-3,0,3,0};
            drawPg(g, x_coords, y_coords, x+16, y-1, a, Color.WHITE, Color.WHITE, 5.8f);

            int[] x_coords3 = new int[]{3,24,3};
            int[] y_coords3 = new int[]{0,0,0};
            drawPg(g, x_coords3, y_coords3, x+2, y-1, a, Color.WHITE, Color.WHITE, 5.8f);

    }
    public static void infoButton(GraphicsContext g, int x, int y, double a){
            int[] x_coords2 = new int[]{11,8,-8,-8,9,11,9,-8,-8,8,11};
            int[] y_coords2 = new int[]{-11,-13,-13,13,13,14,13,13,-13,-13,-11};
            drawPg(g, x_coords2, y_coords2, x-16, y, 1.5*a, Color.WHITE, Color.WHITE, 2.0f);

            int[] x_coords = new int[]{-11,-8,8,8,-9,-11,-9,8,8,-8,-11};
            int[] y_coords = new int[]{-11,-13,-13,13,13,14,13,13,-13,-13,-11};
            drawPg(g, x_coords, y_coords, x+16, y, 1.5*a, Color.WHITE, Color.WHITE, 2.0f);

            int[] x_coords3 = new int[]{0,0};
            int[] y_coords3 = new int[]{20,-17};
            drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, Color.WHITE, 2.5f);

            int[] x_coords4 = new int[]{-21,-21,21,21,21,-21,-21};
            int[] y_coords4 = new int[]{-13,15,15,-13,15,15,-13};
            drawPg(g, x_coords4, y_coords4, x, y+2, 1.5*a, Color.WHITE, Color.WHITE, 2.6f);
    }
}
