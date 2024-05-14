import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    String[] table = new String[]{"一筒", "二筒", "三筒", "四筒", "五筒", "六筒", "七筒", "八筒", "九筒",
            "一条", "二条", "三条", "四条", "五条", "六条", "七条", "八条", "九条",
            "一万", "二万", "三万", "四万", "五万", "六万", "七万", "八万", "九万", "东", "南", "西",
            "北", "中", "発", "白", "混"};//从0开始数
    private int x = 50;
    private int y = 50;
    private int a = 1;

    void drawPg(Graphics g, int[] x_coords, int[] y_coords, int x, int y, double a, Color color1, Color color2, float f) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        Stroke newStroke = new BasicStroke((float) (f * a));
        g2d.setStroke(newStroke);
        int[] x_adjusted = new int[x_coords.length];
        int[] y_adjusted = new int[y_coords.length];
        for (int i = 0; i < x_coords.length; i++) {
            x_adjusted[i] = (int) (x + x_coords[i] * a);
            y_adjusted[i] = (int) (y + y_coords[i] * a);
        }
        Polygon pg = new Polygon(x_adjusted, y_adjusted, x_adjusted.length);
        g.setColor(color1);
        g.fillPolygon(pg);
        g.setColor(color2);
        g.drawPolygon(pg);
        g2d.setStroke(oldStroke);
    }

    void drawO(Graphics g, int x, int y, int i, int j, int h, double a, Color color1, Color color2, float f) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        Stroke newStroke = new BasicStroke((float) (f * a));
        g2d.setStroke(newStroke);
        g.setColor(color1);
        g.fillOval((int) (x - (500 - i) * a), (int) (y - (500 - j) * a), (int) (h * a), (int) (h * a));
        g.setColor(color2);
        g.drawOval((int) (x - (500 - i) * a), (int) (y - (500 - j) * a), (int) (h * a), (int) (h * a));
        g2d.setStroke(oldStroke);
    }

    void drawDown(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{-13, -9, -13, -13, -9, 9, 13, 13, 9, 13, 13, 9, -9, -13, -13};
        int[] y_coords = new int[]{-40, -44, -48, -40, -44, -44, -48, -40, -44, -40, 20, 24, 24, 20, -40};
        drawPg(g, x_coords, y_coords, x, y, a, new Color(80, 180, 30), Color.WHITE, 1.0f);


    }

    void drawDownRight(Graphics g, int x, int y, double a) {
        drawDown(g, x, y, a);

    }

    void drawCardFlank(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{30, 34, 34, 30, -30, -34, -34, -30};
        int[] y_coords = new int[]{48, 44, -44, -48, -48, -44, 44, 48};
        drawPg(g, x_coords, y_coords, x, y, a, new Color(100, 200, 50), Color.WHITE, 1.0f);
    }

    void drawCardUpper(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{9, 13, 13, 9, -9, -13, -13, -9};
        int[] y_coords = new int[]{-82, -78, -48, -44, -44, -48, -78, -82};
        drawPg(g, x_coords, y_coords, x, y, a, new Color(100, 200, 50), Color.WHITE, 1.0f);
    }

    void drawCardUpperLeft(Graphics g, int x, int y, double a) {
        drawCardUpper(g, x, y, a);
        int[] x_coords = new int[]{-9, -13, -13, -9};
        int[] y_coords = new int[]{-44, -48, -78, -82};
        drawPg(g, x_coords, y_coords, x, y, a, Color.WHITE, Color.WHITE, 1.0f);
    }

    void drawCardUpperRight(Graphics g, int x, int y, double a) {
        drawCardUpper(g, x, y, a);
        int[] x_coords = new int[]{9, 13, 13, 9};
        int[] y_coords = new int[]{-82, -78, -48, -44};
        drawPg(g, x_coords, y_coords, x, y, a, Color.WHITE, Color.WHITE, 1.0f);
    }

    void drawCardFront(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{30, 34, 34, 30, -30, -34, -34, -30};
        int[] y_coords = new int[]{48, 44, -44, -48, -48, -44, 44, 48};
        drawPg(g, x_coords, y_coords, x, y, a, new Color(230, 230, 230), Color.WHITE, 1.0f);
    }
    void drawCardFronthui(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{30, 34, 34, 30, -30, -34, -34, -30};
        int[] y_coords = new int[]{48, 44, -44, -48, -48, -44, 44, 48};
        drawPg(g, x_coords, y_coords, x, y, a, new Color(200, 180, 220), new Color(120, 120, 120), 1.0f);
    }

    void drawCardStand(Graphics g, int x, int y, double a) {
        drawCardFlank(g, x, (int) (y - 16 * a), a);
        drawCardFront(g, x, y, a);
    }

    void drawCardReverseStand(Graphics g, int x, int y, double a) {
        drawCardFlank(g, x, (int) (y - 16 * a), a);
        drawCardBack(g, x, y, a);
    }

    void drawCardLaid(Graphics g, int x, int y, double a) {
        drawCardFlank(g, x, (int) (y + 16 * a), a);
        drawCardFront(g, x, y, a);
    }

    void drawCardReverseLaid(Graphics g, int x, int y, double a) {
        drawCardFlank(g, x, (int) (y + 16 * a), a);
        drawCardBack(g, x, y, a);
    }

    void drawCardBack(Graphics g, int x, int y, double a) {

        int[] x_coords = new int[]{30, 34, 34, 30, -30, -34, -34, -30};
        int[] y_coords = new int[]{48, 44, -44, -48, -48, -44, 44, 48};
        drawPg(g, x_coords, y_coords, x, y, a, new Color(150, 200, 50), Color.WHITE, 1.0f);

        int[] x_coords2 = new int[]{-15, -22, -12, -22, -8, -6, 4, 12, 20, 26, 24, 34, 27, 34, 22, 19, 6, 2, 0, -30, -6, -32, -12, -32, -17, -30, -15};
        int[] y_coords2 = new int[]{-4, -10, -12, -20, -20, -34, -27, -38, -22, -26, -15, -13, -8, 5, 8, 26, 17, 25, 16, 32, 15, 26, 8, 20, 2, 10, -4};
        drawPg(g, x_coords2, y_coords2, x, y, a, new Color(200, 160, 0), new Color(200, 160, 0), 1.0f);
        drawO(g, x, y, 483, 475, 43, a, new Color(180, 80, 0), new Color(180, 80, 0), 3.0f);
        int[] x_coords3 = new int[]{-15, 14, 25, 14, 4, 14, 12, -11, 12, 14, 12, 21, 12, 14, 12, 14, 13, -10, 13, 14, 13, 24, 13, 14};
        int[] y_coords3 = new int[]{-2, -8, -8, -8, -25, -8, -12, -18, -12, -8, -12, -16, -12, -8, 16, -8, -4, 12, -4, -8, -4, 2, -4, -8};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, Color.BLACK, 3.0f);
    }

    void drawMJ9(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{-20, -8, -20, -8, -13, -8, -6, -8, 0, 0, 0, 8, 6, 8, 8, 0, -4, 4, 16, 4, -4, 0, -8, -20, -8, -8, -13, -10, 8, 9, 20, 9, 14, 8, 14, 9, 8, -8};
        int[] y_coords = new int[]{14, 0, -4, 0, -14, -16, -4, -16, -10, -4, -10, -16, -6, -16, -24, -30, -34, -31, -38, -31, -34, -30, -24, -26, -24, -16, -18, 0, -2, -4, -4, -4, -20, -16, -20, -4, -2, 0};
        drawPg(g, x_coords, y_coords, x, y, a, Color.WHITE, new Color(0, 100, 0), 3.0f);

        int[] x_coords2 = new int[]{-8, -3, -5, 6, -4, 2, 4, 9, 4, 8, -8};
        int[] y_coords2 = new int[]{0, 26, 2, 42, 0, 4, 0, 36, 14, -2, 0};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.WHITE, new Color(0, 100, 0), 3.0f);

        drawO(g, x, y, 495, 475, 6, a, Color.WHITE, new Color(180, 20, 30), 3.0f);
        drawO(g, x, y, 475, 492, 7, a, Color.WHITE, new Color(0, 100, 0), 4.0f);
        drawO(g, x, y, 517, 492, 7, a, Color.WHITE, new Color(0, 100, 0), 4.0f);
    }

    void drawMJ32(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{-15, -6, -6, 0, 8, 6, 8, 0, 6, 15, 13, 15, 6, 20, 26, 20, 6, 0, -6, -10, -18, -10, -13, -24, -13, -5, -6, -12, -6, -13, -6, -11, -16, -11, -6, -13, -6, -12, -6, -5, -13, -9, -6, -6, -15};
        int[] y_coords = new int[]{-20, -23, -19, -19, -24, -28, -24, -20, -15, -19, -23, -19, -15, -7, -7, -7, -15, -19, -19, -12, -13, -12, -4, 7, -4, -5, -1, 3, 3, 11, 10, 21, 16, 21, 10, 11, 3, 3, -1, -5, -4, -12, -19, -23, -20};
        drawPg(g, x_coords, y_coords, x, y, 1.15 * a, Color.WHITE, new Color(0, 100, 0), 4.0f);

        int[] x_coords2 = new int[]{1, 1, 9, 9, 14, 10, 0, 10, 8, -4, 8, -3, 8, 20, 8, 10, 0, 9, 9, 1};
        int[] y_coords2 = new int[]{3, -7, -9, -1, -3, -1, 7, 5, 15, 7, 15, 19, 15, 23, 15, 5, 7, -1, -9, -7};
        drawPg(g, x_coords2, y_coords2, x, y, 1.15 * a, Color.WHITE, new Color(0, 100, 0), 4.0f);
    }

    void drawMJ10(Graphics g, int x, int y, double a) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        Stroke newStroke = new BasicStroke((float) (a * 4.0f));
        g2d.setStroke(newStroke);

        int[] x_coords = new int[]{0, 3, 3, 0, -3, -3, 0};
        int[] y_coords = new int[]{37, 34, 10, 7, 10, 34, 37};
        drawPg(g, x_coords, y_coords, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords3 = new int[]{0, 3, 3, 0, -3, -3, 0};
        int[] y_coords3 = new int[]{-33, -30, -6, -3, -6, -30, -33};
        drawPg(g, x_coords3, y_coords3, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);
    }

    void drawMJ18(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{-20, -15, 15, 18, 10, -15};
        int[] y_coords = new int[]{-27, -26, -30, -26, -28, -26};
        drawPg(g, x_coords, y_coords, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.0f);

        int[] x_coords2 = new int[]{-16, -12};
        int[] y_coords2 = new int[]{23, 36};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords3 = new int[]{6, -10, -12, -2, 3, -7, -9, -7, -6, -7, -17, -7, 3, 6, 3, 6, 3, 13, 3, -2, 6, 10, 6};
        int[] y_coords3 = new int[]{17, 19, 10, 8, 0, 2, -5, 2, 6, 2, 3, 2, 0, -5, -8, -5, 0, -1, 0, 8, 7, 10, 18};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords4 = new int[]{10, 15, 18, 16, -1, -1, 8, 4, 8, 11, 8, -1, -10, -1, -1, -19, -1, -1, 4, -1, -8, -1, -1, -2, -1, -1, -1, 16, 18, 15, 10};
        int[] y_coords4 = new int[]{36, 37, 24, 22, 24, 29, 28, 25, 28, 32, 28, 29, 30, 29, 24, 28, 24, 13, 13, 13, 14, 13, 10, 8, 10, 13, 24, 22, 24, 37, 36};
        drawPg(g, x_coords4, y_coords4, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);


    }

    void drawMJ0(Graphics g, int x, int y, double a) {

        drawO(g, x, y, 470, 470, 60, a, Color.WHITE, new Color(0, 100, 0), 4.0f);
        drawO(g, x, y, 479, 479, 42, a, Color.WHITE, new Color(0, 100, 0), 10.0f);
        drawO(g, x, y, 489, 489, 22, a, Color.WHITE, new Color(180, 20, 30), 4.0f);
        drawO(g, x, y, 491, 491, 8, a, Color.WHITE, new Color(180, 20, 30), 4.0f);
        drawO(g, x, y, 501, 491, 8, a, Color.WHITE, new Color(180, 20, 30), 4.0f);
        drawO(g, x, y, 491, 500, 8, a, Color.WHITE, new Color(180, 20, 30), 4.0f);
        drawO(g, x, y, 501, 500, 8, a, Color.WHITE, new Color(180, 20, 30), 4.0f);
        drawO(g, x, y, 497, 477, 6, a, Color.WHITE, new Color(230, 250, 230), 2.0f);
        drawO(g, x, y, 497, 516, 6, a, Color.WHITE, new Color(230, 250, 230), 2.0f);
        drawO(g, x, y, 486, 481, 6, a, Color.WHITE, new Color(230, 250, 230), 2.0f);
        drawO(g, x, y, 508, 481, 6, a, Color.WHITE, new Color(230, 250, 230), 2.0f);
        drawO(g, x, y, 508, 513, 6, a, Color.WHITE, new Color(230, 250, 230), 2.0f);
        drawO(g, x, y, 486, 513, 6, a, Color.WHITE, new Color(230, 250, 230), 2.0f);
        drawO(g, x, y, 479, 491, 6, a, Color.WHITE, new Color(230, 250, 230), 2.0f);
        drawO(g, x, y, 515, 491, 6, a, Color.WHITE, new Color(230, 250, 230), 2.0f);
        drawO(g, x, y, 515, 504, 6, a, Color.WHITE, new Color(230, 250, 230), 2.0f);
        drawO(g, x, y, 479, 503, 6, a, Color.WHITE, new Color(230, 250, 230), 2.0f);


    }

    void drawMJ8(Graphics g, int x, int y, double a) {
        drawO(g, x, y, 473, 491, 18, a, Color.WHITE, new Color(180, 20, 30), 3.0f);
        drawO(g, x, y, 477, 495, 10, a, Color.WHITE, new Color(180, 20, 30), 2.0f);
        drawO(g, x, y, 481, 499, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);
        drawO(g, x, y, 491, 491, 18, a, Color.WHITE, new Color(180, 20, 30), 3.0f);
        drawO(g, x, y, 495, 495, 10, a, Color.WHITE, new Color(180, 20, 30), 2.0f);
        drawO(g, x, y, 499, 499, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);
        drawO(g, x, y, 509, 491, 18, a, Color.WHITE, new Color(180, 20, 30), 3.0f);
        drawO(g, x, y, 513, 495, 10, a, Color.WHITE, new Color(180, 20, 30), 2.0f);
        drawO(g, x, y, 517, 499, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);

        drawO(g, x, y, 473, 518, 18, a, Color.WHITE, new Color(0, 0, 0), 3.0f);
        drawO(g, x, y, 477, 522, 10, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 481, 526, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 491, 518, 18, a, Color.WHITE, new Color(0, 0, 0), 3.0f);
        drawO(g, x, y, 495, 522, 10, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 499, 526, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 509, 518, 18, a, Color.WHITE, new Color(0, 0, 0), 3.0f);
        drawO(g, x, y, 513, 522, 10, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 517, 526, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);

        drawO(g, x, y, 473, 464, 18, a, Color.WHITE, new Color(0, 100, 0), 3.0f);
        drawO(g, x, y, 477, 468, 10, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 481, 472, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 491, 464, 18, a, Color.WHITE, new Color(0, 100, 0), 3.0f);
        drawO(g, x, y, 495, 468, 10, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 499, 472, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 509, 464, 18, a, Color.WHITE, new Color(0, 100, 0), 3.0f);
        drawO(g, x, y, 513, 468, 10, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 517, 472, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);

    }

    void drawMJ33(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{20, 22, 22, 20, -20, -22, -22, -20};
        int[] y_coords = new int[]{-36, -34, 35, 37, 37, 35, -34, -36};
        drawPg(g, x_coords, y_coords, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.0f);

        int[] x_coords2 = new int[]{17, 17, -17, -17};
        int[] y_coords2 = new int[]{-31, 32, 32, -31};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.WHITE, new Color(0, 0, 0), 3.0f);

        int[] x_coords3 = new int[]{17, 17, 8};
        int[] y_coords3 = new int[]{-31, -22, -31};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, new Color(0, 0, 0), 2.0f);

        int[] x_coords4 = new int[]{-17, -17, -8};
        int[] y_coords4 = new int[]{-31, -22, -31};
        drawPg(g, x_coords4, y_coords4, x, y, a, Color.WHITE, new Color(0, 0, 0), 2.0f);

        int[] x_coords5 = new int[]{-17, -17, -8};
        int[] y_coords5 = new int[]{31, 22, 31};
        drawPg(g, x_coords5, y_coords5, x, y, a, Color.WHITE, new Color(0, 0, 0), 2.0f);

        int[] x_coords6 = new int[]{17, 17, 8};
        int[] y_coords6 = new int[]{31, 22, 31};
        drawPg(g, x_coords6, y_coords6, x, y, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
    }

    void drawMJ28(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{-7, -4, -11, -18, -11, -4, 6, 12, 8, -3, -3, 0, -4, -5, -5, -5, -6, -5, -4, -4, -7};
        int[] y_coords = new int[]{0, -15, -13, -13, -13, -15, -18, -17, -18, -16, -24, -25, -26, -29, -35, -29, -30, -31, -26, -17, 0};
        drawPg(g, x_coords, y_coords, x, y, 0.9 * a, Color.WHITE, new Color(0, 0, 0), 5f);

        int[] x_coords2 = new int[]{-6, -4, -6, -14, -6, 9, -6, -3, -15, -3, 8, -3, 3, 5, -7, -10, -19, -22, -17, -22, -23, -19, -22, -19, -10, -15, -10, -7, 5, 14, 20, 23, 20, 20, 20, 16, 8, 5};
        int[] y_coords2 = new int[]{15, 29, 15, 18, 15, 12, 15, 6, 10, 6, 5, 6, -4, -3, 0, 1, 4, 6, 29, 6, 4, 4, 6, 4, 1, -5, 1, 0, -2, -2, 1, 2, 3, 1, 2, 21, 29, 22};
        drawPg(g, x_coords2, y_coords2, x, y, 1 * a, Color.WHITE, new Color(0, 0, 0), 5f);
    }

    void drawMJ1(Graphics g, int x, int y, double a) {

        drawO(g, x, y, 483, 464, 32, a, Color.WHITE, new Color(0, 100, 0), 4.2f);
        drawO(g, x, y, 483, 508, 32, a, Color.WHITE, new Color(0, 0, 0), 4.2f);
        drawO(g, x, y, 489, 514, 20, a, Color.WHITE, new Color(0, 0, 0), 3.0f);
        drawO(g, x, y, 494, 519, 10, a, Color.WHITE, new Color(0, 0, 0), 3.0f);
        drawO(g, x, y, 498, 523, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 489, 470, 20, a, Color.WHITE, new Color(0, 100, 0), 3.0f);
        drawO(g, x, y, 494, 475, 10, a, Color.WHITE, new Color(0, 100, 0), 3.0f);
        drawO(g, x, y, 498, 479, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
    }

    void drawMJ2(Graphics g, int x, int y, double a) {

        drawO(g, x, y, 488, 491, 22, a, Color.WHITE, new Color(180, 20, 30), 4.0f);
        drawO(g, x, y, 494, 497, 10, a, Color.WHITE, new Color(180, 20, 30), 3.0f);
        drawO(g, x, y, 498, 501, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);
        drawO(g, x, y, 474, 463, 22, a, Color.WHITE, new Color(0, 100, 0), 4.0f);
        drawO(g, x, y, 480, 469, 10, a, Color.WHITE, new Color(0, 100, 0), 3.0f);
        drawO(g, x, y, 484, 473, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 502, 519, 22, a, Color.WHITE, new Color(0, 0, 0), 4.0f);
        drawO(g, x, y, 508, 525, 10, a, Color.WHITE, new Color(0, 0, 0), 3.0f);
        drawO(g, x, y, 512, 529, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
    }

    void drawMJ3(Graphics g, int x, int y, double a) {


        drawO(g, x, y, 473, 466, 20, a, Color.WHITE, new Color(0, 100, 0), 4.0f);
        drawO(g, x, y, 478, 471, 10, a, Color.WHITE, new Color(0, 100, 0), 2.5f);
        drawO(g, x, y, 482, 475, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 473, 516, 20, a, Color.WHITE, new Color(0, 0, 0), 4.0f);
        drawO(g, x, y, 478, 521, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 482, 525, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 505, 516, 20, a, Color.WHITE, new Color(0, 100, 0), 4.0f);
        drawO(g, x, y, 510, 521, 10, a, Color.WHITE, new Color(0, 100, 0), 2.5f);
        drawO(g, x, y, 514, 525, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 505, 466, 20, a, Color.WHITE, new Color(0, 0, 0), 4.0f);
        drawO(g, x, y, 510, 471, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 514, 475, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);

    }
    void drawMJ4(Graphics g, int x, int y, double a) {

        drawO(g, x, y, 490, 490, 20, a, Color.WHITE, new Color(180, 20, 30), 3.5f);
        drawO(g, x, y, 495, 495, 10, a, Color.WHITE, new Color(180, 20, 30), 2.5f);
        drawO(g, x, y, 499, 499, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);


        drawO(g, x, y, 474, 516, 20, a, Color.WHITE, new Color(0, 0, 0), 3.5f);
        drawO(g, x, y, 479, 521, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 483, 525, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 506, 516, 20, a, Color.WHITE, new Color(0, 100, 0), 3.5f);
        drawO(g, x, y, 511, 521, 10, a, Color.WHITE, new Color(0, 100, 0), 2.5f);
        drawO(g, x, y, 515, 525, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);

        drawO(g, x, y, 474, 464, 20, a, Color.WHITE, new Color(0, 100, 0), 3.5f);
        drawO(g, x, y, 479, 469, 10, a, Color.WHITE, new Color(0, 100, 0), 2.5f);
        drawO(g, x, y, 483, 473, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 506, 464, 20, a, Color.WHITE, new Color(0, 0, 0), 3.5f);
        drawO(g, x, y, 511, 469, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 515, 473, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);

    }
    void drawMJ5(Graphics g, int x, int y, double a) {
        drawO(g, x, y, 479, 495, 20, a, Color.WHITE, new Color(180, 20, 30), 3.5f);
        drawO(g, x, y, 484, 500, 10, a, Color.WHITE, new Color(180, 20, 30), 2.5f);
        drawO(g, x, y, 488, 504, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);
        drawO(g, x, y, 500, 495, 20, a, Color.WHITE, new Color(180, 20, 30), 3.5f);
        drawO(g, x, y, 505, 500, 10, a, Color.WHITE, new Color(180, 20, 30), 2.5f);
        drawO(g, x, y, 509, 504, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);

        drawO(g, x, y, 479, 517, 20, a, Color.WHITE, new Color(180, 20, 30), 3.5f);
        drawO(g, x, y, 484, 522, 10, a, Color.WHITE, new Color(180, 20, 30), 2.5f);
        drawO(g, x, y, 488, 526, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);
        drawO(g, x, y, 500, 517, 20, a, Color.WHITE, new Color(180, 20, 30), 3.5f);
        drawO(g, x, y, 505, 522, 10, a, Color.WHITE, new Color(180, 20, 30), 2.5f);
        drawO(g, x, y, 509, 526, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);


        drawO(g, x, y, 479, 463, 20, a, Color.WHITE, new Color(0, 100, 0), 3.5f);
        drawO(g, x, y, 484, 468, 10, a, Color.WHITE, new Color(0, 100, 0), 2.5f);
        drawO(g, x, y, 488, 472, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 500, 463, 20, a, Color.WHITE, new Color(0, 100, 0), 3.5f);
        drawO(g, x, y, 505, 468, 10, a, Color.WHITE, new Color(0, 100, 0), 2.5f);
        drawO(g, x, y, 509, 472, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);


    }
    void drawMJ6(Graphics g, int x, int y, double a) {
        drawO(g, x, y, 479, 497, 20, a, Color.WHITE, new Color(180, 20, 30), 3.5f);
        drawO(g, x, y, 484, 502, 10, a, Color.WHITE, new Color(180, 20, 30), 2.5f);
        drawO(g, x, y, 488, 506, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);
        drawO(g, x, y, 500, 497, 20, a, Color.WHITE, new Color(180, 20, 30), 3.5f);
        drawO(g, x, y, 505, 502, 10, a, Color.WHITE, new Color(180, 20, 30), 2.5f);
        drawO(g, x, y, 509, 506, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);

        drawO(g, x, y, 479, 519, 20, a, Color.WHITE, new Color(180, 20, 30), 3.5f);
        drawO(g, x, y, 484, 524, 10, a, Color.WHITE, new Color(180, 20, 30), 2.5f);
        drawO(g, x, y, 488, 528, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);
        drawO(g, x, y, 500, 519, 20, a, Color.WHITE, new Color(180, 20, 30), 3.5f);
        drawO(g, x, y, 505, 524, 10, a, Color.WHITE, new Color(180, 20, 30), 2.5f);
        drawO(g, x, y, 509, 528, 2, a, Color.WHITE, new Color(180, 20, 30), 2.0f);


        drawO(g, x, y, 472, 461, 20, a, Color.WHITE, new Color(0, 100, 0), 3.5f);
        drawO(g, x, y, 477, 466, 10, a, Color.WHITE, new Color(0, 100, 0), 2.5f);
        drawO(g, x, y, 481, 470, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 490, 467, 20, a, Color.WHITE, new Color(0, 100, 0), 3.5f);
        drawO(g, x, y, 495, 472, 10, a, Color.WHITE, new Color(0, 100, 0), 2.5f);
        drawO(g, x, y, 499, 476, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);
        drawO(g, x, y, 507, 473, 20, a, Color.WHITE, new Color(0, 100, 0), 3.5f);
        drawO(g, x, y, 512, 478, 10, a, Color.WHITE, new Color(0, 100, 0), 2.5f);
        drawO(g, x, y, 516, 482, 2, a, Color.WHITE, new Color(0, 100, 0), 2.0f);


    }
    void drawMJ7(Graphics g, int x, int y, double a) {
        drawO(g, x, y, 480, 502, 18, a, Color.WHITE, new Color(0, 0, 0), 3.6f);
        drawO(g, x, y, 484, 506, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 488, 510, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 501, 502, 18, a, Color.WHITE, new Color(0, 0, 0), 3.6f);
        drawO(g, x, y, 505, 506, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 509, 510, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);

        drawO(g, x, y, 480, 522, 18, a, Color.WHITE, new Color(0, 0, 0), 3.6f);
        drawO(g, x, y, 484, 526, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 488, 530, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 501, 522, 18, a, Color.WHITE, new Color(0, 0, 0), 3.6f);
        drawO(g, x, y, 505, 526, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 509, 530, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);

        drawO(g, x, y, 480, 482, 18, a, Color.WHITE, new Color(0, 0, 0), 3.6f);
        drawO(g, x, y, 484, 486, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 488, 490, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 501, 482, 18, a, Color.WHITE, new Color(0, 0, 0), 3.6f);
        drawO(g, x, y, 505, 486, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 509, 490, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);

        drawO(g, x, y, 480, 462, 18, a, Color.WHITE, new Color(0, 0, 0), 3.6f);
        drawO(g, x, y, 484, 466, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 488, 470, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
        drawO(g, x, y, 501, 462, 18, a, Color.WHITE, new Color(0, 0, 0), 3.6f);
        drawO(g, x, y, 505, 466, 10, a, Color.WHITE, new Color(0, 0, 0), 2.5f);
        drawO(g, x, y, 509, 470, 2, a, Color.WHITE, new Color(0, 0, 0), 2.0f);
    }
    void drawMJ11(Graphics g, int x, int y, double a) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        Stroke newStroke = new BasicStroke((float) (a * 4.0f));
        g2d.setStroke(newStroke);

        int[] x_coords = new int[]{15, 18, 18, 15, 11, 11, 15};
        int[] y_coords = new int[]{37, 34, 10, 7, 10, 34, 37};
        drawPg(g, x_coords, y_coords, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords2 = new int[]{-15, -11, -11, -15, -18, -18, -15};
        int[] y_coords2 = new int[]{37, 34, 10, 7, 10, 34, 37};
        drawPg(g, x_coords2, y_coords2, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords3 = new int[]{0, 3, 3, 0, -3, -3, 0};
        int[] y_coords3 = new int[]{-33, -30, -6, -3, -6, -30, -33};
        drawPg(g, x_coords3, y_coords3, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);
    }
    void drawMJ12(Graphics g, int x, int y, double a) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        Stroke newStroke = new BasicStroke((float) (a * 4.0f));
        g2d.setStroke(newStroke);

        int[] x_coords = new int[]{13, 16, 16, 13, 10, 10, 13};
        int[] y_coords = new int[]{37, 34, 10, 7, 10, 34, 37};
        drawPg(g, x_coords, y_coords, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords2 = new int[]{-13, -11, -11, -13, -16, -16, -13};
        int[] y_coords2 = new int[]{37, 34, 10, 7, 10, 34, 37};
        drawPg(g, x_coords2, y_coords2, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords3 = new int[]{13, 16, 16, 13, 10, 10, 13};
        int[] y_coords3 = new int[]{-33, -30, -6, -3, -6, -30, -33};
        drawPg(g, x_coords3, y_coords3, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords4 = new int[]{-13, -11, -11, -13, -16, -16, -13};
        int[] y_coords4 = new int[]{-33, -30, -6, -3, -6, -30, -33};
        drawPg(g, x_coords4, y_coords4, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);
    }
    void drawMJ13(Graphics g, int x, int y, double a) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        Stroke newStroke = new BasicStroke((float) (a * 4.0f));
        g2d.setStroke(newStroke);

        int[] x_coords = new int[]{15, 18, 18, 15, 12, 12, 15};
        int[] y_coords = new int[]{37, 34, 10, 7, 10, 34, 37};
        drawPg(g, x_coords, y_coords, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords2 = new int[]{-15, -12, -12, -15, -18, -18, -15};
        int[] y_coords2 = new int[]{37, 34, 10, 7, 10, 34, 37};
        drawPg(g, x_coords2, y_coords2, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords3 = new int[]{15, 18, 18, 15, 12, 12, 15};
        int[] y_coords3 = new int[]{-33, -30, -6, -3, -6, -30, -33};
        drawPg(g, x_coords3, y_coords3, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords4 = new int[]{-15, -12, -12, -15, -18, -18, -15};
        int[] y_coords4 = new int[]{-33, -30, -6, -3, -6, -30, -33};
        drawPg(g, x_coords4, y_coords4, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords5 = new int[]{0, 3, 3, 0, -3, -3, 0};
        int[] y_coords5 = new int[]{-14, -11, 13, 16, 13, -11, -14};
        drawPg(g, x_coords5, y_coords5, x, y, 1.1*a, Color.WHITE, new Color(180, 20, 30), 3.5f);
    }
    void drawMJ14(Graphics g, int x, int y, double a) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        Stroke newStroke = new BasicStroke((float) (a * 4.0f));
        g2d.setStroke(newStroke);

        int[] x_coords = new int[]{16, 19, 19, 16, 13, 13, 16};
        int[] y_coords = new int[]{37, 34, 10, 7, 10, 34, 37};
        drawPg(g, x_coords, y_coords, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords2 = new int[]{-15, -12, -12, -15, -18, -18, -15};
        int[] y_coords2 = new int[]{37, 34, 10, 7, 10, 34, 37};
        drawPg(g, x_coords2, y_coords2, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords3 = new int[]{16, 19, 19, 16, 13, 13, 16};
        int[] y_coords3 = new int[]{-33, -30, -6, -3, -6, -30, -33};
        drawPg(g, x_coords3, y_coords3, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords4 = new int[]{-15, -12, -12, -15, -18, -18, -15};
        int[] y_coords4 = new int[]{-33, -30, -6, -3, -6, -30, -33};
        drawPg(g, x_coords4, y_coords4, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords5 = new int[]{0, 3, 3, 0, -2, -2, 0};
        int[] y_coords5 = new int[]{37, 34, 10, 7, 10, 34, 37};
        drawPg(g, x_coords5, y_coords5, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords6 = new int[]{0, 3, 3, 0, -2, -2, 0};
        int[] y_coords6 = new int[]{-33, -30, -6, -3, -6, -30, -33};
        drawPg(g, x_coords6, y_coords6, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);
    }
    void drawMJ15(Graphics g, int x, int y, double a) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        Stroke newStroke = new BasicStroke((float) (a * 4.0f));
        g2d.setStroke(newStroke);

        int[] x_coords = new int[]{20, 23, 23, 20, 17, 17, 20};
        int[] y_coords = new int[]{45, 42, 22, 19, 22, 42, 45};
        drawPg(g, x_coords, y_coords, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);

        int[] x_coords2 = new int[]{-19, -16, -16, -19, -22, -22, -19};
        int[] y_coords2 = new int[]{45, 42, 22, 19, 22, 42, 45};
        drawPg(g, x_coords2, y_coords2, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);

        int[] x_coords3 = new int[]{20, 23, 23, 20, 17, 17, 20};
        int[] y_coords3 = new int[]{-13, -10, 10, 13, 10, -10, -13};
        drawPg(g, x_coords3, y_coords3, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);

        int[] x_coords4 = new int[]{-19, -16, -16, -19, -22, -22, -19};
        int[] y_coords4 = new int[]{-13, -10, 10, 13, 10, -10, -13};
        drawPg(g, x_coords4, y_coords4, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);

        int[] x_coords5 = new int[]{0, 4, 4, 0, -3, -3, 0};
        int[] y_coords5 = new int[]{45, 42, 22, 19, 22, 42, 45};
        drawPg(g, x_coords5, y_coords5, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);

        int[] x_coords6 = new int[]{0, 4, 4, 0, -3, -3, 0};
        int[] y_coords6 = new int[]{-13, -10, 10, 13, 10, -10, -13};
        drawPg(g, x_coords6, y_coords6, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);

        int[] x_coords7 = new int[]{0, 4, 4, 0, -3, -3, 0};
        int[] y_coords7 = new int[]{-45, -42, -22, -19, -22, -42, -45};
        drawPg(g, x_coords7, y_coords7, x, y, 0.9*a, Color.WHITE, new Color(180, 20, 30), 4f);
    }
    void drawMJ16(Graphics g, int x, int y, double a) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        Stroke newStroke = new BasicStroke((float) (a * 4.0f));
        g2d.setStroke(newStroke);

        int[] x_coords = new int[]{16, 19, 19, 16, 13, 13, 16};
        int[] y_coords = new int[]{37, 34, 12, 9, 12, 34, 37};
        drawPg(g, x_coords, y_coords, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords2 = new int[]{-15, -12, -12, -15, -18, -18, -15};
        int[] y_coords2 = new int[]{37, 34, 12, 9, 12, 34, 37};
        drawPg(g, x_coords2, y_coords2, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords3 = new int[]{16, 19, 19, 16, 13, 13, 16};
        int[] y_coords3 = new int[]{-33, -30, -8, -5, -8, -30, -33};
        drawPg(g, x_coords3, y_coords3, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords4 = new int[]{-15, -12, -12, -15, -18, -18, -15};
        int[] y_coords4 = new int[]{-33, -30, -8, -5, -8, -30, -33};
        drawPg(g, x_coords4, y_coords4, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords5 = new int[]{1,13,13,0,-12,-12,-1};
        int[] y_coords5 = new int[]{-26,-13,-6,-21,-6,-13,-26};
        drawPg(g, x_coords5, y_coords5, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);

        int[] x_coords6 = new int[]{1,13,13,0,-12,-12,-1};
        int[] y_coords6 = new int[]{28,16,10,23,10,16,28};
        drawPg(g, x_coords6, y_coords6, x, y, 1.1*a, Color.WHITE, new Color(0, 100, 0), 3.5f);
    }
    void drawMJ17(Graphics g, int x, int y, double a) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        Stroke newStroke = new BasicStroke((float) (a * 4.0f));
        g2d.setStroke(newStroke);

        int[] x_coords = new int[]{20, 23, 23, 20, 17, 17, 20};
        int[] y_coords = new int[]{45, 42, 22, 19, 22, 42, 45};
        drawPg(g, x_coords, y_coords, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);

        int[] x_coords2 = new int[]{-19, -16, -16, -19, -22, -22, -19};
        int[] y_coords2 = new int[]{45, 42, 22, 19, 22, 42, 45};
        drawPg(g, x_coords2, y_coords2, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);

        int[] x_coords3 = new int[]{20, 23, 23, 20, 17, 17, 20};
        int[] y_coords3 = new int[]{-13, -10, 10, 13, 10, -10, -13};
        drawPg(g, x_coords3, y_coords3, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);

        int[] x_coords4 = new int[]{-19, -16, -16, -19, -22, -22, -19};
        int[] y_coords4 = new int[]{-13, -10, 10, 13, 10, -10, -13};
        drawPg(g, x_coords4, y_coords4, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);

        int[] x_coords5 = new int[]{0, 4, 4, 0, -3, -3, 0};
        int[] y_coords5 = new int[]{45, 42, 22, 19, 22, 42, 45};
        drawPg(g, x_coords5, y_coords5, x, y, 0.9*a, Color.WHITE, new Color(180, 20, 30), 4f);

        int[] x_coords6 = new int[]{0, 4, 4, 0, -3, -3, 0};
        int[] y_coords6 = new int[]{-13, -10, 10, 13, 10, -10, -13};
        drawPg(g, x_coords6, y_coords6, x, y, 0.9*a, Color.WHITE, new Color(180, 20, 30), 4f);

        int[] x_coords7 = new int[]{0, 4, 4, 0, -3, -3, 0};
        int[] y_coords7 = new int[]{-45, -42, -22, -19, -22, -42, -45};
        drawPg(g, x_coords7, y_coords7, x, y, 0.9*a, Color.WHITE, new Color(180, 20, 30), 4f);

        int[] x_coords8 = new int[]{20, 23, 23, 20, 17, 17, 20};
        int[] y_coords8 = new int[]{-45, -42, -22, -19, -22, -42, -45};
        drawPg(g, x_coords8, y_coords8, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);


        int[] x_coords9 = new int[]{-19, -16, -16, -19, -22, -22, -19};
        int[] y_coords9 = new int[]{-45, -42, -22, -19, -22, -42, -45};
        drawPg(g, x_coords9, y_coords9, x, y, 0.9*a, Color.WHITE, new Color(0, 100, 0), 4f);

    }
    void drawMJ19(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{-20, -15, 15, 18, 10, -15};
        int[] y_coords = new int[]{-17, -16, -20, -16, -18, -16};
        drawPg(g, x_coords, y_coords, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.0f);

        int[] x_coords2 = new int[]{-16, -12};
        int[] y_coords2 = new int[]{23, 36};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords3 = new int[]{6, -10, -12, -2, 3, -7, -9, -7, -6, -7, -17, -7, 3, 6, 3, 6, 3, 13, 3, -2, 6, 10, 6};
        int[] y_coords3 = new int[]{17, 19, 10, 8, 0, 2, -5, 2, 6, 2, 3, 2, 0, -5, -8, -5, 0, -1, 0, 8, 7, 10, 18};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords4 = new int[]{10, 15, 18, 16, -1, -1, 8, 4, 8, 11, 8, -1, -10, -1, -1, -19, -1, -1, 4, -1, -8, -1, -1, -2, -1, -1, -1, 16, 18, 15, 10};
        int[] y_coords4 = new int[]{36, 37, 24, 22, 24, 29, 28, 25, 28, 32, 28, 29, 30, 29, 24, 28, 24, 13, 13, 13, 14, 13, 10, 8, 10, 13, 24, 22, 24, 37, 36};
        drawPg(g, x_coords4, y_coords4, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords5 = new int[]{-20, -14, 15, 16, 10, -14};
        int[] y_coords5 = new int[]{-41, -40, -44, -41, -42, -40};
        drawPg(g, x_coords5, y_coords5, x, y, 0.7*a, Color.WHITE, new Color(0, 0, 0), 6.0f);


    }
    void drawMJ20(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{-20, -15, 15, 18, 10, -15};
        int[] y_coords = new int[]{-15, -14, -18, -14, -16, -14};
        drawPg(g, x_coords, y_coords, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.0f);

        int[] x_coords2 = new int[]{-16, -12};
        int[] y_coords2 = new int[]{23, 36};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords3 = new int[]{6, -10, -12, -2, 3, -7, -9, -7, -6, -7, -17, -7, 3, 6, 3, 6, 3, 13, 3, -2, 6, 10, 6};
        int[] y_coords3 = new int[]{17, 19, 10, 8, 0, 2, -5, 2, 6, 2, 3, 2, 0, -5, -8, -5, 0, -1, 0, 8, 7, 10, 18};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords4 = new int[]{10, 15, 18, 16, -1, -1, 8, 4, 8, 11, 8, -1, -10, -1, -1, -19, -1, -1, 4, -1, -8, -1, -1, -2, -1, -1, -1, 16, 18, 15, 10};
        int[] y_coords4 = new int[]{36, 37, 24, 22, 24, 29, 28, 25, 28, 32, 28, 29, 30, 29, 24, 28, 24, 13, 13, 13, 14, 13, 10, 8, 10, 13, 24, 22, 24, 37, 36};
        drawPg(g, x_coords4, y_coords4, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords5 = new int[]{-20, -14, 14, 16, 10, -14};
        int[] y_coords5 = new int[]{-53, -52, -56, -53, -54, -52};
        drawPg(g, x_coords5, y_coords5, x, y, 0.6*a, Color.WHITE, new Color(0, 0, 0), 7.0f);

        int[] x_coords6 = new int[]{-20, -14, 14, 17, 10, -14};
        int[] y_coords6 = new int[]{-47, -48, -50, -47, -48, -46};
        drawPg(g, x_coords6, y_coords6, x, y, 0.5*a, Color.WHITE, new Color(0, 0, 0), 7.0f);


    }
    void drawMJ21(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{-20,-19,-8,0,8,14,17,20,18,14,9,8,5,-7,-10,-13,-20};
        int[] y_coords = new int[]{-27,-27,-31,-33,-34,-34,-32,-29,-28,-21,-17,-20,-22,-20,-18,-17,-27};
        drawPg(g, x_coords, y_coords, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.5f);

        int[] x_coords2 = new int[]{-16, -12};
        int[] y_coords2 = new int[]{23, 36};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords3 = new int[]{6, -10, -12, -2, 3, -7, -9, -7, -6, -7, -17, -7, 3, 6, 3, 6, 3, 13, 3, -2, 6, 10, 6};
        int[] y_coords3 = new int[]{17, 19, 10, 8, 0, 2, -5, 2, 6, 2, 3, 2, 0, -5, -8, -5, 0, -1, 0, 8, 7, 10, 18};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords4 = new int[]{10, 15, 18, 16, -1, -1, 8, 4, 8, 11, 8, -1, -10, -1, -1, -19, -1, -1, 4, -1, -8, -1, -1, -2, -1, -1, -1, 16, 18, 15, 10};
        int[] y_coords4 = new int[]{36, 37, 24, 22, 24, 29, 28, 25, 28, 32, 28, 29, 30, 29, 24, 28, 24, 13, 13, 13, 14, 13, 10, 8, 10, 13, 24, 22, 24, 37, 36};
        drawPg(g, x_coords4, y_coords4, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords5 = new int[]{-8,0,6,1,-7,-8};
        int[] y_coords5 = new int[]{-31,-33,-34,-22,-20,-32};
        drawPg(g, x_coords5, y_coords5, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.5f);



    }
    void drawMJ22(Graphics g, int x, int y, double a) {
        int[] x_coords = new int[]{-9,-9,-13,-22,-13,-13,-13,-9,-9};
        int[] y_coords = new int[]{-39,-33,-28,-21,-28,-8,-28,-33,-39};
        drawPg(g, x_coords, y_coords, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.2f);

        int[] x_coords2 = new int[]{-16, -12};
        int[] y_coords2 = new int[]{23, 36};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords3 = new int[]{6, -10, -12, -2, 3, -7, -9, -7, -6, -7, -17, -7, 3, 6, 3, 6, 3, 13, 3, -2, 6, 10, 6};
        int[] y_coords3 = new int[]{17, 19, 10, 8, 0, 2, -5, 2, 6, 2, 3, 2, 0, -5, -8, -5, 0, -1, 0, 8, 7, 10, 18};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords4 = new int[]{10, 15, 18, 16, -1, -1, 8, 4, 8, 11, 8, -1, -10, -1, -1, -19, -1, -1, 4, -1, -8, -1, -1, -2, -1, -1, -1, 16, 18, 15, 10};
        int[] y_coords4 = new int[]{36, 37, 24, 22, 24, 29, 28, 25, 28, 32, 28, 29, 30, 29, 24, 28, 24, 13, 13, 13, 14, 13, 10, 8, 10, 13, 24, 22, 24, 37, 36};
        drawPg(g, x_coords4, y_coords4, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords5 = new int[]{-4,6,8,3,0,-8,0,7,10,9,8,17,22,17,8,-5,-11,-5,0,3,-4};
        int[] y_coords5 = new int[]{-34,-37,-36,-36,-27,-25,-27,-28,-26,-26,-15,-16,-14,-16,-15,-14,-13,-14,-27,-36,-34};
        drawPg(g, x_coords5, y_coords5, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.4f);



    }
    void drawMJ23(Graphics g, int x, int y, double a) {

        int[] x_coords = new int[]{-21, -16, 17, 20, 10, -16};
        int[] y_coords = new int[]{-29, -27, -32, -28, -30, -27};
        drawPg(g, x_coords, y_coords, x, y, 0.9*a, Color.WHITE, new Color(0, 0, 0), 4.2f);

        int[] x_coords2 = new int[]{-16, -12};
        int[] y_coords2 = new int[]{23, 36};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords3 = new int[]{6, -10, -12, -2, 3, -7, -9, -7, -6, -7, -17, -7, 3, 6, 3, 6, 3, 13, 3, -2, 6, 10, 6};
        int[] y_coords3 = new int[]{17, 19, 10, 8, 0, 2, -5, 2, 6, 2, 3, 2, 0, -5, -8, -5, 0, -1, 0, 8, 7, 10, 18};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords4 = new int[]{10, 15, 18, 16, -1, -1, 8, 4, 8, 11, 8, -1, -10, -1, -1, -19, -1, -1, 4, -1, -8, -1, -1, -2, -1, -1, -1, 16, 18, 15, 10};
        int[] y_coords4 = new int[]{36, 37, 24, 22, 24, 29, 28, 25, 28, 32, 28, 29, 30, 29, 24, 28, 24, 13, 13, 13, 14, 13, 10, 8, 10, 13, 24, 22, 24, 37, 36};
        drawPg(g, x_coords4, y_coords4, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords5 = new int[]{0,0,-2,0,3,0,0};
        int[] y_coords5 = new int[]{-28,-33,-35,-37,-34,-33,-28};
        drawPg(g, x_coords5, y_coords5, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.0f);

        int[] x_coords6 = new int[]{-4,-9,-14,-9,-2,-4};
        int[] y_coords6 = new int[]{-21,-13,-10,-13,-19,-21};
        drawPg(g, x_coords6, y_coords6, x-1, y+1, a, Color.WHITE, new Color(0, 0, 0), 4.0f);

        int[] x_coords7 = new int[]{6,9,12,11,6};
        int[] y_coords7 = new int[]{-19,-18,-14,-13,-19};
        drawPg(g, x_coords7, y_coords7, x, y+3, 1.1*a, Color.WHITE, new Color(0, 0, 0), 4.2f);



    }
    void drawMJ24(Graphics g, int x, int y, double a) {

        int[] x_coords = new int[]{-15,11,18,18,11,-13,-15};
        int[] y_coords = new int[]{-14,-31,-30,-29,-29,-14,-14};
        drawPg(g, x_coords, y_coords, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.2f);

        int[] x_coords2 = new int[]{-16, -12};
        int[] y_coords2 = new int[]{23, 36};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords3 = new int[]{6, -10, -12, -2, 3, -7, -9, -7, -6, -7, -17, -7, 3, 6, 3, 6, 3, 13, 3, -2, 6, 10, 6};
        int[] y_coords3 = new int[]{17, 19, 10, 8, 0, 2, -5, 2, 6, 2, 3, 2, 0, -5, -8, -5, 0, -1, 0, 8, 7, 10, 18};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords4 = new int[]{10, 15, 18, 16, -1, -1, 8, 4, 8, 11, 8, -1, -10, -1, -1, -19, -1, -1, 4, -1, -8, -1, -1, -2, -1, -1, -1, 16, 18, 15, 10};
        int[] y_coords4 = new int[]{36, 37, 24, 22, 24, 29, 28, 25, 28, 32, 28, 29, 30, 29, 24, 28, 24, 13, 13, 13, 14, 13, 10, 8, 10, 13, 24, 22, 24, 37, 36};
        drawPg(g, x_coords4, y_coords4, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords5 = new int[]{-2,-2,-4,-2,1,-2,-2,1,13,13,1,-2,-2};
        int[] y_coords5 = new int[]{-28,-33,-35,-37,-34,-33,-18,-14,-14,-15,-15,-18,-28};
        drawPg(g, x_coords5, y_coords5, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.2f);


    }
    void drawMJ25(Graphics g, int x, int y, double a) {

        int[] x_coords2 = new int[]{-16, -12};
        int[] y_coords2 = new int[]{23, 36};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords3 = new int[]{6, -10, -12, -2, 3, -7, -9, -7, -6, -7, -17, -7, 3, 6, 3, 6, 3, 13, 3, -2, 6, 10, 6};
        int[] y_coords3 = new int[]{17, 19, 10, 8, 0, 2, -5, 2, 6, 2, 3, 2, 0, -5, -8, -5, 0, -1, 0, 8, 7, 10, 18};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords4 = new int[]{10, 15, 18, 16, -1, -1, 8, 4, 8, 11, 8, -1, -10, -1, -1, -19, -1, -1, 4, -1, -8, -1, -1, -2, -1, -1, -1, 16, 18, 15, 10};
        int[] y_coords4 = new int[]{36, 37, 24, 22, 24, 29, 28, 25, 28, 32, 28, 29, 30, 29, 24, 28, 24, 13, 13, 13, 14, 13, 10, 8, 10, 13, 24, 22, 24, 37, 36};
        drawPg(g, x_coords4, y_coords4, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);


        int[] x_coords6 = new int[]{-4,-6,-16,-6,-1,-4};
        int[] y_coords6 = new int[]{-25,-19,-10,-17,-20,-25};
        drawPg(g, x_coords6, y_coords6, x-5, y-5, 0.9*a, Color.WHITE, new Color(0, 0, 0), 4.0f);

        int[] x_coords7 = new int[]{-4,0,15,24,16,0,-4};
        int[] y_coords7 = new int[]{-31,-33,-11,-12,-15,-33,-31};
        drawPg(g, x_coords7, y_coords7, x-3, y-6, 0.9*a, Color.WHITE, new Color(0, 0, 0), 4.4f);



    }
    void drawMJ26(Graphics g, int x, int y, double a) {

        int[] x_coords = new int[]{-9,-3,-6,-16,-6,-3,-9};
        int[] y_coords = new int[]{-39,-30,-20,-9,-20,-30,-39};
        drawPg(g, x_coords, y_coords, x, y-1, a, Color.WHITE, new Color(0, 0, 0), 4.4f);

        int[] x_coords2 = new int[]{-16, -12};
        int[] y_coords2 = new int[]{23, 36};
        drawPg(g, x_coords2, y_coords2, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords3 = new int[]{6, -10, -12, -2, 3, -7, -9, -7, -6, -7, -17, -7, 3, 6, 3, 6, 3, 13, 3, -2, 6, 10, 6};
        int[] y_coords3 = new int[]{17, 19, 10, 8, 0, 2, -5, 2, 6, 2, 3, 2, 0, -5, -8, -5, 0, -1, 0, 8, 7, 10, 18};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords4 = new int[]{10, 15, 18, 16, -1, -1, 8, 4, 8, 11, 8, -1, -10, -1, -1, -19, -1, -1, 4, -1, -8, -1, -1, -2, -1, -1, -1, 16, 18, 15, 10};
        int[] y_coords4 = new int[]{36, 37, 24, 22, 24, 29, 28, 25, 28, 32, 28, 29, 30, 29, 24, 28, 24, 13, 13, 13, 14, 13, 10, 8, 10, 13, 24, 22, 24, 37, 36};
        drawPg(g, x_coords4, y_coords4, x, y, a, Color.WHITE, new Color(180, 20, 30), 4.0f);

        int[] x_coords5 = new int[]{-17,-6,8,8,9,8,2,4,20,16,16,16,16,20,4,2,8,9,8,8,-6,-17};
        int[] y_coords5 = new int[]{-29,-29,-34,-32,-32,-34,-19,-16,-16,-16,-23,-23,-16,-16,-16,-19,-34,-32,-32,-34,-29,-29};
        drawPg(g, x_coords5, y_coords5, x, y+1, a, Color.WHITE, new Color(0, 0, 0), 4.4f);


    }
    void drawMJ31(Graphics g, int x, int y, double a) {

        int[] x_coords = new int[]{-21,-19,0,8,12,19,18,14,9,8,5,-7,-10,-13,-14,-21};
        int[] y_coords = new int[]{-27,-26,-30,-32,-32,-27,-27,-21,-17,-19,-19,-17,-16,-16,-15,-27};
        drawPg(g, x_coords, y_coords, x, y+15, a, Color.WHITE, new Color(180, 20, 30), 5f);

        int[] x_coords2 = new int[]{0,-1,-1,-5,-2,4,1,1,0};
        int[] y_coords2 = new int[]{38,35,-22,-22,-25,-22,-22,35,38};
        drawPg(g, x_coords2, y_coords2, x-3, y-8, a, Color.WHITE, new Color(180, 20, 30), 4.4f);


    }
    void drawMJ30(Graphics g, int x, int y, double a) {

        int[] x_coords = new int[]{-16,-16,-25,-30,-25,-16,-16,-23,-27,-23,-16,-16,-19,-24,-19,-16,-16,-4,-16,-16};
        int[] y_coords = new int[]{24,11,20,18,20,11,6,4,1,4,6,-10,-13,-10,-13,-10,11,-6,11,24};
        drawPg(g, x_coords, y_coords, x+6, y+2, a, Color.WHITE, new Color(0, 0, 0), 4.4f);

        int[] x_coords5 = new int[]{-9,-5,-3,7,-3,-3,4,8,6,8,4,-3,-4,0,11,15,11,0,-4,-3,-3,-5,-9};
        int[] y_coords5 = new int[]{-21,-26,-21,-21,-21,5,3,1,-5,1,3,5,14,20,20,15,19,19,14,5,-21,-26,-21};
        drawPg(g, x_coords5, y_coords5, x+7, y, a, Color.WHITE, new Color(0, 0, 0), 5.2f);


    }
    void drawMJ29(Graphics g, int x, int y, double a) {

        int[] x_coords = new int[]{-11,-8,8,14,10,-8,-11};
        int[] y_coords = new int[]{-25,-25,-32,-28,-28,-24,-25};
        drawPg(g, x_coords, y_coords, x-2, y+4, 0.9*a, Color.WHITE, new Color(0, 0, 0), 4.0f);

        int[] x_coords2 = new int[]{-21,-18,-8,0,8,14,17,22,19,15,9,8,5,-7,-10,-10,-13,-21};
        int[] y_coords2 = new int[]{-28,-28,-31,-33,-34,-35,-32,-29,-28,-15,-9,-13,-15,-13,-11,-10,-12,-28};
        drawPg(g, x_coords2, y_coords2, x, y+35, 1.05*a, Color.WHITE, new Color(0, 0, 0), 5.2f);

        int[] x_coords3 = new int[]{0,2,4,2,2,12,8,0,4,2,2,0};
        int[] y_coords3 = new int[]{-12,-14,-11,-11,8,10,9,15,9,8,-11,-12};
        drawPg(g, x_coords3, y_coords3, x, y, a, Color.WHITE, new Color(0, 0, 0), 4.6f);

        int[] x_coords5 = new int[]{-14,-5,-7,-5,-5,-8,-5,-5,-14};
        int[] y_coords5 = new int[]{-1,-3,-9,-3,10,17,10,-3,-1};
        drawPg(g, x_coords5, y_coords5, x-2, y-1, a, Color.WHITE, new Color(0, 0, 0), 4.6f);



    }
    void drawMJ27(Graphics g, int x, int y, double a) {


        int[] x_coords2 = new int[]{-21,-17,-3,12,18,21,18,13,-12,-18,-20,-21};
        int[] y_coords2 = new int[]{-22,-21,-23,-25,-21,-20,-20,-2,0,-3,-18,-22};
        drawPg(g, x_coords2, y_coords2, x, y+4, 0.7*a, Color.WHITE, new Color(0, 0, 0), 6.8f);

        int[] x_coords = new int[]{-3,-6,1,-3,-3,-3,-14,-3,10,-3,-3,-9,-3,6,-3,-3,-5,-8,-3,-3};
        int[] y_coords = new int[]{-40,-35,-36,-40,-35,-27,-26,-27,-29,-27,-13,-12,-13,-14,-13,30,26,23,24,-40};
        drawPg(g, x_coords, y_coords, x, y+5, 0.9*a, Color.WHITE, new Color(0, 0, 0), 4.8f);

        int[] x_coords3 = new int[]{-23,-3,0,12,22,16,0,-3,-23};
        int[] y_coords3 = new int[]{21,1,2,14,18,20,2,1,21};
        drawPg(g, x_coords3, y_coords3, x, y+3, a, Color.WHITE, new Color(0, 0, 0), 4.6f);




    }



    protected void paintComponent(Graphics g) {

        g.setColor(new Color(0, 100, 60));
        g.fillRect(0, 0, 1280, 830);
        drawCardFront(g, x, y, a);
        drawMJ0(g, x, y, a);
        drawCardFront(g, x+100, y, a);
        drawMJ1(g,x+100,y,a);
        drawCardFront(g, x+200, y, a);
        drawMJ2(g,x+200,y,a);
        drawCardFront(g, x+300, y, a);
        drawMJ3(g,x+300,y,a);
        drawCardFront(g, x+400, y, a);
        drawMJ4(g,x+400,y,a);
        drawCardFront(g, x+500, y, a);
        drawMJ5(g,x+500,y,a);
        drawCardFront(g, x+600, y, a);
        drawMJ6(g,x+600,y,a);
        drawCardFront(g, x + 700, y, a);
        drawMJ7(g, x + 700, y, a);
        drawCardFront(g, x + 800, y, a);
        drawMJ8(g, x + 800, y, a);
        drawCardFront(g, x + 900, y, a);
        drawMJ9(g, x + 900, y, a);
        drawCardFront(g, x + 1000, y, a);
        drawMJ10(g, x + 1000, y, a);
        drawCardFront(g, x + 1100, y, a);
        drawMJ11(g, x + 1100, y, a);
        drawCardFront(g, x , y+150, a);
        drawMJ12(g, x , y+150, a);
        drawCardFronthui(g, x+100 , y+150, a);
        drawMJ13(g, x+100 , y+150, a);
        drawCardFront(g, x+200 , y+150, a);
        drawMJ14(g, x+200 , y+150, a);
        drawCardFront(g, x+300 , y+150, a);
        drawMJ15(g, x+300 , y+150, a);
        drawCardFront(g, x+400 , y+150, a);
        drawMJ16(g, x+400 , y+150, a);
        drawCardFront(g, x+500 , y+150, a);
        drawMJ17(g, x+500 , y+150, a);
        drawCardFront(g, x+600 , y+150, a);
        drawMJ18(g, x+600 , y+150, a);
        drawCardFront(g, x+700 , y+150, a);
        drawMJ19(g, x+700 , y+150, a);
        drawCardFront(g, x+800 , y+150, a);
        drawMJ20(g, x+800 , y+150, a);
        drawCardFront(g, x+900 , y+150, a);
        drawMJ21(g, x+900 , y+150, a);
        drawCardFront(g, x+1000 , y+150, a);
        drawMJ22(g, x+1000 , y+150, a);
        drawCardFront(g, x+1100 , y+150, a);
        drawMJ23(g, x+1100 , y+150, a);
        drawCardFront(g, x , y+300, a);
        drawMJ24(g, x , y+300, a);
        drawCardFront(g, x +100, y+300, a);
        drawMJ25(g, x +100 , y+300, a);
        drawCardFront(g, x +200, y+300, a);
        drawMJ26(g, x +200 , y+300, a);
        drawCardFront(g, x +300, y+300, a);
        drawMJ27(g, x +300 , y+300, a);
        drawCardFront(g, x +400, y+300, a);
        drawMJ28(g, x +400 , y+300, a);
        drawCardFront(g, x +500, y+300, a);
        drawMJ29(g, x +500 , y+300, a);
        drawCardFront(g, x +600, y+300, a);
        drawMJ30(g, x +600 , y+300, a);
        drawCardFront(g, x +700, y+300, a);
        drawMJ31(g, x +700 , y+300, a);
        drawCardFront(g, x +800, y+300, a);
        drawMJ32(g, x +800 , y+300, a);
        drawCardFront(g, x +900, y+300, a);
        drawMJ33(g, x +900 , y+300, a);





    }
}
