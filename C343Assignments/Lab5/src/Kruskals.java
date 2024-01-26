import java.util.*;

public class Kruskals {

    /** MST
     *
     * implement Kruskal's MST algorithm from class.
     *
     * As a refresher,
     *
     * Get a list of edges and their weights (use the
     * Edge class for this).
     * Sort the edges. (You may use Collections.sort()).
     * Then, add the edges in order of smallest to
     * largest into the MST.
     * If a cycle is created, then don't add the edge.
     * Once each node has an edge, you're done!
     *
     * For a quick, more visual explanation see:
     *  https://www.youtube.com/watch?v=71UQH7Pr9kU
     *
     * One important note about the mst array.
     * It does not contain information on the weights,
     * only the nodes of the edges.
     *         i        = u
     *       mst[i]     = v
     * graph[i][mst[i]] = weight(u, v)
     *
     * @param graph graph of edges and weights.
     * @return a Minimum Spanning Tree of the graph.
     */
    public static int[] mst(Graph graph) {
        //TODO
        int numVertices = graph.getNumVertices();
        int[] mst = new int[numVertices];
        List<Edge> edges = graph.getEdges();

        Collections.sort(edges); // Sort edges by weight

        for (int i = 0; i < numVertices; i++) {
            mst[i] = i; // Initialize each node's parent to itself
        }

        for (Edge edge : edges) {
            int u = edge.getU();
            int v = edge.getV();

            int parentU = findParent(mst, u);
            int parentV = findParent(mst, v);

            if (parentU != parentV) {
                mst[parentU] = parentV; // Make u's parent the same as v's parent
            }
        }

        return mst;

    }
    private static int findParent(int[] mst, int node) {
        if (mst[node] != node) {
            mst[node] = findParent(mst, mst[node]); // Path compression
        }
        return mst[node];
    }

    /** CYCLEEXISTS
     *
     * Use any cycle detection algorithm of your choosing.
     *
     * BFS/DFS recommended
     *
     * Simply traverse the graph and if you encounter a node
     * twice, then there is a cycle. Return true.
     *
     * Otherwise, there is no cycle. Return false.
     *
     * @param mst The MST in progress.
     * @return True, if a cycle is detected, otherwise false.
     */
    public static boolean cycleExists(int[] mst) {
        //TODO
        int numVertices = mst.length;
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (cycleExistsUtil(mst, i, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean cycleExistsUtil(int[] mst, int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int i = 0; i < mst.length; i++) {
            if (mst[node] == i) {
                if (!visited[i]) {
                    if (cycleExistsUtil(mst, i, visited, node)) {
                        return true;
                    }
                } else if (i != parent) {
                    return true;
                }
            }
        }

        return false;
    }
}

