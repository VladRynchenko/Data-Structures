public class PriorityQueue extends SortedList {
    SortedListExtended sortedList;

    public PriorityQueue(Link[] linkArray) {
        sortedList = new SortedListExtended(linkArray);
    }

    public PriorityQueue() {
        sortedList = new SortedListExtended();
    }

    public void insert(Link k, long priority) {
        k.priority = priority;
        sortedList.insert(k);
    }

    public Link pull() {
        return sortedList.remove();
    }
}
