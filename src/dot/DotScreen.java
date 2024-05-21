package screen.cardsScreen.Dot;

import javafx.scene.canvas.GraphicsContext;

import screen.cardsScreen.ChooseDrawable;
import screen.cardsScreen.Drawable;

import javafx.scene.paint.Color;

import static screen.cardsScreen.CardScreen.*;

public class DotScreen implements ChooseDrawable {
    private static DotScreen dot=new DotScreen();
    Drawable[] dots= new Drawable[]{new MJ0(),new MJ1(),new MJ2(),new MJ3(),new MJ4(),new MJ5(),new MJ6(),new MJ7(),new MJ8()};
    private DotScreen(){}
    public static DotScreen getDot(){
        return dot;
    }
    static void drawDot(GraphicsContext g, int x, int y, int i, int j, int h, double a, Color color, int k){
        drawO(g, x, y, i, j, h, a, white, color, 3.5f);
        drawO(g, x, y, i+k, j+k, 10, a, white, color, 2.5f);
        drawO(g, x, y, i+k+4, j+k+4, 2, a, white, color, 2.0f);
    }
    static void draw3Dot(GraphicsContext g, int x, int y, double a, Color color){//3 on a line
        drawDot(g, x, y, 473, 491, 18, a, color, 4);
        drawDot(g, x, y, 491, 491, 18, a, color, 4);
        drawDot(g, x, y, 509, 491, 18, a, color, 4);
    }
    static void draw4Dot(GraphicsContext g, int x, int y, double a, Color color){//4 as a square
        drawDot(g, x, y, 479, 495, 20, a, color, 5);
        drawDot(g, x, y, 500, 495, 20, a, color, 5);
        drawDot(g, x, y, 479, 517, 20, a, color, 5);
        drawDot(g, x, y, 500, 517, 20, a, color, 5);
    }

    @Override
    public void chooseDraw(int i, GraphicsContext g, int x, int y, double a) {
        dots[i].draw(g,x,y,a);
    }
}
