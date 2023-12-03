package QueueCirArr;

import QueueLL.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(10);

        System.out.println(queue);

        queue.dequeue();

        System.out.println(queue);
    }
}
