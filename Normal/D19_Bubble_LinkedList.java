class LinkedList {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    Node head;

    void insertAtEnd(int data) {

        Node newNode = new Node(data);
        Node currentNode;

        if (head == null) {
            head = newNode;
            return;
        }

        currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;

    }

    void print() {
        Node currentNode;
        currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println("Null");

    }

    void sort() {

        Node currentNode;
        Node secondNode;
        currentNode = head;

        while (currentNode.next != null) {

            secondNode = head;

            while (secondNode.next != null) {

                if (secondNode.data > secondNode.next.data) {

                    System.out.println("Swapping data : " + secondNode.data + "," + secondNode.next.data);

                    int temp = secondNode.next.data;
                    secondNode.next.data = secondNode.data;
                    secondNode.data = temp;
                    System.out.println("After Swapping data : " + secondNode.data + "," + secondNode.next.data);

                }

                secondNode = secondNode.next;
            }

            // reset second node to head again so next time it runs again with starting
            secondNode = head;
            currentNode = currentNode.next;
        }

        System.out.println("Null");

    }

}

public class D19_Bubble_LinkedList {

    public static void main(String[] args) {

        System.out.println("hdd");

        LinkedList l = new LinkedList();

        for (int i = 100; i >= 10; i -= 10) {
            l.insertAtEnd(i);
        }

        l.print();
        l.sort();
        l.print();

    }
}
