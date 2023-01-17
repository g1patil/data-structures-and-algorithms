package graph;

public class GraphNode {
    private int data;
    private GraphNode next;

    public GraphNode(int data_ , GraphNode next_){ this.data = data_ ; this.next = next_; }

    public GraphNode getNext(){
        return this.next;
    }

    public void setNext(GraphNode next) {
        this.next = next;
    }

}
