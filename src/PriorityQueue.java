public class PriorityQueue extends SortedList {

    public PriorityQueue(Link[] linkArray) {
        first = null; // initialize list
        for (int j = 0; j < linkArray.length; j++) // copy array
            priorityInsert(linkArray[j]); // to list }
    }

    public PriorityQueue() {
        super();
    }

    public void insert(Link k, long priority) {
        k.priority = priority;
        super.priorityInsert(k);
    }

    public Link pull() {
        return super.remove();
    }
}
