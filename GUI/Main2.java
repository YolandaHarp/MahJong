package GUI;

import game.Mahjong;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


import java.io.IOException;


public class Main2 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        new Thread(() -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("New.fxml"));

                // Ensure the UI update is run on the JavaFX Application Thread
                Platform.runLater(() -> {
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.setOnCloseRequest(event -> System.exit(0));
                    primaryStage.show();
                });
                Mahjong.getMJ().startGame();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    
    public static void main(String[] args) {


        launch(args);
    }

}

