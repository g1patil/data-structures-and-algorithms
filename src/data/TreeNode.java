package data;

public class TreeNode {
    private int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int data){
        this.data = data;
    }

    public void setChild(final TreeNode left, final TreeNode right){
        this.left = left ;
        this.right = right ;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }
}
