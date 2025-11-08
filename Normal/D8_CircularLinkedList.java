package Normal;
// in this we create a circular linked list
// ib=n this a last node points to the head node which is not null

//     1000                 2000                3000
// --------------      --------------      --------------
// |DATA | 2000 | ---> | DATA | 3000| ---> | DATA | 1000|    pointing to head
// --------------      --------------      --------------

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = this;
    }
}

class CircularLinkedList {
    Node head;
    Node tail;
    int length = 0;

    void createHead(Node newNode) {
        newNode.next = newNode;
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
        Node prevNode;
        if (head == null) {
            createHead(newNode);
        } else {

            do {
                prevNode = currentNode;
                currentNode = currentNode.next;
            } while (currentNode != head);

            // now when loop ends it give current node which is = to head we need 1 before
            // so we make prevNode

            prevNode.next = newNode;
            newNode.next = head;
            tail = newNode;
            incrementLength();

        }
    }

    void insertAtFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            createHead(newNode);
        } else {
            tail.next = newNode;
            newNode.next = head;
            head = newNode;
            incrementLength();
        }

    }

    void insertAtPosition(int data, int position) {

        Node newNode = new Node(data);
        Node currentNode = null;

        if (head == null) {
            createHead(newNode);
        }
        // suppose user add at 1st positon so we have to update the head instead we use
        // direct insert At first (DRY)
        else if (position == 1) {
            insertAtFirst(data);
        }

        else if (position == length) {
            insertAtEnd(data);
        } else {
            // jiss position p insert krna usse ek phle ka chaiye isliye -1
            currentNode = getNodeByPos(position - 1);

            newNode.next = currentNode.next;
            currentNode.next = newNode;

            // suppose user add at last positon so we have to update the tail
            if (newNode.next == head) {
                tail = newNode;
            }
            incrementLength();

        }

    }

    void deleteLastNode() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            Node currentNode = getNodeByPos(length - 1);

            currentNode.next = currentNode.next.next;
            tail = currentNode;
            decrementLength();
        }
    }

    void deleteFirstNode() {

        Node currentNode = head;

        if (head == null) {
            System.out.println("Empty list");
        } else {
            head = currentNode.next;
            currentNode = null;
            tail.next = head;
            decrementLength();
        }
    }

    void deleteNodeByPos(int position) {

        if (head == null) {
            System.out.println("Empty list");
        } else if (position == length) {
            deleteLastNode();

        } else if (position == 1) {
            deleteFirstNode();
        } else {
            // jo delete krna usse ek phle ka
            Node currentNode = getNodeByPos(position - 1);

            currentNode.next = currentNode.next.next;

            decrementLength();
        }
    }

    void reverseList() {
        Node currentNode = head;

        Node prevNode = null;
        if (head == null) {
            System.out.println("Empty list");
        } else {

            int tempLength = length;

            while (tempLength > 0) {

                currentNode.next.next = currentNode;

                prevNode = currentNode;
                currentNode = currentNode.next;
                tempLength--;
            }

        }

    }

}

public class D8_CircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList l1 = new CircularLinkedList();

        l1.insertAtEnd(10);
        l1.insertAtEnd(20);
        l1.insertAtEnd(30);
        l1.printList();
        l1.insertAtFirst(8);
        l1.insertAtFirst(5);

        l1.insertAtPosition(40, 6);
        // l1.deleteLastNode();
        l1.printList();
        // l1.printDetails();

        // l1.deleteFirstNode();

        // l1.printDetails();
        // l1.reverseList();
        l1.printList();
        l1.printDetails();

    }
}
