class Link {
    public long dData;
    public long priority;
    public Link next;
    public Link previous;

    public Link(long dd) {
        dData = dd;
    }

    public Link(int priority, long gg) {
        dData = gg;
        this.priority = priority;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
