import java.util.EmptyStackException;

class EmptyStackE extends Exception{}

public class Stack<E>{
    private DoublyLinkedList<E> st;
    private int size;

    // TODO: default constructor
    public Stack(){
        st = new DoublyLinkedList<>();
        size = 0;
    }

    // TODO: Push the element to the top of stack
    public void push(E elem){
        st.insertAtTail(elem);
        size++;
    }

    // TODO: Pop the element off the top of the stack. If nothing to pop, throw EmptyStackE
    public E pop() throws EmptyStackE, EmptyListE {
        if(size == 0) {
            throw new EmptyStackE();
        }
        E elem = st.deleteAtTail();
        size--;

        return elem;
    }

    // TODO: Without affecting the stack, return the element at the top of the stack
    public E peek() throws IndexOutOfBoundsException{
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return st.get(size);
    }

    public int size() {
        return this.size;
    }

    // TODO: Check if some other object is the same Stack
    public boolean equals(Object o){
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Stack<?> otherStack = (Stack<?>) o;
        return size == otherStack.size && st.equals(otherStack.st);
    }

    public String toString(){
        return st.toString();
    }

}
