package com.aed.kanbanpro.command;

import com.aed.kanbanpro.model.AddCommand;
import com.aed.kanbanpro.model.UndoRedoCommand;
import com.aed.kanbanpro.util.PropertyLocalDateTime;
import com.aed.kanbanpro.util.PropertyTable;
import com.aed.kanbanpro.util.RenderTable;
import com.aed.kanbanpro.util.stack.CustomStack;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class AddTaskCommand implements AddCommand, UndoRedoCommand {
    private final CustomStack<Object[][]> undoStack = new CustomStack<>();
    private final CustomStack<Object[][]> redoStack = new CustomStack<>();

    @Override
    public void addTask(JTable table, String id, JTextField name, JTextField lastName, JSpinner priority, JTextArea description) {
        DefaultTableModel modeloTablaGeneral = (DefaultTableModel) table.getModel();
        PropertyTable propertyTable = new PropertyTable();
        PropertyLocalDateTime propertyLocalDateTime = new PropertyLocalDateTime();
        String[] columnas = {"Clave", "Valor"};
        Object[][] data = {
            {"ID", id},
            {"Prioridad", priority.getValue()},
            {"Estado", "Creada"},
            {"Nombre", String.format("%s, %s", lastName.getText(), name.getText())},
            {"Descripción", description.getText()},
            {"Fecha/Hora de creación", propertyLocalDateTime.nowLocalDateTime()}
        };

        JTable tableData = new JTable(data, columnas);

        propertyTable.tableHeaderColor(tableData, "#AF0404", "#AF0404", "#414141");

        // Asegúrate de tener una instancia de RenderTable
        RenderTable renderizador = new RenderTable();        

        tableData.getColumnModel().getColumn(0).setPreferredWidth(80);
        tableData.getColumnModel().getColumn(1).setPreferredWidth(150);

        // Configura el renderizador en la columna específica
        table.getColumnModel().getColumn(0).setCellRenderer(renderizador);

        // Agrega la fila al modelo de la tabla principal
        SwingUtilities.invokeLater(() -> {
            int columnIndex = 0; // Cambia este índice si quieres verificar otra columna
            int insertRow = -1; // Por defecto, no hay espacio vacío

            // Buscar el último espacio vacío desde la primera fila hasta el final
            for (int row = 0; row < modeloTablaGeneral.getRowCount(); row++) {
                Object cellValue = modeloTablaGeneral.getValueAt(row, columnIndex);
                if (cellValue == null || cellValue.toString().trim().isEmpty()) {
                    insertRow = row; // Encuentra el último vacío
                }
            }

            if (insertRow == -1) {
                // Si no se encuentra ningún espacio vacío, inserta al final
                modeloTablaGeneral.addRow(new Object[]{tableData});
            } else {
                // Inserta en el último espacio vacío encontrado
                modeloTablaGeneral.setValueAt(tableData, insertRow, columnIndex);
            }
        });

        // Guarda los datos agregados para deshacer y borra la pila de rehacer
        Object[][] addedData = {
            {"ID", id},
            {"Prioridad", priority.getValue()},
            {"Estado", "Creada"},
            {"Nombre", String.format("%s, %s", lastName.getText(), name.getText())},
            {"Descripción", description.getText()},
            {"Fecha/Hora de creación", propertyLocalDateTime.nowLocalDateTime()}
        };
        undoStack.push(addedData);
        redoStack.clear();
    }


    @Override
    public void undo(JTable table) {
        if (!undoStack.isEmpty()) {
            RenderTable renderizador = new RenderTable();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(model.getRowCount() - 1);
            redoStack.push(undoStack.pop());
            table.getColumnModel().getColumn(0).setCellRenderer(renderizador);
        }
    }

    @Override
    public void redo(JTable table) {
        if (!redoStack.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            String[] columnas = {"Clave", "Valor"};
            JTable tableData = new JTable(redoStack.pop(), columnas);

            PropertyTable propertyTable = new PropertyTable();
            propertyTable.tableHeaderColor(tableData, "#AF0404", "#AF0404", "#414141");

            RenderTable renderizador = new RenderTable();
            tableData.getColumnModel().getColumn(0).setPreferredWidth(80);
            tableData.getColumnModel().getColumn(1).setPreferredWidth(150);

            table.getColumnModel().getColumn(0).setCellRenderer(renderizador);

            // Agrega la fila al modelo de la tabla principal
            SwingUtilities.invokeLater(() -> {
                int columnIndex = 0;
                int insertRow = -1;

                for (int row = 0; row < model.getRowCount(); row++) {
                    Object cellValue = model.getValueAt(row, columnIndex);
                    if (cellValue == null || cellValue.toString().trim().isEmpty()) {
                        insertRow = row;
                    }
                }

                if (insertRow == -1) {
                    model.addRow(new Object[]{tableData});
                } else {
                    model.setValueAt(tableData, insertRow, columnIndex);
                }
            });
        }
    }


}
