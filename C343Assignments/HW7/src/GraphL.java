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
        this.nodeArray = nodeArray;
        this.nodes = nodes;
        init(nodeArray.length);
    }

    // Implement the missing functions here:
    // TODO:
    public void init(int n) {
        this.nodeArray = new ArrayList[n];
        this.nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeArray[i] = new ArrayList<>();
        }
    }

    // Hint: may need a reset function for the Runner class (not in the Interface)
    public void reset(){
        for (List<Node> nodeList : nodeArray) {
            nodeList.clear();
        }
        nodes.clear();
        numEdge = 0;
    }

    // TODO:
    public int nodeCount() {
        return nodes.size();
    }

    // TODO:
    public int edgeCount() {
        return numEdge;

    }

    // TODO:
    public void addEdge(int v, int w) {
        Node nodeV = nodes.get(v);
        Node nodeW = nodes.get(w);
        nodeArray[v].add(nodeW);
        numEdge++;
    }

    // TODO:
    public void removeEdge(int v, int w) {
        Node nodeW = nodes.get(w);
        nodeArray[v].remove(nodeW);
        numEdge--;
    }

    // TODO:
    public boolean hasEdge(int v, int w) {
        return nodeArray[v].contains(nodes.get(w));
    }

    // TODO:
    public List<Node> neighbors(int v) {
        return nodeArray[v];
    }

    // TODO: Implement topological sort with stack.
    /*
    Potential way to implement:
    1. For each node in the nodes, you can perform DFS
     */
    // Hint: think of how you can use the value of the Node (not the name)
    public List<Node> topologicalSortStack() throws CycleDetected {
        Stack<Node> stack = new Stack<>(); // this keeps track of the order in which nodes are visited during the
        // dfs travel, tropo
        List<Node> result = new ArrayList<Node>(); // this is the list that will eventually contain the nodes in
        // topological order. The nodes will be popped from the stack and added to the list once their exploration is
        // complete
        Set<Node> visited = new HashSet<Node>(); // this is the set that keeps track of nodes that have been visited
        // during DFS traversal. This helps prevent visiting the same node multiple time and ensures we won't get infinite
        // loop while traversing cycles in the graph.

        // perform dfs for each unvisited nodes
        for(Node node : nodes) {
            if(!visited.contains(node)) {

            }

        }
        // pop the nodes to get the topological order


        return result;
    }

    private void topologicalSortDFS(Node node, Stack<Node> stack, Set<Node> visited) throws CycleDetected {
        visited.add(node);

        for (Node neighbor : neighbors(getNodeIndex(node))) {
            if (!visited.contains(neighbor)) {
                topologicalSortDFS(neighbor, stack, visited);
            } else if (stack.contains(neighbor)) {
                throw new CycleDetected(); // Cycle detected
            }
        }

        stack.push(node);
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

    private int getNodeIndex(Node node) {
        return nodes.indexOf(node);
    }
}