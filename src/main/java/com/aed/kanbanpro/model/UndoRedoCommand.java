package com.aed.kanbanpro.model;

import javax.swing.JTable;

/**
 *
 * @author Juan Romero Collazos
 */
public interface UndoRedoCommand {
    void undo(JTable table);
    void redo(JTable table);
}
