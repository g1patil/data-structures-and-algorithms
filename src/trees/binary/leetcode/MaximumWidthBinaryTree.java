package trees.binary.leetcode;

import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 */
public class MaximumWidthBinaryTree {

    List<List<Integer>> listList = new ArrayList<>();

    private List<List<Integer>> widthOfBinaryTreeHelper(TreeNode treeNode , int level , int index){
        if (treeNode == null)
            return listList;

        if (listList.size() < level){
            List<Integer> integerList = new ArrayList<>();
            integerList.add(index);
            listList.add(level -1  , integerList );
        } else {
            listList.get(level - 1 ).add(index);
        }

        widthOfBinaryTreeHelper(treeNode.left , level + 1 , 2*index);
        widthOfBinaryTreeHelper(treeNode.right , level + 1 , 2*index + 1);

        return listList;
    }

    public int widthOfBinaryTree(TreeNode root) {
        listList = widthOfBinaryTreeHelper(root , 1 , 0 );
        int result = 1;
        for (int i = listList.size() - 1 ; i > 0 ; i--) {
            if (listList.get(i).size() > 1){
                List list = listList.get(i);
                int first = (int) list.get(0);
                int last = (int) list.get( list.size() -1 );
                result = Math.max(last - first + 1 , result) ;
            }
        }
        return result;
    }

    @Test
    public void test_(){

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.setChild(n2 , n5 );
        n2.setChild(n3 , null );
        n3.setChild(n4 , null );

        n5.setChild(null , n6 );
        n6.setChild(null , n7 );

        System.out.println(widthOfBinaryTree(n1));
    }

    @Test
    public void test_2(){

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.setChild(n2 , null );
        n2.setChild(n3 , n4 );



        System.out.println(widthOfBinaryTree(n1));
    }

    @Test
    public void test_3(){

        TreeNode n1 = new TreeNode(1);



        System.out.println(widthOfBinaryTree(n1));
    }
}
