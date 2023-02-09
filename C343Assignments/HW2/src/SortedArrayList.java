public class SortedArrayList<E extends Comparable> extends List<E> {

    private int size;
    private int capacity;
    private Object[] ls; // list maintained in the sorted order


    private void resizeArray() {
        Object[] newArray = new Object[ls.length * 2+1];
        for (int i = 0; i < ls.length; i++) {
            newArray[i] = ls[i];
        }
        newArray = ls;
    }
    private int findIndex(E element) {
        int left = 0;
        int right = size - 1;
        while(left <= right) {
            int mid = (left + right)/2;
            E midElement = (E) ls[mid];
            int compare = midElement.compareTo(element);
            if(compare== 0) {
                return mid;
            } else if(compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    // TODO: default: should create a sortedarraylist that is capable of holding 10 element
    public SortedArrayList(){
        ls = new Object[10];
        size = 0;
    }


    // TODO: second constructor - should create a sortedarraylist that is capable of holding x element that size
    public SortedArrayList(Class<E> c, int capacity){
        ls = new Object[capacity];
        size = capacity;
    }

    public int size(){
        return this.size;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return (E) this.ls[index];
    }

    //TODO: inserts element while maintaining the sorted order of the contents; resize to double capacity if no space
    public void add(E value) {
        int index = findIndex(value);
        for(int i = size - 1; i >= index; i--) {
            ls[i+1] = ls[i];
        }
        ls[index] = value;
        size++;
    }
    private boolean isEmpty() {
        return size == 0;
    }




    // TODO: delete - deletes an element at said index; moves elements such that there are no gaps in between them
    public void delete(int index) throws IndexOutOfBoundsException{
        for(int i = index; i < size -1; i++) {
            ls[i] = ls[i+1];
        }
        size--;
    }

    // TODO: search - binary search O(log(n)) for the element; returns -1 if not found
    public int search(E value){
        int low = 0;
        int high = size - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(value.toString().equals(ls[mid].toString())) {
                return mid;
            } else if(value.toString().compareTo(ls[mid].toString()) > 0) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }

    // TODO: given some other sortedarraylist, compare it to see if it has the same contents (also in same order)
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        SortedArrayList<Comparable> that = new SortedArrayList<>();
        return this.equals(that);
    }

    // helper
    public String toString(){
        String ret = "";
        for(int i = 0; i < this.capacity; i++){
            ret += i + ": "+ this.ls[i] + "\n";
        }
        return ret;
    }

}
