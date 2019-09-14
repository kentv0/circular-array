/* Kent Vo */

package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayLinearList<E> implements LinearListADT<E> {

    private E[] storage;
    private int currentSize;
    private int maxSize;
    private int front;
    private int rear;

    public ArrayLinearList(int size) {
        rear = 1;
        maxSize = size;
        currentSize = front = 0;
        storage = (E[]) new Object[maxSize];
    }

    public ArrayLinearList() { this(DEFAULT_MAX_CAPACITY); } 

    public boolean addFirst(E obj) {
        if(currentSize == maxSize)
            return false;
        storage[front--] = obj;
        if(front == -1)
            front += maxSize;
        currentSize++;
        return true;
    }
    
    public boolean addLast(E obj) {
        if(currentSize == maxSize)
            return false;
        storage[rear++] = obj;
        if(rear == maxSize)
            rear = 0;
        currentSize++;
        return true;
    }

    public E removeFirst() {
        E tmp;
        if(currentSize == 0)
            return null;
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

    public E removeLast() {
        E tmp;
        if(currentSize == 0)
            return null;
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

    public E remove(E obj) {
        if(currentSize == 0)
            return null;
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
                        }
                        else
                            storage[position] = storage[--position];
                    }
                    front++;
                    currentSize -= 1;
                    return tmp;
                }
        }
        return null;
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

    private int indexOf(E obj) {
        int index = front + 1;
        if(index == maxSize)index = 0;
        int count = 0;
        while(count != currentSize) {
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
            if(!hasNext()) { throw new NoSuchElementException(); }
            index++;
            count++;
            if(index == maxSize) index = 0;
            return (E) storage[index];
        }
        
        public void remove() { throw new UnsupportedOperationException(); }
    }
}
