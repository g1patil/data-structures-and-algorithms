package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author g1patil
 *
 * If node exist in the tree, the print the path of the root to
 * target node.
 */
@Platform(Site.RANDOM)
@Quality(Stage.DOCUMENTED)
public class DFSPath {

    List<Integer> integerList = new LinkedList<>();

    /**
     * Validates if the node exist in the tree or not. Main algo is the
     * DFS traversal. Once found, it add the path to the list.
     * @param treeNode root node
     * @param target element that we want to search and find path for
     * */
    private boolean nodeExist(TreeNode treeNode, int target){
        boolean result ;
        if(treeNode == null)
            return false;

        if (treeNode.getData() == target){
            integerList.add(0, treeNode.getData());
            return true;
        }


        result =  nodeExist(treeNode.left , target) || nodeExist(treeNode.right , target);
        if (result)
            integerList.add(0, treeNode.getData());
        return result;
    }

    /**
     * Calls the search method, and print the path of the node from the root if found.
     * @param target node that we want to search
     * @param treeNode root node of the tree or subtree
     * @return path of the target node from the root in list format.
     * List will be empty if the path does not exist
     * */
    public List<Integer> getPath(TreeNode treeNode , int target){
        nodeExist(treeNode, target);
        return integerList;
    }

    @Test
    @DisplayName("Print the path of the target node from the root node")
    public void test_(){
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

        System.out.println(getPath(n1,-1 ));
    }

    @Test
    @DisplayName("If the target node is the root node")
    public void test_root_node(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.setChild(n2,n3);


        System.out.println(getPath(n1,1 ));
    }
}
