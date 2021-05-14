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
        if (full()) {
            return;
        }
        head = (head + maxSize) % maxSize;
        stackArray[head++] = l;
    }

    long popTop() {
        if (empty()) {
            return -1;
        }
        head = (head + maxSize) % maxSize;
        return stackArray[head--];
    }

    void pushBack(int l) {
        if (full()) {
            return;
        }
        tail = (tail - 1 + maxSize) % maxSize;
        stackArray[tail] = l;
    }

    long popBack() {
        if (empty()) {
            return -1;
        }
        tail = (tail + maxSize) % maxSize;
        return stackArray[tail++];
    }

    boolean empty() {
        return (head == 0 || tail == maxSize);
    }

    boolean full() {
        return (head == tail);
    }

    long peekTop() {
        return stackArray[head];
    }

    long peekBack() {
        return stackArray[tail];
    }

}
