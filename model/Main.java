package model;

import java.util.*;

import static java.util.Arrays.*;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
        Stack_of_cards.getStack().newStack();
        Cards_in_hand c=new Cards_in_hand();
        Integer[] hand = {34};
        c.setCards(new ArrayList<>(List.of(hand)));
        Check_Win w=new Check_Win(c);
        w.findCards();
        System.out.print(w.getWinCards());

        // 当文本光标位于高亮显示的文本处时按 Alt+Enter，
        // 可查看 IntelliJ IDEA 对于如何修正该问题的建议。
        /*boolean[] s=new boolean[5];
        Scanner scanner = new Scanner(System.in);
        Stack_of_cards i=new Stack_of_cards();
        Cards_in_hand p1=new Cards_in_hand(i);
        Cards_in_hand p2=new Cards_in_hand(i);
        Cards_in_hand p3=new Cards_in_hand(i);
        Cards_in_hand p4=new Cards_in_hand(i);
        Cards_in_hand[] pList=new Cards_in_hand[]{p1,p2,p3,p4};
        Cards_in_hand np=p1;
        for(Cards_in_hand a:pList){
            a.sortCards();
        }
        int p=0;
        int card = 0;
        int input;
        boolean chow=false;
        boolean pong=false;
        boolean win=false;
        int chown=0;
        int pongn=0;
        int winn=0;
        int pp=0;
        ArrayList<Integer[]> chowl=new ArrayList<>();
        while(true){
            if(i.remainCardNum()==0){
                System.out.println("没牌了，平局");
                break;
            }
            if(win){
                p=winn;
            }else if(pong){
                p=pongn;
            }else if(chow){
                p=chown;
            }
            np=pList[p%4];
            System.out.println(name(np,pList)+" turn");
            //np.wenzi();
            //System.out.println(np.showPutAway());
            if (win) {
                np.wenzi();
                System.out.println("胡？(1or2)");
                input = scanner.nextInt();
                if(input==1){
                    System.out.println("你赢了");
                    break;
                }else{
                    p=pp;
                    continue;
                }
            }else if(pong){
                pong=false;
                np.wenzi();
                System.out.println("碰？(1or2)");
                input = scanner.nextInt();
                if(input==1){
                    np.pong(card);
                    np.wenzi();
                    System.out.println(np.showPutAway());
                }else{
                    p=pp;
                    continue;
                }
            }else if(chow){
                chow=false;
                np.wenzi();
                System.out.println("吃？(1or2)");
                input = scanner.nextInt();
                if(input==1) {
                    for(Integer[] t:chowl){
                        System.out.print("[ "+np.get(t[0])+", "+np.get(t[1])+" ]");
                        System.out.print("---");
                    }
                    System.out.println();
                    System.out.println("吃哪个（0，1,2）");
                    input = scanner.nextInt()%chowl.size();
                    np.chow(chowl.get(input),card);
                    np.wenzi();
                    System.out.println(np.showPutAway());
                }else{
                    p=pp;
                    continue;
                }
            }else {
                np.drawCard(i);

                np.wenzi();
                System.out.println(np.showPutAway());
                if (np.ifWin(np.showCards().get(np.showCards().size() - 1))) {
                    System.out.println("胡？(1or2)");
                    input = scanner.nextInt();
                    if (input == 1) {
                        System.out.println(name(np,pList)+" 赢了");
                        break;
                    }
                }
            }
            System.out.println("出牌，输入手牌:(序号）");
            input = scanner.nextInt()%(14-3*np.showPutAway().size());
            card=np.playCard(input);
            System.out.println("出了:"+np.get(card));
            int num =0;
            while(num <4){
                if(np!=pList[num]&&pList[num].ifWin(card)){
                    winn=num;
                    win=true;
                }
                if(np!=pList[num]&&pList[num].ifPong(card)){
                    pongn=num;
                    pong=true;
                }
                if(pList[num]==pList[(p+1)%4]&&pList[num].ifChow(card)!=null){
                    chowl=pList[num].ifChow(card);
                    chown=num;
                    chow=true;
                }
                num++;
            }
            pp=p+1;
            p++;
        }

    }
    static String name(Cards_in_hand a, Cards_in_hand[] p){
        if(a==p[0]){
            return "player 1";
        }
        if(a==p[1]){
            return "player 2";
        }
        if(a==p[2]){
            return "player 3";
        }
        if(a==p[3]){
            return "player 4";
        }
        return "";
    }*/
}}