// now create extra methods to enhance the d11_Queue functionality
package Advance;

import java.util.Scanner;

class Queue {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    Node front;
    Node rear;
    int length;

    void printQueue() {
        Node currentNode = front;

        if (front == null) {
            System.out.println("Queue is empty");
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

    void enqueue(int data) {

        Node newNode = new Node(data);

        if (front == null) {
            front = newNode;
            rear = newNode;

        } else {

            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Data Enqueued");
        length++;

    }

    void dequeue() {
        if (front == null) {
            System.out.println("Front is null");
        } else {

            front = front.next;
            System.out.println("First element dequeued");
            length--;
        }

    }

    void reverseQueue() {
        Node prevNode = null;
        Node currentNode = front;
        Node nextNode = null;

        if (front == null) {
            System.out.println("Front is null");
        } else {

            rear = front;

            while (currentNode != null) {
                nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = nextNode;
            }
            front = prevNode;

            System.out.println("Queue Reversed");

        }
    }

    void encodeQueue(int key) {
        Node currentNode = front;
        while (currentNode != null) {
            while (currentNode != null) {
                currentNode.data = (currentNode.data ^ key);
                currentNode = currentNode.next;
            }
        }

        System.out.println("Queue data encoded");
    }

    void decodeQueue(int key) {
        Node currentNode = front;
        while (currentNode != null) {
            while (currentNode != null) {
                currentNode.data = (currentNode.data ^ key);
                currentNode = currentNode.next;
            }
        }

        System.out.println("Queue decoded print to see original queue");
    }

}

class Handlers {

    Scanner sc;
    Queue queue;

    Handlers(Scanner sc, Queue queue) {
        this.sc = sc;
        this.queue = queue;
    }

    // --- Menu Printing ---
    void printMenu() {
        clearTerminal();
        queue.printQueue();
        System.out.println("\n========= Queue Operations ===========");
        System.out.println("""
                1. Enqueue                     4. Reverse Queue
                2. Print Queue                 5. Encode Queue
                3. Dequeue                     6. Decode Queue
                                               7. Print Length
                                               8. Exit
                              ------------------
                              | Made by @vikas |
                              ------------------
                """);

    }

    // --- Handlers for Input ---
    void handleEnqueue() {
        System.out.print("Enter Data: ");
        int data = sc.nextInt();
        queue.enqueue(data);

    }

    void handleEncode() {
        System.out.println("Enter Integer Secret Key: ");
        int key = sc.nextInt();

        queue.encodeQueue(key);
    }

    void handleDecode() {
        System.out.println("Enter Your Key: ");
        int key = sc.nextInt();

        queue.decodeQueue(key);
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

public class D3_Queue_LinkedList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue queue = new Queue();

        Handlers handler = new Handlers(sc, queue);
        boolean run = true;

        while (run) {
            handler.printMenu();
            System.out.print("Select Input: ");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> handler.handleEnqueue();
                case 2 -> queue.printQueue();
                case 3 -> queue.dequeue();
                case 4 -> queue.reverseQueue();
                case 5 -> handler.handleEncode();
                case 6 -> handler.handleDecode();
                case 7 -> System.out.println("Length: " + queue.getLength());
                case 8 -> {
                    System.out.println("Exiting...");
                    run = false;
                }
                default -> System.out.println("Invalid input, please try again!");
            }
        }

        sc.close();
    }

}
