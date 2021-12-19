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
 * Any node will have not covered , covered , has camera
 * Main logic : Never put camera at leaf lode.
 *              If either child is not covered , put camera there. return has_camera
 *              If either child has_camera, you current not is covered. So return covered.
 *              If your both child are covered , that means you will not be covered and return not_covered.
 *                  so that in parent put put camera there.
 */
@Quality(Stage.DOCUMENTED)
@Platform(Site.LEETCODE)
public class CameraSolution {
    enum Camera {
        HAS_CAMERA,
        COVERED,
        NOT_COVERED
    }
    int res = 0;

    public int minCameraCover(TreeNode root) {
        Camera x = dfs(root);
        if (x == Camera.NOT_COVERED) {
            res++;
        }
        return res;
    }

    private Camera dfs(TreeNode node) {
        if (node == null || node.left == null  && node.right == null)
            return Camera.NOT_COVERED;

        Camera left = dfs(node.left);
        Camera right = dfs(node.right);

        if (left == Camera.COVERED && right == Camera.COVERED) {
            return Camera.NOT_COVERED;
        }
        if (left == Camera.NOT_COVERED || right == Camera.NOT_COVERED) {
            res++;
            return Camera.HAS_CAMERA;
        }
        // this has to check at the end to not cover the case where left or right is NOT_COVERED
        if (left == Camera.HAS_CAMERA || right == Camera.HAS_CAMERA) {
            return Camera.COVERED;
        }
        return null;
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
