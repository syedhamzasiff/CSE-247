package Graph;

import LinkedList.*;

public class Vertex implements Comparable<Vertex> {
    public String name;
    int age;
    LinkedList<Vertex> friendsList;

    public Vertex(String d, int a) {
        name = d;
        age = a;
        friendsList = new LinkedList<Vertex>();
    }

    @Override
    public int compareTo(Vertex o) {
        return 0;
    }
}