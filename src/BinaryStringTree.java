import java.io.*;
import java.util.*;

class NodeTree {
    public String data;
    public NodeTree leftChild;
    public NodeTree rightChild;

    public void displayNode() {
        System.out.print("{" + data + "}");
    }

}

class StringTree {
    private NodeTree root;

    public StringTree(String dataString) {
        root = null;
        NodeTree[] arrayNode = new NodeTree[dataString.length()];
        for (int i = 0; i < dataString.length(); i++) {
            arrayNode[i] = new NodeTree();
            arrayNode[i].data = String.valueOf(dataString.charAt(i));
        }

        NodeTree parent = new NodeTree();

        parent.data = "+";
        parent.leftChild = arrayNode[0];
        parent.rightChild = arrayNode[1];

        for (int j = 2; j < arrayNode.length; j++) {
            NodeTree newNode = new NodeTree();
            newNode.data = "+";
            newNode.leftChild = parent;
            newNode.rightChild = arrayNode[j];
            parent = newNode;

        }
        root = parent;
    }

    public void traverse(int traversType) {

        switch (traversType) {
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

    public void displayTree() {

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

}

class BinaryTreeApp {

    public static void main(String[] args) throws IOException {

        int cursor;

        System.out.print("Enter user string:");

        String userString = getString();

        StringTree stringTree = new StringTree(userString);


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