package model;

import java.util.*;

public class Stack_of_cards {
    private static Stack_of_cards stack=new Stack_of_cards();
    Random random = new Random();
    private Deque<Integer> cards = new ArrayDeque<>();
    private int pointJoker;
    private int end=0;
    private Stack_of_cards() {
    }
    public static Stack_of_cards getStack(){
        return stack;
    }
    int pick(){
        return cards.removeFirst();
    }
    int pickFromBottom(){
        return cards.pop();
    }
    int remainCardNum(){
        return cards.size()-end;
    }
    public int getJoker(){
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
    void setEnd(int i){
        end=i;
    }
    int getPointJoker(){
        return pointJoker;
    }
    void newStack(){
        List<Integer> list = new ArrayList<>();
        for(int j =1 ;j <= 4; j++){
            for(int i = 0; i <= 34; i++){
                int place = random.nextInt(list.size()+1);
                list.add(place,i);
            }
        }
        cards.addAll(list);
        pointJoker = random.nextInt(34);
        Integer joker=getJoker();
        cards.remove(pointJoker);
        for(int i=0;i<4;i++){
            cards.remove(joker);
        }
    }
}
