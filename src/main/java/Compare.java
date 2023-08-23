import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Compare extends Main{
    public static Random random = new Random();
    public static void compare(int a, int b){
        System.out.println(a + "" + b);
        boolean isIt = true, really = false;
        Boolean positive = a > 0;
        double coeff=1.24;
        System.out.println(positive + ":" + (float)coeff*random.nextInt(a,b));
        Node node1 = null;
        Node node2 = null;
        LinkedList list = new LinkedList();
        list.add(node1);
        list.add(node2);

    }
}
