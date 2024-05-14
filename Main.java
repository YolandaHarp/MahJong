package application;

import java.awt.Canvas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("New.FXML"));
            
            // 获取TabPane
            TabPane tabPane = (TabPane) root.lookup("#Table");

            // 获取第一个Tab
            Tab tab1 = tabPane.getTabs().get(0);

            // 获取HBox
            HBox hbox = (HBox) tab1.getContent().lookup("#hbox");

            // 获取pane1
            AnchorPane[] panes = new AnchorPane[] {(AnchorPane) hbox.lookup("#pane1"),(AnchorPane) hbox.lookup("#pane11"),(AnchorPane) hbox.lookup("#pane111")};

            if (panes[0] == null) {
                System.out.println("Error: Could not find pane1.");
                return;
            }
            if (panes[1] == null) {
                System.out.println("Error: Could not find pane11.");
                return;
            }
           // Canvas canvas = new Canvas(400, 300);
            
            // 获取GraphicsContext，用于绘制
           // GraphicsContext gc = canvas.getGraphicsContext2D();

            // 添加鼠标点击事件处理器
            for(AnchorPane p: panes) {
            	p.setOnMouseClicked(event -> {
                    System.out.println("Mouse clicked pane1.");
                    // 将pane1向上移动30个像素
                    if(p.getTranslateY()!=-15) {
                    p.setTranslateY(-15);
                    }else {
                    	p.setTranslateY(0);
                    }
                    for(AnchorPane p1: panes) {
                    	if(p1!=p) {
                    		p1.setTranslateY(0);
                    	}
                    }
                });
            }
            

            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.show();

            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
