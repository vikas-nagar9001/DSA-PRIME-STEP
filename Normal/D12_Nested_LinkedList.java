package Normal;

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
            Node currentNode = head;

            for (int i = 1; i < pos; i++) {

                if (currentNode.next == null) {
                    break;
                }

                if (count == pos - 1) {

                    data = currentNode.next.data;

                    currentNode.next = currentNode.next.next;

                    isFound = true;

                    break;
                }
                currentNode = currentNode.next;
                count++;
            }

            System.out.println(isFound == true ? "data deleted : " + data : "positon not exits");
        }
    }

}

class OuterLinkedList {

    class Node {

        LinkedList list;
        Node next;

        Node(LinkedList list) {
            this.list = list;
            this.next = null;
        }

    }

    Node head;

    void printLists() {
        Node currentList = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        while (currentList != null) {

            // yha par humne linked list wali class me jo node class h usme current list ka head rkh diya 
            LinkedList.Node currentNode = currentList.list.head;
            while (currentNode != null) {
                System.out.print(currentNode.data + "->");
                currentNode = currentNode.next;
            }
            System.out.println("null");



            currentList=currentList.next;
        }

    }

    void addList(LinkedList list) {
        Node newList = new Node(list);

        if (head == null) {
            head = newList;

        } else {

            Node currentList = head;

            while (currentList.next != null) {
                currentList = currentList.next;
            }

            currentList.next = newList;
        }
    }

    void removeList() {
        if (head == null) {
            System.out.println("Head is null");
        } else {

            Node currentList = head;
            Node nextNode = head.next;

            while (nextNode.next != null) {

                currentList = currentList.next;
                nextNode = nextNode.next;
            }

            currentList.next = null;
        }
    }

}

public class D12_Nested_LinkedList {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.addAtLast(10);
        list.addAtLast(20);
        list.insertAtFirst(5);

        LinkedList list2 = new LinkedList();

        list2.addAtLast(30);
        list2.addAtLast(40);
        list2.insertAtFirst(25);

        OuterLinkedList ol = new OuterLinkedList();

        ol.addList(list);
        ol.addList(list2);
        ol.printLists();

        
    }
}