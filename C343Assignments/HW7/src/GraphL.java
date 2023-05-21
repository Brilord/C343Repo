import java.util.*;

class CycleDetected extends Exception{};

public class GraphL implements Graph {
    // An Array of nodes where each item points to a list of adjacent nodes
    private List<Node>[] nodeArray;
    // A List of nodes that will be referenced in the nodeArray
    private List<Node> nodes;
    // Number of edges in the graph
    private int numEdge;

    public GraphL(int n){
        this.nodeArray = new ArrayList[n];
        this.nodes = new ArrayList<>();
        init(n);
    }

    // TODO:
    public GraphL(List<Node>[] nodeArray, List<Node> nodes){

    }

    // Implement the missing functions here:
    // TODO:
    public void init(int n) {

    }

    // Hint: may need a reset function for the Runner class (not in the Interface)
    public void reset(){

    }

    // TODO:
    public int nodeCount() {
        return 0;
    }

    // TODO:
    public int edgeCount() {
        return 0;
    }

    // TODO:
    public void addEdge(int v, int w) {

    }

    // TODO:
    public void removeEdge(int v, int w) {

    }

    // TODO:
    public boolean hasEdge(int v, int w) {
        return false;
    }

    // TODO:
    public List<Node> neighbors(int v) {
        return null;
    }

    // TODO: Implement topological sort with stack.
    /*
    Potential way to implement:
    1. For each node in the nodes, you can perform DFS
     */
    // Hint: think of how you can use the value of the Node (not the name)
    public List<Node> topologicalSortStack() throws CycleDetected {
        return null;
    }

    // TODO: Implement topological sort with queue.
    /*
    Potential way to implement:
    1. Go through the edges and set the value of the node to the number of incoming edges and unvisited.
    2. Push nodes that have 0 incoming edges into the queue.
    3. Implement BFS
        -Everytime you process a node, decrease it's value.
     */
    public List<Node> topologicalSortQueue() throws CycleDetected {
        return null;
    }


}