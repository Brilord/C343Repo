import java.lang.reflect.Array;
import java.util.ListIterator;

public class ArrayList<E extends Comparable> extends List<E> {
    private int size;
    private int capacity;
    private Object[] ls;
    private void ensureCapacity() {
        if(size > ls.length) {
            Object[] newData = new Object[ls.length*2+1];
            System.arraycopy(ls,0,newData,0,ls.length);
            ls = newData;
        }
    }

    // TODO: default: should create an arraylist that is capable of holding 10 element
    public ArrayList(){
        ls = new Object[10];
        size = 0;
    }

    // TODO: second constructor - should create an arraylist that is capable of holding x element
    public ArrayList(int capacity){

        size = capacity;
        ls = new Object[capacity];

    }
    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return this.size;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        return (E) this.ls[index];
    }

    // TODO: insert --> takes some element and inserts it at the end of the arraylist, resizes to double capacity if no space
    public void add(E value){
        if(size == ls.length) {
            makeArrayBigger();
        }
        ls[size++] = value;
    }



    // TODO: delete - deletes an element at said index; moves elements such that there are no gaps in between them
    public void delete(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Object element = ls[index];
        for(int i = index; i < size - 1; i++) {
            ls[i] = ls[i+1];
        }
        ls[--size] = null;
    }

    // TODO: searches one by one to find the element, if it doesn't exist then return -1
    public int search (E value){
        for (int i = 0; i < size; i++) {
            if (value.equals(ls[i])) {
                return i;
            }

        }
        return -1;
    }

    // TODO: given some other arraylist, compare it to see if it has the same contents
    public boolean equals (Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList list = (ArrayList) o;
        return this.equals(list);
    }



    // to help you
    public String toString () {
        String ret = "";
        for (int i = 0; i < this.size; i++) {
            ret += i + ": " + this.ls[i] + "\n";
        }
        return ret;
    }
    private void makeArrayBigger() {
        Object[] newArray = new Object[ls.length * 2];
        for(int i = 0; i < ls.length; i++) {
            newArray[i] = ls[i];
        }
        ls = newArray;
    }
}

