package Normal;

class LinkedList<T> {

    class Node {

        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

    }

    Node head;
    int length;

    void printList() {
        Node currentNode = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        int length = getLength();
        for (int i = 1; i <= length; i++) {
            System.out.print("------------");

        }
        System.out.println();

        while (currentNode != null) {
            System.out.print("| ");
            System.out.print(currentNode.data);
            System.out.print(" |");
            System.out.print(" -> ");
            currentNode = currentNode.next;
        }
        System.out.println(" null |");

        for (int i = 1; i <= length; i++) {
            System.out.print("------------");

        }
    }

    int getLength() {
        return length;
    }

    void addAtLast(T data) {

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

        System.out.println("Data Inserted at last");
        length++;

    }

    void insertAtFirst(T data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;

            head = newNode;
        }
        System.out.println("Data Inserted at first");
        length++;
    }

    void insertAtPosition(T data, int pos) {
        Node newNode = new Node(data);

        Node currentNode = head;

        if (pos <= getLength()) {

            for (int i = 1; i <= pos - 2; i++) {
                currentNode = currentNode.next;

            }

            newNode.next = currentNode.next;
            currentNode.next = newNode;
            System.out.println("Data inserted at postion : " + pos);
            length++;

        } else {
            System.out.println("Position not exists");
        }

    }

    void updateDataByPos(T data, int pos) {

        Node currentNode = head;

        if (pos <= getLength()) {

            for (int i = 1; i <= pos - 2; i++) {
                currentNode = currentNode.next;

            }

            T temp = currentNode.data;
            currentNode.data = data;
            System.out.println("Data updated " + temp + " to " + data);

        } else {
            System.out.println("Position not exists");
        }

    }

    void deleteFirst() {
        if (head == null) {
            System.out.println("Head is null");
        } else {

            head = head.next;
            System.out.println("First element deleted");
            length--;
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

            System.out.println("Last node deleted");
            length--;
        }
    }

    void deleteByPosition(int pos) {
        if (head == null) {
            System.out.println("Head is null");
        } else {

            boolean isFound = false;
            int count = 1;
            T data =null;

            Node currentNode = head;

            for (int i = 1; i < pos; i++) {

                if (currentNode.next == null) {
                    break;
                }

                if (count == pos - 1) {

                    data = currentNode.next.data;

                    currentNode.next = currentNode.next.next;

                    isFound = true;
                    length--;

                    break;
                }
                currentNode = currentNode.next;
                count++;
            }

            System.out.println(isFound == true ? "data deleted : " + data : "positon not exits");

        }
    }

    void reverseList() {
        Node currentNode = head;

        if (head == null) {
            System.out.println("Head is null");
        } else {

            LinkedList<T> revList = new LinkedList<>();

            while (currentNode != null) {
                revList.insertAtFirst(currentNode.data);

                currentNode = currentNode.next;
            }
            head = revList.head;

            System.out.println("List Reversed");

        }
    }


}


public class D6_Generics_LinkedList {
    
    public static void main(String[] args) {
          LinkedList<String> list = new LinkedList<>();

        list.addAtLast("Honey");
        list.addAtLast("Vikas");
        list.addAtLast("Priyansh");

        list.printList();

        list.insertAtFirst("First");
        list.printList();

        list.deleteFirst();
        list.printList();

        System.out.println("Length: " + list.getLength());
    }
    
}
