package fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import screen.cardsScreen.Bam.BamScreen;
import javafx.scene.canvas.Canvas;
import screen.cardsScreen.CardScreen;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class Main2 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("New.FXML"));

        // 获取TabPane

        Scene scene = new Scene(root, 1280, 830);
        primaryStage.setScene(scene);
        primaryStage.show();
        /*new Thread(() ->{
            System.out.println(ActionButtonsPane.getButton().getChoice());
            System.out.println(1);
        }).start();*/



    }
    
    public static void main(String[] args) {
        launch(args);

    }

}

