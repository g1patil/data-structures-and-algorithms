package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 993. Cousins in Binary Tre
 * */
@Quality(Stage.FAILING)
@Platform(Site.LEETCODE)
public class CousinsinBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        return bfs(root,x,y);
    }

    public boolean bfs(TreeNode root , int x , int y){
        Queue<TreeNode> q = new LinkedList();
        boolean left = false , right = false;

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){

                TreeNode c = q.poll();

                if(c.val == x)
                    left = true;
                if(c.val == y)
                    right = true;

                if(root.left !=null)
                    q.add(root.left);
                if(root.right !=null)
                    q.add(root.right);
            }

            if(left != right)
                return false;
        }

        return false;
    }
}
