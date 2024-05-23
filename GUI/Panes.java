package fx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public abstract class Panes {
    Pane p;
    GraphicsContext gc;

    Panes(Pane p){
        this.p=p;
        Canvas canvas = new Canvas(p.getPrefWidth(),p.getPrefHeight());
        gc = canvas.getGraphicsContext2D();
        p.getChildren().add(canvas);
    }
    Pane getPane() {
        return p;
    }
}
