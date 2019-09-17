package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The ArrayLinearList implementation Class for {@link LinearListADT.class}.
 *
 * @version     0.1.0 01 Oct 2015
 * @author      Kent Vo
 */
public class ArrayLinearList<E> implements LinearListADT<E> {
    /* A circular array list implementation for the LinearListADT interface. */

    private E[] storage;
    private int maxSize;
    private int currentSize = 0;
    private int front = 0;
    private int rear = 1;

    /**
     * Set the default maximum size for the list.
     */
    public ArrayLinearList() {
        this(DEFAULT_MAX_CAPACITY);
    }

    /**
     * Set a specific maximum size for the list.
     * 
     * @param size the specified size
     */
    public ArrayLinearList(int size) {
        maxSize = size;
        storage = (E[]) new Object[maxSize];
    }

    /**
     * Add an object to the beginning of the list.
     *
     * @param obj the object to add
     * @return false if list is full; otherwise true
     */
    public boolean addFirst(E obj) {
        if(currentSize == maxSize) {
            return false;
        }
        storage[front--] = obj;

        if(front == -1) {
            front += maxSize;
        }
        currentSize++;
        return true;
    }

    /**
     * Add an object to the end of the list.
     *
     * @param obj the object to add
     * @return false if list is full; otherwise true
     */
    public boolean addLast(E obj) {
        if(currentSize == maxSize) {
            return false;
        }
        storage[rear++] = obj;

        if(rear == maxSize) {
            rear = 0;
        }
        currentSize++;
        return true;
    }

    /**
     * Remove the object at the beginning of the list.
     *
     * @return the removed object; otherwise null if list is empty
     */
    public E removeFirst() {
        E tmp;

        if(currentSize == 0) {
            return null;
        }

        if(front == (maxSize - 1)) {
            tmp = storage[0];
            front = 0;
            currentSize -= 1;
            return tmp;
        }
        tmp = storage[++front];
        currentSize -= 1;
        return tmp;
    }

    /**
    * Remove the object at the end of the list.
    *
    * @return the removed object; otherwise null if list is empty
    */
    public E removeLast() {
        E tmp;

        if(currentSize == 0) {
            return null;
        }

        if(rear == 0) {
            tmp = storage[maxSize - 1];
            rear = maxSize - 1;
            currentSize -= 1;
            return tmp;
        }
        tmp = storage[--rear];
        currentSize -= 1;
        return tmp;
    }

    /**
     * Remove a specific object from the list.
     *
     * @param obj the object to remove
     * @return the removed object; otherwise null if list is empty
     */
    public E remove(E obj) {
        if(currentSize == 0) {
            return null;
        }
        E tmp;
        int position;
        position = indexOf(obj);

        if(position >= 0) {
            tmp = storage[position];

                if(tmp == obj) {

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

                        if(position == 0) {
                            storage[position] = storage[(maxSize - 1)];
                            position = (maxSize -1);
                        } else {
                            storage[position] = storage[--position];
                        }
                    }
                    front++;
                    currentSize -= 1;
                    return tmp;
                }
        }
        return null;
    }

    /**
     * Return the object at the beginning of the list.
     *
     * @return the object at the beginning of the list
     */
    public E peekFirst() {
        if(currentSize == 0) {
            return null;
        }

        if(front == (maxSize - 1)) {
            return storage[0];
        }
        return storage[front + 1];
    }

    /**
     * Return the object at the end of the list.
     *
     * @return the object at the end of the list
     */
    public E peekLast() {
        if(currentSize == 0) {
            return null;
        }

        if(rear == 0) {
            return storage[maxSize -1];
        }
        return storage[rear - 1];
    }

    /**
     * Verify a specific object exist in the list.
     *
     * @param obj the specified object to verify
     * @return true if the object is found; otherwise false
     */
    public boolean contains(E obj) {
        if(find(obj) != null) {
            return true;
        }
        return false;
    }

    /**
     * Find the first occurence of a specific object in the list.
     *
     * @param obj the specified object to find
     * @return the found object; otherwise null
     */
    public E find(E obj) {
        int index = front + 1;

        if(index == maxSize) {
            index = 0;
        }
        int count = 0;

        while(count != currentSize) {

            if(index == maxSize) {
                index = 0;
            }

            if(((Comparable<E>)obj).compareTo(storage[index]) == 0) {
                return storage[index];
            }
            index++;
            count++;
        }
        return null;
    }

    /**
     * Return the list to an empty state.
     */
    public void clear() {
        currentSize = 0;
        front = 0;
        rear = 1;
    }
    
    /**
     * Verify if the list is empty.
     *
     * @return true if list is empty; otherwise false
     */
    public boolean isEmpty() {
        if(currentSize == 0) {
            return true;
        }
        return false;
    }

    /**
     * Verify if the list is full.
     *
     * @return true if list is full; otherwise false
     */
    public boolean isFull() {
        if(currentSize == maxSize) {
            return true;
        }
        return false;
    }
    
    /**
     * Return the number of object in the list.
     *
     * @return the integer value for the current size of the list
     */
    public int size() {
        return currentSize;
    }
    
    /**
     * Return the iterator.
     *
     * @return the iterator
     */
    public Iterator<E> iterator() {
        return new IteratorHelper<E>();
    }
    
    /**
     * Implementation for the iterator of the object in the list.
     */
    private class IteratorHelper<E> implements Iterator<E> {
        private int index;
        private long count;

        public IteratorHelper() {
            index = front;
            count = 0;
        }
        
        public boolean hasNext() {
            return(count != currentSize);
        }
        
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            index++;
            count++;

            if(index == maxSize) {
                index = 0;
            }
            return (E) storage[index];
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Find the index of a specific object in the list.
     *
     * @param obj the specified object to find the index for
     * @return the integer value for the index; otherwise -1
     */
    private int indexOf(E obj) {
        int index = front + 1;

        if(index == maxSize) {
            index = 0;
        }
        int count = 0;

        while(count != currentSize) {

            if(index == maxSize) {
                index = 0;
            }

            if(((Comparable<E>)obj).compareTo(storage[index]) == 0) {
                return index;
            }
            index++;
            count++;
        }
        return -1;
    }
}
