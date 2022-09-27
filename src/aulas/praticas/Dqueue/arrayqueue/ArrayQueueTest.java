package aulas.praticas.Dqueue.arrayqueue;

public class ArrayQueueTest {
    public static void main(String[] args) {


        ArrayQueue queue = new ArrayQueue();

        queue.enqueue(1);
        queue.enqueue('a');
        queue.enqueue(3);
        queue.enqueue(4);

        queue.dequeue();
        System.out.println(queue.size());
        System.out.println(queue);
    }
}
