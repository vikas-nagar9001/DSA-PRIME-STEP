package Normal;
// now hum multiple list bana sakte hain
// constructor ka use karenge 
// and class k andr hi head ko define karenge
// taki har list or object ka apna head ho 

//and kisi bhi method me head pass or return ki jarurat nahi padegi
// hum direct class k head ko use kar lenge

class Node {

    int data;
    Node next;

    // ab hum object banate time data pass kar sakte hain
    // aur next ko null kar denge
    Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Node newNode = new Node();
    // newNode.data = data;
    // newNode.next = null; ------> Node newNode = new Node(data);
}

class LinkedList {
    Node head;

    void printList() {
        Node currentNode = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    void addAtLast(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;

        } else {

            Node currentNode = head;

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }

    }

    void insertAtFirst(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;

            head = newNode;
        }
    }

    void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);

        Node currentNode = head;

        if (head == null) {
            head = newNode;
        }

        else {

            for (int i = 1; i <= pos - 2; i++) {
                currentNode = currentNode.next;

            }

            newNode.next = currentNode.next;
            currentNode.next = newNode;

        }

    }

    void deleteFirst() {
        if (head == null) {
            System.out.println("Head is null");
        } else {

            head = head.next;
        }

    }

    void deleteLast() {
        if (head == null) {
            System.out.println("Head is null");
        } else {

            Node currentNode = head;
            Node nextNode = head.next;

            while (nextNode.next != null) {

                currentNode = currentNode.next;
                nextNode = nextNode.next;
            }

            currentNode.next = null;
        }
    }

    void deleteByPosition(int pos) {
        if (head == null) {
            System.out.println("Head is null");
        } else {

            boolean isFound = false;
            int count = 1, data = 0;

            for (int i = 1; i < pos; i++) {

                if (head.next == null) {
                    break;
                }

                if (count == pos - 1) {

                    data = head.next.data;

                    head.next = head.next.next;

                    isFound = true;

                    break;
                }
                head = head.next;
                count++;
            }

            System.out.println(isFound == true ? "data deleted : " + data : "positon not exits");
        }
    }

}

public class D5_LinkedList {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // now hume head pass karne ki jarurat nahi hai

        list.addAtLast(10);
        list.addAtLast(20);
        list.insertAtFirst(5);

        list.printList();
        list.deleteLast();
        list.printList();

        LinkedList list2 = new LinkedList();

        // now we can create multiple lists

        list2.addAtLast(30);
        list2.addAtLast(40);
        list2.insertAtFirst(25);

        list2.printList();
        list2.deleteLast();
        list2.printList();

    }
}
