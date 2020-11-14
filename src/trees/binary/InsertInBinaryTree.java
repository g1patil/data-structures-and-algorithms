package trees.binary;

/**
 * Algorithm to insert the node in the binary tree.
 * 
 * Algorithm
 * 
 * insert (node, targetElement)
 *  if node == null;
 *      return (create new node)
 * 
 * if targetElement < node.data
 *  if data is less, then insert in the left
 *  node.left = insert(node.left, targetElement)
 * if targetElement > node.data
 *  node.right = insert (node.right, targetElement)
 * 
 * Remember that new node will always inserted at the leaf, 
 * which means at the bottom of the tree. Just find the null leaf and attach the link.
*/
public class InsertInBinaryTree {

    /**
     * Method to insert the element in the Binary Search Tree (BST)
     * @param root node 
     * @param target element that needs to be inserted.
     * @return returns the new created node.
    */
    Node insertNode(Node root,int target){
        if(root == null){
            root = new Node(target);
        }

        if(target < root.data){
            root.left =  insertNode(root.left, target);
        } 
        if (target > root.data){
            root.right =  insertNode(root.right, target);
        }

        return root;
    } 
    public static void main(String[] args) {

        //initialize the node
        Node root = new Node(10);
        Node n1 = new Node(5);
        Node n2 = new Node(20);
        Node n3 = new Node(3);
        Node n4 = new Node(7);
        Node n5 = new Node(15);
        Node n6 = new Node(25);
        Node n7 = new Node(8);


        
        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;
        n4.right = n7;

        new InsertInBinaryTree().insertNode(root, 6);
        DFSTraversal dfsTraversal = new DFSTraversal();
        dfsTraversal.inorderTraversal(root);
        
    }
}