// now create extra methods to enhance the d10_Stack functionality
package Advance;

import java.util.Scanner;

class Stack {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    Node top;
    int length;

    void printStack() {
        Node currentNode = top;

        if (top == null) {
            System.out.println("Stack is empty");
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

    void push(int data) {

        Node newNode = new Node(data);

        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;

            top = newNode;
        }
        System.out.println("Data Pushed");
        length++;
    }

    void pop() {
        if (top == null) {
            System.out.println("Top is null");
        } else {

            top = top.next;
            System.out.println("Top element popped");
            length--;
        }

    }

    void reverseStack() {
        Node currentNode = top;

        if (top == null) {
            System.out.println("Top is null");
        } else {

            Stack revStack = new Stack();

            while (currentNode != null) {
                revStack.push(currentNode.data);

                currentNode = currentNode.next;
            }
            top = revStack.top;

            System.out.println("Stack Reversed");

        }
    }

    void encodeStack(int key) {
        Node currentNode = top;
        while (currentNode != null) {
            while (currentNode != null) {
                currentNode.data = (currentNode.data ^ key);
                currentNode = currentNode.next;
            }
        }

        System.out.println("Stack data encoded");
    }

    void decodeStack(int key) {
        Node currentNode = top;
        while (currentNode != null) {
            while (currentNode != null) {
                currentNode.data = (currentNode.data ^ key);
                currentNode = currentNode.next;
            }
        }

        System.out.println("Stack decoded print to see original stack");
    }

}

class Handlers {

    Scanner sc;
    Stack stack;

    Handlers(Scanner sc, Stack stack) {
        this.sc = sc;
        this.stack = stack;
    }

    // --- Menu Printing ---
    void printMenu() {
        clearTerminal();
        stack.printStack();
        System.out.println("\n========= Stack Operations ===========");
        System.out.println("""
                1. Push                        4. Reverse Stack
                2. Print Stack                 5. Encode Stack
                3. Pop                         6. Decode Stack
                                               7. Print Length
                                               8. Exit
                              ------------------
                              | Made by @vikas |
                              ------------------
                """);

    }

    // --- Handlers for Input ---
    void handlePush() {
        System.out.print("Enter Data: ");
        int data = sc.nextInt();
        stack.push(data);

    }

    void handleEncode() {
        System.out.println("Enter Integer Secret Key: ");
        int key = sc.nextInt();

        stack.encodeStack(key);
    }

    void handleDecode() {
        System.out.println("Enter Your Key: ");
        int key = sc.nextInt();

        stack.decodeStack(key);
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

public class D2_Stack_LinkedList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack stack = new Stack();

        Handlers handler = new Handlers(sc, stack);
        boolean run = true;

        while (run) {
            handler.printMenu();
            System.out.print("Select Input: ");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> handler.handlePush();
                case 2 -> stack.printStack();
                case 3 -> stack.pop();
                case 4 -> stack.reverseStack();
                case 5 -> handler.handleEncode();
                case 6 -> handler.handleDecode();
                case 7 -> System.out.println("Length: " + stack.getLength());
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
