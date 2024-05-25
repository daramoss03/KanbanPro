package com.aed.kanbanpro.util.linkedList;

/**
 * Un nodo para una lista doblemente enlazada.
 * @param <T> el tipo de datos almacenado en el nodo
 */
public class CustomNodeListDoubly<T> {
    
    /**
     * El dato almacenado en el nodo.
     */
    private T data;
    
    /**
     * Referencia al siguiente nodo en la lista.
     */
    private CustomNodeListDoubly<T> next;
    
    /**
     * Referencia al nodo anterior en la lista.
     */
    private CustomNodeListDoubly<T> previous;

    /**
     * Crea un nuevo nodo con el dato especificado.
     * @param data el dato a almacenar en el nodo
     */
    public CustomNodeListDoubly(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     * @return el dato almacenado en el nodo
     */
    public T getData() {
        return data;
    }

    /**
     * Establece el dato almacenado en el nodo.
     * @param data el dato a establecer en el nodo
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Obtiene el siguiente nodo en la lista.
     * @return el siguiente nodo en la lista
     */
    public CustomNodeListDoubly<T> getNext() {
        return next;
    }

    /**
     * Establece el siguiente nodo en la lista.
     * @param next el siguiente nodo a establecer
     */
    public void setNext(CustomNodeListDoubly<T> next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo anterior en la lista.
     * @return el nodo anterior en la lista
     */
    public CustomNodeListDoubly<T> getPrevious() {
        return previous;
    }

    /**
     * Establece el nodo anterior en la lista.
     * @param previous el nodo anterior a establecer
     */
    public void setPrevious(CustomNodeListDoubly<T> previous) {
        this.previous = previous;
    }        
}
