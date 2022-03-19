package trees.m_ary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author g1patil
 * 1522. Diameter of N-Ary Tree
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class DiameterOfNAryTree {

    int result = 0 ;
    public int diameter(Node root) {
        getHeight(root);
        return result;
    }

    public int getHeight(Node root){
        if (root == null)
            return 0;

        int max1 = 0;
        int max2 = 0;
        for(Node child : root.children){
            int h = getHeight(child);

            if (h > max1){
                max2 = max1;
                max1 = h;
            } else if (h > max2){
                max2 = h;
            }
        }

        result = Math.max( result , max1 + max2);
        return 1 + max1;
    }

    @Test
    public void test_(){
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
        Node n11 = new Node(11);

        n1.children.addAll(List.of(n5,n6));
        n3.children.addAll(List.of(n8,n9));
        n9.children.addAll(List.of(n7));
        n7.children.addAll(List.of(n11));

        root.children.addAll(List.of(n1,n2,n3,n4));
        System.out.println(diameter(root));
    }
}
