package aulas.praticas.Cstack.linkedstack;
import aulas.praticas.Cstack.arraystack.StackADT;
import java.util.EmptyStackException;
import aulas.praticas.ANode;

public class LinkedStack<T> implements StackADT<T> {

    private ANode<T> top;
    private int nodesCount;

    /**
     * creates the first node of the stack
     */
    public LinkedStack() {
        top = null;
        this.nodesCount = 0;
    }

    /**
     * Adds the specified data to the top of the stack
     */
    @Override
    public void push(Object element) {
        ANode<T> tempNode = new ANode<>();
        tempNode.setData((T) element);
        if (isEmpty()) {
            top = tempNode;
        } else {
            tempNode.setNext(top);
            top = tempNode;
        }
        this.nodesCount++;
    }

    /**
     * Removes and returns the top element from this stack.
     *
     * @return T element removed from the top of the stack
     */
    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T result = top.getData();
        top = top.getNext();
        this.nodesCount--;
        return result;
    }

    /**
     * returns the last element added to the stack
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return top.getData();
    }

    @Override
    public boolean isEmpty() {
        return (nodesCount == 0);
    }

    /**
     * number of stack elements
     *
     * @return
     */
    @Override
    public int size() {
        return this.nodesCount;
    }

}
