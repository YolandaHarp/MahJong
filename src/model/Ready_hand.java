import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ready_hand {

    public boolean ready = false;
    public List<Integer> pairs = new ArrayList<>();
    public boolean[] used = new boolean[14];
    public int meld = 0;
    public int[] player;
    public int[] check = new int[14];
    public boolean[] tiles_to_win = new boolean[34];

    public Ready_hand(int[] player){
        this.player= player;
    }

    public void is_ready(){
        for(int i = 0; i < 34; i++){

            System.out.println("\n查看" + i);

            for(int h = 0; h < player.length; h++){
                check[h] = player[h];
            }
            check[13] = i;
            check = Arrays.stream(check).sorted().toArray();

            System.out.println("手牌" + Arrays.toString(check));

            find_pairs();

            int[] ee = new int[pairs.size()];
            for(int e = 0; e < pairs.size(); e++){
                ee[e] = check[pairs.get(e)];
            }
            System.out.println(Arrays.toString(ee));

            for(int num = 0; num < pairs.size(); num++){

                System.out.println("\n对[" + check[pairs.get(num)] + ", " + check[pairs.get(num)+1] + "]");

                used[pairs.get(num)] = true;
                used[pairs.get(num)+1] = true;

                System.out.println(Arrays.toString(used));

                for(int j = 0; j <= 11; j++){
                    if(!used[j]){
                        System.out.println("===");
                        find_sequence(j);
                    }
                }
                for(int j = 0; j <= 11; j++){
                    if(!used[j]){
                        find_triplet(j);
                    }
                }
                if(meld != 4){
                    System.out.println("\n对[" + check[pairs.get(num)] + ", " + check[pairs.get(num)+1] + "]");
                    Arrays.fill(used, false);
                    used[pairs.get(num)] = true;
                    used[pairs.get(num)+1] = true;
                    meld = 0;
                    for(int j = 0; j <= 11; j++){
                        if(!used[j]){
                            find_triplet(j);
                        }
                    }
                    for(int j = 0; j <= 11; j++){
                        if(!used[j]){
                            find_sequence(j);
                        }
                    }
                }
                if(meld == 4 && judge()){
                    ready = true;
                    tiles_to_win[i] = true;
                    System.out.println("听"+i);
                    break;
                }
                Arrays.fill(used, false);
                meld = 0;
            }
            reset();
        }
    }

    public void find_pairs(){
        for(int i = 0; i <=12; i++){
            int temp = check[i];
            if(temp == check[i+1]){
                pairs.add(i);
                while(temp == check[i]){
                    if(i == 13){
                        break;
                    }else if(temp != check[i+1]){
                        break;
                    }else{
                        i++;
                    }
                }
            }
        }
    }

    public void find_sequence(int index){
        int[] sequence = new int[3];

        int[] temp = new int[3];

        sequence[0] = index;
        temp[0] = check[index];
        //System.out.println("\n头" + check[index]);

        int limit = find_domain(index);
        for(int i = index + 1; i <= 12 ; i++){
            if(check[i] == check[index]+1 && check[i] <= limit && !used[i]){
                sequence[1] = i;
                temp[1] = check[i];

                for(int j = i + 1; j <= 13 ; j++){
                    if(check[j] == check[i]+1 && check[j] <= limit && !used[j]){
                        sequence[2] = j;
                        temp[2] = check[j];

                        for(int h = 0; h < 3; h++){
                            used[sequence[h]] = true;
                        }
                        meld++;
                        System.out.println("顺" + Arrays.toString(temp));
                        System.out.println("第" + meld);
                        System.out.println(Arrays.toString(used));

                        break;
                    }
                }
            }
        }
    }

    public void find_triplet(int index){
        if (check[index] == check[index+1] && !used[index+1]) {
            if(check[index] == check[index+2] && !used[index+2]){
                meld++;
                for(int i = index; i < index+3;i++){
                    used[i] = true;
                }
                System.out.println("刻[" + check[index] + ", " + check[index+1]+ ", " + check[index+2] + "]");
                System.out.println("第" + meld);
                System.out.println(Arrays.toString(used));
            }
        }
    }

    public int find_domain(int index){
        if(0 <= check[index] && check[index] <= 8){
            return 8;
        }else if(9 <= check[index] && check[index] <= 17){
            return 17;
        }else{
            return 28;
        }
    }

    public void reset(){
        Arrays.fill(used, false);
        meld = 0;
        pairs = new ArrayList<>();
        check = new int[14];
    }

    public boolean judge(){
        boolean win = true;
        for(int i = 0; i < used.length; i++){
            if(!used[i]){
                win = false;
                break;
            }
        }
        return win;
    }

    public void win(){
        System.out.println("听牌:");
        for(int i = 0; i < tiles_to_win.length; i++){
            if(tiles_to_win[i]){
                System.out.println(i);
            }
        }
    }
}
