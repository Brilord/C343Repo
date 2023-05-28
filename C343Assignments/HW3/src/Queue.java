class EmptyQueueE extends Exception{}

public class Queue<E> {
    private DoublyLinkedList<E> q;
    private int size;

    // TODO: default constructor
    public Queue(){
        q = new DoublyLinkedList<>();
    }

    // TODO: Put element at end of queue
    public void enqueue(E elem){
        q.insertAtTail(elem);
    }

    // TODO: Return the head of the queue; If there's nothing to return then throw EmptyQueueE
    public E dequeue() throws EmptyQueueE {
        if(q.isEmpty())
    }

    // TODO: Without affecting the queue, return the element at the top of the queue
    public E peek() throws EmptyQueueE{
        if (q.equals(null)) {
            throw new EmptyQueueE();
        }
        return q.get(size);
    }

    public int size() {
        return this.size;
    }

    // TODO: Checks if inputted is the same Queue
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Queue)) {
            return false;
        }
        Queue<?> otherQueue = (Queue<?>) o;
        return q.equals(otherQueue.q);
    }

    public String toString(){
        return "" + q.size();
    }
}
