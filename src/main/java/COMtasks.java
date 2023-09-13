import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import ibio.Helpers.*;

import static ibio.Helpers.input;
import static ibio.Helpers.inputInt;

public class COMtasks{
    public static Random random = new Random();
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
            if((int)map[0]<cardValues&&(int)map[1]>=cardValues){
                System.out.print((String)map[2]+cardValues);
                break;
            }
        }
    }


    public static void CalcBacteria(){
        System.out.println("bruh!!1!");
    }


    protected static float SmallerThanS(float n, float S, float Step){
        for(; (n*(n+1)/2)<S; n=Math.round((n+Step)/Step)*Step) System.out.print("\rdoes not equate to smaller than S with n being " + n);
        return n;
    }

    public static void Test(Object[] argz){
        for (Object ignored:
             argz) {
            System.out.println(Arrays.deepToString(argz)+", bruh");
        }
    }
    public void twoSum(int[] nums, int target) {
        int indice1=0;
        int indice2=0;
        for(int i=0; i!=nums.length; i++)
        {
            for(int n=i+1; n!=nums.length; n++)
            {
                if(nums[i]+nums[n]==target)
                {
                    indice1=i;
                    indice2=n;
                }
            }
        }
        System.out.println("Result of two sum: " + Arrays.toString(new int[]{indice1, indice2}) + ", Solution found: " + !Arrays.equals(new int[]{indice1, indice2},new int[]{0,0}));
    }

    public static void IsLeapYear(int year){
        System.out.println((year%4==0&&year%100!=0)||(year%4==0&&year%400==0));
    }

    public static void GreaterThanMillion(int n){
        while(n*n*n-1000*n*n<100000)n++;
        System.out.println(n);
    }

    public static void Homework2(int A, int B){
        System.out.println((A==B)?(A+B)*(A+B):A+A);
    }

    public static void Homework3(){
        String int1="";
        for (int i = 10; i < 17; i++) int1 += i+", ";
        System.out.print(int1);
        String int2="";
        for (int i = 998; i < 900; i--) int2+=i+", ";
    }

    public static void HomeworkJames(int day, boolean OnVacation){
        System.out.println((day>=0&&day<=5&&!OnVacation)?("James is a true taoist and bestirs oneself before forenoon") :("James is a bone-idly twat could do with some forty-winks till 4 o cock in the afternoon"));
    }

    public static void HomeworkJamesVolumeTwo(boolean Shining, int TimeOfDay) {
        if (TimeOfDay <= 24 && (TimeOfDay >= 0))
            System.out.println((TimeOfDay >= 10 && TimeOfDay <= 16 && Shining) ? ("James must bear on some shitting sunscreen") : ("nah"));
        else
            System.out.println("\"" + TimeOfDay + "\" isnt a fucking hour of the day time you fucking brainlet");
    }
    public static void Homework3(int A, int B){
        System.out.println((String.valueOf(A).charAt(String.valueOf(A).length()-1)==String.valueOf(B).charAt(String.valueOf(B).length()-1)));
    }

    public static void Homework4(){
        //contains the prime factors of both numbers might write program to find factors
        System.out.println(3*3*709*43);
    }
    public static void FindSmallest(int[] findSmallestFrom){
        for (int i = 0; i < findSmallestFrom.length; i++) {
            if(findSmallestFrom[i]>findSmallestFrom[i-(1-((i-1)==-1 ? 1 : 0))]){
                findSmallestFrom[i]=findSmallestFrom[i-1];
            }
        }
        System.out.println(findSmallestFrom[findSmallestFrom.length-1]);
    }

    public void FindIfArith(int[] ArrayToCheck) {
        if(ArrayToCheck.length > 1){
            int v = ArrayToCheck[1] - ArrayToCheck[0];
            for (int i = 1; i < ArrayToCheck.length; i++) {
                if ((ArrayToCheck[i + (i+1==ArrayToCheck.length?0:1)] - ArrayToCheck[i] != v)) {
                    ArrayToCheck[0] = ArrayToCheck[1] + 1;
                    break;
                }
            }
            System.out.println(ArrayToCheck[0] == ArrayToCheck[1] - 1 ? "The array isn't arithmetic" : "The array is arithmetic");
        }else System.out.println("The array is of length 1!");
    }

    public void ArrayHomeWork1(){
        int[] arr=new int[]{2,5,-3,11,193,-2};
        for (int i = arr.length-1; i >= 0; i--) {
            arr[(i-1==-1?0:i-1)]+=arr[i];
        }
        System.out.println(arr[0]);
    }
    public void ArrayHomeWork2(){
        System.out.println("S would return the sum of all of the array elements and variable COUNT " +
                "would be the count of non-zero elements in the array, the program outputs the average " +
                "of the elements of the array (except if COUNT is 0, in which case it outputs 0)");
    }

    public void ArrayHomeWork3(int[] VALUES){
        System.out.println("First the algorithm assigns N a value of 1 and checks if the array is \n" +
                "of size 5 and if the result is true (continues if this is true, outputs false if not). \n" +
                "It then evaluates if N is smaller than N-1. (outputs false if it isn't, grows N by 1 and continues if it is). \n" +
                "With the value of VALUES being {-3, 2,5,4} the algorithm returns false, because this array isn't sorted. (5 > 4)\n"  +
                " The purpose of this algorithm is to check if it sorted");
        //corresponding program
        boolean result=true;
        if(!(VALUES.length < 5)) {
            for (int n = 1; n < 5; n++) {
                if((VALUES[n] > VALUES[n-1])){ result=false; break;}
            }
        }System.out.println(result?"The user-inputted array is sorted":"The user-inputted array isn't sorted");
    }
    public void ArrayHomework4(int[] ArrayToReverse){
        int[] temp=ArrayToReverse;
        for (int i = 0; i<temp.length/2; i++) {
            int ind0=ArrayToReverse[temp.length-1-i];
            int ind1=ArrayToReverse[i];
            temp[temp.length-1-i]=ind1;
            temp[i]=ind0;
        }
        System.out.println("Result of reversing array with elements " + Arrays.toString(ArrayToReverse)+" is: "+Arrays.toString(temp));

    }
    public static int[] SwapArrayElements(int[] arr, int swapInd1, int swapInd2){
        try {
            int temp = arr[swapInd1];
            arr[swapInd1] = arr[swapInd2];
            arr[swapInd2] = temp;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("Index "+swapInd1 +" or "+swapInd2+" is out of bounds for array arr: "+Arrays.toString(arr));
        }
        System.out.println("Result: "+Arrays.toString(arr));
        return arr;
    }
    public static void reverse(int[] arr){
        int temp=arr.length;
        for (int i = 0; i < temp/2; i++) {
            SwapArrayElements(arr, i, temp-i);
        }
        System.out.println("Swapped array: "+Arrays.toString(arr));
    }
    public static void CalculatePI(int iterations) throws InterruptedException {
        int hits=0;
        for (int i = 0; i < iterations; i++) {
            float x=random.nextFloat(0,8);
            float y=random.nextFloat(0,8);
            System.out.print(((float)(i*100)/(float)(iterations))+"%...\r");
            if(x*x+y*y<=64) hits++;
        }float result=4*(((float)hits/(float)iterations));
        System.out.println("Approximation: " + result + " ("+(1-(Math.abs(Math.PI-result)))*100+"% accurate)");
    }
}
