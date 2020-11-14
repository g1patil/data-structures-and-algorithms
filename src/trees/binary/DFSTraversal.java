package trees.binary;
/**
 * Code for DFS traversal of the Binary Tree
 * Inorder traversal. LDR (Left,Data,Right)
 * Preorder traversal. DLR (Data, Left, Right)
 * Postorder traversal. LRD (Left, Data, Right)
 * 
 * The idea behind the DFS is that you complete the entire depth first and then proceed.
 * 
*/
public class DFSTraversal {

    /**
     * @param node node of the tree. Initially root node.
    */
    void inorderTraversal(Node node){
        if(node ==null){
            return ;
        }

        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    /**
     * 
     * Pre-order traversal of the tree. 
     * DLR -> First Data, then left tree and then right tree.
    */
    void preOrderTraversal(Node node){
        if(node ==null){
            return ;
        }

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    private void postOrderTraversal(Node node) {
        if(node ==null){
            return ;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }
    /* Driver class*/
    public static void main(String[] args) {
        Node root = new Node(100);
        Node n1 = new Node(55);
        Node n2 = new Node(2);
        Node n3 = new Node(14);
        Node n4 = new Node(88);
        Node n5 = new Node(1);
        Node n6 = new Node(5);
        Node n7 = new Node(16);
        Node n8 = new Node(39);
        Node n9 = new Node(7);


        
        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

        n4.left = n7;
        n4.right = n8;

        n8.left = n9;

        System.out.println("This is in-order traversal");
        new DFSTraversal().inorderTraversal(root);

        System.out.println("This is pre-order traversal");
        new DFSTraversal().preOrderTraversal(root);

        System.out.println("This is pre-order traversal");
        new DFSTraversal().postOrderTraversal(root);
    }

    
}