package trees;
import data.TreeNode;
import org.junit.jupiter.api.Test;
import trees.binary.DFSPath;

import java.util.List;

/**
 * Find the lowest common ancestor for the given two nodes.
 * */
public class LCATree {

    /**
     * Returns the LCA of given two nodes
     * @param one_ path node one
     * @param two_ path node two
     * @param root_ root node of the tree
     * @return returns the LCA if found. Returns -1 if does not exist
     * */
    public int getLCAofNodes(TreeNode root_ , TreeNode one_ , TreeNode two_){
        if (root_ == null)
            return -1 ;

        if (one_ == two_)
            return one_.getData();

        List pathOne = new DFSPath().getPath(root_ , one_.getData());
        List pathTwo = new DFSPath().getPath(root_ , two_.getData());

        if (pathOne.isEmpty() || pathTwo.isEmpty())
            return -1;

        int pointer = 0 ;

        while (pathOne.get(pointer) == pathTwo.get(pointer)){
            pointer ++;
        }

        return (int) pathOne.get(--pointer);

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

        System.out.println(getLCAofNodes(n1, n7 , n6 ));
    }
}
