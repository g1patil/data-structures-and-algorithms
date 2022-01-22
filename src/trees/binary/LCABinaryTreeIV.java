package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author g1patil
 * 1676. Lowest Common Ancestor of a Binary Tree IV
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LCABinaryTreeIV {

    TreeNode lca = null;
    int foundCount = 0 ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (nodes.length == 1)
            return nodes[0];

        Set<Integer> setOfNodes = new HashSet<>();
        for (TreeNode node : nodes)
            setOfNodes.add(node.val);

        lowestCommonAncestorHelper(root , setOfNodes);
        return lca ;
    }

    private int lowestCommonAncestorHelper(TreeNode root, Set<Integer> setOfNodes) {
        if (root == null)
            return 0 ;
        int left = lowestCommonAncestorHelper(root.left , setOfNodes);
        int right = lowestCommonAncestorHelper(root.right , setOfNodes);

        foundCount = left + right ;
        if (setOfNodes.contains(root.val)){
            foundCount++;
        }

        if (foundCount == setOfNodes.size() && lca == null){
            lca = root;
        }
        return foundCount;
    }
}
