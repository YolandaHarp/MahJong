import java.util.ArrayList;
import java.util.Collections;

public class Cards_in_hand {
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    Cards_in_hand(Stack_of_cards p){
        for(int i=0;i<=12;i++){
            drawCard(p);
        }
    }
    void sortCards() {
        Collections.sort(cards);
    }
    void drawCard(Stack_of_cards p){
        cards.add(p.pick());
    }
    void playCard(Discard_Pile q, int n){
        q.add(n);
        cards.remove(n);
        sortCards();
    }
    int[] show(){
        int[] copyCards=new int[cards.size()];
        int n =0;
        for (int i : cards) {
            copyCards[n]=i;
            n++;
        }
        return copyCards;
    }
}
