package com.aed.kanbanpro.command;

import com.aed.kanbanpro.model.UndoRedoCommand;
import com.aed.kanbanpro.model.UpdateCommand;
import com.aed.kanbanpro.util.CustomAlert;
import com.aed.kanbanpro.util.RenderTable;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

/**
 * @author Juan Romero Collazos
 */
public class UpdateTaskCommand implements UpdateCommand, UndoRedoCommand {

    @Override
    public void updateTask(JTable table, int row, int column, String id, JTextField name, JTextField lastName, JComboBox<String> status, JSpinner priority, JTextArea description, String dateTime) {
        if (row >= 0 && column >= 0) {
            Object value = table.getValueAt(row, column);
            if (value instanceof JTable jTable) {
                CustomAlert alert = new CustomAlert();
                JTable subTable = jTable;
                TableModel subTableModel = subTable.getModel();

                // Obtener el índice seleccionado en el JComboBox status
                int selectedIndex = status.getSelectedIndex();

                // Verificar si el índice es válido y mover la columna correspondiente en la fila
                if (selectedIndex >= 0 && selectedIndex < table.getColumnCount()) {
                    Object[] values = {id, priority.getValue(), status.getSelectedItem().toString(), String.format("%s, %s", lastName.getText(), name.getText()), description.getText(), dateTime};

                    for (int i = 0; i < subTableModel.getRowCount(); i++) {
                        subTableModel.setValueAt(values[i], i, 1);
                    }
                    table.setValueAt(null, row, column);
                    table.setValueAt(subTable, row, selectedIndex);
                    RenderTable renderer = new RenderTable();
                    table.getColumnModel().getColumn(selectedIndex).setCellRenderer(renderer);
                    alert.successfulAlert("Se actualizó de forma correcta la tarea.");
                } else {
                    alert.errorAlert("Índice seleccionado fuera de rango.");
                }
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
