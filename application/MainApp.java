package application;

import MainScreen.MainScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static application.MainApp.primaryStage;

public class MainApp extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("MAHJONG");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        new MainScreen().startMainScreen();
    }

    public static void main(String[] args) {
        launch(args);
    }
}