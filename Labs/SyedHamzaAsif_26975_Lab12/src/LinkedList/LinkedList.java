package LinkedList;

import Graph.Vertex;

public class LinkedList<Vertex> {
    Node head;

    public void insert(Vertex v) {
        Node newNode = new Node((Graph.Vertex) v);
        newNode.next = head;
        head = newNode;
    }

    public void delete(Vertex v) {
        Node temp = head;
        Node prev = null;

        if (temp != null && temp.v == v) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.v != v) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        prev.next = temp.next;
    }

    public boolean find(Vertex v) {
        Node current = head;
        while (current != null) {
            if (current.v == v) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.v.name).append(" -> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }
}