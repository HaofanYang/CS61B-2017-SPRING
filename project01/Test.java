import java.util.*;
public class Test{
    public static void main(String[] args){
        LinkedListDeque<Integer> l = new LinkedListDeque<Integer>(3);

        l.addFirst(5);
        l.addLast(6);
        l.printDeque();
        //l.removeFirst()
        //System.out.println(l.get(1));
    }
}