import java.io.IOException

@Throws(IOException::class)
fun main(args: Array<String>) {

    lateinit var aKey: String
    var aStringItem: HashingString.StringItem?

    print("Enter size of hash table: ")
    val size = HashTableApp.getInt()

    val theHashTable = HashingString(size)

    while (true) {
        print("Enter first letter of ");
        print("show, insert, delete, or find: ");

        when (HashTableApp.getChar()) {
            's' -> theHashTable.displayTable();
            'i' -> {
                print("Enter key value to insert: ");
                aKey = HashTableApp.getString();
                aStringItem = HashingString.StringItem(aKey);
                theHashTable.insert(aStringItem);
            }
            'd' -> {
                print("Enter key value to delete: ");
                aKey = getString();
                theHashTable.delete(aKey);
            }
            'f' -> {
                print("Enter key value to find: ");
                aKey = getString();
                aStringItem = theHashTable.find(aKey);
                if (aStringItem != null) {
                    println("Found $aKey");
                } else
                    println("Could not find $aKey");
            }
            else -> print("Invalid entry\n");
        } // end switch
    }
}


