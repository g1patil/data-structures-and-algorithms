package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author g1patil
 * 437. Path Sum III
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class PathSum3 {


    int result = 0 ;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer,Integer> sumMap = new HashMap();
        sumMap.put(0,1);
        return pathSumHelder(root , 0 , targetSum , sumMap);
    }

    public int pathSumHelder(TreeNode root , int curSum , int target , HashMap<Integer,Integer> map){
        if (root == null)
            return 0;

        curSum+=root.val;


        int result=map.getOrDefault(curSum - target , 0);


        if(map.containsKey(curSum)){
            map.put(curSum , map.get(curSum) + 1);
        } else {
            map.put(curSum , 1 );
        }

        result+=pathSumHelder(root.left , curSum , target , map)+
        pathSumHelder(root.right , curSum , target , map);
        map.put(curSum , map.get(curSum) - 1 );
        return result;
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(2);

        root.setChild(n1,n2);
        n1.setChild(n3,n4);
        n2.setChild(n5,n6);

        pathSum(root , 6 );
    }
}
