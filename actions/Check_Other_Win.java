package actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Check_Other_Win implements Serializable {
    // Include two special way to win

    private static Check_Other_Win otherWin = new Check_Other_Win();
    ArrayList<Integer> oneOfAKind = new ArrayList<Integer>(Arrays.asList(0,8,9,17,18,26,27,28,29,30,31,32,33));
    int pairNum=0;

    private Check_Other_Win() {}
    protected static Check_Other_Win getOtherWin(){
        return otherWin;
    }
    boolean check(int[] cardCountOrigin,int jokerInHandOrigin){
        countPairNum(cardCountOrigin);
        return (checkSevenPairs(jokerInHandOrigin)||checkOneOfAKind(cardCountOrigin,jokerInHandOrigin));
    }

    void countPairNum(int[] cardCountOrigin){
        // One of the special way to win
        // Player have 7 pairs in his hand

        pairNum=0;
        for(int i = 0; i <= 33; i++){
            if(cardCountOrigin[i]>=2){
                pairNum++;
                if(cardCountOrigin[i]==4){
                    pairNum++;
                }
            }
        }
    }

    boolean checkSevenPairs(int jokerInHandOrigin){
        // One of the special way to win
        // Player have 7 pairs in his hand
        // Include joker

        return (pairNum +jokerInHandOrigin)>=7;
    }

    boolean checkOneOfAKind(int[] cardCountOrigin,int jokerInHandOrigin){
        // One of the special way to win
        // Player have 13 designated cards and any duplicate card
        // Designated cards are 1 and 9 in Bam, Dot and Wan and all cards in letter
        // Include joker

        int num=0;
        for(int i: oneOfAKind){
            if(cardCountOrigin[i]==0){
                if(jokerInHandOrigin>0){
                    jokerInHandOrigin--;
                }else{
                    return false;
                }
            }else if(cardCountOrigin[i]>=2){
                num++;
            }
        }
        return(num+jokerInHandOrigin)>=1;
    }
}
