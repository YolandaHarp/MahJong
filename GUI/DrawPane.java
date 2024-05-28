package fx;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class DrawPane implements Screens{
    private static DrawPane drawPane=new DrawPane();
    Pane table;
    Label l;
    private DrawPane() {}
    public static DrawPane getDrawPane(){
        return drawPane;
    }
    @Override
    public void initialize(Pane p) {
        l=(Label) p.lookup("#over");
        table=(Pane)p.lookup("#table");
    }

    @Override
    public void updateCanvases() {
        table.setVisible(false);
        l.setVisible(true);
        l.setText("Draw");
    }
}
