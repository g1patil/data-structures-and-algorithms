package trees;

import org.junit.jupiter.api.Test;
import trees.binary.AVLTree;


/**
 * @auther g1patil
 */
public class TestBST {

    @Test
    public void test_(){
        AVLTree<Integer> integerTree = new AVLTree<>();
        integerTree.insert(40);
        integerTree.insert(20);
        integerTree.insert(10);
        integerTree.insert(25);
        integerTree.insert(30);
        integerTree.insert(22);

        integerTree.traverse();
    }
}
