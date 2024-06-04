package GUI;

import javafx.scene.layout.Pane;
import model.Discard_Pile;
import screen.cardsScreen.CardScreen;
import screen.cardsScreen.tileFactory;

import java.util.ArrayList;

// Singleton pattern
class DiscardPane extends Panes implements Screens{
    // Discard the front end of the pile

    private static DiscardPane discards=new DiscardPane(new Pane());
    private DiscardPane(Pane p){
        super(p);
    }
    protected static DiscardPane getDiscards(){
        return discards;
    }

    @Override
    public void initialize(Pane p) {
        p=(Pane)p.lookup("#table").lookup("#discard");
        discards = new DiscardPane(p);
    }

    @Override
    public void updateCanvases() {
        // Draw each card for a limit of 17 per row

        gc.clearRect(-300, -300, 1280,830);
        ArrayList<Integer> cards= Discard_Pile.getDiscard().show();
        for(int i=0;i<cards.size();i++){
            CardScreen.getCard().drawCardFront(gc, 25+(i%17)*49, 35+(i/17)*69, 0.7);
            tileFactory.getFac().getTile(cards.get(i), gc, 25+(i%17)*49, 35+(i/17)*69, 0.7);
        }
    }
    public void update(ArrayList<Integer> cards) {
        for(int i=0;i<cards.size();i++){
            CardScreen.getCard().drawCardFront(gc, 25+(i%17)*49, 35+(i/17)*69, 0.7);
            tileFactory.getFac().getTile(cards.get(i), gc, 25+(i%17)*49, 35+(i/17)*69, 0.7);
        }
    }

}
