package Graph;

class MyGraphMatrix {
    int[][] adjacencyMatrix;
    Vertex[] vertices;
    int vertexCount;

    MyGraphMatrix(int size) {
        adjacencyMatrix = new int[size][size];
        vertices = new Vertex[size];
        vertexCount = 0;
    }

    public void addVertex(String name, int age) {
        Vertex newVertex = new Vertex(name, age);
        vertices[vertexCount++] = newVertex;
    }

    public void addEdge(String name1, String name2) {
        int index1 = findVertexIndex(name1);
        int index2 = findVertexIndex(name2);

        if (index1 != -1 && index2 != -1) {
            adjacencyMatrix[index1][index2] = 1;
            adjacencyMatrix[index2][index1] = 1; // Assuming friendship is mutual
        }
    }

    public void deleteVertex(String name) {
        int index = findVertexIndex(name);
        if (index != -1) {
            for (int i = 0; i < vertexCount; i++) {
                adjacencyMatrix[i][index] = 0;
                adjacencyMatrix[index][i] = 0;
            }
            vertices[index] = null;
            vertexCount--;
        }
    }

    public void deleteEdge(String name1, String name2) {
        int index1 = findVertexIndex(name1);
        int index2 = findVertexIndex(name2);

        if (index1 != -1 && index2 != -1) {
            adjacencyMatrix[index1][index2] = 0;
            adjacencyMatrix[index2][index1] = 0; // Assuming friendship is mutual
        }
    }

    public int findVertexIndex(String name) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i] != null && vertices[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i] != null) {
                result.append("Vertex: ").append(vertices[i].name).append(", Age: ").append(vertices[i].age).append(", Friends: ");
                for (int j = 0; j < vertexCount; j++) {
                    if (adjacencyMatrix[i][j] == 1) {
                        result.append(vertices[j].name).append(" ");
                    }
                }
                result.append("\n");
            }
        }
        return result.toString();
    }
}
