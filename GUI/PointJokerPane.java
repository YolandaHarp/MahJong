package fx;

import javafx.scene.layout.Pane;
import model.Stack_of_cards;

public class PointJokerPane implements Screens{
    private static PointJokerPane pointJokerPane=new PointJokerPane();
    private PointJokerPane(){}
    Pane p;
    public static PointJokerPane getPointJokerPane() {
        return pointJokerPane;
    }
    @Override
    public void initialize(Pane p) {
        this.p=(Pane)p.lookup("#table");

    }

    @Override
    public void updateCanvases() {
        Pane pane=new Pane();
        pane.setPrefSize(70,98);
        p.getChildren().add(pane);
        pane.setLayoutX(1000);
        CardPane card=new CardPane(pane,0);
        card.update(Stack_of_cards.getStack().getPointJoker());
    }
}
