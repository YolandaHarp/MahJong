import java.util.*;

public class Stack_of_cards {
    Random random = new Random();
    private Deque<Integer> stack= new ArrayDeque<>();
    private int pointJoker;
    private int joker;
    private int end=0;
    public Stack_of_cards(){
        List<Integer> list = new ArrayList<>();
        for(int j =1 ;j <= 4; j++){
            for(int i = 0; i <= 34; i++){
                int place = random.nextInt(list.size()+1);
                list.add(place,i);
            }
        }
        stack.addAll(list);
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
        stack.remove(pointJoker);
        stack.remove(joker);
        stack.remove(joker);
        stack.remove(joker);
        stack.remove(joker);
    }
    int pick(){
        return stack.removeFirst();
    }
    int pickFromBottom(){
        return stack.pop();
    }
    int remainCardNum(){
        return stack.size()-end;
    }
    int getJoker(){
        return joker;
    }
    void setEnd(int i){
        end=i;
    }
    int getPointJoker(){
        return pointJoker;
    }
}
