import java.util.ArrayList;
import java.util.Random;

public class COMtasks{


    public static void compare(int a, int b){
        System.out.println(a + "" + b);
        boolean isIt = true, really = false;
        Boolean positive = a > 0;
        double coeff=1.24;
        System.out.println(positive + ":" + (float)coeff*random.nextInt(a,b));

    }


    public static void Largest(int largest, int smallest, int loopLim) {
        for (int i = 0; i < loopLim; i++) {
            int val = i * (i - 36) * (i - loopLim);
            if (val < largest) {
                largest = val;
            }
            if (val < smallest) {
                smallest = val;
            }
        }
        System.out.println(smallest + "," + largest);
        float Step = 0.1f;
        float S = 100000;
        float n = 0;
        System.out.print("\ndoes equate to smaller than S with n being " + SmallerThanS(n, S, Step));
    }


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


    public static void CalcBacteria(){
        System.out.println("bruh!!1!");
    }

    //util
    public static Random random = new Random();
    protected static float SmallerThanS(float n, float S, float Step){
        for(; (n*(n+1)/2)<S; n=Math.round((n+Step)/Step)*Step) System.out.print("\rdoes not equate to smaller than S with n being " + n);
        return n;
    }

    public static void Test(int[] argz){
        for (int ignored:
             argz) {
            System.out.println(argz+", bruh");
        }
    }
}
