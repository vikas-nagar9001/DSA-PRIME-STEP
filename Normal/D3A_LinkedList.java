package Normal;
//advanced linked list with multiple methods to add , delete , get length , get position , get data by position and reverse the linked list

 class Node{
    int data;
    Node next;

    Node headIsNull(Node head, Node newNode) {

        System.out.println("No head found adding the current data(" + newNode.data + ")as a head\nPlease accept the new head");
        head = newNode;
        return head;

    }

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }

        System.out.print("Null\n");
    }

    void getLength(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }

        System.out.print("Length : " + count);
    }

    Node insertAtLast(Node head, int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        Node currentNode = head;

        if (head == null) {
            head = headIsNull(head, newNode);
        }

        else {

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;

        }
        return head;

    }

    Node insertAtFirst(Node head, int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = headIsNull(head, newNode);
        }

        newNode.next = head;

        // this is our new head
        return newNode;

    }

    Node insertAtPosition(Node head, int data, int pos) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        Node currentNode = head;

        if (head == null) {
            head = headIsNull(head, newNode);
        }

        else {

            for (int i = 1; i <= pos - 2; i++) {
                currentNode = currentNode.next;

            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;

        }
        return head;

    }

    void getPosition(Node head, int data) {
        if (head == null) {
            System.out.println("Head is null");
        } else {
            int count = 0;
            while (head != null) {
                count++;
                if (head.data == data) {
                    break;
                }
                head = head.next;
            }

            System.out.println("The position of " + data + " is : " + count);
        }
    }

    void getDataByPosition(Node head, int pos) {
        if (head == null) {
            System.out.println("Head is null");
        } else {
            boolean isFound = false;
            int count = 1;
            for (int i = 1; i <= pos; i++) {
                if (head == null) {
                    break;
                }
                if (count == pos) {
                    isFound = true;
                    break;
                }
                head = head.next;
                count++;
            }

            System.out.println(isFound == true ? "data found : " + head.data : "positon not exits");
        }
    }

    Node deleteFirst(Node head) {
        if (head == null) {
            System.out.println("Head is null");
        } else {
            head = head.next;
        }
        return head;

    }

    void deleteLast(Node head) {
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

    void deleteByPosition(Node head, int pos) {
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

    void reverseList(Node head) {
        Node tempList = new Node();
        Node tempHead = tempList;
        if (head == null) {
            System.out.println("Head is null");
        } else {
            while (head != null) {
                System.out.println("->" + head.data);
                tempHead = tempList.insertAtFirst(tempHead, head.data);

                head = head.next;
            }
            tempList.printList(tempHead);
        }

    }
}

public class D3A_LinkedList {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");

        Node list = new Node();
        Node head = null;
        // head= null;

        head = list.insertAtLast(head, 23);
        list.insertAtLast(head, 45);
        list.insertAtLast(head, 50);

        head = list.insertAtFirst(head, 10);

        list.insertAtPosition(head, 34, 3);
        list.printList(head);

        // list.getPosition(head, 45);
        // list.getDataByPosition(head, 0);

        // list.deleteLast(head);
        // head = list.deleteFirst(head);

        // list.deleteByPosition(head, 6);

        // list.getLength(head);

        list.reverseList(head);

    }
}