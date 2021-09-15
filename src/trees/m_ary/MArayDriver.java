package trees.m_ary;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MArayDriver {

    Set<Integer> traverseTree(Node node){
        
        Set<Integer> set = new TreeSet<>();
        if(node == null){
            return null;
        }

        if(!node.nodes.isEmpty()){
            node.nodes.forEach(consumer->{
                set.addAll(traverseTree(consumer));
            });
        }

        set.add(node.data);
        return set;
    }
    public static void main(String[] args) {
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

        n1.nodes.addAll(List.of(n5,n6));
        n2.nodes.addAll(List.of(n3));
        n3.nodes.addAll(List.of(n8,n9));
        n9.nodes.addAll(List.of(n7));

        root.nodes.addAll(List.of(n1,n2,n3,n4));

        MArayDriver obj = new MArayDriver();
        obj.traverseTree(root).forEach(a->{
            System.out.println(a);
        });
        
    }
}