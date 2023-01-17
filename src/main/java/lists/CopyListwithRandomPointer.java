package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 * 138. Copy List with Random Pointer
 *
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class CopyListwithRandomPointer {

    public NodeRandom copyRandomList(NodeRandom head) {
        Map<NodeRandom , NodeRandom> map = new HashMap<>();
        NodeRandom root = new NodeRandom( -1);
        NodeRandom headCopy = head ;
        NodeRandom rootCopy  = root;

        while (headCopy != null ){
            NodeRandom newNode = new NodeRandom(headCopy.val);
            rootCopy.next = newNode ;
            map.put(headCopy , newNode );

            rootCopy = rootCopy.next;
            headCopy = headCopy.next;
        }

        headCopy = head ;
        rootCopy  = root;

        while (headCopy != null ){
            rootCopy.next.random = map.get(headCopy.random);
            rootCopy = rootCopy.next;
            headCopy = headCopy.next;
        }

        return root.next;

    }

    @Test
    public void test_(){
        NodeRandom random = new NodeRandom( 1);
        NodeRandom n2 = new NodeRandom( 2);
        NodeRandom n3 = new NodeRandom( 4);
        NodeRandom n4 = new NodeRandom( 6);

        random.next = n2 ;
        n2.next = n3;
        n3.next = n4 ;

        n2.random = n4;
        n3.random = random;

        copyRandomList(random);
    }
}

class NodeRandom {
    int val;
    NodeRandom next;
    NodeRandom random;

    public NodeRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
