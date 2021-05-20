public class Deque {

    private int maxSize;
    private long[] stackArray;
    private int head;
    private int tail;
    private int count;


    public Deque(int s) {
        maxSize = s; // set array size
        stackArray = new long[maxSize]; // create array
        head = -1;
        tail = -1;
        count = 0;
    }

    void pushTop(int l) {
        if (full()) {
            return;
        }
        head = (head + 1 + maxSize) % maxSize;
        stackArray[head] = l;
        count++;
    }

    long popTop() {
        if (empty()) {
            return -1;
        }
        if (head == -1) head = 0;
        count--;
        long ret = stackArray[head];
        head = (head - 1 + maxSize) % maxSize;
        return ret;
    }

    long popBack() {
        if (empty()) {
            return -1;
        }
        if (tail == -1) tail = maxSize -1;
        count--;
        long ret = stackArray[tail];
        tail = (tail + 1 + maxSize) % maxSize;
        return ret;
    }

    void pushBack(int l) {
        if (full()) return;
        count++;
        tail = (tail - 1 + maxSize) % maxSize;
        stackArray[tail] = l;
    }

    boolean empty() {
        return (head == tail);
    }

    boolean full() {
        return (count == maxSize);
    }

    long peekTop() {
        if (empty()) return -1;
        if (head == -1) head = 0;
        return (stackArray[head]);
    }

    long peekBack() {
        if (empty()) return -1;
        if (tail == -1) tail = maxSize -1;
        return (stackArray[tail]);
    }

    void clean() {
        head = -1;
        tail = maxSize;
        count = 0;
    }

}
