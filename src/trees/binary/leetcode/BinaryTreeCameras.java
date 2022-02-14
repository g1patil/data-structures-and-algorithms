package trees.binary.leetcode;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author g1patil
 * My own impl of BinaryTreeCameras. Look at other solution since this is
 * not perfect
 */
@Platform(Site.LEETCODE)
@Quality(value = Stage.FAILING , details = "passes 97/171 test on LC")
public class BinaryTreeCameras {

    private int totalNumberOfNodes = 0;
    private int getNumberOfNodes(TreeNode treeNode){
        if (treeNode == null)
            return 0;

        return 1 + getNumberOfNodes(treeNode.left) + getNumberOfNodes(treeNode.right);
    }

    private boolean canChoose(List<TreeNode> treeNodeList , TreeNode currentNode){
        if (treeNodeList.isEmpty())
            return true;
        for (TreeNode node : treeNodeList){
            if (node.left != null && node.left == currentNode ){
                return false;
            } else if (node.right != null && node.right == currentNode)
                return false;
        }
        return true;
    }

    private int getLIS(TreeNode treeNode , List<TreeNode> treeNodeList){
        if (treeNode == null)
            return 0;

        if (canChoose(treeNodeList , treeNode)){
            List<TreeNode> newTreeNodeList = new LinkedList<>();
            newTreeNodeList.addAll(treeNodeList);
            newTreeNodeList.add(treeNode);
            return Math.max(
                    1 + getLIS(treeNode.left , newTreeNodeList) + getLIS(treeNode.right , newTreeNodeList),
                    getLIS(treeNode.left , treeNodeList) + getLIS(treeNode.right , treeNodeList)
            );
        }
        return getLIS(treeNode.left , treeNodeList) + getLIS(treeNode.right , treeNodeList);
    }

    public int minCameraCover(TreeNode root) {
        totalNumberOfNodes = getNumberOfNodes(root);
        return totalNumberOfNodes - getLIS(root , new LinkedList<>());
    }
}
