package GUI;

import javafx.scene.layout.Pane;
import screen.cardsScreen.CardScreen;
import screen.cardsScreen.tileFactory;

public class CardPane extends Panes{
    // Single button to show one card

    // The number of cards(count from left to right)
    int num;

    // A multiple of amplification or reduction
    Double a;

    public CardPane(Pane p, int n){
        super(p);
        num=n;
        a=p.getPrefWidth()/70;
    }
    public void update(int i){
        // Draw the corresponding card face based on i
        tileFactory.getFac().getTile(i, gc, 35*a, 50*a, a);

        // Draw a signal for the joker
        if(i==34){
            CardScreen.getCard().drawCardFrontHun(gc, 35*a, 50*a, a);
        }
    }
    int getNum(){
        return num;
    }
}
