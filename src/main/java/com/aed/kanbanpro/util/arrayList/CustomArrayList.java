package com.aed.kanbanpro.util.arrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Juan Romero Collazos
 * @param <T>
 */
public class CustomArrayList<T> implements Iterable<T>{
    private T[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = (T[]) new Object[10];
    }
    
    public void add(T element) {
        if (size == elements.length) {
            T[] newArray = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
        elements[size] = element;
        size++;
    }
    
    public void add(T[] elementsToAdd) {
        int newSize = size + elementsToAdd.length;
        if (newSize > elements.length) {
            T[] newArray = (T[]) new Object[Math.max(elements.length * 2, newSize)];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
        System.arraycopy(elementsToAdd, 0, elements, size, elementsToAdd.length);
        size = newSize;
    }


    public void addFirst(T element) {
        if (size == elements.length) {
            T[] newArray = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 1, size);
            elements = newArray;
        } else {
            System.arraycopy(elements, 0, elements, 1, size);
        }
        elements[0] = element;
        size++;
    }

    public void addLast(T element) {
        add(element);
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Índice fuera de rango");
        return elements[index];
    }
    
    public T getLast() {
        if (size == 0) throw new NoSuchElementException("La lista está vacía");
        return elements[size - 1];
    }

    
    public void set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Índice fuera de rango");
        elements[index] = element;
    }

    
    public boolean isEmpty() {
        return elements == null;
    }
    
    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Índice fuera de rango");
        T removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        elements[size] = null;
        return removedElement;
    }

    public T removeLast() {
        if (size == 0) throw new NoSuchElementException("La lista está vacía");
        T removedElement = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return removedElement;
    }

    
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return elements[currentIndex++];
            }
        };
    }
    
}
