package GUI;

import game.Mahjong;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

// Singleton pattern
// Null Object pattern
class ChoicePane implements Screens{
    // Offer different choices when one player action can get different result

    HBox h;
    private static ChoicePane choicePane = new ChoicePane();
    int choice;
    volatile boolean doneChoose; // Whether the player have made the choice
    private ChoicePane(){
    }

    protected static ChoicePane getChoicePane(){
        return choicePane;
    }

    @Override
    public void initialize(Pane p) {
        // Design the popup style

        this.h =(HBox) p.lookup("#table").lookup("#choices");
        h.setPadding(new Insets(15));
        h.setSpacing(10);
        h.setVisible(false);
    }

    @Override
    public void updateCanvases() {
    }

    // Facde pattern
    protected void updateChoices(boolean b) {
        // "b" determines two situations that require the player to make further choices

        doneChoose = false;
        h.getChildren().clear();
        if(b){
            updateChowChoices(Mahjong.getMJ().getPlayer(Mahjong.getMJ().getPlayerNum()).getAction().getChowChoice());
        }else{
            updateSingleChoices(Mahjong.getMJ().getPlayer(Mahjong.getMJ().getPlayerNum()).getAction().getCKongChoice());
        }
        h.setVisible(true);
    }

    private void updateChowChoices(ArrayList<Integer[]> choices){
        // Situation for Chow. Each situation include two cards

        for(int i=0;i<choices.size(); i ++){
            HBox hbox =new HBox();
            for(int j:choices.get(i)){
                updateCard(hbox,i,j);
            }
            h.getChildren().add(hbox);
        }
    }

    private void updateSingleChoices(ArrayList<Integer> cards){
        // Situation for Kong. Each situation include one cards

        for(int i=0;i<cards.size();i++){
            updateCard(h,i,cards.get(i));
        }
    }

    private void updateCard(HBox h,int i,int value){
        // Initialize every button

        CardPane card= WinPane.updateCard(h,i,value);
        card.getPane().setOnMouseClicked(event -> {
            choice=card.getNum();
            doneChoose=true;
            this.h.setVisible(false);
        });
    }

    public int getChoice(){
        // Get player's choice

        while (!doneChoose&&!CardsController.getStop()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        doneChoose = false;
        return choice;
    }
}
