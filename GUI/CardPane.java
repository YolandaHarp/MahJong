package fx;

import javafx.scene.layout.Pane;
import screen.cardsScreen.CardScreen;
import screen.cardsScreen.tileFactory;

public class CardPane extends Panes{
    int num;

    CardPane(Pane p, int n){
        super(p);
        num=n;
    }
    void update(int i){
        if(i>35){
            CardScreen.getCard().drawCardBack(gc, 35, 50, 1);
        }else {
            CardScreen.getCard().drawCardFront(gc, 35, 50, 1);
            tileFactory.getFac().getTile(i, gc, 35, 50, 1);
        }
        if(i==34){
            CardScreen.getCard().drawCardFrontHun(gc, 35, 50, 1);
        }
    }
    int getNum(){
        return num;
    }
}
