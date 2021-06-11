public class CyclingListApp {
    public static void main(String[] args) throws Throwable {
        CyclingList cycleList = new CyclingList();
        System.out.println(cycleList.isEmpty());

        for (int i = 0; i < 6; i++) {
            cycleList.insertFirst(i);
        }
        cycleList.displayList();
        for (int i = 0; i < 6; i++){
            System.out.print(cycleList.deleteFirst());
            System.out.println(cycleList.isEmpty());
        }
        cycleList.displayList();
        System.out.print(cycleList.search(3));
        System.out.print(cycleList.search(15));
    }
}
