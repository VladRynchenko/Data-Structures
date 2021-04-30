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
        int countDups = 0;
        for (int out = 1; out < nElems; out++) {

            long temp = a[out];
            int in = out;
            while (in > 0 && temp <= a[in - 1]) {
                if (temp == a[in - 1]) {
                    temp = -1;
                }
                a[in] = a[in - 1];
                in--;
            }
            a[in] = temp;
            if(a[in] == -1){
                countDups++;
            }
        }
        delete(countDups);

    }

    public boolean delete(int value) {
        for (int k = 0; k < nElems; k++) a[k] = a[k + value];
        nElems -= value;
        return true;
    }

    public void median() {
        System.out.println("Median: " + a[nElems / 2]);
    }
}
