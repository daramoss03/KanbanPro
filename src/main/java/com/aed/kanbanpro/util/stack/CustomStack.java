package com.aed.kanbanpro.util.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Una implementación personalizada de una pila (stack) en Java.
 * Esta clase proporciona funcionalidades básicas de una pila, incluyendo la inserción,
 * eliminación y consulta de elementos.
 * @param <T> el tipo de elementos almacenados en la pila
 */
public class CustomStack<T> implements Iterable<T> {

    private CustomNodeStack<T> top; // El nodo superior de la pila
    private int size; // El tamaño de la pila

    /**
     * Crea una pila vacía.
     */
    public CustomStack() {
        top = null;
        size = 0;
    }

    /**
     * Inserta un elemento en la parte superior de la pila.
     * @param item el elemento a insertar
     */
    public void push(T item) {
        CustomNodeStack<T> node = new CustomNodeStack<>(item);
        if (top == null) {
            top = node; // Si la pila está vacía, el nuevo nodo se convierte en el nodo superior
        } else {
            CustomNodeStack<T> current = top;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node); // Enlazar el nuevo nodo al final de la pila
        }
        size++; // Incrementar el tamaño de la pila
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     * @return el elemento eliminado de la parte superior de la pila
     * @throws EmptyStackException si la pila está vacía
     */
    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.getData();
        top = top.getNext();
        size--;
        return item;
    }

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     * @return el elemento en la parte superior de la pila
     * @throws EmptyStackException si la pila está vacía
     */
    public T peek() {
        if(top == null) throw new EmptyStackException();
        return top.getData();
    }

    /**
     * Comprueba si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Devuelve el tamaño actual de la pila.
     * @return el tamaño de la pila
     */
    public int size() {
        return size;
    }

    /**
    * Elimina todos los elementos de la pila, dejándola vacía.
    */
    public void clear() {
        top = null;
        size = 0;
    }

    
    /**
     * Devuelve un iterador sobre los elementos de la pila.
     * @return un iterador sobre los elementos de la pila
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private CustomNodeStack<T> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new EmptyStackException();
                T item = current.getData();
                current = current.getNext();
                return item;
            }
        };
    }
}
