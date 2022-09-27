package aulas.praticas.Blinkedlists.singlylinkedlist;


public class SinglyLinkedList<T> {
    protected class Node<T> {

        private int size;
        T data;   //object data
        Node next;//Next its a pointer to the next Node

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head = null; //head - first Node of the list
    private Node<T> tail = null;//tail - last Node of the list

    //will add a new node to the list
    public void addNode(T data) {

        Node<T> newNode = new Node<T>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            //the newNode will be added after the tail, next will point to the next newNode
            tail.next = newNode;
            //the tail now represents the newNode
            tail = newNode;
        }
    }

    public void remove(T data) {
        Node<T> currentNode;
        currentNode = head;

        //if currentNode.data equals data, head will point to the next Node of the list
        if (currentNode.data == data) {
            head = currentNode.next;
        } else {
            //if the currentNode.next exists, if the data from that node is the same as
            //the data we want to remove, current node will point to the node after the
            //currentNode.next
            while (currentNode.next != null) {
                if (currentNode.next.data == data) {
                    System.out.println("Data Removed: " + currentNode.next.data);
                    currentNode.next = currentNode.next.next;
                } else {
                    currentNode = currentNode.next;
                }
            }
        }
    }

    public void display() {

        Node<T> currentNode;
        //current will point to the head
        currentNode = head;

        //if head equals null, the list is empty
        if (head == null) {
            System.out.println("No nodes in this list yet");
            return;
        }

        //if currentNode isnt null, sout current data and than currentNode point to the next Node
        while (currentNode != null) {
            System.out.println("Node Data: " + currentNode.data);
            currentNode = currentNode.next;
        }
    }
}















