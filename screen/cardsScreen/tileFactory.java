package screen.cardsScreen;

import javafx.scene.canvas.GraphicsContext;
import model.Stack_of_cards;
import screen.cardsScreen.Bam.BamScreen;
import screen.cardsScreen.Dot.DotScreen;
import screen.cardsScreen.Letter.LetterScreen;
import screen.cardsScreen.Wan.WanScreen;

public class tileFactory {
    private static tileFactory fac=new tileFactory();
    ChooseDrawable[] c =new ChooseDrawable[]{DotScreen.getDot(),BamScreen.getBam(), WanScreen.getWan(), LetterScreen.getLetter()};
    private tileFactory(){}
    public void getTile(int i, GraphicsContext g, int x, int y, double a){
        if(i==34){
            i= Stack_of_cards.getStack().getJoker();
        }
        c[i/9].chooseDraw(i%9,g,x, y,a);
    }
    public static tileFactory getFac(){
        return fac;
    }
}
