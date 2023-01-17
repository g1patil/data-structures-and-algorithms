package trees.binary;
import model.TreeNode;
import java.util.Stack;

/**
 * Inorder traversal of the BST using the iterative approach
 * */
public class InorderTraversalIterative {

    private void inorderTraversalIterative(TreeNode root){
        if (root==null)
            return;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;

        while (true){
            while (temp!=null){
                stack.push(temp);
                temp = temp.left;
            }

            TreeNode current = stack.isEmpty() ? null : stack.pop();
            if (current == null )
                return;
            System.out.print(current.val + "  ");
            temp = current.right;
        }
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n2.setChild(n1,n3);
        n4.setChild(n2,n6);
        n6.setChild(n5,n7);

        InorderTraversalIterative o = new InorderTraversalIterative();
        o.inorderTraversalIterative(n4);
    }
}
