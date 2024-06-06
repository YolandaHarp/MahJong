package model;

import java.io.Serializable;
import java.util.*;

// Singleton pattern
public class Stack_of_cards implements Serializable {
    private static Stack_of_cards stack=new Stack_of_cards();
    Random random = new Random();
    private Deque<Integer> cards = new ArrayDeque<>();
    private int pointJoker;
    private int end=16;
    private Stack_of_cards() {
    }
    public static Stack_of_cards getStack(){
        return stack;
    }
    protected int pick(){
        return cards.removeFirst();
    }
    public int remainCardNum(){
        // The last 16 cards in the rule cannot be used
        // 16 come from each player can Kong 4 times at most
        // When one player Kong one more cards join into the game

        return cards.size()-end;
    }

    public int getJoker(){
        // Get the joker in this game

        int joker;
        if (pointJoker == 8 || pointJoker == 17 || pointJoker == 26) {
            joker = pointJoker - 8;
        } else if (pointJoker == 30) {
            joker = pointJoker - 3;
        } else if (pointJoker == 33) {
            joker = pointJoker - 2;
        } else {
            joker = pointJoker + 1;
        }
        return joker;
    }

    public int getPointJoker(){
        return pointJoker;
    }
    public void changeEnd(){
        end--;
    }

    public void newStack(){
        // Initialize the tack before the game start

        cards.clear();
        List<Integer> list = new ArrayList<>();
        for(int j =1 ;j <= 4; j++){
            for(int i = 0; i <= 34; i++){
                int place = random.nextInt(list.size()+1);
                list.add(place,i);
            }
        }
        cards.addAll(list);

        // Set the joker in the game
        // Joker is the 35th in the list
        pointJoker = random.nextInt(34);
        Integer joker=getJoker();

        // Removes the card joker replaced
        cards.remove(pointJoker);
        for(int i=0;i<4;i++){
            cards.remove(joker);
        }
    }

    public Deque<Integer> show(){
        return new ArrayDeque<>(cards);
    }

    // Update the stack when online
    public void setStack(Stack_of_cards s){
        stack=s;
    }
}
