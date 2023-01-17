package trees.binary;

import model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author g1patil
 * 637. Average of Levels in Binary Tree
 *
 * Algo :
 * Create two array , size array and sum array
 * dfs with level of the node
 * for each level , increase the sum + node.val and size + 1
 *
 * Iterate over both array, get average, add to new list
 */
public class AverageLevelsBinaryTree {

    Map<Integer , NodeWrapper> map = new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root) {
        averageOfLevelsHelper(root , 1);
        return map.keySet().stream().map(k->map.get(k).average).collect(Collectors.toList());
    }

    /**
     * Using objects
     * */
    private void averageOfLevelsHelper(TreeNode root , int level) {
        if (root == null)
            return;

        if (!map.containsKey(level)){
            NodeWrapper nodeWrapper = new NodeWrapper(0,0.0,0.0);

            nodeWrapper.size++;
            nodeWrapper.currentSum+=root.val;
            nodeWrapper.average = nodeWrapper.currentSum/ nodeWrapper.size;

            map.put(level,nodeWrapper);
        } else {
            NodeWrapper nodeWrapper = map.get(level);

            nodeWrapper.size++;
            nodeWrapper.currentSum+=root.val;
            nodeWrapper.average = nodeWrapper.currentSum/ nodeWrapper.size;
        }

        averageOfLevelsHelper(root.left , level + 1);
        averageOfLevelsHelper(root.right , level + 1);

    }


    public List<Double> averageOfLevelsArray(TreeNode root) {
        List<Double> result = new ArrayList<>();
        averageOfLevelsHelperArray(root,0);

        for (int i = 0; i < sumArray.size(); i++) {
            result.add( sumArray.get(i)/sizeArray.get(i));
        }
        return result;
    }
    /**
     * Using array
     * 50 % faster
     * */
    List<Double> sumArray = new ArrayList<>();
    List<Integer> sizeArray = new ArrayList<>();

    private void averageOfLevelsHelperArray(TreeNode root , int level) {
        if (root == null)
            return;

        if (sizeArray.size() < level + 1){
            sizeArray.add(0);
            sumArray.add(0.0);
        }

        sizeArray.set(level , sizeArray.get(level) + 1);
        sumArray.set(level , sumArray.get(level) + root.val);

        averageOfLevelsHelperArray(root.left , level + 1);
        averageOfLevelsHelperArray(root.right , level + 1);
    }


    @Test
    public void test_(){
        TreeNode root= new TreeNode(10);
        TreeNode n1= new TreeNode(20);
        TreeNode n2= new TreeNode(100);
        TreeNode n3= new TreeNode(100);
        TreeNode n4= new TreeNode(3);
        TreeNode n5= new TreeNode(1);

        root.setChild(n1,n2);
        n1.setChild(n3,null);
        n2.setChild(n4,n5);
        System.out.println(averageOfLevelsArray(root));
    }
}


class NodeWrapper{
    int size;
    double average;
    double currentSum;

    public NodeWrapper(int _size , double _avg, double _sum){
        this.size = _size;
        this.average = _avg;
        this.currentSum = _sum;
    }
}
