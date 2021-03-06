public class QueueApp {

    public static void main(String[] args) {
        Queue theQueue = new Queue(5);


        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        while (!theQueue.isEmpty()) {
            long n = theQueue.remove(); // (40, 50, 60, 70, 80)
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println(" ");


        Deque deq = new Deque(4);
//        System.out.println("Empty" + deq.empty());

        deq.pushTop(1);
        deq.pushTop(3);
        deq.pushBack(4);
//        deq.pushBack(2);

        System.out.println("Empty" + deq.empty());
        System.out.println("Full" + deq.full());

        for (int i = 0; i < 5; i++) {
            System.out.print(deq.peekTop() + " ");
            System.out.print(deq.peekBack() + " ");

            System.out.print(deq.popBack());
            System.out.println("Empty" + deq.empty());
        }

        Deque deque = new Deque(1);
        deque.pushTop(1);
        System.out.println(deque.peekTop());


//
//        System.out.print(deq.popTop());
//        System.out.print(deq.empty());
//
//        System.out.print(deq.popTop());
//        System.out.print(deq.empty());
//
//        System.out.print(deq.popTop());
//        System.out.print(deq.empty());
//
//        System.out.print(deq.popTop());

//
//        Deque deque = new Deque(2);
//        deque.pushBack(1);
//        deque.pushBack(1);
//        deque.popTop();
//        deque.pushBack(1);
//        System.out.print(deque.peekBack());
    }


}

