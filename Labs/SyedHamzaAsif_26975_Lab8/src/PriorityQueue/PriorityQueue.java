package PriorityQueue;


class PriorityQueue<T extends Comparable<T>> {
    T[] Q;
    int front;
    int rear;
    int maxSize;

    // Default constructor
    PriorityQueue() {
        this(10); // Default size is 10
    }

    // Constructor with a specified size
    PriorityQueue(int size) {
        maxSize = size;
        Q = (T[]) new Comparable[size];
        front = rear = -1;
    }

    public void enqueue(T obj) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
            Q[rear] = obj;
        } else {
            int i;
            for (i = rear; i >= front; i--) {
                if (obj.compareTo(Q[i]) > 0) {
                    Q[i + 1] = Q[i];
                } else {
                    break;
                }
            }
            Q[i + 1] = obj;
            rear++;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        T removed = Q[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
        return removed;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return rear == maxSize-1;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }
        return Q[front];
    }
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        String str = "{";
        for (int i = front; i <= rear; i++) {
            str += Q[i];
            if (i < rear) {
                str += ", ";
            }
        }
        str += "}";
        return str;
    }


}