import java.util.ArrayList;

public class Discard_Pile {
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    void add(int card){
        cards.add(card);
    }
    ArrayList<Integer> show(){
        return new ArrayList<Integer>(cards);
    }
}
