public class test_2 {
    public static void main(String[] args){

        int[] player = new int[]{0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8};
        Ready_hand rh = new Ready_hand(player);
        rh.is_ready();
        rh.win();

    }
}
