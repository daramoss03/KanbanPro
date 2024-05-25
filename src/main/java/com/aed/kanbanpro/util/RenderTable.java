package com.aed.kanbanpro.util;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clase para personalizar la renderización de celdas de una tabla en Swing.
 * @author Juan Romero Collazos
 */
public class RenderTable extends DefaultTableCellRenderer {

    /**
     * Personaliza la renderización de celdas de la tabla.
     * Si el valor de la celda es una tabla, se muestra en un JScrollPane dentro de la celda principal.
     * @param table La tabla que se está renderizando.
     * @param value El valor de la celda.
     * @param isSelected Indica si la celda está seleccionada.
     * @param hasFocus Indica si la celda tiene el foco.
     * @param row El índice de la fila de la celda.
     * @param column El índice de la columna de la celda.
     * @return El componente de la celda renderizada.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JTable subTable) {
            subTable.setPreferredScrollableViewportSize(subTable.getPreferredSize()); // Ajusta el tamaño preferido de la tabla interna
            subTable.setFillsViewportHeight(true); // Hace que la tabla interna ocupe todo el espacio disponible en la celda

            JScrollPane scrollPane = new JScrollPane(subTable);
            scrollPane.setBorder(null); // Elimina el borde del JScrollPane

            return scrollPane;
        } else {
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
    
    /**
     * Establece el valor de la celda.
     * Si el valor es una tabla, se muestra en un JScrollPane dentro de la celda principal.
     * @param value El valor de la celda.
     */
    @Override
    public void setValue(Object value) {
        if (value instanceof JTable table) {
            setLayout(new BorderLayout());
            add(new JScrollPane(table), BorderLayout.CENTER);
        } else {
            super.setValue(value);
        }
    }
}
