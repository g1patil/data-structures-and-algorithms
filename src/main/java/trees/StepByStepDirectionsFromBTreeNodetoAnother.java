package trees;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 2096. Step-By-Step Directions From a Binary Tree Node to Another
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class StepByStepDirectionsFromBTreeNodetoAnother {

    public String getDirections(TreeNode root , int source , int target){
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        dfsPath(root , source , start);
        dfsPath(root , target , end);

        start = start.reverse();
        end = end.reverse();

        int min = Math.min( start.length() , end.length()) , i = 0;

        while ( i < min && start.charAt(i) == end.charAt(i))
            i++;

        return "U".repeat(start.length() - i) + end.substring(i);
    }

    public boolean dfsPath(TreeNode root , int target , StringBuilder sb){
        if (root.val == target){
            return true;
        }
        if ( root.left!=null && dfsPath(root.left , target , sb)){
            sb.append("L");
        } else if ( root.right!=null && dfsPath(root.right , target , sb) ) {
            sb.append("R");
        }
        return sb.length() > 0 ;
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(-10);
        TreeNode n1 = new TreeNode(-5);
        TreeNode n2 = new TreeNode(-6);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        root.setChild(n1,n2);
        n1.setChild(n3,n4);
        n2.setChild(n5,n6);
        System.out.println(getDirections(root , 2,4 ));
    }
}
