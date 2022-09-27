package aulas.praticas.Dqueue.linkedqueue;

public class LinkedQueueTest {
    public static void main(String[] args) {

        LinkedQueue queue = new LinkedQueue();

        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        System.out.println(queue.getCount());

        queue.dequeue();
        System.out.println(queue.getCount());
        queue.dequeue();
        System.out.println(queue.first());
        queue.dequeue();
        System.out.println(queue.first());
    }
}
