package GUI;

import game.Mahjong;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

 class ChoicePane implements Screens{
    HBox h;
    private static ChoicePane choicePane = new ChoicePane();
    int choice;
    volatile boolean doneChoose;
    private ChoicePane(){
    }
    protected static ChoicePane getChoicePane(){
        return choicePane;
    }

    @Override
    public void initialize(Pane p) {
        this.h =(HBox) p.lookup("#table").lookup("#choices");
        h.setPadding(new Insets(15));
        h.setSpacing(10);
        h.setVisible(false);
    }

    @Override
    public void updateCanvases() {
    }

    public void updateChoices(boolean b) {
        doneChoose = false;
        h.getChildren().clear();
        if(b){
            updateChowChoices(Mahjong.getMJ().getPlayer(Mahjong.getMJ().getPlayerNum()).getAction().getChowChoice());
        }else{
            updateSingleChoices(Mahjong.getMJ().getPlayer(Mahjong.getMJ().getPlayerNum()).getAction().getCKongChoice());
        }
        h.setVisible(true);
    }
    void updateChowChoices(ArrayList<Integer[]> choices){
        for(int i=0;i<choices.size(); i ++){
            HBox hbox =new HBox();
            for(int j:choices.get(i)){
                updateCard(hbox,i,j);
            }
            h.getChildren().add(hbox);
        }
    }
    void updateSingleChoices(ArrayList<Integer> cards){
        for(int i=0;i<cards.size();i++){
            updateCard(h,i,cards.get(i));
        }
    }
    void updateCard(HBox h,int i,int value){
        CardPane card= WinPane.updateCard(h,i,value);
        card.getPane().setOnMouseClicked(event -> {
            choice=card.getNum();
            doneChoose=true;
            this.h.setVisible(false);
        });
    }
    public int getChoice(){
        while (!doneChoose) {
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
