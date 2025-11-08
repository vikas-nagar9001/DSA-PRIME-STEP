package Normal;
//in this we create basic linked list with only head node and data node
// and also traverse the linked list

//      1000                 2000                 3000
// --------------      --------------       ---------------
// |DATA | 2000 | ---> |DATA | 3000 | --->  | DATA | NULL |
// --------------      --------------       ---------------


class Node {
    int data;
    Node next;

void printList(Node head) {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

}



public class D1_LinkedList {
    public static void main(String[] args) {
    
        Node head = new Node();
        head.data = 10;
        head.next = null;

        Node n2 = new Node();
        n2.data = 20;       
        n2.next = null; 

        head.next = n2;

        Node n3 = new Node();
        n3.data = 30;   
        n3.next = null;

        n2.next = n3;

        head.printList(head);


    }
}
