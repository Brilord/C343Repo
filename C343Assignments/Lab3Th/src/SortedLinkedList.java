public class SortedLinkedList {
    /**
     * The 0th indexed Node in the list.
     */
    Node head;
    private int size;
    /**
     * Creates a SortedLinkedList.
     */
    public SortedLinkedList() {
        head = null;
        size = 10;
    }
    public SortedLinkedList(int capacity) {
        head = null;
        size = capacity;
    }

    public boolean isEmpty() {
        return (head == null);
    }
    /**
     * Inserts the given data at a location that maintains sorted order (ascending).
     * @param data The value to be inserted into the list.
     */
    public void insertSorted(int data) {
        // make the new node to insert to the array
        Node newNode = new Node(data);
        if(isEmpty()) {
            head = newNode;
            size++;
        } else if(data - head.data < 0) {
            newNode.next = head;
            head = newNode;
            size++;
        } else {
            Node after = head.next;
            Node before = head;
            while(after != null) {
                if(data - after.data < 0) {
                    break;
                }
                before = after;
                after = after.next;
            }
            newNode.next = before.next;
            before.next = newNode;
            size++;
        }
    }

    /**
     * Deletes the Node at the given index. Throws an IndexOutOfBoundException if index
     * is negative or too large.
     * @param idx Index of the int to be deleted.
     */
    public void delete(int idx) {
        if(idx < 0 || idx >= size){
            throw new IndexOutOfBoundsException();
        }
        Node ptr = head, prev = null;
        if(idx == 0) {
            head = head.next;
            size--;
        }
        for(int i = 0; i < idx; i++) {
            prev = ptr;
            ptr = ptr.next;
        }
        // unlink the node from the list
        prev.next = ptr.next;
        size--;

    }

    /**
     * Gets the int at the given index. Throws an IndexOutOfBoundException if index
     * is negative or too large.
     * @param idx Index of the int to be return.
     * @return The int at the given index
     */
    public int get(int idx) {
        if(idx < 0 || idx >= size){
            throw new IndexOutOfBoundsException();
        }
        Node ptr = head;
        for(int i = 0; i < idx; i++ ) {
            ptr = ptr.next;
        }
        return ptr.data;
    }

    /**
     * Searches for the given int and returns its index if found. If the int is not
     * found, returns -1.
     * @param data The int to search for.
     * @return The data at the given index
     */
    public int search(int data) {
        if(size == 0) {
            return -1;
        }
        Node ptr = head;
        int index = 0;
        while(ptr != null) {
            if(data == ptr.data){
                return index;
            }
            index++;
            ptr = ptr.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        return printList();
    }

    /**
     * A recursive helper for toString that generates a String representation of this.
     * @return A String representation of the this.
     */
    private String printList() {
        String listStr = "";
        String delimiter = ", ";
        Node cur = head;
        while (cur != null) {
            listStr += cur.data + delimiter;
            cur = cur.next;
        }

        return listStr.substring(0, listStr.length()-delimiter.length());
    }
}
