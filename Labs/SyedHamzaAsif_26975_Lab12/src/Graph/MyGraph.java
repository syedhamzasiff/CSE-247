package Graph;

import LinkedList.*;

class MyGraph {
    Vertex[] adjList;
    int count;

    MyGraph(int size) {
        adjList = new Vertex[size];
        count = 0;
    }

    public void addVertex(String name, int age) {
        Vertex newVertex = new Vertex(name, age);
        adjList[count] = newVertex;
        count++;
    }

    public void addEdge(String name1, String name2) {
        Vertex v1 = findVertex(name1);
        Vertex v2 = findVertex(name2);

        if (v1 != null && v2 != null) {
            v1.friendsList.insert(v2);
            v2.friendsList.insert(v1); // Assuming friendship is mutual
        }
    }

    public void deleteVertex(String name) {
        Vertex v = findVertex(name);
        if (v != null) {
            for (Vertex vertex : adjList) {
                if (vertex != null) {
                    vertex.friendsList.delete(v);
                }
            }
            v.friendsList = null;
        }
    }

    public void deleteEdge(String name1, String name2) {
        Vertex v1 = findVertex(name1);
        Vertex v2 = findVertex(name2);

        if (v1 != null && v2 != null) {
            v1.friendsList.delete(v2);
            v2.friendsList.delete(v1); // Assuming friendship is mutual
        }
    }

    public Vertex findVertex(String name) {
        for (Vertex v : adjList) {
            if (v != null && v.name.equals(name)) {
                return v;
            }
        }
        return null;
    }

    public LinkedList findVertexFriendsList(String name) {
        Vertex v = findVertex(name);
        if (v != null) {
            return v.friendsList;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Vertex v : adjList) {
            if (v != null) {
                result.append("Vertex: ").append(v.name).append(", Age: ").append(v.age).append(", Friends: ");
                result.append(v.friendsList).append("\n");
            }
        }
        return result.toString();
    }
}
