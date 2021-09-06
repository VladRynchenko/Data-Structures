
class DataItem {
    private int iData;

    public DataItem(int ii) {
        iData = ii;
    }

    public int getKey() {
        return iData;
    }
}

class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print(" ** ");
        }
        System.out.println();
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        for (int counter = 0; hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1; counter++) {
            hashVal += counter * counter;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) // delete a DataItem
    {
        int hashVal = hashFunc(key); // hash the key
        for (int counter = 0; hashArray[hashVal] != null; counter++) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += counter * counter;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        for (int counter = 0; hashArray[hashVal] != null; counter++) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal]; // yes, return item
            hashVal += counter * counter;
            hashVal %= arraySize;
        }
        return null;
    }
}




