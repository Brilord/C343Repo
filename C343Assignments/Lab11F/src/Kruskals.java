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
    }
}

