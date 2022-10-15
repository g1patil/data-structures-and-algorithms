package trees.binary.leetcode;

import annotation.Quality;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import trees.m_ary.Node;
import java.util.List;

/**
 * 559. Maximum Depth of N-ary Tree
 * */
@Quality(Stage.INCOMPLETE)
public class MaximumDepthofNaryTree {

    public int maxDepth(Node root) {
        return maxDepthHelper(root,0);
    }

    private int maxDepthHelper(Node root, int level ){
        if(root == null)
            return level;
        int max = level;

        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(maxDepthHelper(root.children.get(i) , level + 1), max);
        }
        return max;
    }

    @Test
    public void test(){
        Node root = new Node(10);

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        Node n5 = new Node(5);
        Node n6 = new Node(6);


        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n1.children.addAll(List.of(n5,n6));
        n2.children.addAll(List.of(n3));
        n3.children.addAll(List.of(n8,n9));
        n9.children.addAll(List.of(n7));

        root.children.addAll(List.of(n1,n2,n3,n4));

        System.out.println(maxDepth(root));
    }
}
