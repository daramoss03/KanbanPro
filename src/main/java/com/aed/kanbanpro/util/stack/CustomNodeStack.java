package com.aed.kanbanpro.util.stack;

/**
 * Un nodo personalizado utilizado en una estructura de datos de lista enlazada.
 * Cada nodo contiene un dato de un tipo genérico y una referencia al siguiente nodo en la lista.
 * @param <T> el tipo de datos almacenado en el nodo
 */
public class CustomNodeStack<T> {
    private T data; // El dato almacenado en el nodo
    private CustomNodeStack<T> next; // La referencia al siguiente nodo en la lista

    /**
     * Crea un nuevo nodo con el dato especificado.
     * @param data el dato a almacenar en el nodo
     */
    public CustomNodeStack(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Devuelve el dato almacenado en el nodo.
     * @return el dato almacenado en el nodo
     */
    public T getData() {
        return data;
    }

    /**
     * Establece el dato almacenado en el nodo.
     * @param data el nuevo dato a almacenar en el nodo
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Devuelve el siguiente nodo en la lista.
     * @return el siguiente nodo en la lista
     */
    public CustomNodeStack<T> getNext() {
        return next;
    }

    /**
     * Establece el siguiente nodo en la lista.
     * @param next el nuevo siguiente nodo en la lista
     */
    public void setNext(CustomNodeStack<T> next) {
        this.next = next;
    }
}
