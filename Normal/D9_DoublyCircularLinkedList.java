package Normal;
//        1000                        2000                       3000
// ---------------------      --------------------      --------------------
// |3000 | DATA | 2000 | ---> |1000 | DATA | 3000| ---> |2000 | DATA | 1000|
// ---------------------      --------------------      --------------------

class Node {
    Node previous;
    int data;
    Node next;

    Node(int data) {
        this.previous = this;
        this.data = data;
        this.next = this;
    }
}

class DoublyCircularLinkedList {
    Node head;
    Node tail;
    int length;

    void createHead(Node newNode) {
        newNode.next = newNode;
        newNode.previous = newNode;
        head = newNode;
        tail = newNode;
        incrementLength();
    }

    void printDetails() {
        System.out.println("Head : " + head.data);
        System.out.println("Tail : " + tail.data);
        System.out.println("Length : " + length);
    }

    void incrementLength() {
        length++;
    }

    void decrementLength() {
        length--;
    }

    void printList() {
        Node currentNode = head;

        if (head == null) {
            System.out.println("List is empty");
        } else {

            do {
                System.out.print(currentNode.data + "->");
                currentNode = currentNode.next;
            } while (currentNode != head);

            System.out.println("head");

        }
    }

    Node getNodeByPos(int pos) {
        int count = 1;
        Node currentNode = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {

            do {
                if (count == pos) {
                    return currentNode;
                }

                currentNode = currentNode.next;
                count++;
            } while (currentNode != head);

        }
        System.out.println("Position not found");
        return null;
    }

    void insertAtEnd(int data) {

        Node newNode = new Node(data);
        Node currentNode = head;

        if (head == null) {
            createHead(newNode);
        } else {

            do {

                currentNode = currentNode.next;

            } while (currentNode != tail);

            newNode.next = currentNode.next;
            newNode.previous = currentNode;

            currentNode.next.previous = newNode;
            currentNode.next = newNode;

            tail = newNode;
            incrementLength();

        }

    }

    void insertAtFirst(int data) {

        Node newNode = new Node(data);
        Node currentNode = head;
        if (head == null) {
            createHead(newNode);
        } else {

            newNode.next = currentNode;
            currentNode.previous = newNode;

            newNode.previous = tail;
            tail.next = newNode;

            head = newNode;

            incrementLength();

        }

    }

    void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (head == null) {
            createHead(newNode);
        }
        // if user add at 1st pos
        else if (position == 1) {
            insertAtFirst(data);
        }
        // if user add at last pos
        else if (position == length) {
            insertAtEnd(data);

        } else {

            Node currentNode = getNodeByPos(position);

            newNode.previous = currentNode.previous;
            newNode.next = currentNode;

            currentNode.previous.next = newNode;
            currentNode.previous = newNode;

            incrementLength();

        }

    }

    void deleteFirst() {

        Node firstNode = head;

        if (head == null) {
            System.out.println("lIst is empty");
        }

        else {
            tail.next = firstNode.next;
            firstNode.next.previous = tail;
            head = firstNode.next;
            firstNode = null;

            decrementLength();
        }
    }

    void deleteLast() {
        if (head == null) {
            System.out.println("list is empty");
        }

        else {
            // this gives as last node
            Node lastNode = getNodeByPos(length);

            lastNode.previous.next = lastNode.next;

            // update the head-> previous
            lastNode.next.previous = lastNode.previous;

            tail = lastNode.previous;
            lastNode = null;

            decrementLength();

        }
    }

    void deleteAtPos(int pos) {
        if (head == null) {
            System.out.println("lIst is empty");
        }

        else if (pos == 1) {
            deleteFirst();

        } else if (pos == length) {
            deleteLast();
        }

        else {

            Node currentNode = getNodeByPos(pos);

            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;

            currentNode = null;

            decrementLength();

        }
    }

    void reverseList() {
        if (head == null) {
            System.out.println("lIst is empty");
        } else {

            Node currentNode = head;
            Node prevNode;
            Node temp;

            do {

                temp = currentNode.previous;
                currentNode.previous = currentNode.next;
                
                currentNode.next = temp;

                // we store the current node in prev bcoz when we are on last node then our
                // current again assign to current.prev
                // and we lost the last node ref.. thats why we use prev or (lastnode)
                prevNode = currentNode;
                currentNode = currentNode.previous; // we assign with prev bcoz at above we swap the address prev and
                                                    // so the next node ref will be in previous block not next
            } while (currentNode != head);

            // we can change the head and tail in two ways

            // head = prevNode;
            // tail = prevNode.previous;

            // or

            temp = head;
            head = tail;
            tail = temp;

        }

    }

}

public class D9_DoublyCircularLinkedList {
    public static void main(String[] args) {
        DoublyCircularLinkedList l1 = new DoublyCircularLinkedList();

        l1.insertAtEnd(10);
        l1.insertAtEnd(20);
        l1.insertAtEnd(30);
        // l1.insertAtEnd(40);

        // l1.insertAtFirst(5);
        // l1.insertAtFirst(4);
        // l1.insertAtFirst(2);

        // l1.insertAtPos(15, 5);

        // l1.deleteLast();

        // l1.printList();
        // l1.deleteFirst();

        // l1.deleteAtPos(8);

        l1.printList();
        l1.reverseList();

        l1.printList();
        // l1.printDetails();

    }
}
