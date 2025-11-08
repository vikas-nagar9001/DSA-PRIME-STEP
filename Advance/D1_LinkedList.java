// now create extra methods to enhance the d5_LinkedList functionality
package Advance;

import java.util.Scanner;

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

        System.out.println("Data Inserted at last");
        length++;

    }

    void insertAtFirst(int data) {

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

    void insertAtPosition(int data, int pos) {
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

    void updateDataByPos(int data, int pos) {

        Node currentNode = head;

        if (pos <= getLength()) {

            for (int i = 1; i <= pos - 2; i++) {
                currentNode = currentNode.next;

            }

            int temp = currentNode.data;
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

            LinkedList revList = new LinkedList();

            while (currentNode != null) {
                revList.insertAtFirst(currentNode.data);

                currentNode = currentNode.next;
            }
            head = revList.head;

            System.out.println("List Reversed");

        }
    }

    void encodeList(int key) {
        Node currentNode = head;
        while (currentNode != null) {
            while (currentNode != null) {
                currentNode.data = (currentNode.data ^ key);
                currentNode = currentNode.next;
            }
        }

        System.out.println("List data encoded");
    }

    void decodeList(int key) {
        Node currentNode = head;
        while (currentNode != null) {
            while (currentNode != null) {
                currentNode.data = (currentNode.data ^ key);
                currentNode = currentNode.next;
            }
        }

        System.out.println("List decoded print to see original list");
    }

}

class Handlers {

    Scanner sc;
    LinkedList list;

    Handlers(Scanner sc, LinkedList list) {
        this.sc = sc;
        this.list = list;
    }

    // --- Menu Printing ---
    void printMenu() {
        clearTerminal();
        list.printList();
        System.out.println("\n========= Linked List Operations ===========");
        System.out.println("""
                1. Add At Last                 7. Delete First
                2. Add At First                8. Delete By Position
                3. Print List                  9. Insert At Position
                4. Reverse List                10. Encode List
                5. Print Length                11. Decode List
                6. Delete Last                 12. Update Data
                                               13. Exit
                              ------------------
                              | Made by @vikas |
                              ------------------
                """);

    }

    
    LinkedList getLinkedList() {
        System.out.println("======= Linked List Type =======");
        System.out.println("""
                1. Integer                 4. Character
                2. String                  5. Boolean
                3. Null                    6. Exit
                """);

        System.out.print("Enter : ");
        int input = sc.nextInt();
      
        switch (input) {
            case 1 -> {
                // return new LinkedList<Integer>();
            }
            case 2 -> {
                // return new LinkedList<String>();
            }
            case 4 -> {
                // return new LinkedList<Character>();
            }
            case 5 -> {
                // return new LinkedList<Boolean>();
            }
            case 6 -> {
                System.out.println("Exiting...");
                return null;
            }
            default -> {
                System.out.println("Invalid input!");
                return null;
            }
        }
        return list;
    }

    // --- Handlers for Input ---
    void handleAddAtLast() {
        System.out.print("Enter Data: ");
        int data = sc.nextInt();
        list.addAtLast(data);

    }

    void handleAddAtFirst() {
        System.out.print("Enter Data: ");
        int data = sc.nextInt();
        list.insertAtFirst(data);

    }

    void handleDeleteByPosition() {
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();
        list.deleteByPosition(pos);

    }

    void handleInsertAtPosition() {
        System.out.print("Enter Data: ");
        int data = sc.nextInt();
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();
        list.insertAtPosition(data, pos);

    }

    void handleEncode() {
        System.out.println("Enter Integer Secret Key: ");
        int key = sc.nextInt();

        list.encodeList(key);
    }

    void handleDecode() {
        System.out.println("Enter Your Key: ");
        int key = sc.nextInt();

        list.decodeList(key);
    }

    void handleUpdate() {
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();
        System.out.print("Enter Updated Data: ");
        int data = sc.nextInt();

        list.updateDataByPos(data, pos);
    }

    void clearTerminal() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("mac") || os.contains("nix") || os.contains("nux")) {
                // macOS / Linux: try native clear
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } else if (os.contains("windows")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Fallback: ANSI escape code
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // IDE fallback: print a bunch of blank lines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

}

public class D1_LinkedList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList list = new LinkedList();

        Handlers handler = new Handlers(sc, list);
        boolean run = true;

        while (run) {
            handler.printMenu();
            System.out.print("Select Input: ");
            int input = sc.nextInt();

            switch (input) {
                case 1 ->  handler.handleAddAtLast();
                case 2 -> handler.handleAddAtFirst();
                case 3 -> list.printList();
                case 4 -> list.reverseList();
                case 5 -> System.out.println("Length: " + list.getLength());
                case 6 -> list.deleteLast();
                case 7 -> list.deleteFirst();
                case 8 -> handler.handleDeleteByPosition();
                case 9 -> handler.handleInsertAtPosition();
                case 10 -> handler.handleEncode();
                case 11 -> handler.handleDecode();
                case 12 -> handler.handleUpdate();
                case 13 -> {
                    System.out.println("Exiting...");
                    run = false;
                }
                default -> System.out.println("Invalid input, please try again!");
            }
        }

        sc.close();
    }

}
