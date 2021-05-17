public class Deque {

    private int maxSize;
    private long[] stackArray;
    private int head;
    private int tail;
    private int count;


    public Deque(int s) {
        maxSize = s; // set array size
        stackArray = new long[maxSize]; // create array
        head = 0;
        tail = maxSize - 1;
        count = 0;
    }

    void pushTop(int l) {
        if (full()) {
            return;
        }
        head = (head + maxSize) % maxSize;
        stackArray[head++] = l;
        count++;
    }

    long popTop() {
        if (empty()) {
            return -1;
        }
        count--;
        head = (head - 1 + maxSize) % maxSize;
        return stackArray[head];
    }

    long popBack() {
        if (empty()) {
            return -1;
        }
        count--;
        tail = (tail + 1 + maxSize) % maxSize;
        return stackArray[tail];
    }

    void pushBack(int l) {
        if (full()) return;
        count++;
        tail = (tail + maxSize) % maxSize;
        stackArray[tail--] = l;
    }

    boolean empty() {
        return (count == 0);
    }

    boolean full() {
        return (count == maxSize);
    }

    long peekTop() {
        if (empty()) return -1;
        int picker = (head + maxSize)%maxSize;
        return (stackArray[picker]);
    }

    long peekBack() {
        if (empty()) return -1;
        int picker = (tail + maxSize)%maxSize;
        return stackArray[picker];
    }

}
