import java.util.Arrays;

public class shoupai {
    private card[] pai=new card[14];
    shoupai(paidui p){
        int i=0;
        while(i<=12){
            pai[i]=p.chou();
            i++;
        }
    }
    void zhengli() {
        Arrays.sort(pai, (a, b) -> {
            if (a == null) {
                return 1;
            } else if (b == null) {
                return -1;
            }
            int colorCompare = Integer.compare(a.getColor(), b.getColor());
            if (colorCompare != 0) {
                return colorCompare;
            } else {
                return Integer.compare(a.getNumber(), b.getNumber());
            }
        });
    }
    void choupai(paidui p){
        card c=p.chou();
        pai[13]=c;
    }
    void chupai(qipaidui q,int n){
        card c=pai[n];
        q.add(c);
        pai[n]=null;
        zhengli();

    }
    card[] show(){
        card[] copyPai=new card[14];
        int i=0;
        for (card card : pai) {
            copyPai[i]=card;
            i++;
        }
        return copyPai;
    }
    boolean ifPeng(card c){
        int count=0;
        for (card card : pai) {
            if(card.getColor()==c.getColor()&&card.getNumber()==c.getNumber()){
                count++;
            }
        }
        if(count>=2){
            return true;
        }else{
            return false;
        }
    }
}
