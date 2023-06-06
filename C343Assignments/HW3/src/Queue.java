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
<<<<<<< HEAD
=======
        size++;
>>>>>>> 887b8875d5ca21ad183fb8959b375ead70ed1c96
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
<<<<<<< HEAD
    public E peek() throws EmptyQueueE{
        if (q.equals(null)) {
            throw new EmptyQueueE();
        }
        return q.get(size);
=======
    public E peek() throws IndexOutOfBoundsException,{
        
>>>>>>> 887b8875d5ca21ad183fb8959b375ead70ed1c96
    }

    public int size() {
        return this.size;
    }

    // TODO: Checks if inputted is the same Queue
    public boolean equals(Object o){
<<<<<<< HEAD
        if (o == this) {
            return true;
        }
        if (!(o instanceof Queue)) {
            return false;
        }
        Queue<?> otherQueue = (Queue<?>) o;
        return q.equals(otherQueue.q);
=======
        if(o == this) {
            return true;
        }
        if(!o inst)
        return false;
>>>>>>> 887b8875d5ca21ad183fb8959b375ead70ed1c96
    }

    public String toString(){
        return "" + q.size();
    }
}
