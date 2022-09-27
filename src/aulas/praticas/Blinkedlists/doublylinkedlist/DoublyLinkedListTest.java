package aulas.praticas.Blinkedlists.doublylinkedlist;

public class DoublyLinkedListTest {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.addNode(3);
        list.addNode(2);
        list.addNode(7);
        list.addNode("Hello");
        list.addNode(4);
        list.addNode(7);

        list.displayList();
        System.out.println("");

//        list.displayPreviousAndNextNodeData(2);
//
//        list.removeFirstNode();
//        list.removeFirstNode();
//
//        list.removeLastNode();
//        list.removeLastNode();

//        System.out.println(list.isEmpty());

//        list.listToArray();
//        list.displayArrayList(list.listToArray());
        System.out.println("*******************");
        list.showPairNumbersInList();
    }
}
