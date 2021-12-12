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
    public Tree<T> insert(Comparable data) {
        if ( isEmpty()){
            root =  new Node<>(data);
        } else {
            insert(data , root);
        }
        return this;
    }

    /**
     * Adds the node to given tree/subtree. Since this is BST ,
     * we need to traverse either to right or to left and then add node.
     * This is not optimized, since smaller value will always be added to left and
     * bigger values will always be added to right. It might create skewed tree.
     * @param data data node that needs to be inserted
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
    public void delete(Comparable data) {
        root = delete(data , root );
    }

    private Node<T> delete(Comparable data , Node<T> node){
        if (node == null)
            return null;

        if ( data.compareTo(node.getData())< 0){
            node.setLeftChild( delete(data , node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0){
            node.setRightChild( delete(data , node.getRightChild()));
        } else {
            /* We reached to the node that needs to be deleted*/
            /* When node we want to delete has one child , or no child (leaf )*/
            if (node.getLeftChild() == null){
                return node.getRightChild();
            } else if ( node.getRightChild() == null){
                return node.getLeftChild();
            }

            /* Node we want to delete has the two non null child*/
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild( delete(node.getData() , node.getLeftChild()));
        }
        return node;
    }

    @Override
    public void traverse() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node){
        if (node != null){
            inorderTraversal(node.getLeftChild());
            System.out.println(node);
            inorderTraversal(node.getRightChild());
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
    public T getMin( ) {
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
