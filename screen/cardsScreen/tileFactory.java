package screen.cardsScreen;

import javafx.scene.canvas.GraphicsContext;
import model.Stack_of_cards;
import screen.cardsScreen.Bam.BamScreen;
import screen.cardsScreen.Dot.DotScreen;
import screen.cardsScreen.Letter.LetterScreen;
import screen.cardsScreen.Wan.WanScreen;

// Singleton pattern
// Facade pattern
// Factory pattern
public class tileFactory {
    private static tileFactory fac=new tileFactory();
    private ChooseDrawable[] c =new ChooseDrawable[]{DotScreen.getDot(),BamScreen.getBam(), WanScreen.getWan(), LetterScreen.getLetter()};
    private tileFactory(){}
    public void getTile(int i, GraphicsContext g, double x, double y, double a){
        // If i > 35 draw card back

        if(i<35) {
            CardScreen.getCard().drawCardFront(g, x, y, a);
            if (i == 34) {
                i = Stack_of_cards.getStack().getJoker();
            }
            c[i / 9].chooseDraw(i % 9, g, x, y, a);
        }else{
            CardScreen.getCard().drawCardBack(g, x, y, a);
        }
    }
    public static tileFactory getFac(){
        return fac;
    }
}
