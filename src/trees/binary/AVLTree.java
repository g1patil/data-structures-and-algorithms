package trees.binary;

import trees.AVLNode;
import trees.Tree;

/**
 * @auther g1patil
 */
public class AVLTree <T extends Comparable<T>>  implements Tree {

    private trees.AVLNode<T> root;

    @Override
    public Tree insert(Comparable data_) {
        root = insert(data_ , root);
        return this;
    }

    private AVLNode insert(Comparable data,AVLNode<T> node_){
        if ( node_ == null)
            return new AVLNode(data);

        if ( data.compareTo(node_.getData()) < 0){
            node_.setLeftChild(insert(data , node_.getLeftChild()));
        } else if (data.compareTo(node_.getData()) > 0){
            node_.setRightChild(insert(data , node_.getRightChild()));
        } else {
            return node_ ;
        }
        updateHeight(node_);
        return applyRotation(node_);
    }

    private int getBalanceFactor(AVLNode<T> node_ ){
        if (node_ == null){
            return 0 ;
        }

        if (node_.getLeftChild() == null && node_.getRightChild() == null)
            return 0 ;

        if (node_.getRightChild() == null || node_.getRightChild() == null){
            return height(node_.getLeftChild()) +  height(node_.getRightChild()) + 1 ;
        }
        return node_ == null ? 0 : height(node_.getLeftChild()) - height(node_.getRightChild());
    }

    private int height(AVLNode node_){
        return node_ == null ? 0 : node_.getHeight() ;
    }

    private void updateHeight(AVLNode<T> node_) {
        int height = Math.max(
                height(node_.getLeftChild()) ,
                height(node_.getRightChild())
        );
        if (node_.getLeftChild() == null && node_.getRightChild() == null){
            node_.setHeight(0);
            return;
        }
        node_.setHeight(height + 1 );
    }

    @Override
    public void delete(Comparable data) {

    }

    @Override
    public void traverse() {
        inorderTraversal(root);
    }

    private void inorderTraversal(AVLNode<T> node_){
        if (node_ != null){
            inorderTraversal(node_.getLeftChild());
            System.out.println(node_);
            inorderTraversal(node_.getRightChild());
        }
    }

    @Override
    public Comparable getMax() {
        return null;
    }

    @Override
    public Comparable getMin() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private AVLNode<T> applyRotation(AVLNode<T> node){
        int balance = getBalanceFactor(node);

        if ( balance > 1) {
            if (getBalanceFactor(node.getLeftChild()) < 0 ){
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }

        if ( balance < -1) {
            if (getBalanceFactor(node.getRightChild()) > 0 ){
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }

        return node;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> node){
        AVLNode<T> rightNode = node.getRightChild();
        AVLNode<T> centerNode = rightNode.getLeftChild();

        if(centerNode == null){
            rightNode.setLeftChild(node);
            centerNode.setRightChild(rightNode);
            centerNode.setLeftChild(node);
            rightNode.setLeftChild(centerNode.getRightChild());
            node.setRightChild(centerNode.getLeftChild());
            updateHeight(node);
            updateHeight(rightNode);
            return centerNode;
        } else {
            rightNode.setLeftChild(node);
            node.setRightChild(centerNode);
            updateHeight(node);
            updateHeight(rightNode);
            return centerNode;

        }

    }

    /**
     *        n1
     *      /
     *     n2
     *    / \
     *   n3  n4
     *  n1 = node
     *  n2 = leftNode
     *  n4 = centerNode
     *
     *        n2
     *      /   \
     *     n3     n1
     *          /
     *         n4
     * */
    private AVLNode<T> rotateRight(AVLNode<T> node){
        AVLNode<T> leftNode = node.getLeftChild();
        AVLNode<T> centerNode = leftNode.getRightChild();

        if (centerNode == null){
            leftNode.setRightChild(node);
            node.setLeftChild(centerNode);
            updateHeight(node);
            updateHeight(leftNode);

            return leftNode;
        } else {
            centerNode.setRightChild(node);
            centerNode.setLeftChild(leftNode);
            node.setLeftChild(null);
            leftNode.setRightChild(null);
            updateHeight(node);
            updateHeight(leftNode);
            return centerNode;
        }

    }
}
