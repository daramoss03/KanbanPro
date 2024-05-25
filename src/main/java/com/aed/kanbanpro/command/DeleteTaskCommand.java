package com.aed.kanbanpro.command;

import com.aed.kanbanpro.model.DeleteCommand;
import com.aed.kanbanpro.model.UndoRedoCommand;
import com.aed.kanbanpro.util.CustomAlert;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author Juan Romero Collazos
 */
public class DeleteTaskCommand implements DeleteCommand, UndoRedoCommand {

    @Override
    public void deleteTask(int row, int column, JTable table) {
        CustomAlert alert = new CustomAlert();
        int response = alert.questionYesNo("¿Deseas eliminar esta tarea?");
        if (response == 0) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Verificar si hay tareas en otras columnas de la misma fila
            boolean moreTasksInRow = false;
            for (int col = 0; col < model.getColumnCount(); col++) {
                if (col != column && model.getValueAt(row, col) != null) {
                    moreTasksInRow = true;
                    break;
                }
            }

            if (moreTasksInRow) {
                // Eliminar solo la celda si hay más tareas en la misma fila en otras columnas
                table.setValueAt(null, row, column);
            } else {
                // Eliminar toda la fila si la tarea a eliminar es la única en esa fila
                model.removeRow(row);
            }
        }
    }

    @Override
    public void undo(JTable table) {
        
    }
    
    @Override
    public void redo(JTable table) {
        
    }
    
}
