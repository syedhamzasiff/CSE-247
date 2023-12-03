package Graph;

import LinkedList.LinkedList;

public class GraphTest {
    public static void main(String[] args) {
        System.out.println("Testing MyGraph (Adjacency List):");
        testMyGraph();

        System.out.println("\nTesting MyGraphMatrix (Adjacency Matrix):");
        testMyGraphMatrix();
    }

    public static void testMyGraph() {
        MyGraph graph = new MyGraph(10);

        // Adding vertices
        graph.addVertex("Alice", 25);
        graph.addVertex("Bob", 30);
        graph.addVertex("Charlie", 28);

        // Creating friendships (edges)
        graph.addEdge("Alice", "Bob");
        graph.addEdge("Alice", "Charlie");

        // Printing the graph
        System.out.println("Graph:");
        System.out.println(graph);

        // Finding friends list for a vertex
        LinkedList<Vertex> aliceFriends = graph.findVertexFriendsList("Alice");
        if (aliceFriends != null) {
            System.out.println("Friends of Alice: " + aliceFriends);
        }

        // Deleting a vertex and its relationships
        graph.deleteVertex("Bob");
        System.out.println("Graph after deleting Bob:");
        System.out.println(graph);
    }

    public static void testMyGraphMatrix() {
        MyGraphMatrix matrixGraph = new MyGraphMatrix(10);

        // Adding vertices
        matrixGraph.addVertex("Alice", 25);
        matrixGraph.addVertex("Bob", 30);
        matrixGraph.addVertex("Charlie", 28);

        // Creating friendships (edges)
        matrixGraph.addEdge("Alice", "Bob");
        matrixGraph.addEdge("Alice", "Charlie");

        // Printing the graph
        System.out.println("Matrix Graph:");
        System.out.println(matrixGraph);

        // Deleting a vertex and its relationships
        matrixGraph.deleteVertex("Bob");
        System.out.println("Matrix Graph after deleting Bob:");
        System.out.println(matrixGraph);
    }
}
