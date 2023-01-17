package graph;

/**
 * Model class for tree node. This class only only limited to node with at most two children only.
 * Binary tree is the perfect example of this.
 * */
public class TreeNode {
    public int data;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode(int data){
        this.data = data ;
        this.rightNode = null;
        this.leftNode = null;
    }

    public TreeNode(int data , TreeNode r , TreeNode l ){
        this.data = data ;
        this.leftNode = l ;
        this.rightNode = r ;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setChild(TreeNode leftNode , TreeNode rightNode){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public boolean isLeaf(){
        return this.leftNode == null && this.rightNode == null;
    }
}
