package com.aed.kanbanpro.model;

import javax.swing.JTable;

/**
 *
 * @author Juan Romero Collazos
 */
public interface DeleteCommand {
    /**
     * Elimina una tarea del sistema.
     * @param row la fila de la tarea en la vista del tablero Kanban
     * @param column la columna de la tarea en la vista del tablero Kanban
     * @param table
     */
    void deleteTask(int row, int column, JTable table);
}
