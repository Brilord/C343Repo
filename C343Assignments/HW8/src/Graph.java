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

    }

    // TODO: not tested for credit technically but this method should reset your node's value
    public void reset(){

    }

    // TODO:
    public void addEdge(Node src, Node dest, int weight){

    }

    // TODO: remove the edge from the Node
    public void removeEdge(Node src, Node dest){

    }

    // TODO: Return the shortest path from start to dest with the correct cost of the nodes; return null if no path possible
    public List<Node> shortestPath(int start, int dest){
        return null;
    }
}

