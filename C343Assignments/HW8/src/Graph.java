import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
    private List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    // TODO: Initialize the nodes
    public void init(int n){
        nodes.clear();
        for(int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }
    }

    // TODO: not tested for credit technically but this method should reset your node's value
    public void reset(){
        for(Node node : nodes) {
            node.setValue(Integer.MAX_VALUE);
        }
    }



    // TODO:
    public void addEdge(Node src, Node dest, int weight){
         src.addEdge(new Edge(dest, weight))
    }

    // TODO: remove the edge from the Node
    public void removeEdge(Node src, Node dest){
        src.removeEdge(dest);
    }

    // TODO: Return the shortest path from start to dest with the correct cost of the nodes; return null if no path possible
    public List<Node> shortestPath(int start, int dest){
        return null;
    }
}

