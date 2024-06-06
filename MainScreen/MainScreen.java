package MainScreen;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import static application.MainApp.primaryStage;

public class MainScreen {
    public void startMainScreen()  {
        // Show the main screen

        Platform.runLater(() -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        });
    }
}
