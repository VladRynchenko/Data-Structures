public class HighArray {

    private long[] a; // ref to array a
    private int nElems; // number of data items //-----------------------------------------------------------

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] == searchKey)
                break;
        if (j == nElems)
            return false;
        else
            return true;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
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

    public void display() {

        {
            for (int j = 0; j < nElems; j++) // for each element,
                System.out.print(a[j] + " "); // display it System.out.println(“”);
        }
        System.out.println("");
    }

    public void noDups() {
        int counterDups = 0;
        for (int i = 0; i < nElems; i++) {
            for (int j = i; j < nElems; j++) {
                if (a[i] == 0) {
                    break;
                }
                if (a[i] == a[j + 1]) {
                    counterDups++;
                    a[j+1] = -1;
                }
            }
        }
        for (int i = 0; i < counterDups; i++) {
            delete(-1);
        }
    }

}



