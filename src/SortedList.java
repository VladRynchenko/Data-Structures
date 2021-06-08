public class SortedList {
    private Link first;

    public SortedList() {
        first = null;
    }

    public SortedList(Link[] linkArr) {
        first = null; // initialize list
        for (int j = 0; j < linkArr.length; j++) // copy array
            insert(linkArr[j]); // to list }
    }

    public void insert(Link k) {
        Link previous = null;
        Link current = first;
        while (current != null && k.priority > current.priority) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = k;
        } else previous.next = k;
        k.next = current;
    }

    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }
}
