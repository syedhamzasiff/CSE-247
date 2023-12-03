
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int v;
    private ArrayList<ArrayList<Integer>> adjList;

    public Graph(int vertices) {
        v = vertices;
        adjList = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }
    public void DFS(int s) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        visited[s] = true;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + " ");
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println();
    }
    public void BFS(int s) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
    public void shortestPath(int start, int end) {
        boolean[] visited = new boolean[v];
        int[] previous = new int[v];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int s = queue.poll();

            for (int neighbor : adjList.get(s)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    previous[neighbor] = s;
                }
            }
        }
        printShortestPath(start, end, previous);
    }
    public void printShortestPath(int start, int end, int[] previous) {
        ArrayList<Integer> path = new ArrayList<>();
        int current = end;
        while (current != start && current != 0) {
            path.add(current);
            current = previous[current];
        }
        if (current != start) {
            System.out.println("No path exists between " + start + " and " + end);
            return;
        }
        path.add(start);
        System.out.print("Shortest path from " + start + " to " + end + ": ");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
}
