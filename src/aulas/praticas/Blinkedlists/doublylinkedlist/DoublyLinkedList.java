package aulas.praticas.Blinkedlists.doublylinkedlist;

import java.util.Scanner;

public class DoublyLinkedList<Data> {

    public class Node<Data> {

        public Node previous = null;
        public Node next = null;
        public Data data;

        public Node(Data data) {
            this.data = data;
        }

    }

    private Node<Data> head = null;
    private Node<Data> tail = null;

    public void addNode(Data data) {

        Node<Data> newNode = new Node<Data>(data);

        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        } else {
            newNode.previous = tail;
            this.tail.next = newNode;
            this.tail = newNode;
            tail.next = null;
        }


    }

    public void displayList() {

        Node currentNode = this.head;

        while (currentNode != null) {
            System.out.println(currentNode.data.toString());
            currentNode = currentNode.next;
        }
    }

    public void displayPreviousAndNextNodeData(int index) {

        Node currentNode = this.head;
        int count = 1;

        if (this.head == null) {
            System.out.println("This List its Empty...");
            return;
        } else if (index == 0) {
            System.out.println("Index Starts at 1...");
            return;
        }
        for (int i = 1; i < index; i++) {
            if (currentNode.next != null) {
                currentNode = currentNode.next;
                count++;
            }
        }

        if (count < index) {
            System.out.println("Invalid Index.");
            return;
        }
        if (currentNode.next == null) {
            System.out.println("Node at Index " + index + " Data: " +
                    currentNode.data +
                    "\nPrevious Node Data: " + currentNode.previous.data +
                    "\nNext Node Data: " + "No Data available yet...");
        } else {
            System.out.println("Node at Index " + index + " Data: " +
                    currentNode.data +
                    "\nPrevious Node Data: " + currentNode.previous.data +
                    "\nNext Node Data: " + currentNode.next.data);
        }
    }

    public void removeFirstNode() {

        if (this.head == null) {
            System.out.println("List already empty.");
            return;
        }
        if (this.head.next != null) {
            this.head = this.head.next;
            this.head.previous = null;
            System.out.println("New List: ");
            displayList();
        } else {
            this.head = null;
            this.tail = null;
            System.out.println("List now empty...");
        }
    }

    public void removeLastNode() {

        if (this.tail == null) {
            System.out.println("List already empty.");
            return;
        }
        if (this.tail.previous != null) {
            this.tail = this.tail.previous;
            this.tail.next = null;
            displayList();
        } else {
            this.tail = null;
            this.head = null;
            System.out.println("List now empty...");
        }
    }

    public boolean IsEmpty() {
        if (head == null) {
            return true;
        } else
            return false;
    }

    /**
     * Creates a new DoublyLinkedList with only PairNumbers
     * Display All Pair Numbers of the List
     * Checks if the data its type Integer
     */
    public void showPairNumbersInList() {

        DoublyLinkedList<Integer> newPairList = new DoublyLinkedList<>();
        Node currentNode = head;

        if (currentNode == null) {
            System.out.println("Empty List.");
            return;
        }
        while (currentNode.next != null) {
            if (currentNode.data instanceof Integer) {
                if ((int) currentNode.data % 2 == 0) {
                    newPairList.addNode((int) currentNode.data);
                }
            }
            currentNode = currentNode.next;
        }
        newPairList.displayList();
    }


    public Object[] listToArray() {

        Object array[] = new Object[100];
        int count = 0, i = 0;

        Node currentNode = head;

        while (currentNode != null) {
            array[count] = currentNode.data;
            currentNode = currentNode.next;
            count++;
        }
        return array;
    }

    public void displayArrayList(Object[] array) {

        Scanner scanner = new Scanner(System.in);
        int option, arrayIndex, filled = 0;

        while (array[filled] != null) {
            filled++;
        }

        System.out.println("Press 0- Entire Array\nPress 1- Until Desired Index");
        option = scanner.nextInt();

        switch (option) {
            case 0:
                System.out.println("Listing the list as an Array: ");
                for (int i = 0; i < listToArray().length; i++) {
                    if (array[i] == null) {
                        return;
                    }
                    System.out.println(array[i]);
                }
                break;
            case 1:
                System.out.println("Until index: ");
                arrayIndex = scanner.nextInt();

                if (arrayIndex > 0 && arrayIndex < filled + 1) {
                    System.out.println("Listing desired array index: ");
                    for (int i = 0; i < arrayIndex; i++) {
                        if (array[i] == null) {
                            return;
                        }
                        System.out.println(array[i]);
                    }
                } else {
                    System.out.println("Invalid Index.");
                }
        }
    }
}





















