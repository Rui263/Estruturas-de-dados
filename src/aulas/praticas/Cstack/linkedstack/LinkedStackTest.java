package aulas.praticas.Cstack.linkedstack;

public class LinkedStackTest {
    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();

        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());

        //System.out.println(stack.peek());
    }
}
