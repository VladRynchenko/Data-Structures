public class Deq {
    private int maxSize;
    private long[] stackArray;
    private int head;
    private int tail;

    public Deq(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        head = 0;
        tail = maxSize;
    }


}
