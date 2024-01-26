import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> implements Tree<E> {

    private int height;
    private int size;
    private BinaryNode<E> root;

    public BST(){
        this.root = null;
        this.height = 0;
        this.size = 0;
    }

    // TODO: BST
    public BST(BinaryNode<E> root){
        this.root = null;
        this.height = 0;
        this.size = 0;
    }

    // Access field
    public BinaryNode<E> root() {
        return this.root;
    }

    // Basic properties
    public int height() {
        return this.height;
    }
    public int size() {
        return this.size;
    }
    public boolean isBalanced() {
        return root.isBalanced();
    }

    // TODO: updateHeight - Update the root height to reflect any changes
    public void updateHeight() {
        if(root != null) {
            root.updateHeight();
        }
    }

    // Traversals that return lists
    // TODO: Preorder traversal
    public List<E> preOrderList() {
        List<E> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return result;
    }

    // TODO: Inorder traversal
    public List<E> inOrderList() {
        List<E> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    // TODO: Postorder traversal
    public List<E> postOrderList() {
        List<E> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }

    // Helpers for BST/AVL methods
    // TODO: extractRightMost
    //    This will be called on the left subtree and will get the maximum value.
    public BinaryNode<E> extractRightMost(BinaryNode<E> curNode) {
        if(curNode == null) {
            return null;
        }
        if(curNode.right() == null) {
            return curNode;
        }
        return extractRightMost(curNode.right());
    }

    // AVL & BST Search & insert same
    // TODO: search
    public BinaryNode<E> search(E elem) {
        return searchNode(root, elem);
    }

    // helper method to search for a node with a given element
    private BinaryNode<E> searchNode(BinaryNode<E> node, E elem){
        if (node == null || node.element().equals(elem)) {
            return node;
        }
        int cmp = elem.compareTo(node.element());
        if (cmp < 0) {
            return searchNode(node.left(), elem);
        } else {
            return searchNode(node.right(), elem);
        }
    }

    // TODO: insert
    public void insert(E elem) {
        root = insertNode(root, elem);
        size++;
        updateHeight();
    }

    private BinaryNode<E> insertNode(BinaryNode<E> node, E elem) {
        if (node == null) {
            return new BinaryNode<>(elem);
        }
        int cmp = elem.compareTo(node.element());
        if (cmp < 0) {
            node.setLeft(insertNode(node.left(), elem));
        } else if (cmp > 0) {
            node.setRight(insertNode(node.right(), elem));
        }
        return node;
    }

    private BinaryNode<E> deleteNode(BinaryNode<E> node, E elem) {
        if (node == null) {
            return null;
        }
        int cmp = elem.compareTo(node.element());
        if (cmp < 0) {
            node.setLeft(deleteNode(node.left(), elem));
        } else if (cmp > 0) {
            node.setRight(deleteNode(node.right(), elem));
        } else {
            if (node.left() == null) {
                return node.right();
            } else if (node.right() == null) {
                return node.left();
            }
            BinaryNode<E> rightMost = extractRightMost(node.left());
            node.setData(rightMost.element());
            node.setLeft(deleteNode(node.left(), rightMost.element()));
        }
        return node;
    }

    // TODO: delete
    public BinaryNode<E> delete(E elem) {
        BinaryNode<E> deleteNode = deleteNode(root, elem);
        if(deleteNode != null) {
            size--;
            updateHeight();
        }

        return deleteNode;
    }

    // Stuff to help you debug if you want
    // Can ignore or use to see if it works.
    static <E extends Comparable<E>> Tree<E> mkBST (Collection<E> elems) {
        Tree<E> result = new BST<>();
        for (E e : elems) result.insert(e);
        return result;
    }
    public TreePrinter.PrintableNode getLeft() {
        return this.root.hasLeft() ? this.root.left() : null;
    }
    public TreePrinter.PrintableNode getRight() {
        return this.root.hasRight() ? this.root.right() : null;
    }
    public String getText() {
        return (this.root != null) ? this.root.getText() : "";
    }
}
