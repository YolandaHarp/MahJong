package MainScreen;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

import static application.MainApp.primaryStage;

abstract class StartGame {
    void startGame() {
        new Thread(() -> {
            try {
                // Load the Main2 class
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/Game.fxml"));

                // Ensure the UI update is run on the JavaFX Application Thread
                Platform.runLater(() -> {
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                });
                mode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    abstract void mode() throws IOException;
}
