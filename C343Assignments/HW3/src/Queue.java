class EmptyQueueE extends Exception{}

public class Queue<E> {
    private DoublyLinkedList<E> q;
    private int size;

    // TODO: default constructor
    public Queue(){
        q = new DoublyLinkedList<>();
        size = 0;
    }

    // TODO: Put element at end of queue
    // this will add the value to the end of th queue
    public void enqueue(E elem){
        q.insertAtTail(elem);
        size++;
    }

    // TODO: Return the head of the queue; If there's nothing to return then throw EmptyQueueE
    public E dequeue() throws EmptyQueueE, EmptyListE {
        if(q.equals(null)) {
            throw new EmptyQueueE();
        }
        size--;
        return q.deleteAtHead();
    }

    // TODO: Without affecting the queue, return the element at the top of the queue
    public E peek() throws IndexOutOfBoundsException,{
        
    }

    public int size() {
        return this.size;
    }

    // TODO: Checks if inputted is the same Queue
    public boolean equals(Object o){
        if(o == this) {
            return true;
        }
        if(!o inst)
        return false;
    }

    public String toString(){
        return "" + q.size();
    }
}
