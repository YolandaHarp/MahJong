public class card {
    private int color;
    private int number;
    private int re;
    card(int c,int n,int r){
        color=c;
        number=n;
        re=r;
    }
    public int getColor(){
        return color;
    }
    public int getNumber(){
        return number;
    }
    public void reduceRe(){
        re--;
    }
    public void noRe(){
        re=0;
    }
    public int getRe(){
        return re;
    }
}
