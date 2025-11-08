package Normal;
//we create a linked list with multiple methods to add nodes at last , at first and at any position

class Node {
    int data;
    Node next;

    void printList(Node head) {
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

    // now we add the nodes by methods
    void addAtLast(Node head, int data) {

        // create new node and add data in it
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = newNode;
            return;
        }

        // we assign head to current node to not lose the head reference
        // because head will traverse to the last node
        Node currentNode = head;

        // we have to traverse the linked list to reach the last node
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        // IN LAST NODE NEXT WE HAVE TO ADD THE NEW NODE
        // SO NOW OUR LAST NODE .NEXT STORE THE REFERENCE OF NEW NODE
        currentNode.next = newNode;
    }

    Node insertAtFirst(Node head, int data) {

        // create new node and add data in it
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        }

        newNode.next = head;

        // this is our new head we have to accept it in main method
        return newNode;

    }

    Node insertAtPosition(Node head, int data, int pos) {

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        Node currentNode = head;

        if (head == null) {
            head =newNode;
        }

        else {
            // now hu7me to traverse the linked list to reach the position before the pos where we want to insert the new node
            // hume jaha insert karna hai usse ek position pehle tak traverse karna hai
            for (int i = 1; i <= pos - 2; i++) {
                currentNode = currentNode.next;

            }
            // then traverse hone ke baad new node ka next current node ke next pe point karega
            // aur current node ka next new node pe point karega
            newNode.next = currentNode.next;
            currentNode.next = newNode;

        }
        return head;

    }

}

public class D2_LinkedList {
    public static void main(String[] args) {

        Node head = new Node();
        head.data = 10;
        head.next = null;

        head.printList(head);
        // we pass head so our method can traverse the linked list
        head.addAtLast(head, 20);

        head.printList(head);

        // now we have to accept the new head
        // bcoz we add the node in first so our head also changes and the insertAtFirst
        // method return the new head
        head = head.insertAtFirst(head, 5);
        head.printList(head);
        head = head.insertAtPosition(head, 15, 3);
                head.printList(head);

    }
}
