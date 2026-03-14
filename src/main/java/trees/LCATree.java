package trees;
import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * Find the lowest common ancestor for the given two children.
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LCATree {

    /**
     * Returns the LCA of given two children
     * @param _one path node one
     * @param _two path node two
     * @param _root root node of the tree
     * @return returns the LCA if found. Returns -1 if does not exist
     * */
    public TreeNode getLCAofNodes(TreeNode _root, TreeNode _one , TreeNode _two){
        if ( _root == null || _one == _root || _two == _root)
            return _root;

        TreeNode left = getLCAofNodes(_root.left , _one , _two);
        TreeNode right = getLCAofNodes(_root.right , _one , _two);


        if (left != null && right != null)
            return _root;

        if (left == null)
            return right;
        else return left;

    }

    @Test
    public void test(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n3.setChild(n6,n7);

        System.out.println(getLCAofNodes(n1, n2 , n7 ).val);
    }
}
