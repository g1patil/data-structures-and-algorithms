package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author g1patil
 * 988. Smallest String Starting From Leaf
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SmallestStringStartingFromLeaf {

    String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        smallestFromLeafHelper(root, "");
        return ans;
    }

    private void smallestFromLeafHelper(TreeNode root , String str ) {
        if (root == null)
            return;

        if (root.left == null && root.right == null){
            String newString = Character.toString( root.val + 'a') + str;
            if(newString.compareTo(ans) < 0){
                ans = newString ;
            }
        }

        smallestFromLeafHelper(root.left , Character.toString( root.val + 'a') + str);
        smallestFromLeafHelper(root.right , Character.toString( root.val + 'a') + str);
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        root.setChild(n1,n2);
        n1.setChild(n3,n4);
        n2.setChild(n3,n4);

        System.out.println(smallestFromLeaf(root));
    }
}
