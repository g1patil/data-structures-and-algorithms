package data;

public class TreeNode {
    private int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }
}
