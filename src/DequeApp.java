import java.util.Random;

public class DequeApp {

    public static void main(String[] args) {

        CustomDeque deque = new CustomDeque(5);
        Random random = new Random();


        Deque deq = new Deque(1);
        deq.pushTop(1);
        System.out.println(deq.peekTop());
        System.out.println(deq.peekBack());

        Deque deq1 = new Deque(3);
        deq1.pushTop(1);
        deq1.pushTop(2);
        deq1.pushTop(3);

        System.out.print(deq1.popTop());
        System.out.print(deq1.peekBack());
        System.out.println(deq1.peekTop());


        System.out.println(123);
        deque.pushTop(1);
        deque.pushTop(2);
        deque.pushTop(3);

        for (int i = 0; i < 5; i++) {
            System.out.print("PopTop" + deque.popTop() + " ");
            System.out.print("PeekTop" + deque.getTop() + " ");
            System.out.println("PeekBack" + deque.getBack() + " ");
        }
        System.out.println("");
        deque.clean();

        deque.pushBack(6);
        deque.pushBack(7);
        deque.pushBack(8);
        deque.pushBack(9);

        System.out.print(6789);
        System.out.println("");


        for (int i = 0; i < 5; i++) {
            System.out.print("PopBack" + deque.popBack() + " ");
            System.out.print("PeekTop" + deque.getTop() + " ");
            System.out.println("PeekBack" + deque.getBack() + " ");
        }
        System.out.println("");
        deque.clean();

        for (int i = 0; i < 3; i++) {
            int value = random.nextInt(10);
            int value2 = random.nextInt(10);
            System.out.print(value);
            System.out.println(value2);
            deque.pushTop(value);
            deque.pushBack(value2);
        }
        System.out.println("");

        for (int i = 0; i < 3; i++) {
            System.out.print("PopBack" + deque.popBack() + " ");
            System.out.print("PopTop" + deque.popTop() + " ");
            System.out.println("PeekBack" + deque.getBack());
        }
        System.out.println("");
        deque.clean();

        CustomDeque customDeq = new CustomDeque(1);
        customDeq.pushBack(1);

        System.out.print(customDeq.getTop());
        System.out.print(customDeq.getBack());
        System.out.println(customDeq.popTop());
    }

}
