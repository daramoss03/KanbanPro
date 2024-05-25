package com.aed.kanbanpro.model;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Juan Romero Collazos
 */
public interface AddCommand {
    /**
     * Agrega una nueva tarea al sistema.
     * @param table es la tabla donde se insertara la tarea
     * @param id el identificador único de la persona asignada
     * @param name el campo de texto que contiene el nombre de la persona asignada
     * @param lastname el campo de texto que contiene el apellido de la persona asignada
     * @param priority el control de spinner que especifica la prioridad de la tarea
     * @param description el área de texto que contiene la descripción de la tarea
     */
    void addTask(JTable table, String id, JTextField name, JTextField lastname, JSpinner priority, JTextArea description);
}
