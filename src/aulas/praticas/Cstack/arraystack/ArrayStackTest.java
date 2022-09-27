package aulas.praticas.Cstack.arraystack;

public class ArrayStackTest {
    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack();

        arrayStack.push(2);
        arrayStack.push("Hello");
        arrayStack.push(true);

        System.out.println(arrayStack.size());

        System.out.println(arrayStack.peek());

        System.out.println(arrayStack.pop());


        for(int i=0; i<100;i++){
            arrayStack.push(2);
        }

        System.out.println(arrayStack.size());

    }
}
