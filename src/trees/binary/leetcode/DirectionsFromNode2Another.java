package trees.binary.leetcode;

import annotation.Quality;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author g1patil
 *
 * 2096. Step-By-Step Directions From a Binary Tree Node to Another
 *
 */
@Quality(Stage.INCOMPLETE)
public class DirectionsFromNode2Another {

    boolean found = false;
    Stack<Integer> integerStack = new Stack<>();
    StringBuilder stringBuilder = new StringBuilder();

    static Logger log = Logger.getLogger(DirectionsFromNode2Another.class.getName());

    private void distanceHelper(TreeNode treeNode , DIRECTION direction , int source , int destination){
        if (treeNode == null)
            return;

        integerStack.push(treeNode.getData());

        if (integerStack.peek() == source || integerStack.peek() == destination){
            found = true;
        }
        if (found)
            stringBuilder.append(direction.name()).append("\t");
        log.log(Level.INFO , "Node value is : {0} , direction : {1}" , new Object[]{ integerStack.peek(), direction.name()});

        distanceHelper(treeNode.left , DIRECTION.LEFT , source , destination);
        distanceHelper(treeNode.right , DIRECTION.RIGHT , source , destination);
        integerStack.pop();
        log.log(Level.INFO , "Node value is : {0} , direction : {1}" , new Object[]{ integerStack.peek(), DIRECTION.UP});

    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(1);
        n1.setChild(new TreeNode(2) , new TreeNode(3));
        distanceHelper(n1, DIRECTION.LEFT , -1 , -1);
    }
}

enum DIRECTION {
    RIGHT("RIGHT"),
    LEFT("LEFT"),
    UP("UP"),
    DOWN("DOWN");

    DIRECTION(String right) {
    }
}
