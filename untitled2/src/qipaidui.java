public class qipaidui {
    private card[] qi=new card[34];
    int i=0;
    void add(card c){
        qi[i]=c;
        i++;
    }
    card[] show(){
        card[] copyQi=new card[34];
        int n =0;
        for (card card : qi) {
            copyQi[n]=card;
            n++;
        }
        return copyQi;
    }
}
