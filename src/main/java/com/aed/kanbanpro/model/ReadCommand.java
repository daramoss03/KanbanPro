package com.aed.kanbanpro.model;

import com.aed.kanbanpro.view.PanelConfigTask;
import javax.swing.JTable;

/**
 *
 * @author Juan Romero Collazos
 */
public interface ReadCommand {
    /**
     * Lee los detalles de una tarea en el sistema.
     * @param panelConfigTask
     * @param row la fila de la tarea en la vista del tablero Kanban
     * @param column la columna de la tarea en la vista del tablero Kanban
     * @param table
     */
    void readTask(PanelConfigTask panelConfigTask, int row, int column, JTable table);
}
