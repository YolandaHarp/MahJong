package GUI;

import MainScreen.MainScreen;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import language.LanguageChange;
import net.Client;
import net.EchoServer2c;
import screen.OtherScreen;

// Singleton pattern
// Composite pattern
// Facade pattern
// Proxy pattern
public class CardsController {
    // Show the hole screen

    private static Screens[] screen = new Screens[]{ChoicePane.getChoicePane(), ActionButtonsPane.getButton(), HandCardsPane.getHandCardsPane(), TablePane.getTablePane(), DiscardPane.getDiscards(), WinPane.getFinish(), OtherPane.getOtherPane(), PointJokerPane.getPointJokerPane(),ShowCardButton.getShowCardButton()};

    @FXML
    private Pane stage;
    private static boolean stop; // Use to stop a single game

    public void initialize() {
        // Initialize all parts on the screen

        stop=false;
        for (Screens s : screen) {
            s.initialize(stage);
        }

        // Initialize exit button
        stage.lookup("#leave").setOnMouseClicked(event->{
            new MainScreen().startMainScreen();
            stop=true;
            EchoServer2c.getServer().closeServer();
            Client.getClient().stopClient();
        });
        Canvas canvas = new Canvas(65,55);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        ((Pane)stage.lookup("#leave")).getChildren().add(canvas);
        OtherScreen.exitButton(gc,25,25,1);
        ((Label)stage.lookup("#table").lookup("#turn")).setText(LanguageChange.getLanguage().getString("turn"));
    }

    public static void updateScreen(int i) {
        // Invoke the corresponding data from the back end

        Platform.runLater(() -> {
            screen[i].updateCanvases();
        });
    }

    // Proxy pattern
    public static void updateGame(boolean hide) {
        // Update game screen

        updateScreen(3);
        Platform.runLater(() -> {
            HandCardsPane.getHandCardsPane().updateCards(hide);
            DiscardPane.getDiscards().updateCanvases();
        });
    }

    public static int updateChoices(boolean b) {
        // Update player's choice when there have many situation

        Platform.runLater(() -> {
            ChoicePane.getChoicePane().updateChoices(b);
        });
        return ChoicePane.getChoicePane().getChoice();
    }

    public static int playCard() {
        // Player play a card
        // Return index for this card

        HandCardsPane.getHandCardsPane().setPlayCard();
        return HandCardsPane.getHandCardsPane().getChoice();
    }

    public static int getChoice(){
        // Get player's choice

        return ActionButtonsPane.getButton().getChoice();
    }

    public static void setString(String s){
        // Use setString()

        Platform.runLater(() -> {
            OtherPane.getOtherPane().setString(s);
        });
    }
    public static void showNetError(){
        // The network error popup window is displayed

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
        // Show player's turn

        Platform.runLater(() -> {
            OtherPane.getOtherPane().showTurn(b);
        });
    }
    public static boolean getStop(){
        return stop;
    }
}
