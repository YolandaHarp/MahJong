package GUI;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import language.LanguageChange;

// Singleton pattern
// Null Object pattern
class OtherPane implements Screens{
    // The implementation of the rest of the front-end functions

    private static OtherPane otherPane =new OtherPane();
    Pane p;
    private OtherPane() {}
    protected static OtherPane getOtherPane(){
        return otherPane;
    }

    @Override
    public void initialize(Pane p) {
        this.p=p;
        ((Label)p.lookup("#over")).setText(LanguageChange.getLanguage().getString("over"));
        ((Label)p.lookup("#wait")).setText(LanguageChange.getLanguage().getString("wait"));
    }

    @Override
    public void updateCanvases() {
        // Show when draw

        clearTable();
        ((Label)p.lookup("#over")).setText(LanguageChange.getLanguage().getString("draw"));
    }

    protected void clearTable(){
        // Clean the table after game over

        p.lookup("#table").setVisible(false);
        p.lookup("#over").setVisible(true);
    }

    protected void showTurn(boolean b){
        // Show is your turn

        p.lookup("#table").lookup("#turn").setVisible(b);
    }

    public void setString(String s){
        // Change the text in the screen
        // Use to show the IP address

        ((Label)p.lookup("#wait")).setText(s);
    }

}
