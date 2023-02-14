class EmptyListE extends Exception{}

public class DoublyLinkedList<E> {

    private NodeDL<E> head;
    private NodeDL<E> tail;
    private int size;

    // TODO: default constructor
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // TODO: secondary constructor
    public DoublyLinkedList(NodeDL<E> head, NodeDL<E> tail){
        this.head = head;
        this.tail = tail;
        this.size = 0;

    }

    public int size() {
        return this.size;
    }

    // TODO: Insert elem at the start of the DoublyLinkedList
    void insertAtHead(E elem){
        NodeDL<E> newNode = new NodeDL<>(elem);
        newNode.next = head;
        if(head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if(tail == null) {
            tail = head;
        }
        size++;
    }




    // TODO: Insert elem at the end of the DoublyLinkedList
    void insertAtTail(E elem){
        NodeDL<E> newNode = new NodeDL<>(elem);
        newNode.prev = tail;
        if(tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if(head == null) {
            head = tail;
        }
        size++;
    }

    // TODO: Delete the element from the start of the DoublyLinkedList. Throw an EmptyListE if there's nothing to delete
    E deleteAtHead() throws EmptyListE{
        if(head == null) {
            throw new EmptyListE();
        }
        NodeDL<E> temp = head;
        head = head.next;
        if(head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return temp.data;
    }


    // TODO: Delete the element from the end of the DoublyLinkedList. Throw an EmptyListE if there's nothing to delete
    E deleteAtTail() throws EmptyListE{
        if(tail == null) {
            throw new EmptyListE();
        }
        NodeDL<E> temp = tail;
        tail = tail.prev;
        if(tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return temp.data;
    }

    // TODO: Get the element at some position. If it's not possible, throw an IndexOutOfBoundsException
    E get (int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        NodeDL<E> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;

    }

    // TODO: Search the DoublyLinkedList for elem. If not found, return -1;
    public int search(E elem){
        int index = 0;
        NodeDL<E> current = had;
        while(current != null){
            if(current.data.equals(elem)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    // TODO: When passed some object, return true if it's a DoublyLinkedList, has the same elements in the same order.
    public boolean equals(Object o){
        return false;
    }

    public String toString(){
        String ret = "";
        NodeDL<E> temp = head;
        for(int i = 0; i < size; i++){
            ret += temp.data + " ";
            temp = temp.next;
        }
        return ret;
    }
}
