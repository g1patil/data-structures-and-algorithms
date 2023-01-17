package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 1650. Lowest Common Ancestor of a Binary Tree III
 */

@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LCABT3 {

    public int foundCount = 0 ;

    public Node getRootNode(Node node){
        Node temp = node;

        while(temp.parent != null){
            temp = temp.parent;
        }

        return temp;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        Node rootNode = getRootNode(p);
        Node lcaNode =  lowestCommonAncestorHelper(rootNode , p , q);
        return foundCount == 2 ? lcaNode : null;
    }

    public Node lowestCommonAncestorHelper(Node root, Node p, Node q) {
        if(root == null)
            return root;

        Node left = lowestCommonAncestorHelper(root.left , p , q);
        Node right = lowestCommonAncestorHelper(root.right , p , q);

        if(root == p){
            foundCount++;
            return root;
        }

        if(root == q){
            foundCount++;
            return root;
        }

        return left == null ? right : right == null ? left : root;
    }
}
