class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    //--------------------------------------------------------------
    public Queue(int s) // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //--------------------------------------------------------------
    public void insert(long j) {
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }

    // put item at rear of queue // deal with wraparound
// increment rear and insert // one more item
//--------------------------------------------------------------
    public long remove() // take item from front of queue
    {
        long temp = queArray[front++]; // get value and incr front
        if (front == maxSize) // deal with wraparound
            front = 0;
        nItems--; // one less item
        return temp;
    }

    public long peekFront() // peek at front of queue
    {
        return queArray[front];
    }

    public boolean isEmpty() {// true if queue is empty {
        return (nItems == 0);
    }

    public boolean isFull() // true if queue is full
    {
        return (nItems == maxSize);
    }
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is Empty!");
        } else if (rear < front) {
            for (int i = front; i < maxSize; i++) {
                System.out.println(queArray[i]);
            }
            for (int i = 0; i <= rear; i++) {
                System.out.println(queArray[i]);
            }
        } else if (front >= rear) {
            for (int i = front; i <= rear; i++) {
                System.out.println(queArray[i]);
            }
        }
    }
    public int size() // number of items in queue
    {
        return nItems;
    }

}
