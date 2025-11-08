// now create extra methods to enhance the d11_Queue functionality
package Normal;

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

    void enqueueAtFront(int data) {

        Node newNode = new Node(data);

        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;

            front = newNode;
        }
        System.out.println("Data Enqueued at front");
        length++;
    }

    void enqueueAtPosition(int data, int pos) {
        Node newNode = new Node(data);

        Node currentNode = front;

        if (pos <= getLength()) {

            for (int i = 1; i <= pos - 2; i++) {
                currentNode = currentNode.next;

            }

            newNode.next = currentNode.next;
            currentNode.next = newNode;
            System.out.println("Data enqueued at postion : " + pos);
            length++;

        } else {
            System.out.println("Position not exists");
        }

    }

    void updateDataByPos(int data, int pos) {

        Node currentNode = front;

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

    void dequeue() {
        if (front == null) {
            System.out.println("Front is null");
        } else {

            front = front.next;
            System.out.println("First element dequeued");
            length--;
        }

    }

    void dequeueRear() {
        if (front == null) {
            System.out.println("Front is null");
        } else {

            Node currentNode = front;
            Node nextNode = front.next;

            while (nextNode.next != null) {

                currentNode = currentNode.next;
                nextNode = nextNode.next;
            }

            currentNode.next = null;

            System.out.println("Rear node dequeued");
            length--;
        }
    }

    void dequeueByPosition(int pos) {
        if (front == null) {
            System.out.println("Front is null");
        } else {

            boolean isFound = false;
            int count = 1, data = 0;

            Node currentNode = front;

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

            System.out.println(isFound == true ? "data dequeued : " + data : "positon not exits");

        }
    }

    void reverseQueue() {
        Node currentNode = front;

        if (front == null) {
            System.out.println("Front is null");
        } else {

            Queue revQueue = new Queue();

            while (currentNode != null) {
                revQueue.enqueueAtFront(currentNode.data);

                currentNode = currentNode.next;
            }
            front = revQueue.front;

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
                1. Enqueue                     7. Dequeue
                2. Enqueue At Front            8. Dequeue By Position
                3. Print Queue                 9. Enqueue At Position
                4. Reverse Queue               10. Encode Queue
                5. Print Length                11. Decode Queue
                6. Dequeue Rear                12. Update Data
                                               13. Exit
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

    void handleEnqueueAtFront() {
        System.out.print("Enter Data: ");
        int data = sc.nextInt();
        queue.enqueueAtFront(data);

    }

    void handleDequeueByPosition() {
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();
        queue.dequeueByPosition(pos);

    }

    void handleEnqueueAtPosition() {
        System.out.print("Enter Data: ");
        int data = sc.nextInt();
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();
        queue.enqueueAtPosition(data, pos);

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

    void handleUpdate() {
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();
        System.out.print("Enter Updated Data: ");
        int data = sc.nextInt();

        queue.updateDataByPos(data, pos);
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

public class D11A_Queue_LinkedList {

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
                case 2 -> handler.handleEnqueueAtFront();
                case 3 -> queue.printQueue();
                case 4 -> queue.reverseQueue();
                case 5 -> System.out.println("Length: " + queue.getLength());
                case 6 -> queue.dequeueRear();
                case 7 -> queue.dequeue();
                case 8 -> handler.handleDequeueByPosition();
                case 9 -> handler.handleEnqueueAtPosition();
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
