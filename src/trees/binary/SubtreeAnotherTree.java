package trees.binary;

import data.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 572. Subtree of Another Tree
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a tree
 * consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 *
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 *
 * */
public class SubtreeAnotherTree {

    /**
     * Check if the given tree is the sub tree of the other tree.
     * @param s first sub tree
     * @param t second sub tree
     * @return true/false
     * */
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if ( s == t){
            return true;
        }

        if(s == null || t == null){
            return false;
        }
        if ( s.getData() == t.getData()){
            return isSubtree(s.left,t.left) && isSubtree( s.right,t.right);
        }

        return isSubtree(s.left,t) || isSubtree( s.right,t);
    }

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(10);

        Assert.assertTrue(isSubtree(t1,t2));
    }

    @Test
    public void test2(){
        Assert.assertTrue(isSubtree(null,null));
    }

    @Test
    public void test3(){
        TreeNode t1 = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        t1.setChild(n1,null);
        TreeNode t2 = new TreeNode(10);
        Assert.assertTrue(isSubtree(t1,t2));
    }

    @Test
    public void test4(){
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(11);
        Assert.assertFalse(isSubtree(t1,t2));
    }

    @Test
    public void test5(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.setChild( t2, t3);

        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t2.setChild( t4, t5);

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);

        n1.setChild(n2,n3);

        Assert.assertTrue(isSubtree(t1,n1));
    }
}
