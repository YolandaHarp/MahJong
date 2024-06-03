package GUI;


import MainScreen.MainScreen;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import language.LanguageChange;
import screen.OtherScreen;

import java.io.IOException;

public class CardsController {
    private static Screens[] screen = new Screens[]{ChoicePane.getChoicePane(), ActionButtonsPane.getButton(), HandCardsPane.getHandCardsPane(), TablePane.getTablePane(), DiscardPane.getDiscards(), WinPane.getFinish(), DrawPane.getDrawPane(), PointJokerPane.getPointJokerPane(),ShowCardButton.getShowCardButton()};

    @FXML
    private Pane stage;


    public void initialize() {
        for (Screens s : screen) {
            s.initialize(stage);
        }
        stage.lookup("#leave").setOnMouseClicked(event->{
            new MainScreen().startMainScreen();
        });
        Canvas canvas = new Canvas(65,55);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        ((Pane)stage.lookup("#leave")).getChildren().add(canvas);
        OtherScreen.exitButton(gc,25,25,1);
        ((Label)stage.lookup("#table").lookup("#turn")).setText(LanguageChange.getLanguage().getString("turn"));
    }

    public static void updateScreen(int i) {
        Platform.runLater(() -> {
            screen[i].updateCanvases();
        });
    }

    public static void updateGame(boolean hide) {
        updateScreen(3);
        Platform.runLater(() -> {
            HandCardsPane.getHandCardsPane().updateCards(hide);
            DiscardPane.getDiscards().updateCanvases();
        });
    }

    public static int updateChoices(boolean b) {
        Platform.runLater(() -> {
            ChoicePane.getChoicePane().updateChoices(b);
        });
        return ChoicePane.getChoicePane().getChoice();
    }

    public static int playCard() {
        HandCardsPane.getHandCardsPane().setPlayCard();
        return HandCardsPane.getHandCardsPane().getChoice();
    }
    public static int getChoice(){
        return ActionButtonsPane.getButton().getChoice();
    }
    public static void setString(String s){
        Platform.runLater(() -> {
            PointJokerPane.getPointJokerPane().setString(s);
        });
    }
    public static void showNetError(){
        Platform.runLater(() -> {
            Alert dialog = new Alert(null);
            dialog.setTitle(":(");
            dialog.setContentText(LanguageChange.getLanguage().getString("disconnect"));
            ButtonType customButton = new ButtonType(":(", ButtonBar.ButtonData.OK_DONE);
            dialog.getButtonTypes().add(customButton);
            dialog.show();
            new MainScreen().startMainScreen();
        });
    }
    public static void showTurn(boolean b){
        DrawPane.getDrawPane().showTurn(b);
    }
}
