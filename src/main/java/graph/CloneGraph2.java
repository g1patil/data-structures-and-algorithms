package graph;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 * 133. Clone Graph
 */
@Quality(value = Stage.TESTED , details = "passes all the test cases")
@Platform(Site.LEETCODE)
public class CloneGraph2 {

     static class Node{
         public int val;
         public List<Node> neighbors;
         public Node() {
             val = 0;
             neighbors = new ArrayList<Node>();
         }
         public Node(int _val) {
             val = _val;
             neighbors = new ArrayList<Node>();
         }
         public Node(int _val, ArrayList<Node> _neighbors) {
             val = _val;
             neighbors = _neighbors;
         }

    }

    public Node root;
     Set<Integer> visited = new HashSet<>();
     HashMap<Node , Node> nodes = new HashMap<>();

    public Node cloneGraph(Node node , Node root) {
        if (root == null )
            root = new Node(node.val);


        for (Node child : node.neighbors){
            if (!visited.contains(node.hashCode() + child.hashCode())){
                Node newChild = nodes.containsKey(child) ? nodes.get(child) : new Node(child.val);

                root.neighbors.add(newChild);
                newChild.neighbors.add(root);

                visited.add(node.hashCode() + child.hashCode());
                nodes.put(node, root);
                nodes.put(child, newChild);

                cloneGraph(child ,newChild );
            }

        }
        return root;
    }

    @Test
    public void test_(){
         Node node1 = new Node(1);
         Node node2 = new Node(2);
         Node node3 = new Node(3);
         Node node4 = new Node(4);

         node1.neighbors.add(node2);
         node1.neighbors.add(node4);

         node2.neighbors.add(node1);
         node2.neighbors.add(node3);

         node3.neighbors.add(node2);
         node3.neighbors.add(node4);


         node4.neighbors.add(node1);
         node4.neighbors.add(node3);

         root = cloneGraph(node1 , root);
    }


}


