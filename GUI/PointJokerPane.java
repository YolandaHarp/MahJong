package GUI;

import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import language.LanguageChange;
import model.Stack_of_cards;

// Singleton pattern
// Null Object pattern
class PointJokerPane implements Screens{
    private static PointJokerPane pointJokerPane=new PointJokerPane();
    private PointJokerPane(){}
    Pane p;
    protected static PointJokerPane getPointJokerPane() {
        return pointJokerPane;
    }

    @Override
    public void initialize(Pane p) {
        this.p=p;
    }

    @Override
    public void updateCanvases() {
        // Show the joker point card in this game

        p.lookup("#wait").setVisible(false);
        Pane pane=new Pane();
        pane.setPrefSize(70,98);
        ((Pane)p.lookup("#table")).getChildren().add(pane);
        pane.setLayoutX(1000);
        CardPane card=new CardPane(pane,0);
        card.update(Stack_of_cards.getStack().getPointJoker());
    }

}
