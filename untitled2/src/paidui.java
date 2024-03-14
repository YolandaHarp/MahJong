import java.util.Random;

public class paidui {
    Random random = new Random();
    private card[] dui=new card[35];
    private card zhishi;
    private card hun;
    private int end=0;
    paidui(){
        int i = 0;
        for (int c = 0; c < 3; c++) {
            for (int n = 0; n < 9; n++) {
                dui[i] = new card(c, n, 4);
                i++;
            }
        }
        for (int n = 0; n < 7; n++) {
            dui[i] = new card(3, n, 4);
            i++;
        }
        dui[i] = new card(4, 0, 4);
        int a = new Random().nextInt(34);
        zhishi = dui[a];
        dui[a].reduceRe();
        int hunnum;
        if (a == 8 || a == 17 || a == 26) {
            hunnum = a - 8;
        } else if (a == 30) {
            hunnum = a - 3;
        } else if (a == 33) {
            hunnum = a - 2;
        } else {
            hunnum = a + 1;
        }
        hun = dui[hunnum];
        dui[hunnum].noRe();
    }
    card chou(){
        int num=random.nextInt(35);
        while (true) {
            if (dui[num].getRe() != 0) {
                dui[num].reduceRe();
                return dui[num];
            }else{
                num=(num+1)%35;
            }
        }
    }
    int remainCardNum(){
        int remain = 0;
        for (card card : dui) {
            remain += card.getRe();
        }
        return remain;
    }
}
