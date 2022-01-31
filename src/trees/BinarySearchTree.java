package trees;

/**
 * @author g1patil
 *
 * This is straight implementation of the BST using the YT channel Geekific
 * Reference : https://www.youtube.com/watch?v=zIX3zQP0khM
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree{

    private Node<T> root;


    /**
     * Inserts the node in the tree. Calls the helper method to traverse
     * and add the node to right location.
     * Creates tree if null , or adds node.
     * */
    @Override
    public Tree<T> insert(Comparable data_) {
        if ( isEmpty()){
            root =  new Node<>(data_);
        } else {
            insert(data_ , root);
        }
        return this;
    }

    /**
     * Adds the node to given tree/subtree. Since this is BST ,
     * we need to traverse either to right or to left and then add node.
     * This is not optimized, since smaller value will always be added to left and
     * bigger values will always be added to right. It might create skewed tree.
     * @param data val node that needs to be inserted
     * @param node subtree node, with whom we will compare the value
     * */
    private void insert(Comparable data, Node<T> node){
        /* traverse to the left*/
        if (data.compareTo(node.getData()) < 0){
            if (node.getLeftChild() == null){
                /* location found !! Add to the left*/
                Node<T> newNode = new Node<>(data);
                node.setLeftChild(newNode);
            } else {
                /* keep traversing since there exist a child*/
                insert(data , node.getLeftChild());
            }
            /* traverse to the right*/
        } else if (data.compareTo(node.getData()) > 0){
            if (node.getRightChild() == null){
                /* location found !! Add to the right*/
                Node<T> newNode = new Node<>(data);
                node.setRightChild(newNode);
            } else {
                /* keep traversing since there exist a child*/
                insert(data , node.getRightChild());
            }
        }
    }

    @Override
    public void delete(Comparable data_) {
        root = delete(data_ , root );
    }

    private Node<T> delete(Comparable data , Node<T> node_){
        if (node_ == null)
            return null;

        if ( data.compareTo(node_.getData())< 0){
            node_.setLeftChild( delete(data , node_.getLeftChild()));
        } else if (data.compareTo(node_.getData()) > 0){
            node_.setRightChild( delete(data , node_.getRightChild()));
        } else {
            /* We reached to the node_ that needs to be deleted*/
            /* When node_ we want to delete has one child , or no child (leaf )*/
            if (node_.getLeftChild() == null){
                return node_.getRightChild();
            } else if ( node_.getRightChild() == null){
                return node_.getLeftChild();
            }

            /* Node we want to delete has the two non null child*/
            node_.setData(getMax(node_.getLeftChild()));
            node_.setLeftChild( delete(node_.getData() , node_.getLeftChild()));
        }
        return node_;
    }

    @Override
    public void traverse() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node_){
        if (node_ != null){
            inorderTraversal(node_.getLeftChild());
            System.out.println(node_);
            inorderTraversal(node_.getRightChild());
        }
    }

    @Override
    public T getMax() {
        if (isEmpty())
            return null ;

        Node<T> node = root ;

        while (node.getLeftChild() != null)
            node = node.getRightChild();
        return node.getData();
    }

    public T getMax(Node<T> root_) {
        if (root_ == null)
            return null ;

        Node<T> node = root_ ;

        while (node.getLeftChild() != null)
            node = node.getRightChild();
        return node.getData();
    }

    @Override
    public T getMin() {
        if (isEmpty())
            return null ;

        Node<T> node = root ;

        while (node.getLeftChild() != null)
            node = node.getLeftChild();
        return node.getData();
    }

    @Override
    public boolean isEmpty() {
        return root == null ;
    }
}
