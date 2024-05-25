package com.aed.kanbanpro.util.queue;

/**
 *
 * @author Juan Romero Collazos
 * @param <T>
 */
public class CustomNodeQueue<T> {
    private T data;
    private CustomNodeQueue<T> next;

    public CustomNodeQueue(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CustomNodeQueue<T> getNext() {
        return next;
    }

    public void setNext(CustomNodeQueue<T> next) {
        this.next = next;
    }
    
}
