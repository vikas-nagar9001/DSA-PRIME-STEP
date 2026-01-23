
class Node {

    Node left;
    int data;
    Node right;

    Node(int data) {
        this.left = null;
        this.data = data;
        this.right = null;
    }
}

class BST {

    Node root;

    void print(Node root) {

        if (root == null) {
            return;
        }

        print(root.left);
        System.out.println(root.data);
        print(root.right);

    }

    void addByRecursion(int data, Node root) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Node currentNode = root;

        if (data < currentNode.data) {
            addByRecursion(data, root.left);
        }

        else if (data > currentNode.data) {
            addByRecursion(data, root.right);
        }

    }

    void addByLoop(int data) {

        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Node currentNode = root;

        while (true) {
            if (data < currentNode.data) {

                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                }
                currentNode = currentNode.left;

            } else if (data > currentNode.data) {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                }
                currentNode = currentNode.right;
            }

        }
    }
}

public class D26_BST_Tree {

public static void main(String[] args) {
      BST tree = new BST();

    tree.addByRecursion(10,null);
    tree.addByRecursion(67,null);
    tree.addByRecursion(30,null);
    tree.addByRecursion(34,null);
    tree.addByRecursion(32,null);

    tree.print(null);
}
  
}
