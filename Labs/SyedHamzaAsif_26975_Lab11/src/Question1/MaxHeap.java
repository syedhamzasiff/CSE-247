package Question1;

public class MaxHeap<T extends Comparable<T>> {
    T[] heap;
    int size;

    public MaxHeap(int s) {
        size = 0;
        heap = (T[]) new Comparable[s];
    }

    //return the value at root.
    public T getMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    //attach at the left most vacant position in the last level and call sift up.
    public void insert(T d) {
        if (size == heap.length) {
            throw new IllegalStateException("heap is full");
        }

        heap[size] = d;
        siftUp(size);
        size++;
    }

    //swap larger node with its parent until the heap property is satisfied.
    public void siftUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index].compareTo(heap[parent]) > 0) {
            T temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;

            index = parent;
            parent = (index - 1) / 2;
        }
    }

    // swap smaller node with its larger child until the heap property is satisfied.
    public void siftDown(int index) {
        int maxChild;

        while (2 * index + 1 < size) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < size && heap[rightChild].compareTo(heap[leftChild]) > 0) {
                maxChild = rightChild;
            } else {
                maxChild = leftChild;
            }
            if (heap[index].compareTo(heap[maxChild]) < 0) {
                T temp = heap[index];
                heap[index] = heap[maxChild];
                heap[maxChild] = temp;
                index = maxChild;
            } else {
                break;
            }
        }
    }

    // replace the root with the last leaf and call sift down.
    public T extractMax() {
        if (size == 0) {
            throw new IllegalStateException("heap is empty");
        }
        T max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return max;
    }

    public int find(T d) {
        for (int i = 0; i < size; i++) {
            if (heap[i].equals(d)) {
                return i;
            }
        }
        return -1;
    }

    //change the value of the element to a very high number (say, positive infinity), then call sift up, and then call extractMax.
    public void remove(T value) {
        int index = find(value);
        if (index == -1) {
            throw new IllegalArgumentException("not found");
        }
        heap[index] = heap[size - 1];
        size--;
        siftUp(index);
        siftDown(index);
    }

    // change the priority and if the priority is increased then call sift up,
    // otherwise, if the priority is decreased then call sift down.
    public void changePriority(T d, T v) {
        int index = find(d);
        if (index == -1) {
            throw new IllegalArgumentException("not found");
        }
        heap[index] = v;
        siftUp(index);
        siftDown(index);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T t : heap) {
            if (t!=null)
                str.append(t).append(" ");
        }
        return str.toString();
    }

}

