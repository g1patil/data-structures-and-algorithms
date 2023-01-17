package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
* Checks if the given sum exists in path. Add the root to leaf node values and check if there is
* possible path whose sum is equal to the target path
* */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SumExist {

    /**
     * @param node current node
     * @param sum current target sum
     * @return true/false
     * Prints the value of the node if the target sum is found.
     * */
    boolean sumExist(Node node, int sum){

        if(sum == 0 ){
            return true;
        }

        if ( sumExist(node.left, sum - node.data)  ) {
            System.out.println(node.data);
            return true;
        }

        if ( sumExist(node.right, sum - node.data)  ) {
            System.out.println(node.data);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        Node n1 = new Node(5);
        Node n2 = new Node(20);
        Node n3 = new Node(4);
        Node n4 = new Node(8);
        Node n5 = new Node(14);
        Node n6 = new Node(25);
        Node n7 = new Node(6);
        Node n8 = new Node(9);

        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

        n4.left = n7;
        n4.right = n8;

        new SumExist().sumExist(root,19);
    }
}
