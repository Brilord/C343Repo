import java.util.*;

import org.w3c.dom.NodeList;

public class Graph {

    private List<Node> nodes; // List of all nodes in a graph
    private boolean[][] adjacencyMatrix; // directional adjacency matrix that has adjacencyMatrix[v][w] = true if v is connected to w

    public Graph(List<Node> nodes, boolean[][] adjacencyMatrix){
        this.nodes = nodes;
        this.adjacencyMatrix = adjacencyMatrix;
    }


    /** CONNECTED
     *
     * This method is a very simple graph traversal problem.
     *
     * Using the traversal algorithm of your choosing, (BFS/DFS recommended)
     * Traverse the graph starting from a node v until you find a node w.
     * Once found, return the path from v to w.
     *
     * This path does not need to be the shortest nor the most efficient,
     * simply a path. You will have difference outputs depending on which
     * traversal you use.
     *
     * Use the helper method getPath() to retrieve the path once you have
     * found w.
     *
     * @param v starting node
     * @param w ending node
     * @return Arraylist path from v to w
     */
    public ArrayList<Node> connected(Node v, Node w) {
        // perform a branch-search to find path from v to w
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parentMap = new HashMap<>();

        queue.offer(v);
        visited.add(v);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == w) {
                // Path found, retrieve and return it
                return getPath(current, parentMap);
            }

            for (Node neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }
        // no path found, return the arrayList containing only the starter node.
        ArrayList<Node> emptyPath = new ArrayList<>();
        emptyPath.add(v);
        return emptyPath;
    }


    /** GETPATH
     *
     * Each node has a path variable that stores a node. This node is
     * the previous node in the path. If the path variable is equal to
     * null that means that it is the origin node in the path.
     *
     * Recursively add those nodes to an arraylist and then return
     * that arraylist once you encounter a null path variable to retrieve
     * the entire path.
     *
     * If no path exists, simply return an arraylist only containing
     * the given node.
     *
     * @param node ending node in the path
     * @param parentMap
     * @return ordered arraylist that is a path from the
     *          origin node to the specified node.
     */
    ArrayList<Node> getPath(Node node, Map<Node, Node> parentMap)
    {
        //TODO
        ArrayList<Node> path = new ArrayList<>();
        Node current = node;
        
        while(current != null) {
            path.add(0, current);
            current = parentMap.get(current);       
        }

        return path;
    }

    private List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();

        int nodeIndex = nodes.indexOf(node);
        if (nodeIndex >= 0) {
            for (int i = 0; i < nodes.size(); i++) {
                if (adjacencyMatrix[nodeIndex][i]) {
                    neighbors.add(nodes.get(i));
                }
            }
        }

        return neighbors;
    }
}
