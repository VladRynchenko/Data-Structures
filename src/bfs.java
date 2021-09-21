class QueueX {
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public QueueX() {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int j) // put item at rear of queue
    {
        if (rear == SIZE - 1)
            rear = -1;
        queArray[++rear] = j;
    }

    public int remove() // take item from front of queue
    {
        int temp = queArray[front++];
        if (front == SIZE)
            front = 0;
        return temp;
    }

    public boolean isEmpty() {
        return (rear + 1 == front || (front + SIZE - 1 == rear));
    }
}

class Vertex {
    public char label; // label (e.g. 'A')
    public boolean wasVisited;

    public Vertex(char lab) // constructor
    {
        label = lab;
        wasVisited = false;
    }
}

class GraphBFS {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private QueueX theQueue;

    public GraphBFS() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];


        nVerts = 0;
        for (
                int j = 0;
                j < MAX_VERTS; j++)
            for (
                    int k = 0;
                    k < MAX_VERTS; k++)
                adjMat[j][k] = 0;
        theQueue = new QueueX();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void mst() // minimum spanning tree (depth first)
    {
        vertexList[0].wasVisited = true;
        theQueue.insert(0);
        while (!theQueue.isEmpty()) {
            int currentVertex = theQueue.remove();
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) {
                int temp = theQueue.remove();
                theQueue.insert(temp);
            } else {
                vertexList[v].wasVisited = true; // mark it
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
                theQueue.insert(v);
            }
        }

        for (int j = 0; j < nVerts; j++) vertexList[j].wasVisited = false;
    }


    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;
        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        for (int j = 0; j < nVerts; j++)
            vertexList[j].wasVisited = false;
    }


    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++)
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited) return j;
        return -1;
    }

}

class BFSApp {
    public static void main(String[] args) {
        GraphBFS theGraph = new GraphBFS();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');
        theGraph.addVertex('H');
        theGraph.addVertex('I');
        theGraph.addVertex('J');
        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(5, 7);
        theGraph.addEdge(5, 2);
        theGraph.addEdge(6, 8);
        theGraph.addEdge(1, 9);
        theGraph.addEdge(3, 5);
        theGraph.addEdge(1, 6);
        theGraph.addEdge(2, 7);
        theGraph.addEdge(6, 4);
        theGraph.addEdge(2, 8);

        System.out.print("Visits: ");
        theGraph.bfs(); // breadth-first search
        System.out.println();
        theGraph.mst();


    } // end main()
} // end class BFSApp