package GUI;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class CardsController {
    private static Screens[] screen =new Screens[] {ChoicePane.getChoicePane(),ActionButtonsPane.getButton(),HandCardsPane.getHandCardsPane(),TablePane.getTablePane(),DiscardPane.getDiscards(), WinPane.getFinish(),DrawPane.getDrawPane(),PointJokerPane.getPointJokerPane()};

    @FXML
    private Pane stage;
    @FXML
    private Button next;



    public void initialize() {
        for(Screens s:screen){
            s.initialize(stage);
        }
        next.setOnMouseClicked(event -> {
                HandCardsPane.getHandCardsPane().updateCards(false);
        });
    }
    public static void updateScreen(int i){
        Platform.runLater(() -> {
            screen[i].updateCanvases();
        });
    }
    public static void updateGame(boolean hide){
        updateScreen(3);
        HandCardsPane.getHandCardsPane().updateCards(hide);
        DiscardPane.getDiscards().updateCanvases();
    }
    public static int updateChoices(boolean b){
        Platform.runLater(() -> {
            ChoicePane.getChoicePane().updateChoices(b);
        });
        return ChoicePane.getChoicePane().getChoice();
    }
}