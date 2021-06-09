public class CyclingListApp {
    public static void main(String[] args) {
        CyclingList cycleList = new CyclingList();
        for (int i = 0; i < 6; i++) {
            cycleList.insertFirst(i);
        }
        cycleList.displayList();
        System.out.print(cycleList.search(3));
        System.out.print(cycleList.search(15));
    }
}
