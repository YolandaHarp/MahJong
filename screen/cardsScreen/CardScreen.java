package screen.cardsScreen;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CardScreen {
    private static CardScreen card=new CardScreen();
    public static Color green = Color.rgb(0, 100, 0);
    public static Color red= Color.rgb(180, 20, 30);
    public static Color white =Color.rgb(230, 230, 230);
    public static Color blue =Color.rgb(142, 155, 255);
    private CardScreen(){}
    public static CardScreen getCard(){
        return card;
    }
    public static void drawPg(GraphicsContext g, int[] x_coords, int[] y_coords, double x, double y, double a, Color color1, Color color2, float f) {
        double oldLineWidth = g.getLineWidth();
        g.setLineWidth(f * a);
        double[] x_adjusted = new double[x_coords.length];
        double[] y_adjusted = new double[y_coords.length];
        for (int i = 0; i < x_coords.length; i++) {
            x_adjusted[i] = x + x_coords[i] * a;
            y_adjusted[i] = y + y_coords[i] * a;
        }
        g.setFill(color1);
        g.setStroke(color2);
        g.fillPolygon(x_adjusted, y_adjusted, x_adjusted.length);
        g.strokePolygon(x_adjusted, y_adjusted, x_adjusted.length);
        g.setLineWidth(oldLineWidth);
    }

    public static void drawO(GraphicsContext g, double x, double y, int i, int j, int h, double a, Color color1, Color color2, float f) {
        double oldLineWidth = g.getLineWidth();
        g.setLineWidth(f * a);
        g.setFill(color1);
        g.setStroke(color2);
        g.fillOval((x - (500 - i) * a), (y - (500 - j) * a),(h * a), (h * a));
        g.strokeOval( (x - (500 - i) * a), (y - (500 - j) * a), (h * a), (h * a));
        g.setLineWidth(oldLineWidth);
    }
    void drawDown(GraphicsContext g, int x, int y, double a) {
        int[] x_coords = new int[]{-13, -9, -13, -13, -9, 9, 13, 13, 9, 13, 13, 9, -9, -13, -13};
        int[] y_coords = new int[]{-40, -44, -48, -40, -44, -44, -48, -40, -44, -40, 20, 24, 24, 20, -40};
        drawPg(g, x_coords, y_coords, x, y, a, blue, white, 1.0f);


    }

    void drawDownRight(GraphicsContext g, int x, int y, double a) {
        drawDown(g, x, y, a);

    }

    void drawCardFlank(GraphicsContext g, int x, int y, double a) {
        int[] x_coords = new int[]{30, 34, 34, 30, -30, -34, -34, -30};
        int[] y_coords = new int[]{48, 44, -44, -48, -48, -44, 44, 48};
        drawPg(g, x_coords, y_coords, x, y, a, blue, Color.BLACK, 2.0f);
    }

    public void drawCardUpper(GraphicsContext g, int x, int y, double a) {
        int[] x_coords = new int[]{-82, -78, -48, -44, -44, -48, -78, -82};
        int[] y_coords = new int[]{6, 10, 10, 6, -6, -10, -10, -6};
        drawPg(g, x_coords, y_coords, x, y, a, blue, Color.BLACK, 1.0f);
        x_coords = new int[]{-44, -48, -78, -82};
        y_coords = new int[]{ 6, 10, 10, 6};
        drawPg(g, x_coords, y_coords, x, y, a, white, white, 1.0f);
    }

    public void drawCardFront(GraphicsContext g, int x, int y, double a) {
        int[] x_coords = new int[]{30, 34, 34, 30, -30, -34, -34, -30};
        int[] y_coords = new int[]{48, 44, -44, -48, -48, -44, 44, 48};
        drawPg(g, x_coords, y_coords, x, y, a, white, Color.BLACK, 2.0f);
    }
    public void drawCardFrontHun(GraphicsContext g, int x, int y, double a) {
        int[] x_coords = new int[]{-18, -34, -34, -30};
        int[] y_coords = new int[]{-48, -32, -44, -48};
        drawPg(g, x_coords, y_coords, x, y, a, red, Color.BLACK, 1.0f);
    }

    void drawCardStand(GraphicsContext g, int x, int y, double a) {
        drawCardFlank(g, x, (int) (y - 16 * a), a);
        drawCardFront(g, x, y, a);
    }

    void drawCardReverseStand(GraphicsContext g, int x, int y, double a) {
        drawCardFlank(g, x, (int) (y - 16 * a), a);
        drawCardBack(g, x, y, a);
    }

    void drawCardLaid(GraphicsContext g, int x, int y, double a) {
        drawCardFlank(g, x, (int) (y + 16 * a), a);
        drawCardFront(g, x, y, a);
    }

    void drawCardReverseLaid(GraphicsContext g, int x, int y, double a) {
        drawCardFlank(g, x, (int) (y + 16 * a), a);
        drawCardBack(g, x, y, a);
    }

    public void drawCardBack(GraphicsContext g, int x, int y, double a) {
        drawCardFlank(g,x,y,a);

        int[] x_coords2 = new int[]{-15, -22, -12, -22, -8, -6, 4, 12, 20, 26, 24, 34, 27, 34, 22, 19, 6, 2, 0, -30, -6, -32, -12, -32, -17, -30, -15};
        int[] y_coords2 = new int[]{-4, -10, -12, -20, -20, -34, -27, -38, -22, -26, -15, -13, -8, 5, 8, 26, 17, 25, 16, 32, 15, 26, 8, 20, 2, 10, -4};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.rgb(200, 160, 0), Color.rgb(200, 160, 0), 1.0f);
        drawO(g, x, y, 483, 475, 43, a, Color.rgb(180, 80, 0), Color.rgb(180, 80, 0), 3.0f);
        int[] x_coords3 = new int[]{-15, 14, 25, 14, 4, 14, 12, -11, 12, 14, 12, 21, 12, 14, 12, 14, 13, -10, 13, 14, 13, 24, 13, 14};
        int[] y_coords3 = new int[]{-2, -8, -8, -8, -25, -8, -12, -18, -12, -8, -12, -16, -12, -8, 16, -8, -4, 12, -4, -8, -4, 2, -4, -8};
        drawPg(g, x_coords3, y_coords3, x, y, a, white, Color.BLACK, 3.0f);
    }
}
