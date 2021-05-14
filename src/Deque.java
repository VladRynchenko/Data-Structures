public class Deque {

    private int maxSize;
    private long[] stackArray;
    private int head;
    private int tail;


    public Deque(int s) {
        maxSize = s; // set array size
        stackArray = new long[maxSize]; // create array
        head = 0;
        tail = maxSize - 1;
    }

    void pushTop(int l) {
        head = (head + maxSize) % maxSize;
        stackArray[head++] = l;
    }

    long popTop() {
        head = (head - 1 + maxSize) % maxSize;
        return stackArray[head];
    }

    long popBack() {
        tail = (tail + 1 + maxSize) % maxSize;
        return stackArray[tail];
    }

    void pushBack(int l) {
        tail = (tail + maxSize) % maxSize;
        stackArray[tail--] = l;
    }

    boolean empty() {
        return (tail + 1 == head);
    }

    boolean full() {
        return (head == tail - 1);
    }

}
