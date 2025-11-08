package Normal;

class Stack {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    void push(int data) {

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Pushed: " + data);
    }

    void pop() {
        if (head == null) {
            System.out.println("Stack Underflow");
            return;
        }

        System.out.println("Popped: " + head.data);
        head = head.next;

    }

    void print() {
        if (head == null) {
            System.out.println("Stack is empty");
            return;
        }

        Node currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }
}

public class D10A_Stack_LinkedList {
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.print();

        s.push(30);
        s.print();
        s.push(40);
        // s.pop();
        s.print();
    }
}
