package GUI;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import language.LanguageChange;

// Singleton pattern
// Null Object pattern
public class ShowCardButton implements Screens{
    // Offer a button to turn the cards from back to front
    private static ShowCardButton showCardButton=new ShowCardButton();
    private Button button;
    private ShowCardButton(){}
    protected static ShowCardButton getShowCardButton(){
        return showCardButton;
    }

    @Override
    public void initialize(Pane p) {
        // Adjust the language

        button=(Button) p.lookup("#table").lookup("#show");
        button.setText(LanguageChange.getLanguage().getString("show"));
        button.setOnMouseClicked(event -> {
            HandCardsPane.getHandCardsPane().updateCards(false);
        });
    }

    @Override
    public void updateCanvases() {
        button.setVisible(true);
    }
}
