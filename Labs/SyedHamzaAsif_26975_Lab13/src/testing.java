public class testing {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        System.out.print("dfs: ");
        graph.DFS(0);
        System.out.print("bfs: ");
        graph.BFS(5);

        graph.shortestPath(2, 4);
    }
}
