package model;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int val){
        this.val = val;
    }

    public void setChild(final TreeNode left, final TreeNode right){
        this.left = left ;
        this.right = right ;
    }

    public int getVal(){
        return val;
    }

    public void setVal(int val){
        this.val = val;
    }

    public void printTree(TreeNode root){
        if (root == null)
            return;
        System.out.println(root.getVal());
        printTree(root.left);
        printTree(root.right);
    }

    public static void printTreeStatic(TreeNode root){
        if (root == null)
            return;
        System.out.println(root.getVal());
        printTreeStatic(root.left);
        printTreeStatic(root.right);
    }

    @Override
    public String toString() {
        return "TreeNode{" + "val=" + val + '}';
    }
}
