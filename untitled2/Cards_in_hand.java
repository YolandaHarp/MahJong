import java.util.*;

public class Cards_in_hand {
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    private ArrayList<Integer> pongCards = new ArrayList<Integer>();
    private ArrayList<Integer> exposedKongCards = new ArrayList<Integer>();
    private ArrayList<Integer> concealedKongCards = new ArrayList<Integer>();
    private Map<Integer,ArrayList<Integer[]>> chowCards = new HashMap<>();
    Cards_in_hand(Stack_of_cards p){
        for(int i=0;i<=12;i++){
            drawCard(p);
        }
    }
    void sortCards() {
        Collections.sort(cards);
    }
    void drawCard(Stack_of_cards p){
        cards.add(p.pick());
        concealedKongCards=findSameCards(4);
    }
    void drawCardFromBottom(Stack_of_cards p){
        cards.add(p.pickFromBottom());
        concealedKongCards=findSameCards(4);
    }
    void playCard(Discard_Pile q, int n){//这里的n是第几张牌
        q.add(n);
        cards.remove(n);
        sortCards();
        pongCards =findSameCards(2);
        exposedKongCards =findSameCards(3);
        chowCards =findChowCards();
    }
    ArrayList<Integer> show(){
        return new ArrayList<Integer>(cards);
    }
    ArrayList<Integer> findSameCards(int n){
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : cards) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == n) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
    Map<Integer,ArrayList<Integer[]>> findChowCards(){
        Map<Integer,ArrayList<Integer[]>> result = new HashMap<>();
        for(int i=0;i<cards.size()-1;i++){
            if(cards.get(i)>26){
                continue;
            }
            if(cards.get(i)+1==cards.get(i+1)&&cards.get(i)%9!=8){
                if(cards.get(i)%9!=0){
                    if(!result.containsKey(cards.get(i)-1)){
                        result.put(cards.get(i)-1,new ArrayList<>());
                    }
                    result.get(cards.get(i)-1).add(new Integer[]{cards.get(i),cards.get(i)+1});
                }if((cards.get(i)+1)%9!=8){
                    if(!result.containsKey(cards.get(i)+2)){
                        result.put(cards.get(i)+2,new ArrayList<>());
                    }
                    result.get(cards.get(i)+2).add(new Integer[]{cards.get(i),cards.get(i)+1});
                }
            }
            if(cards.get(i)+2==cards.get(i+1)&&cards.get(i)%9<7){
                if(!result.containsKey(cards.get(i)+1)){
                    result.put(cards.get(i)+1,new ArrayList<>());
                }
                result.get(cards.get(i)+1).add(new Integer[]{cards.get(i),cards.get(i)+2});
            }
        }
        return result;
    }
    boolean ifPong(int n){
        return pongCards.contains(n);
    }
    boolean ifExposedKong(int n){
        return exposedKongCards.contains(n);
    }
    ArrayList<Integer> ifConcealedKong(){
        return new ArrayList<Integer>(concealedKongCards);//外面判断size==0就是没有
    }
    ArrayList<Integer[]> ifChow(int n){
        return chowCards.getOrDefault(n, null);//在外面判断null就是没有
    }

     ArrayList<Integer> pong(int n){
        cards.remove(n);
        cards.remove(n);
        ArrayList<Integer> p=new ArrayList<Integer>();
        p.add(n);
        p.add(n);
        return p;
    }
    ArrayList<Integer> chow(Integer[] i){
        cards.remove(i[0]);
        cards.remove(i[1]);
        ArrayList<Integer> c=new ArrayList<Integer>();
        c.add(i[0]);
        c.add(i[1]);
        return c;//另外的一个放在外面函数加吧，上面的碰也是
    }
    ArrayList<Integer> exposedKong(int n){
        cards.remove(n);
        cards.remove(n);
        cards.remove(n);
        ArrayList<Integer> k=new ArrayList<Integer>();
        k.add(n);
        k.add(n);
        k.add(n);
        return k;//还要从底部抽一张牌，放在外面吧
    }
    ArrayList<Integer> concealedKong(int n){
        cards.remove(n);
        cards.remove(n);
        cards.remove(n);
        cards.remove(n);
        ArrayList<Integer> k=new ArrayList<Integer>();
        k.add(null);
        k.add(n);
        k.add(n);
        k.add(null);
        return k;
    }


}
