package com.aed.kanbanpro.model;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Juan Romero Collazos
 */
public interface UpdateCommand {
    /**
     * Actualiza una tarea existente en el sistema.
     * @param table
     * @param row la fila de la tarea en la vista del tablero Kanban
     * @param column la columna de la tarea en la vista del tablero Kanban
     * @param id
     * @param name el campo de texto que contiene el nombre actualizado de la persona asignada
     * @param lastname el campo de texto que contiene el apellido actualizado de la persona asignada
     * @param status el cuadro combinado que especifica el estado actualizado de la tarea
     * @param priority el control de spinner que especifica la prioridad actualizada de la tarea
     * @param description el área de texto que contiene la descripción actualizada de la tarea
     * @param dateTime
     */
    void updateTask(JTable table, int row, int column, String id, JTextField name, JTextField lastname, JComboBox<String> status, JSpinner priority, JTextArea description, String dateTime);
}
