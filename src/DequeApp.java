import java.util.Random;

public class DequeApp {

    public static void main(String[] args) {

        Deque deque = new Deque(5);
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

        for (int i = 0; i < 5; i++) {
            int value = random.nextInt(10);
            System.out.print(value);
            deque.pushTop(value);
        }
        System.out.println("");

        for (int i = 0; i < 5; i++) {
            System.out.print("PopTop" + deque.popTop() + " ");
            System.out.print("PeekTop" + deque.peekTop() + " ");
            System.out.println("PeekBack" + deque.peekBack() + " ");
        }
        System.out.println("");
        deque.clean();

        for (int i = 0; i < 5; i++) {
            int value = random.nextInt(10);
            System.out.print(value);
            deque.pushTop(value);
        }
        System.out.println("");

        for (int i = 0; i < 5; i++) {
            System.out.print("PopBack" + deque.popBack() + " ");
            System.out.print("PeekTop" + deque.peekTop() + " ");
            System.out.println("PeekBack" + deque.peekBack() + " ");
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
            System.out.println("PeekBack" + deque.peekBack());
        }
        System.out.println("");
        deque.clean();

        Deque deque1 = new Deque(5);
        deque1.pushBack(2);
        deque1.pushBack(1);

        System.out.println(deque1.popBack());
        System.out.println(deque1.popBack());
    }

}
