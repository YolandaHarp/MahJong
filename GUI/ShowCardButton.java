package GUI;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import language.LanguageChange;

public class ShowCardButton implements Screens{
    private static ShowCardButton showCardButton=new ShowCardButton();
    private Button button;
    private ShowCardButton(){}
    protected static ShowCardButton getShowCardButton(){
        return showCardButton;
    }
    @Override
    public void initialize(Pane p) {
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
