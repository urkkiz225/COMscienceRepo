import java.util.ArrayList;

public class BlackJack extends Main{
    public static void blackjack(int cardValues){
        ArrayList<Object[]> ValueMap = new ArrayList<>(){
            {
                add(new Object[]{21, 31, "Bust! "});
                add(new Object[]{17,21, "Stay! "});
                add(new Object[]{2, 17, "Hit! "});
            }
        };
        for (Object[] map:ValueMap) {
            if((int)map[0]<=cardValues&&(int)map[1]>cardValues){
                System.out.print((String)map[2]+cardValues);
                break;
            }
        }
    }
}
