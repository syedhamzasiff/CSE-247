package Question1;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(10);

        maxHeap.insert(4);
        maxHeap.insert(10);
        maxHeap.insert(8);
        maxHeap.insert(5);
        maxHeap.insert(1);

        System.out.println(maxHeap);

        int max = maxHeap.extractMax();
        System.out.println(max);
        System.out.println(maxHeap);

        maxHeap.remove(8);
        System.out.println(maxHeap);

        maxHeap.changePriority(5, 12);
        System.out.println(maxHeap);
    }
}
