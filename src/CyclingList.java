
class CyclingList {
    private Link current; // ref to first link on list
    private Link head;

    public CyclingList() // constructor
    {
        current = null; // no items on list yet }
    }

    public boolean isEmpty() // true if list is empty
    {
        return (current == null);
    }

    public void insertFirst(long dd) { // make new link
        Link newLink = new Link(dd);
        newLink.next = current;
        if (current != null && head == null) {
            head = current;
        }
        if (head != null) {
            head.next = newLink;
        }
        current = newLink;

    }

    public Link deleteFirst() {
        Link temp = current;
        current = current.next;
        return temp;
    }

    public boolean search(long d) {
        Link current = this.current;
        while (current.next != this.current) {
            if (current.dData == d) return true;
            current = current.next; // move to next link }
            System.out.print(" ");
            if (current.next == null) {
                current.next = this.current;
            }
        }
        return false;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = this.current;
        do {
            current.displayLink();
            current = current.next; // move to next link }
            System.out.print(" ");
        }while (current != this.head.next);
    }
}