package trees.binary.leetcode;

import model.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author g1patil
 *
 * Given a non-empty special binary tree consisting of children with the non-negative value,
 * where each node in this tree has exactly two or zero sub-node. If the node has two sub-children,
 * then this node's value is the smaller value among its two sub-children.
 * More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the children' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 */
public class SecondMinimumNodeInBT {

    Queue<TreeNode> treeNodePriorityQueue = new PriorityQueue<>(Comparator.comparingInt(TreeNode::getVal));
    Queue<Integer> integerQueue = new PriorityQueue<>();

    public int findSecondMinimumValue(TreeNode root) {
        treeNodePriorityQueue.add(root);

        while (!treeNodePriorityQueue.isEmpty()){
            TreeNode treeNode = treeNodePriorityQueue.remove();
            if (treeNode == null)
                continue;
            if (!integerQueue.contains(treeNode.getVal()) && integerQueue.size() < 3)
                integerQueue.add(treeNode.getVal());

            if (treeNode.left!=null)
                treeNodePriorityQueue.add(treeNode.left);

            if (treeNode.right!=null)
                treeNodePriorityQueue.add(treeNode.right);
        }

        if (integerQueue.size() == 1 || integerQueue.isEmpty())
            return -1;

        integerQueue.remove();
        return integerQueue.remove();
    }
}
