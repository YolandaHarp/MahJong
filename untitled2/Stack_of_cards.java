import java.util.*;

public class Stack_of_cards {
    Random random = new Random();
    private Deque<Integer> stack;
    private int pointJoker;
    private int joker;
    private int end=0;
    Stack_of_cards(){
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int j =1 ;j <= 4; j++){
            for(int i = 0; i <= 33; i++){
                int place = random.nextInt(list.size()+1);
                list.add(place,i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            stack.addLast(list.get(i));
        }
        pointJoker = random.nextInt(34);
        if (pointJoker == 8 || pointJoker == 17 || pointJoker == 26) {
            joker = pointJoker - 8;
        } else if (pointJoker == 30) {
            joker = pointJoker - 3;
        } else if (pointJoker == 33) {
            joker = pointJoker - 2;
        } else {
            joker = pointJoker + 1;
        }
    }
    int pick(){
        return stack.pop();
    }
    int remainCardNum(){
        return stack.size();
    }
    int getJoker(){
        return joker;
    }
    int getPointJoker(){
        return pointJoker;
    }
}
