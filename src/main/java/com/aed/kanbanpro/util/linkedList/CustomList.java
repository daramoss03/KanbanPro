package com.aed.kanbanpro.util.linkedList;

/**
 *
 * @author Juan Romero Collazos
 * @param <T>
 */
public interface CustomList<T> extends Iterable<T>{
    void addFirst(T element);
    void addLast(T element);
    T remove(int index);
    void clear();
    T getFirst();
    T getLast();
    boolean isEmpty();
    int size();
}
