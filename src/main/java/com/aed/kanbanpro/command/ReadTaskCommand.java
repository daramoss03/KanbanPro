package com.aed.kanbanpro.command;

import com.aed.kanbanpro.model.ReadCommand;
import com.aed.kanbanpro.model.UndoRedoCommand;
import com.aed.kanbanpro.util.UniqueIDGenerator;
import com.aed.kanbanpro.view.PanelConfigTask;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * @author Juan Romero Collazos
 */
public class ReadTaskCommand implements ReadCommand, UndoRedoCommand {

    @Override
    public void readTask(PanelConfigTask panelConfigTask, int row, int column, JTable table) {
        if (row >= 0 && column >= 0) {
            Object value = table.getValueAt(row, column);
            if (value instanceof JTable jTable) {
                JTable subTable = jTable;
                UniqueIDGenerator uniqueIDGenerator = new UniqueIDGenerator();
                TableModel subTableModel = subTable.getModel();

                // Initialize valores with the appropriate size
                Object[] values = new Object[subTableModel.getRowCount()];

                for (int i = 0; i < subTableModel.getRowCount(); i++) {
                    Object subValue = subTableModel.getValueAt(i, 1);
                    values[i] = subValue;
                }

                panelConfigTask.setLocationRelativeTo(null);
                panelConfigTask.getId().setText(uniqueIDGenerator.idGenerator());
                panelConfigTask.getSp_priority().setValue(values[1]);
                panelConfigTask.getCb_status().setSelectedItem(values[2]);
                panelConfigTask.getInput_name().setText(String.valueOf(values[3]).split(", ")[1]);
                panelConfigTask.getInput_lastname().setText(String.valueOf(values[3]).split(", ")[0]);
                panelConfigTask.getText_description().setText(String.valueOf(values[4]));
                panelConfigTask.setVisible(true);
            }
        }
    }

    @Override
    public void undo(JTable table) {
        throw new UnsupportedOperationException("Undo no soportado en ReadTask.");
    }

    @Override
    public void redo(JTable table) {
        throw new UnsupportedOperationException("Redo no soportado en ReadTask.");
    }
    
}
