package MainScreen;

import GUI.CardPane;
import game.Mahjong;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import language.LanguageChange;
import screen.OtherScreen;

import static MainScreen.LanguageChanger.updateLanguage;

public class StartController {
    @FXML
    private Pane mainScreen;
    @FXML
    private Pane lines;

    public void initialize(){
        drawLines();
        for(int n=0;n<3;n++){
            initializeGameButton(n);
        }
        updateLanguage(mainScreen);
        initializeExitButton();
        initializeInfoButton();
        new LanguageChanger(mainScreen);
    }

    // Decoration the table
    private void drawLines(){
        Canvas canvas = new Canvas(1280, 830);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        lines.getChildren().add(canvas);
        drawLine(gc,Color.PURPLE,4);
        drawLine(gc,Color.BLACK,1);
    }
    private void drawLine(GraphicsContext gc,Color c,int wide){
        gc.setStroke(c);
        gc.setLineWidth(wide);
        for (int i = 0; i < lines.getPrefWidth(); i += 20) {
            gc.strokeLine(i, 0, i + 20, lines.getPrefHeight());
        }
    }
    private void initializeGameButton(int n) {
        // Initialize three button about game model

        Pane p=(Pane) mainScreen.lookup("#but"+n);
        Label l= (Label) p.lookup("#l");
        CardPane c=new CardPane((Pane) p.lookup("#card"),n);
        c.update(n+31);
        p.lookup("#card").setOnMouseEntered(event->{
            if(p.getLayoutY()==300) {
                p.setLayoutY(p.getLayoutY() - 50);
                l.setVisible(true);
            }
        });
        p.setOnMouseExited(event->{
            if(p.getLayoutY()==250) {
                p.setLayoutY(p.getLayoutY() + 50);
                l.setVisible(false);
            }
        });
        int j=n;
        p.setOnMouseClicked(event->{
            startGameMode(j);
        });
    }
    private void initializeExitButton() {
        // Initialize exit button

        mainScreen.lookup("#leave").setOnMouseClicked(event->{
            System.exit(0);
        });
        Canvas canvas = new Canvas(65,55);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        ((Pane)mainScreen.lookup("#leave")).getChildren().add(canvas);
        OtherScreen.exitButton(gc,25,25,1);
    }
    private void initializeInfoButton(){
        // Initialize button for information
        // Show a pop-up window to show the information

        mainScreen.lookup("#info").setOnMouseClicked(event->{
            Platform.runLater(() -> {
                Dialog dialog = new Dialog();
                dialog.setTitle(":)");
                dialog.setContentText(LanguageChange.getLanguage().getString("info"));
                ButtonType customButton = new ButtonType(":)", ButtonBar.ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().add(customButton);
                dialog.getDialogPane().setPrefWidth(600); // 设置对话框宽度
                dialog.getDialogPane().setPrefHeight(600);
                dialog.show();
            });
        });
        Canvas canvas = new Canvas(70,55);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        ((Pane)mainScreen.lookup("#info")).getChildren().add(canvas);
        OtherScreen.infoButton(gc,35,25,1);
    }

    void startGameMode(int mode) {
        // Three different game model

        if(mode==0){
            new LocalGame().startGame();
        }else if(mode==1){
            new HostGame().startGame();
        }else if(mode==2){
            new ClientGame().startGame();
        }
    }
}
