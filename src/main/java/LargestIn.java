
public class LargestIn extends Main{
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
    static private float SmallerThanS(float n, float S, float Step){
        for(; (n*(n+1)/2)<S; n=Math.round((n+Step)/Step)*Step) System.out.print("\rdoes not equate to smaller than S with n being " + n);
        return n;
    }
}