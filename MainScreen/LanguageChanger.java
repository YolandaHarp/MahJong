package MainScreen;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import language.LanguageChange;

class LanguageChanger {
    // Offer button to change the language
    protected LanguageChanger(Pane p){
        ((Label)p.lookup("#language").lookup("#name")).setText(LanguageChange.getLanguage().getString("language"));
        p.lookup("#language").lookup("#left").setOnMouseClicked(event->{
            LanguageChange.getLanguage().languageDown();
            updateLanguage(p);
        });
        p.lookup("#language").lookup("#right").setOnMouseClicked(event->{
            LanguageChange.getLanguage().languageUp();
            updateLanguage(p);
        });
    }
    static void updateLanguage(Pane p) {
        String[] strings=new String[]{LanguageChange.getLanguage().getString("local"),LanguageChange.getLanguage().getString("host"),LanguageChange.getLanguage().getString("client")};
        ((Label)p.lookup("#language").lookup("#name")).setText(LanguageChange.getLanguage().getString("language"));
        for(int i=0;i<3;i++){
            ((Label)p.lookup("#but"+i).lookup("#l")).setText(strings[i]);
        }
    }
}
