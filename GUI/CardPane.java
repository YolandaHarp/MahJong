package GUI;

import javafx.scene.layout.Pane;
import screen.cardsScreen.CardScreen;
import screen.cardsScreen.tileFactory;

public class CardPane extends Panes{
    int num;
    Double a;

    public CardPane(Pane p, int n){
        super(p);
        num=n;
        a=p.getPrefWidth()/70;
    }
    public void update(int i){
        if(i>35){
            CardScreen.getCard().drawCardBack(gc, 35*a, 50*a, a);
        }else {
            CardScreen.getCard().drawCardFront(gc, 35*a, 50*a, a);
            tileFactory.getFac().getTile(i, gc, 35*a, 50*a, a);
        }
        if(i==34){
            CardScreen.getCard().drawCardFrontHun(gc, 35*a, 50*a, a);
        }
    }
    int getNum(){
        return num;
    }
}
