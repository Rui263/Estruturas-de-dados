package aulas.praticas.Blinkedlists.singlylinkedlist;

public class SinglyLinkedListTest {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.addNode(2);
        list.addNode(5);
        list.addNode(5);
        list.addNode(3);
        list.addNode("Filipa");

        System.out.println("Displaying the List: ");
        list.display();

        System.out.println("\nRemoving Data from the List: ");
        list.remove(5);
        list.remove("Filipa");

        System.out.println("\nDisplaying the List: ");
        list.display();
    }
}
