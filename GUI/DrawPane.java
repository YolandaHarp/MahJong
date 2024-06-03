package GUI;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import language.LanguageChange;

class DrawPane implements Screens{
    private static DrawPane drawPane=new DrawPane();
    Pane p;
    private DrawPane() {}
    protected static DrawPane getDrawPane(){
        return drawPane;
    }
    @Override
    public void initialize(Pane p) {
        this.p=p;
        ((Label)p.lookup("#over")).setText(LanguageChange.getLanguage().getString("over"));
    }

    @Override
    public void updateCanvases() {
        clearTable();
        ((Label)p.lookup("#over")).setText(LanguageChange.getLanguage().getString("draw"));
    }
    protected void clearTable(){
        p.lookup("#table").setVisible(false);
        p.lookup("#over").setVisible(true);
        p.lookup("#leave").setVisible(true);
    }
    protected void showTurn(boolean b){
        p.lookup("#table").lookup("#turn").setVisible(b);
    }


}
