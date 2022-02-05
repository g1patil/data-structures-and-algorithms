package trees.binary;

/*
 * 110. Balanced Binary Tree
 * Easy
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * */
public class BalancedTree {


    /**
     * @param node given node
     * @return height of the tree
     * */
    int getHeight(Node node){
        if(node == null){
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * @param node given node
     * @return true/false checks if the given tree is balanced or not.
     * Also make sure that left and right tree are independently balanced or not.
     * */
    boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
         return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1
                 && isBalanced(node.left) && isBalanced(node.right);
    }

    boolean isBalancedOptimal(Node node){
        if(node == null){
            return true;
        }
         return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1
                 && isBalanced(node.left) && isBalanced(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node n1 = new Node(5);
        Node n2 = new Node(20);
        Node n3 = new Node(4);
        Node n4 = new Node(8);
        Node n5 = new Node(14);
        Node n6 = new Node(25);
        Node n7 = new Node(6);
        Node n8 = new Node(9);

        root.left = n1;
        root.right = n2;
        n2.left = n5;
        n2.right = n6;
        n6.left = new Node(50);

        System.out.println(new BalancedTree().isBalanced(root));

    }
}
