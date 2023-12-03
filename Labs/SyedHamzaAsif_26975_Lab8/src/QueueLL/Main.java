package QueueLL;

public class Main {
    public static void main(String[] args) throws Exception {

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();

        System.out.println(queue);
    }
}
