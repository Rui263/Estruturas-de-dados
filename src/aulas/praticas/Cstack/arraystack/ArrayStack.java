package aulas.praticas.Cstack.arraystack;

import java.util.EmptyStackException;

public class ArrayStack<T> implements StackADT<T> {

    private final int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    public ArrayStack() {
        this.top = 0;
        stack = (T[]) (new Object[DEFAULT_CAPACITY]);
    }


    @Override
    public void push(Object element) {
        if (size() == stack.length) expandCapacity();
        stack[top] = (T) element;
        top++;
    }

    @Override
    public T pop() throws EmptyStackException {

        if (isEmpty()) {
            System.out.println("Empty Collection");
            throw new EmptyStackException();
        }
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            System.out.println("Empty Collection");
            throw new EmptyStackException();
        } else
            return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {

        int i = 0;
        for (i = 0; i < stack.length; i++) {
            if (stack[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void expandCapacity() {
        System.out.println("Stack Full- incrementing stack size...");
        int i = 0;
        T[] newStack = (T[]) (new Object[stack.length + DEFAULT_CAPACITY]);
        while (i < stack.length) {
            newStack[i] = stack[i];
            i++;
        }
        stack = newStack;
    }
}
