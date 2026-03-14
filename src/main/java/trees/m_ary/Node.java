package trees.m_ary;
import java.util.ArrayList;
import java.util.List;

public class Node{
    public int data;
    public List<Node> children = new ArrayList<Node>();;

    public Node(final int data) {
        this.data = data;
    }
}