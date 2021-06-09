
class CyclingList {
    private Link first; // ref to first link on list

    public CyclingList() // constructor
    {
        first = null; // no items on list yet }
    }

    public boolean isEmpty() // true if list is empty
    {
        return (first == null);
    }

    public void insertFirst(long dd) { // make new link
        Link newLink = new Link(dd);
        newLink.next = first; // newLink --> old first
        first = newLink; // first --> newLink
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public boolean search(long d){
        Link current = first;
        while (current.next != first) {
            if (current.dData == d) return true;
            current = current.next; // move to next link }
            System.out.print(" ");
            if (current.next == null) {
                current.next = first;
            }
        }
        return false;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current.next != first) {
            current.displayLink();
            current = current.next; // move to next link }
            System.out.print(" ");
            if (current.next == null) {
                current.next = first;
            }
        }
    }
}