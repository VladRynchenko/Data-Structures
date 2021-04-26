import java.lang.reflect.Array;

class OrdArray {
    private long[] a;
    private int nElems;

    static OrdArray merge(OrdArray b, OrdArray c) {
        int size = b.size() + c.size();
        OrdArray array = new OrdArray(200);

        int cI = 0, bI = 0;

        for (int i = 0; i < b.size(); i++) {
            for (int j = cI; j < c.size(); j++) {
                if (c.get(j) < b.get(i)) {
                    array.add(c.get(j));
                    cI = j + 1;
                } else {
                    array.add(b.get(i));
                    break;
                }
            }
        }


        return array;
    }

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public long get(int index) {
        return a[index];
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound)
                return nElems;

            else {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public void add(long value) {
        a[nElems] = value;
        nElems++;
    }


    public void insert(long value) {
        int j = 0;

        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

//        while (true) {
//            curIn = lowerBound + (upperBound - lowerBound) / 2;
//            if (lowerBound > upperBound) {
//                j = lowerBound;
//                break;
//            }
//            else if(lowerBound < upperBound){
//                j = lowerBound;
//                break;
//            }
//
//                else {
//                if (a[curIn] > value) {
//                    lowerBound = curIn + 1;
//                } else {
//                    upperBound = curIn - 1;
//            }

        j = binaryInsert(value);
        int k;

        for (k = nElems; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = value;
        nElems++;
    }

    private int binaryInsert(long insertKey) {
        if (nElems == 0) {
            return 0;
        }

        int lowerBound = 0;
        int upperBound = nElems - 1;

        while (true) {
            int curIn = lowerBound + (upperBound - lowerBound) / 2;
            if (lowerBound == curIn) {
                if (a[curIn] > insertKey) {
                    return curIn;
                }
            }
            if (a[curIn] < insertKey) {
                lowerBound = curIn + 1;
                if (lowerBound > upperBound) {
                    return curIn += 1;
                }
            } else if (lowerBound > upperBound) {
                return curIn;
            } else {
                upperBound = curIn - 1;
            }
        }
    }

    public boolean delete(long value) {
        int j = binaryInsert(value);
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }


}
