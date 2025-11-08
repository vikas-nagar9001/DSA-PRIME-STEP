package Normal;
class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front;
    Node rear;

    Queue() {
        front = rear = null;
    }

    void enqueue(int data) {

        Node newNode = new Node(data);

        if (front == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;

    }

    void dequeue() {

        if (front == null || rear == null) {
            System.out.println("Queue is empty");
            return;
        }

        front = front.next;

        if(front==null){
            rear = null;
        }

    }

    void print() {
        if (front == null || rear == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node currentNode = front;
        while (currentNode != null) {
            System.out.print(" [ ");
            System.out.print(currentNode.data);
            System.out.print(" ] -> ");
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}




public class D11_Queue_LinkedList {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(10);
         q.enqueue(20);
        
          q.enqueue(30);
q.print();
          q.dequeue();
          q.print();
        //   q.dequeue();
        //      q.print();

        //        q.dequeue();
        //            q.print();
               
          
    }
}
