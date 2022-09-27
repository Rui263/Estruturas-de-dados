package aulas.praticas.Dqueue.arrayqueue;


import aulas.praticas.Dqueue.QueueADT;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements QueueADT<T> {

    private final int DEFAULT_SIZE = 100;
    private T[] queue;
    private int front, rear;

    public ArrayQueue() {
        this.rear = this.front = 0;
        this.queue = (T[]) new Object[DEFAULT_SIZE];
    }

    //adding an element at the queue rear (rear is the index of the
    // first element at the queue)
    @Override
    public void enqueue(T element) {

        if (size() == rear) expandCapacity();
        queue[rear] = element;
        rear++;
        //System.out.println("Element: " + element + " added to the queue");
    }

    @Override
    public T dequeue() throws NoSuchElementException {

        if (isEmpty()) throw new NoSuchElementException();

        for (int i = 0; i < size() - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[rear] = null;
        rear--;
        return queue[front];
    }

    @Override
    public T first() {
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return rear;
    }

    public void expandCapacity() {

        T[] biggerArray = (T[]) new Object[queue.length + DEFAULT_SIZE];

        for (int i = 0; i < queue.length; i++) {
            biggerArray[i] = queue[i];
        }
        queue = biggerArray;
    }

    @Override
    public String toString() {

        String s = "Queue=[";
        for (int i = 0; i < rear; i++) {
            s += queue[i];
            if (queue[i] != queue[rear]) s += ", ";
        }
        s += ("]" + "   element at rear: " + queue[rear] + "      element at front: " + queue[front]);
        return s;
    }
}
