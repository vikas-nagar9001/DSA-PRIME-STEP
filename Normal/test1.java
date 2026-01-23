
class LinkedList {

    Node head;

    class Node {

        Node next;
        String data;

        Node(String data) {
            this.data = data;
            this.next = null;
        }

    }

    void insertAtEnd(String data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

    }

    void printData() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

}

public class test1 {

    public static void main(String[] args) {

        LinkedList charLinkedList = new LinkedList();
        LinkedList integerLinkedList = new LinkedList();
        LinkedList specialLinkedList = new LinkedList();

        String str = "asdfglghkj5653453%%@@#fhds";

        int strLength = str.length();

        for (int i = 0; i < strLength; i++) {

            String word = String.valueOf(str.charAt(i));

            if (str.codePointAt(i) >= 97 && str.codePointAt(i) <= 122) {

                charLinkedList.insertAtEnd(word);
            } else if (str.codePointAt(i) >= 65 && str.codePointAt(i) <= 90) {
                charLinkedList.insertAtEnd(word);
            }

            else if (str.codePointAt(i) >= 48 && str.codePointAt(i) <= 57) {
                integerLinkedList.insertAtEnd(word);
            }
            else {
                specialLinkedList.insertAtEnd(word);
            }
        }

        charLinkedList.printData();
        integerLinkedList.printData();
        specialLinkedList.printData();

    }

}
