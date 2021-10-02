package trees;
import org.junit.Test;

/**
 * Find the lowest common ancestor for the given two nodes.
 * */
public class LCATree {

    static int answer = 0;

    private boolean isIsomorphicTree(int _a , int _b , Node root){
        if ( root == null ){
            return false;
        }
        if ( root.data == _a || root.data == _b ){
            return true;
        }

        boolean left = isIsomorphicTree(_a , _b , root.left) ;
        boolean right = isIsomorphicTree(_a , _b , root.right) ;

        if ( left || right ){
            if ( left && right){ answer = root.data; }
            return true;
        }

        return false;
    }

    @Test
    public void test(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(9);
        Node n7 = new Node(10);
        Node n8 = new Node(-1);
        Node n9 = new Node(3);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n6.right = n9;

        System.out.println(isIsomorphicTree(6 , 5 , n1 ) + "    " + answer );
    }
}
