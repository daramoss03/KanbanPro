package com.aed.kanbanpro.util.linkedList;

/**
 * Un nodo para una lista simplemente enlazada.
 * @param <T> el tipo de datos almacenado en el nodo
 */
public class CustomNodeListSingly<T> {
    
    /**
     * El dato almacenado en el nodo.
     */
    private T data;
    
    /**
     * Referencia al siguiente nodo en la lista.
     */
    private CustomNodeListSingly<T> next;

    /**
     * Crea un nuevo nodo con el dato especificado.
     * @param data el dato a almacenar en el nodo
     */
    public CustomNodeListSingly(T data) {
        this.data = data;
        this.next = null;
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
    public CustomNodeListSingly<T> getNext() {
        return next;
    }

    /**
     * Establece el siguiente nodo en la lista.
     * @param next el siguiente nodo a establecer
     */
    public void setNext(CustomNodeListSingly<T> next) {
        this.next = next;
    }
    
}
