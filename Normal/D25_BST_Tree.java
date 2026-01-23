 class Node{

    Node left;
    int data;
    Node right;
        

        Node(int data){
         this.left=null;
         this.data=data;
         this.right=null;
        }
    }


class Tree{




   
}

public class D25_BST_Tree {
    public static void main(String[] args) {

        Node root = new Node(10);

        Node node1 = new Node(20);

        root.left = node1;

        Node node2 = new Node(30);

        root.right = node2;



        Node n3 = new Node(50);


        root.left.left = n3;
    }
}
