package Normal;
//in this we create a doubly linked list 
// a node which have previous node data , current node data and next node data

//        1000                        2000                       3000
// ---------------------      --------------------      --------------------
// |null | DATA | 2000 | ---> |1000 | DATA | 3000| ---> |2000 | DATA | NULL|
// ---------------------      --------------------      --------------------

class Node {

    Node previous;
    int data;
    Node next;

    Node(int data) {
        this.previous = null;
        this.data = data;
        this.next = null;
    }

}

class DoublyLinkedList {

    Node head;

    void headIsNull(Node newNode) {

        System.out.println(
                "No head found adding the current data(" + newNode.data + ")as a head\nPlease accept the new head");
        head = newNode;

    }

    Node getLastNode() {
        Node currentNode = head;
        Node prevNode = null;
        while (currentNode != null) {
            prevNode = currentNode;
            currentNode = currentNode.next;

        }
        return prevNode;
    }

    Node getNodeByPosition(int pos) {
        Node currentNode = head;
        for (int i = 1; i <= pos - 1; i++) {
            currentNode = currentNode.next;

        }
        return currentNode;
    }

    void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;

        }

        System.out.print("Null\n");
    }

    void insertAtLast(int data) {
        Node newNode = new Node(data);

        Node currentNode = head;

        if (head == null) {
            headIsNull(newNode);
        }

        else {

            currentNode = getLastNode();

            currentNode.next = newNode;
            newNode.previous = currentNode;

        }

    }

    void insertAtFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            headIsNull(newNode);
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;

            // this is our new head
        }

    }

    void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        Node currentNode = head;

        if (head == null) {
            headIsNull(newNode);
        }

        else {

            currentNode = getNodeByPosition(pos - 1);
            newNode.next = currentNode.next;
            newNode.previous = currentNode;
            currentNode.next.previous = newNode;
            currentNode.next = newNode;

        }

    }

    void deleteFirst() {
        Node currentNode = head;

        currentNode.next.previous = null;
        head = currentNode.next;
        currentNode.next = null;
    }

    void deleteLast() {

        Node lastNode = getLastNode();
        lastNode.previous.next = null;
        lastNode.next = null;

    }

    void deleteByPosition(int pos) {
        Node currrentNode = getNodeByPosition(pos);

        currrentNode.previous.next = currrentNode.next;
        currrentNode.next.previous = currrentNode.previous;
        currrentNode.next = currrentNode.previous = null;

    }

    void reverseList() {
        Node currentNode = head;
        Node temp = null;
        // head = getLastNode();
        while (currentNode != null) {
            temp = currentNode.previous;
            currentNode.previous = currentNode.next;
            currentNode.next = temp;

            currentNode = currentNode.previous;

        }

        head = temp.previous;

    }
}

public class D7_DoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList d1 = new DoublyLinkedList();

        d1.insertAtLast(20);
        d1.insertAtLast(30);
        d1.insertAtFirst(10);
        d1.printList();
        d1.insertAtPosition(25, 3);
        d1.printList();
        // d1.deleteFirst();
        // d1.printList();
        // d1.deleteLast();
        // d1.printList();

        // d1.deleteByPosition(3);
        d1.reverseList();
        d1.printList();

        

    }
}
