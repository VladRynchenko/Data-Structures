
class CyclingList {
    private Link current; // ref to first link on list
    private Link head;

    public CyclingList() // constructor
    {
        current = null; // no items on list yet }
    }

    public boolean isEmpty() // true if list is empty
    {
        return (head == null);
    }

    public void insertFirst(long dd) { // make new link
        Link newLink = new Link(dd);
        newLink.next = current;
        if (isEmpty()) {
            head = current;
        }
        if (head != null) {
            head.next = newLink;
        }
        current = newLink;
    }

    public long deleteFirst() {
        if (isEmpty()) return -1;
        Link temp = current;
        if (head.next == head) {
            temp = head;
            head = null;
            current = null;
            return temp.dData;
        }
        current = current.next;
        head.next = current;
        return temp.dData;
    }

    public boolean search(long d) {
        if (isEmpty()) return false;
        Link current = this.current;
        while (current.next != this.current) {
            if (current.dData == d) return true;
            current = current.next; // move to next link }
            System.out.print(" ");
        }
        return false;
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.print("List empty");
            return;
        }
        System.out.print("List (first-->last): ");
        Link current = this.current;
        do {
            current.displayLink();
            current = current.next; // move to next link }
            System.out.print(" ");
        } while (current != this.head.next);
    }
}