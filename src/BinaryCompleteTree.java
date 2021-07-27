import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BinaryCompleteTree {
    private NodeTree root;
    private NodeTree[] nodeTree;

    public BinaryCompleteTree(String userString) {
        nodeTree = new NodeTree[userString.length() + 1];
        userString = " " + userString;
        for (int i = 0; i < userString.length(); i++) {
            System.out.print(userString.charAt(i));
            nodeTree[i] = new NodeTree();
            nodeTree[i].data = String.valueOf(userString.charAt(i));
        }

        NodeTree parent;
        parent = nodeTree[1];
        addChildren(parent, 1);

//        parent.leftChild = nodeTree[1];
//        parent.rightChild = nodeTree[2];

//        for (int i = 1; i < nodeTree.length - 1; i++) {
//            System.out.print(userString.charAt(i));
//            parent.leftChild = nodeTree[2 * i - 1];
//            parent.rightChild = nodeTree[2 * i];
//
//        }

        root = parent;
    }

    private void addChildren(NodeTree parent, int i) {
        if (nodeTree.length > 2 * i) {
            parent.leftChild = nodeTree[2 * i];
            nodeTree[2 * i].displayNode();
        }
        if (nodeTree.length > 2 * i + 1) {
            parent.rightChild = nodeTree[2 * i + 1];
            nodeTree[2 * i + 1].displayNode();
        }
        if (nodeTree.length > 2 * i) {
            addChildren(parent.leftChild, 2 * i);
            addChildren(parent.rightChild, 2 * i + 1);
        }
    }


    void displayTree() {
        Stack<NodeTree> nodeTreeStack = new Stack<NodeTree>();

        nodeTreeStack.push(root);
        int emptyNode = 32;
        boolean isEmpty = false;
        System.out.println(".......................................................");

        while (!isEmpty) {

            Stack<NodeTree> lclStack = new Stack<NodeTree>();
            isEmpty = true;


            for (int i = 0; i < emptyNode; i++)
                System.out.print(" ");


            while (!nodeTreeStack.isEmpty()) {

                NodeTree tmp = nodeTreeStack.pop();

                if (tmp != null) {

                    System.out.print(tmp.data);
                    lclStack.push(tmp.leftChild);
                    lclStack.push(tmp.rightChild);

                    if (tmp.leftChild != null ||
                            tmp.rightChild != null)
                        isEmpty = false;
                } else {
                    System.out.print("--");
                    lclStack.push(null);
                    lclStack.push(null);
                }

                for (int lj = 0; lj < emptyNode * 2 - 2; lj++)
                    System.out.print(" ");
            }

            System.out.println();
            emptyNode /= 2;

            while (!lclStack.isEmpty())
                nodeTreeStack.push(lclStack.pop());

        }

        System.out.println(".......................................................");

    }


    void traverse(int cursor) {

        switch (cursor) {
            case 1 -> {
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
            }
            case 2 -> {
                System.out.print("\nInorder traversal: ");
                inOrder(root);
            }
            case 3 -> {
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
            }
        }
        System.out.println("");
    }

    private void preOrder(NodeTree lclRoot) {

        if (lclRoot != null) {
            System.out.print(lclRoot.data + " ");
            preOrder(lclRoot.leftChild);
            preOrder(lclRoot.rightChild);
        }

    }

    private void inOrder(NodeTree lclRoot) {

        if (lclRoot != null) {
            inOrder(lclRoot.leftChild);
            System.out.print(lclRoot.data + " ");
            inOrder(lclRoot.rightChild);
        }

    }

    private void postOrder(NodeTree lclRoot) {

        if (lclRoot != null) {
            postOrder(lclRoot.leftChild);
            postOrder(lclRoot.rightChild);
            System.out.print(lclRoot.data + " ");
        }

    }
}

class BinaryCompleteTreeApp {

    public static void main(String[] args) throws IOException {

        int cursor;

        System.out.print("Enter user string:");

        String userString = getString();

        BinaryCompleteTree stringTree = new BinaryCompleteTree(userString);


        while (true) {

            System.out.print("Enter first letter of (s)how, (t)raverse or (e)xit: ");

            int userChar = getChar();

            switch (userChar) {
                case 's' -> stringTree.displayTree();
                case 't' -> {
                    System.out.print("Enter type 1-Preorder, 2-Inorder, or 3-Postorder: ");
                    cursor = getInt();
                    stringTree.traverse(cursor);
                }
                case 'e' -> System.exit(0);
                default -> System.out.print("Invalid entry!\n");
            }

        }

    }

    public static String getString() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(inputStreamReader);
        return buffer.readLine();

    }

    public static char getChar() throws IOException {

        String userChar = getString();
        return userChar.charAt(0);

    }

    public static int getInt() throws IOException {

        String userString = getString();
        return Integer.parseInt(userString);

    }

}

