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

    public void printTree(TreeNode root){
        if (root == null)
            return;
        System.out.println(root.getData());
        printTree(root.left);
        printTree(root.right);
    }

    public static void printTreeStatic(TreeNode root){
        if (root == null)
            return;
        System.out.println(root.getData());
        printTreeStatic(root.left);
        printTreeStatic(root.right);
    }
}
