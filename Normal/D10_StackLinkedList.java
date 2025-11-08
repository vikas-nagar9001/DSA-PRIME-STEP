package Normal;
class Node {
    int data;
    Node next;

    Node(int data) { 
        this.data = data;
        this.next = null;
    }
}

class Stack {
    int top = 0;
    int SIZE;
    Node head;

    Stack(int size) {
        this.SIZE = size;
    }

    void push(int data) {
        if (top == SIZE) {
            System.out.println("Stack Overflow");
            return;
        } 
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        top++;
        System.out.println("Pushed: " + data);
    }

    void pop() {
        if (top == 0 || head == null) {
            System.out.println("Stack Underflow");
            return;
        }

        System.out.println("Popped: " + head.data);
        head = head.next;
        top--;
    }

    void print() {
        if (top == 0 || head == null) {
            System.out.println("Stack is empty");
            return;
        }

        Node currentNode = head;
        System.out.println("Stack elements (Top to Bottom):");
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }
}

public class D10_StackLinkedList {
    public static void main(String[] args) {
        Stack s = new Stack(3);

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
