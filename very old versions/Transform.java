public class Transform {

    String[] table = new String[]{"东","一筒","二筒","三筒","四筒","五筒","六筒","七筒","八筒","九筒",
                                  "西","一条","二条","三条","四条","五条","六条","七条","八条","九条",
                                  "南","一万","二万","三万","四万","五万","六万","七万","八万","九万",
                                  "北","中","発","白"};

    public Transform(){

    }

    public String trans(int num){
        return table[num];
    }

}
