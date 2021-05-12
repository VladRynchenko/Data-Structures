import java.sql.Array;

public class Deque {

    private int maxSize;
    private long[] stackArray;
    private int head;
    private int tail;

    public Deque(int s) {
        maxSize = s; // set array size
        stackArray = new long[maxSize]; // create array
        head = 0;
        tail = 0;
    }

    public void pushTop(long j) {
        if (head == (tail + 1) % maxSize){
            return;
        }
        head= (head - 1 + maxSize) % maxSize;
        stackArray[head] = j; // increment top, insert item }
    }

    public long popTop() {
        if (isEmpty()) {
            return -1;
        }
        long ret = stackArray[head];
        head = (head + 1) % maxSize;
        return ret;
    }

    public long peekTop() {
        return stackArray[head];
    }

    public boolean isEmpty() {
        return (head == tail);
    }

    public void pushBack(long j) {
        if (head == (tail + 1) % maxSize){
            return;
        }
        stackArray[tail++] = j;
    }

    public long popBack() {
        if (isEmpty()){
            return -1;
        }
        tail = (tail - 1 + maxSize) % maxSize;
        return stackArray[--tail];
    }

    public long peekBack() {
        return stackArray[tail];
    }

    public boolean isFull() {
        return (head == maxSize - 1);
    }
}
