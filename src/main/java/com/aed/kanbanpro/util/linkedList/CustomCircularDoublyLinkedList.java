package com.aed.kanbanpro.util.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Una implementación de lista doblemente enlazada circular personalizada.
 * Permite la inserción, eliminación y acceso a elementos en la lista.
 * @param <T> el tipo de elementos que se almacenarán en la lista
 */
public class CustomCircularDoublyLinkedList<T> implements CustomList<T>, Iterable<T>{
    
    /**
     * Referencia al primer nodo en la lista.
     */
    private CustomNodeListDoubly<T> first;
    
    /**
     * Referencia al último nodo en la lista.
     */
    private CustomNodeListDoubly<T> last;
    
    /**
     * El tamaño actual de la lista.
     */
    private int size;

    /**
     * Crea una nueva lista doblemente enlazada circular vacía.
     */
    public CustomCircularDoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    /**
     * Añade un nuevo elemento al principio de la lista.
     * @param element el elemento a añadir
     */
    @Override
    public void addFirst(T element) {
        CustomNodeListDoubly<T> newNode = new CustomNodeListDoubly<>(element);
        if (isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
            last = newNode;
        } else {
            newNode.setNext(first);
            newNode.setPrevious(last);
            first.setPrevious(newNode);
            last.setNext(newNode);
        }
        first = newNode;
        size++;
    }

    /**
     * Añade un nuevo elemento al final de la lista.
     * @param element el elemento a añadir
     */
    @Override
    public void addLast(T element) {
        CustomNodeListDoubly<T> newNode = new CustomNodeListDoubly<>(element);
        if (isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
            first = newNode;
        } else {
            newNode.setNext(first);
            newNode.setPrevious(last);
            first.setPrevious(newNode);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    /**
     * Elimina el elemento en el índice especificado de la lista.
     * @param index el índice del elemento a eliminar
     * @return el elemento eliminado
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    @Override
    public T remove(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        CustomNodeListDoubly<T> nodeToRemove = getNodeIn(index);
        CustomNodeListDoubly<T> prevNode = nodeToRemove.getPrevious();
        CustomNodeListDoubly<T> nextNode = nodeToRemove.getNext();

        prevNode.setNext(nextNode);
        nextNode.setPrevious(prevNode);

        if(nodeToRemove == first) first = nextNode;
        if(nodeToRemove == last) last = prevNode;

        size--;
        return nodeToRemove.getData();
    }

    /**
     * Elimina todos los elementos de la lista.
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Obtiene el primer elemento de la lista.
     * @return el primer elemento de la lista
     * @throws NoSuchElementException si la lista está vacía
     */
    @Override
    public T getFirst() {
        if (first == null) throw new NoSuchElementException("The list is empty");
        return first.getData();
    }

    /**
     * Obtiene el último elemento de la lista.
     * @return el último elemento de la lista
     * @throws NoSuchElementException si la lista está vacía
     */
    @Override
    public T getLast() {
        if(last == null) throw new NoSuchElementException("The list is empty");
        return last.getData();
    }

    /**
     * Comprueba si la lista está vacía.
     * @return true si la lista está vacía, false de lo contrario
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Obtiene el tamaño actual de la lista.
     * @return el tamaño de la lista
     */
    @Override
    public int size() {
        return size;
    }
        
    /**
     * Obtiene el nodo en el índice especificado.
     * @param index el índice del nodo a obtener
     * @return el nodo en el índice especificado
     */
    private CustomNodeListDoubly<T> getNodeIn(int index) {
        CustomNodeListDoubly<T> current = first;
        for (int i = 0; i < index; i++) current = current.getNext();
        return current;
    }

    /**
     * Devuelve un iterador sobre los elementos en esta lista.
     * @return un iterador sobre los elementos en esta lista
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private CustomNodeListDoubly<T> current = first;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.getData();
                current = current.getNext();
                count++;
                return data;
            }
        };
    }
}
