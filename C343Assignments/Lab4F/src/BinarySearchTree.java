public class BinarySearchTree {

    private int size;
    private BinaryTreeNode root;
    BinaryTreeNode temp = null;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public BinaryTreeNode getRoot() {
        return this.root;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * Inserts the given integer and return nothing. It inserts this int such that the tree remains a BST.
     * @param data The integer to be inserted
     */
    public void insert(int data) {
        /// the data is here
        root = insert(data, root);
        size++;
    }


    /**
     * Inserts the given integer and return nothing. It inserts this int such that the tree remains a BST.
     * @param data The integer to be inserted
     * @param curNode The current Node in the traversal
     */
    private void insert(int data, BinaryTreeNode curNode) {
        // TODO
        if (curNode == null) {
            return new BinaryTreeNode(data);
        }

        if (data < curNode.getItem()) {
            curNode.setLeft(insert(data, curNode.getLeft()));
        } else if (data > curNode.getItem()) {
            curNode.setRight(insert(data, curNode.getRight()));
        }

        return curNode;

    }

    /**
     * Deletes a Node containing the given integer. If the Node has 2 children, replaces with the Node of the minimum
     * value in the right child of the node. If the data is not present, returns null.
     * @param data The integer to be removed
     * @return The Node containing the integer to remove or null if one is not found
     */
    public BinaryTreeNode remove(int data) {
        // TODO
        BinaryTreeNode nodeToRemove = search(data, root);
        root = remove(data, root);
        if (nodeToRemove != null) {
            size--;
        }
        return nodeToRemove;
    }


    /**
     * Deletes a Node containing the given integer. If the Node has 2 children, replaces with the Node of the maximum
     * value in the left child of the node. If the data is not present, returns null.
     * @param data The integer to be removed
     * @param curNode The current Node in the traversal
     * @return The Node containing the integer to remove or null if one is not found
     */
    private BinaryTreeNode remove(int data, BinaryTreeNode curNode) {
        // TODO
        if (curNode == null) {
            return null;
        }

        if (data < curNode.getItem()) {
            curNode.setLeft(remove(data, curNode.getLeft()));
        } else if (data > curNode.getItem()) {
            curNode.setRight(remove(data, curNode.getRight()));
        } else {
            if (curNode.getLeft() == null && curNode.getRight() == null) {
                return null;
            } else if (curNode.getLeft() == null) {
                return curNode.getRight();
            } else if (curNode.getRight() == null) {
                return curNode.getLeft();
            } else {
                BinaryTreeNode minNode = findMin(curNode.getRight());
                curNode.setItem(minNode.getItem());
                curNode.setRight(remove(minNode.getItem(), curNode.getRight()));
            }
        }

        return curNode;
    }

    /**
     * A recursive method that starts at the left child of a parent and extracts the maximum from this child's tree.
     * @param curNode The current Node in the traversal
     * @return The minimum Node in the child's tree
     */
    private BinaryTreeNode extractLeftMax(BinaryTreeNode curNode) {
        // TODO
        return null;
    }

    /**
     * Returns a Node containing the given integer or null if one is not found
     * @param data The integer to search for
     * @return A Node containing the given integer or null if one is not found
     */
    public BinaryTreeNode search(int data) {
        return search(data, root);
    }

    /**
     * Returns a Node containing the given integer or null if one is not found
     * @param data The integer to search for
     * @param curNode The current Node in the traversal
     * @return A Node containing the given integer or null if one is not found
     */
    private BinaryTreeNode search(int data, BinaryTreeNode curNode) {
        // TODO
        if (curNode == null || curNode.getItem() == data) {
            return curNode;
        }

        if (data < curNode.getItem()) {
            return search(data, curNode.getLeft());
        } else {
            return search(data, curNode.getRight());
        }
    }

    /**
     * Returns the pre-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    public String getPreOrderStr() {
        // TODO
        return getPreOrderStr(root);
    }

    /**
     * Returns the pre-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    private String getPreOrderStr(BinaryTreeNode curNode) {
        // TODO
        if (curNode == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(curNode.getItem());

        if (curNode.getLeft() != null) {
            sb.append(", ");
            sb.append(getPreOrderStr(curNode.getLeft()));
        }

        if (curNode.getRight() != null) {
            sb.append(", ");
            sb.append(getPreOrderStr(curNode.getRight()));
        }

        return sb.toString();
    }

    /**
     * Returns the in-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    public String getInOrderStr() {
        // TODO
        return getInOrderStr(root);
    }

    /**
     * Returns the in-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    private String getInOrderStr(BinaryTreeNode curNode) {
        if (curNode == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        if (curNode.getLeft() != null) {
            sb.append(getInOrderStr(curNode.getLeft()));
            sb.append(", ");
        }

        sb.append(curNode.getItem());

        if (curNode.getRight() != null) {
            sb.append(", ");
            sb.append(getInOrderStr(curNode.getRight()));
        }

        return sb.toString();
    }

    /**
     * Returns the post-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    public String getPostOrderStr() {
        // TODO
        return getPostOrderStr(root);
    }

    /**
     * Returns the post-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    private String getPostOrderStr(BinaryTreeNode curNode) {
        // TODO
        if (curNode == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        if (curNode.getLeft() != null) {
            sb.append(getPostOrderStr(curNode.getLeft()));
            sb.append(", ");
        }

        if (curNode.getRight() != null) {
            sb.append(getPostOrderStr(curNode.getRight()));
            sb.append(", ");
        }

        sb.append(curNode.getItem());

        return sb.toString();
    }
}
