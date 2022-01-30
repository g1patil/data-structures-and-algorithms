package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;

import java.util.Stack;

/**
 * @author g1patil
 *
 * Algo : use the stack to main tain the all left most elements.
 * When to pop, add its right element, and it's all left
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class BSTIterator {

    Stack<TreeNode> stack = new Stack<TreeNode>() ;
    public BSTIterator(TreeNode root) {
        addAllLeft(root);
    }

    public int next() {
        TreeNode result = stack.pop();
        addAllLeft(result.right);
        return result.val ;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void addAllLeft(TreeNode root){
        TreeNode rootCopy = root ;

        while(rootCopy != null){
            stack.push(rootCopy);
            rootCopy = rootCopy.left;
        }
    }
}
