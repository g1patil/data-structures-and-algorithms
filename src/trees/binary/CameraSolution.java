package trees.binary;

import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author https://leetcode.com/hunteryuh/
 */
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
        if (node == null) return Camera.COVERED;
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
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);

        n1.setChild(n2,n3);

        System.out.println(minCameraCover(n1));
    }
}
