class EmptyListE extends Exception{}

public class DoublyLinkedList<E> {

    private NodeDL<E> head;
    private NodeDL<E> tail;
    private int size;

    // TODO: default constructor
    public DoublyLinkedList(){
    }

    // TODO: secondary constructor
    public DoublyLinkedList(NodeDL<E> head, NodeDL<E> tail){
    }

    public int size() {
        return this.size;
    }

    // TODO: Insert elem at the start of the DoublyLinkedList
    void insertAtHead(E elem){

    }

    // TODO: Insert elem at the end of the DoublyLinkedList
    void insertAtTail(E elem){

    }

    // TODO: Delete the element from the start of the DoublyLinkedList. Throw an EmptyListE if there's nothing to delete
    E deleteAtHead() throws EmptyListE{
        return null;
    }


    // TODO: Delete the element from the end of the DoublyLinkedList. Throw an EmptyListE if there's nothing to delete
    E deleteAtTail() throws EmptyListE{
        return null;
    }

    // TODO: Get the element at some position. If it's not possible, throw an IndexOutOfBoundsException
    E get (int index) throws IndexOutOfBoundsException{
        return null;
    }

    // TODO: Search the DoublyLinkedList for elem. If not found, return -1;
    public int search(E elem){
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
