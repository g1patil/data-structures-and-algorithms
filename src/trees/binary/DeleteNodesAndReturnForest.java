package trees.binary;


import model.TreeNode;

import java.util.*;

/**
 * 1110. Delete Nodes And Return Forest
 * */
public class DeleteNodesAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(parentMap,root);
        Set<TreeNode> nodeSet = new HashSet<>();
        returnForest(parentMap, nodeSet,root,to_delete);

        return new LinkedList(nodeSet);
    }

    private void returnForest(Map<TreeNode, TreeNode> parentMap, Set<TreeNode> nodeSet, TreeNode root, int[] to_delete) {
        if (root == null)
            return;

        returnForest(parentMap, nodeSet,root.left,to_delete);
        if (contains(root.val , to_delete)) {
            addToSet(parentMap,nodeSet,root);
        }
        returnForest(parentMap, nodeSet,root.right,to_delete);

    }

    private void addToSet(Map<TreeNode, TreeNode> parentMap, Set<TreeNode> nodeSet, TreeNode root) {
        TreeNode parent = parentMap.get(root);
        TreeNode left = root.left;
        TreeNode right = root.right;

        if (parent)
    }

    private void buildParentMap(Map<TreeNode, TreeNode> parentMap,TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;

        buildParentMap(parentMap,root.left);
        parentMap.put(root.left,root);
        parentMap.put(root.right,root);
        buildParentMap(parentMap,root.right);

    }

    private boolean contains(int target,int[] source){
        for (int i : source) {
            if (i == target)
                return true;
        }
        return false;
    }
}
