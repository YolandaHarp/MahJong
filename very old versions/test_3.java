import java.util.Arrays;

public class test_3 {
    public static void main(String[] args){
        int[] player = new int[]{0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8};
        Ready_hand_new rh = new Ready_hand_new(player,9);

        rh.is_ready();
        rh.win();
    }
}
