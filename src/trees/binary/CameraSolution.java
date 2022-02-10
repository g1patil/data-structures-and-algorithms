package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author https://leetcode.com/hunteryuh/
 *
 * 968. Binary Tree Cameras
 * Any node will have not covered , covered , has camera
 * Main logic : Never put camera at leaf lode. Or you can say null is always covered.
 *              If either child is not covered , put camera there. return has_camera
 *              If either child has_camera, you current not is covered. So return covered.
 *              If your both child are covered , that means you will not be covered and return not_covered.
 *                  so that in parent put camera there.
 */
@Quality(Stage.DOCUMENTED)
@Platform(Site.LEETCODE)
public class CameraSolution {

    private static final int NO_COV =  0;
    private static final int COV_NC =  1;
    private static final int COV_CM =  2;

    public int minCameraCover(TreeNode root) {
        int x = dfs(root);
        if (x == NO_COV) {
            result++;
        }
        return result;
    }

    int result = 0 ;
    private int dfs(TreeNode node) {
       if (node == null)
           return COV_NC;
       int left = dfs(node.left);
       int right = dfs(node.right);

       if (left == NO_COV || right == NO_COV){
           result++;
           return COV_CM;
       } else if(left == COV_NC &&  right == COV_NC){
           return NO_COV;
       } else {
           return COV_NC;
       }
    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.setChild(n2,n3);
        n3.setChild(n4 , null);

        System.out.println(minCameraCover(n1));
    }
}
