/* Kent Vo */

package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayLinearList<E> implements LinearListADT<E> {

    // Private encapsulates within this class to use only and nowhere else.
    private E[] storage;    // Generic array of data type E.
    private int currentSize, maxSize, front, rear;

    // Constructor to initialize newly created objects before being used.
    public ArrayLinearList(int size) {
        rear = 1;
        maxSize = size;
        currentSize = front = 0;
        storage = (E[]) new Object[maxSize];
        }

    // "this" differentiate instance variable from local variable.
    // "this()" points to constructor of the class and is the same as saying
    // "ArrayLinearList(DEFAULT_MAX_CAPACITY)"
    public ArrayLinearList() { this(DEFAULT_MAX_CAPACITY); } 

    public boolean addFirst(E obj) {
        if(currentSize == maxSize) // Checks if list is full.
            return false;
        storage[front--] = obj; // Returns original value then decrements.
        if(front == -1) // Resets pointer to the end.
            front += maxSize; // Shorthand for: front = front + maxSize
        currentSize++;
        return true;
        }
    
    public boolean addLast(E obj) {
        if(currentSize == maxSize) // Checks if list is full.
            return false;
        storage[rear++] = obj;  // Returns original value then increments.
        if(rear == maxSize) // Resets pointer to the beginning.
            rear = 0;
        currentSize++;
        return true;
        }

    public E removeFirst() {
        E tmp;
        if(currentSize == 0) // Checks if list is empty.
            return null;
        // Remove first value if front is at end of array
        if(front == (maxSize - 1)) {
            tmp = storage[0];
            front = 0;
            currentSize -= 1;
            return tmp;
            }
        // Iterator skips over index to remove.
        tmp = storage[++front]; // Increments then returns value.
        currentSize -= 1;
        return tmp;
        }

    public E removeLast() {
        E tmp;
        if(currentSize == 0)
            return null;
        // Remove last value if rear is at start of array
        if(rear == 0){
            tmp = storage[maxSize - 1];
            rear = maxSize - 1;
            currentSize -= 1;
            return tmp;
        }
        // Iterator skips over index to remove.
        tmp = storage[--rear];
        currentSize -= 1;
        return tmp;
    }

    public E remove(E obj) {
        if(currentSize == 0) // Checks if list is empty.
            return null;
        E tmp;
        int position;
        position = indexOf(obj);
        if(position >= 0){
            tmp = storage[position];
                if(tmp == obj){
                    if((position == (rear - 1)) || (rear == 0 && position == (maxSize - 1))) {
                        removeLast();
                        return tmp;
                    }
                    if(position == (front +1) || (front == (maxSize -1) && position == 0)) {
                        removeFirst();
                        return tmp;
                    }
                    if(currentSize == 1) {
                        removeLast();
                        return tmp;
                    }
                    while(position != front) {
                        if(position == 0){
                            storage[position] = storage[(maxSize - 1)];
                            position = (maxSize -1);
                        }
                        else
                            storage[position] = storage[--position];
                    }
                    front++;
                    currentSize -= 1;
                    return tmp; // Returns the removed obj.
                }
        }
        return null; // Null if not found.
    }

    public E peekFirst() {
        if(currentSize == 0)
            return null;
        if(front == (maxSize - 1))
            return storage[0];
        return storage[front + 1];
    }

    public E peekLast() {
        if(currentSize == 0)
            return null;
        if(rear == 0) return storage[maxSize -1];
        return storage[rear - 1];
    }

    public boolean contains(E obj) {
        if(find(obj) != null)
            return true;
        return false;
    }

    public E find(E obj) {
        int index = front + 1;
        if(index == maxSize)
            index = 0;
        int count = 0;
        while(count != currentSize) {
            if(index == maxSize)
                index = 0;
            if(((Comparable<E>)obj).compareTo(storage[index]) == 0)
                return storage[index];
            index++;
            count++;
        }
        return null;
    }

    public void clear() { currentSize = front = 0; rear = 1; }
    
    public boolean isEmpty() {
        if(currentSize == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if(currentSize == maxSize)
            return true;
        return false;
    }
    
    public int size() { return currentSize; }
    
    public Iterator<E> iterator() { return new IteratorHelper<E>(); }

    // Returns index of obj in array if found, otherwise null.
    private int indexOf(E obj) {
        int index = front + 1;
        if(index == maxSize)index = 0;
        int count = 0;
        while(count != currentSize){
            if(index == maxSize)index = 0;
            if(((Comparable<E>)obj).compareTo(storage[index]) == 0)
                return index;
            index++;
            count++;
        }
        return -1;
    }
    
    private class IteratorHelper<E> implements Iterator<E> {

        private int index;
        private long count;

        public IteratorHelper() { index = front; count = 0;}
        
        public boolean hasNext() { return count != currentSize; }
        
        public E next() {
            if(!hasNext()){ throw new NoSuchElementException(); }
            index++;
            count++;
            if(index == maxSize) index = 0;
            return (E) storage[index];
        }
        
        public void remove() { throw new UnsupportedOperationException(); }
    }
}

