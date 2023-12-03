package QueueCirArr;
public class Queue<T> {
    T[] Q;
    int front;
    int rear;

    public Queue() {
        Q = (T[]) new Object[10];
        front = rear = -1;
    }

    public Queue(int size) {
        Q = (T[]) new Object[size];
        front = rear = -1;
    }

    public void enqueue(T obj) {
        if (isFull()) {
            new Exception("Queue Overflow");
        }
        if (isEmpty()) {
            rear = front = 0;
        } else {
            rear = (rear + 1) % Q.length;
        }
        Q[rear] = obj;
    }

    public T dequeue() {
        if (isEmpty()) {
            new Exception("Queue Underflow");
        }
        T temp = Q[front];
        front = (rear + 1) % Q.length;
        return temp;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return ((rear + 1) % Q.length == front);
    }

    public T peek() {
        return Q[front];
    }

    public String toString() {
        String str = "{";
        for (int i = front; i <= rear; i++) {
            str += Q[i];
        }
        return str;
    }

}