import java.util.NoSuchElementException;

public class Queue<T> {
    NodeQ<T> front;
    NodeQ<T> rear;

    public void enqueue(T obj) {
        NodeQ<T> new_node = new NodeQ<>(obj);
        if (isEmpty()) {
            front = rear = new_node;
        } else {
            rear.next = new_node;
            rear = new_node;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T temp = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // If the queue is now empty, update rear as well
        }
        return temp;
    }

    public boolean isEmpty() {
        if (front == null && rear == null) {
            return true;
        } else {
            return false;
        }
    }

    public T peek() {
        return front.data;
    }

    public String toString() {
        String str = "{";
        NodeQ<T> temp = front;
        while (temp != null) {
            if (temp.next == null) {
                str += temp.data + "}";
            } else {
                str += temp.data + ", ";
            }
            temp = temp.next;
        }
        return str;
    }
}