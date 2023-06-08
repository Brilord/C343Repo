iimport org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    @Test
    void connected() {
        // Create nodes
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        // Create adjacency matrix
        boolean[][] adjacencyMatrix = {
                {false, true, true, false, false},
                {false, false, true, false, true},
                {false, false, false, true, false},
                {false, false, false, false, true},
                {false, false, false, false, false}
        };

        // Create graph
        Graph graph = new Graph(Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE), adjacencyMatrix);

        // Test case 1: Find a path from node A to node E
        ArrayList<Node> expectedPath1 = new ArrayList<>(Arrays.asList(nodeA, nodeB, nodeE));
        ArrayList<Node> actualPath1 = graph.connected(nodeA, nodeE);
        assertEquals(expectedPath1, actualPath1, "Failed test case 1");

        // Test case 2: Find a path from node C to node D
        ArrayList<Node> expectedPath2 = new ArrayList<>(Arrays.asList(nodeC, nodeD));
        ArrayList<Node> actualPath2 = graph.connected(nodeC, nodeD);
        assertEquals(expectedPath2, actualPath2, "Failed test case 2");

        // Test case 3: Find a path from node B to itself
        ArrayList<Node> expectedPath3 = new ArrayList<>(Arrays.asList(nodeB));
        ArrayList<Node> actualPath3 = graph.connected(nodeB, nodeB);
        assertEquals(expectedPath3, actualPath3, "Failed test case 3");

        // Test case 4: Find a path from node D to node A (no path exists)
        ArrayList<Node> expectedPath4 = new ArrayList<>(Arrays.asList(nodeD));
        ArrayList<Node> actualPath4 = graph.connected(nodeD, nodeA);
        assertEquals(expectedPath4, actualPath4, "Failed test case 4");
    }
}
