import java.util.ArrayList;

public class Discard_Pile {
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    int i=0;
    void add(int card){
        cards.add(card);
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
