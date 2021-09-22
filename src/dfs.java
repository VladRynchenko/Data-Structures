class StackX {
    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX() // constructor
    {
        st = new int[SIZE]; // make array top = -1;
    }

    public void push(int j) // put item on stack
    {
        st[++top] = j;
    }

    public int pop() {
        return st[top--];
    }

    public int peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}


class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // current number of vertices private StackX theStack;
    private StackX theStack;

    public Graph() // constructor
    {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++)
            for (int k = 0; k < MAX_VERTS; k++) adjMat[j][k] = 0;
        theStack = new StackX();
// set adjacency // matrix to 0
    } // end constructor

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
//        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void mst() // minimum spanning tree (depth first)
    {
        vertexList[0].wasVisited = true;
        theStack.push(0);
        while (!theStack.isEmpty()) {
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) theStack.pop();
            else {
                vertexList[v].wasVisited = true;
                theStack.push(v);
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
            }

        }
        for (int j = 0; j < nVerts; j++)
            vertexList[j].wasVisited = false;

    }

    public void dfs(int start) // depth-first search
    {
        vertexList[start].wasVisited = true;
        displayVertex(start);
        theStack.push(start);
        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) theStack.pop();
            else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for (int j = 0; j < nVerts; j++)
            vertexList[j].wasVisited = false;
    }

    public void showConnectivityTable() {
        for (int i = 0; vertexList[i] != null; i++) {
            dfs(i);
            System.out.println();
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++)
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited) return j;
        return -1;
    }
}

class DFSApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(1, 0);
        theGraph.addEdge(1, 4);
        theGraph.addEdge(0, 2);
        theGraph.addEdge(4, 2);
        theGraph.addEdge(3, 4);

        theGraph.showConnectivityTable();
    } // end main()
} // end class DFSApp
