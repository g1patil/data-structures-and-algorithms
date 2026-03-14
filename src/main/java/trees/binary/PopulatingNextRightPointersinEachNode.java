package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author g1patil
 * 116. Populating Next Right Pointers in Each Node
 * 117. Populating Next Right Pointers in Each Node II
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class PopulatingNextRightPointersinEachNode {

    private class Node{
        int val;
        Node left;
        Node right;
        Node next;
        void setChild(Node _l, Node _r){
            this.left = _l ; this.right = _r;
        }
        Node(int _v){
            this.val = _v;
        }
    }
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            Node tempHead = null ;

            for (int i = 0; i < size; i++) {
                Node current = q.poll();

                if (tempHead == null){
                    tempHead = current;
                } else{
                    tempHead.next = current;
                    tempHead = current;
                }
                if (current.left!=null)
                    q.add(current.left);
                if (current.right!=null)
                    q.add(current.right);
            }
        }
        return root;
    }

    @Test
    public void test_(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n3.setChild(n6,n7);
        connect(n1);
    }
}
