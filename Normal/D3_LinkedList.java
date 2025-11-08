package Normal;
// added a multiple methods to add and delete nodes in linked list

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
    Node addAtLast(Node head, int data) {

        // create new node and add data in it
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = newNode;
            return head;
        } else {
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
        return head;
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
            head = newNode;
        }

        else {
            // now hu7me to traverse the linked list to reach the position before the pos
            // where we want to insert the new node
            // hume jaha insert karna hai usse ek position pehle tak traverse karna hai
            for (int i = 1; i <= pos - 2; i++) {
                currentNode = currentNode.next;

            }
            // then traverse hone ke baad new node ka next current node ke next pe point
            // karega
            // aur current node ka next new node pe point karega
            newNode.next = currentNode.next;
            currentNode.next = newNode;

        }
        return head;

    }

    Node deleteFirst(Node head) {
        if (head == null) {
            System.out.println("Head is null");
        } else {

            // hume head ko head ke next pe point karna hai
            // bcoz jo head hai woh ab aage wale node pe point karega
            // ex 5->10->20->null
            // so our new head is 10
            // aur jo head pehle tha woh garbage collection ke liye chhod dena hai
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

            // hum last node se ek pehle node taktraverse karenge
            while (nextNode.next != null) {

                currentNode = currentNode.next;
                nextNode = nextNode.next;
            }

            // ab hamare pass 2 node hain
            // current node jo last se ek pehle node hai
            // next node jo last node hai
            // so ab current node ka next null kar denge
            currentNode.next = null;
        }
    }

    void deleteByPosition(Node head, int pos) {
        if (head == null) {
            System.out.println("Head is null");
        } else {

            boolean isFound = false;
            int count = 1, data = 0;

            // hum jaha delete karna chahte hain usse ek position pehle tak traverse karenge
            for (int i = 1; i < pos; i++) {

                // may be list me itne node nahi hain
                // toh agar head null ho jata hai to break kar denge

                if (head.next == null) {
                    break;
                }

                if (count == pos - 1) {
                    // data ko store kar lenge jise hum delete kar rahe hain
                    // taaki hum print kar sake
                    data = head.next.data;

                    // ab hume jisse delete krna h hum usse ek phle wali node par hai
                    // 5->10->15->20->null
                    // ab hume 15 ko delete krna hai toh hum 10 pe hain
                    // toh hum 10 ke next ko 15 ke next pe point kr denge
                    // toh 15 delete ho jayega means  15 ka reference koi bhi node nahi karega
                    // so garbage collection ke liye chhod denge
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

}

public class D3_LinkedList {
    public static void main(String[] args) {

        Node list = new Node();
        Node head = null;

        // we pass head so our method can traverse the linked list
        head = list.addAtLast(head, 20);

        list.printList(head);

        // now we have to accept the new head
        // bcoz we add the node in first so our head also changes and the insertAtFirst
        // method return the new head
        head = list.insertAtFirst(head, 5);
        list.printList(head);
        head = list.insertAtPosition(head, 15, 3);
        list.printList(head);

        // head = list.deleteFirst(head);
        // list.printList(head);

        list.deleteLast(head);
        list.printList(head);

    }
}
