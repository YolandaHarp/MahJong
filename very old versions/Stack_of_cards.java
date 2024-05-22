import java.util.*;

public class Stack_of_cards {

    Deque<Integer> stack = new ArrayDeque<>();
    public Stack_of_cards(){
        Deque<Integer> stack = new ArrayDeque<>();

    }

    public void get_random_stack(){

        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for(int j =1 ;j <= 4; j++){
            for(int i = 0; i <= 33; i++){
                int place = rand.nextInt(list.size()+1);
                list.add(place,i);
            }
        }

        check(list);

        for (int i = 0; i < list.size(); i++) {
            stack.addLast(list.get(i));
        }
    }

    public void check(List<Integer> list){
        Transform t = new Transform();
        int[] check = new int[34];
        for (int i = 0; i < list.size(); i++) {
            check[list.get(i)]++;
        }
        System.out.println(Arrays.toString(check));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i )+ " " + t.trans(list.get(i)));
        }

        System.out.println(remain());
    }

    public int remain(){
        return stack.size();
    }


}
