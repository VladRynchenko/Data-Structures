import java.util.Random;

public class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);
        arr.insert(77);
        arr.insert(99);


        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);


        arr.display();

        int searchKey = 44;
        if (arr.find(searchKey) != arr.size()) {
            System.out.println("Found " + searchKey);
        } else
            System.out.println("Can`t find " + searchKey);
        arr.display();

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);
        arr.display();


        Random random = new Random();
        int bLength =   5 + random.nextInt(30);
        int cLength = 5 + random.nextInt(30);


        OrdArray b = new OrdArray(bLength);
        OrdArray c = new OrdArray(cLength);


        for (int i = 0; i < bLength; i++) {
            b.insert(random.nextInt(100));
        }
        for (int i = 0; i < cLength; i++) {
            c.insert(random.nextInt(100));
        }
        System.out.print("B: ");
        b.display();
        System.out.print("C: ");
        c.display();

        OrdArray array = OrdArray.merge(b, c);
        array.display();

    }

}
