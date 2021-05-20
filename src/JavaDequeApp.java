import java.util.ArrayDeque;
import java.util.Deque;


public class JavaDequeApp {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(5);



        System.out.println(1234);
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);

//        System.out.print("PopTop" + deque.popBack() + " ");

        for (int i = 0;i < 5; i++) {
            System.out.print("PopTop" + deque.pollFirst() + " ");
            System.out.print("PeekTop" + deque.getFirst() + " ");
            System.out.println("PeekBack" + deque.getLast() + " ");
        }
        System.out.println("");
    }
}
