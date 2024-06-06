package screen.cardsScreen.Letter;

import javafx.scene.canvas.GraphicsContext;
import screen.cardsScreen.ChooseDrawable;
import screen.cardsScreen.Drawable;

// Singleton pattern
// Composite pattern
public class LetterScreen implements ChooseDrawable {
    private static LetterScreen letter=new LetterScreen();
    private Drawable[] letters= new Drawable[]{new MJ27(),new MJ28(),new MJ29(),new MJ30(),new MJ31(),new MJ32(),new MJ33()};
    private LetterScreen(){}
    public static LetterScreen getLetter() {
        return letter;
    }

    @Override
    public void chooseDraw(int i, GraphicsContext g, double x, double y, double a) {
        letters[i].draw(g,x,y,a);
    }
}
