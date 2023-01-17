package trees.binary;

/**
 * Algorithm to delete the node from the BST
 * 
*/
public class DeleteNodeInBST {
    
    Node findNode(Node current,int target){
        if(current == null){
            return null;
        }

        if(current.data == target){
            return current;
        }

        if(target < current.data){
            return findNode(current.left, target);
        } else {
            return findNode(current.right, target);
        }
    }
    public static void main(String[] args) {
        //initialize the node
                Node root = new Node(10);
                Node n1 = new Node(5);
                Node n2 = new Node(20);

        DeleteNodeInBST deleteNodeInBST = new DeleteNodeInBST();

        Node targetNode = deleteNodeInBST.findNode(root, 5);
        targetNode = null;
        System.out.println();
    }

    private Node findLowest(Node node) {
        while(node.right !=null){
            node = node.left;
        }
        return node;
    }
}