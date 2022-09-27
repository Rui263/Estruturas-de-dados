package aulas.praticas.Dqueue.linkedqueue;

import aulas.praticas.ANode;
import aulas.praticas.Dqueue.QueueADT;

public class LinkedQueue<T> implements QueueADT<T> {
    private ANode<T> front, rear;
    private int count;

    public LinkedQueue() {
        front = rear = null;
        count = 0;
    }

    public void enqueue(T n) {

        ANode<T> newNode = new ANode(n);

        if (n != null) {
            if (front == null) {
                front = rear = newNode;
            } else {
                rear.setNext(newNode);
                rear = newNode;
            }
            count++;
        }
        System.out.println("front "+front.getData());
    }

    public T dequeue() {
        ANode<T> node = front;
        if (front != null) {
            front = front.getNext();
            count--;
        }
        assert node != null;
        return node.getData();
    }

    public T first() {

        return front.getData();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }


    public int getCount() {
        return count;
    }
}

