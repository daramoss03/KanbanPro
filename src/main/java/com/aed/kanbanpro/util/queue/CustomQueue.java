package com.aed.kanbanpro.util.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Juan Romero Collazos
 * @param <T>
 */
public class CustomQueue<T> implements Iterable<T>{
    private CustomNodeQueue<T> first;
    private CustomNodeQueue<T> last;
    private int size;

    public CustomQueue() {
        this.first = null;
        this.last = null;
        size = 0;
    }
    
    public void offer(T element) {
        CustomNodeQueue<T> newNode = new CustomNodeQueue<>(element);
        if(isEmpty()) first = newNode;
        else last.setNext(newNode);
        last = newNode;
        size++;
    }
    
    public T poll() {
        if (isEmpty()) throw new IllegalStateException("The queue is empty");
        T element = first.getData();
        first = first.getNext();
        if(first == null) last = null;
        size--;
        return element;
    }
    
    public T peek() {
        if(isEmpty()) return null;
        return first.getData();
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private CustomNodeQueue<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}
