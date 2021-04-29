public class ArrayIns {

    private long[] a; // ref to array a private
    int nElems;

    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() // displays array contents
    {
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println("");

    }

    public void insertionSort() {

        for (int out = 1; out < nElems; out++) {
            long temp = a[out];
            int in = out;
            while (in > 0 && temp <= a[in - 1]) {
                if (temp == a[in - 1]) temp = -1;
                a[in] = a[in - 1];
                in--;
            }
            a[in] = temp;
        }
        display();
        while (a[0] < 0) {
            delete(a[0]);
        }
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (value == a[j]) break;
        if (j == nElems) return false;
        else {
            for (int k = j; k < nElems; k++) a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void median() {
        System.out.println("Median: " + a[nElems / 2]);
    }
}
