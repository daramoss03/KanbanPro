package com.aed.kanbanpro.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Clase para configurar propiedades específicas de una tabla en Swing.
 * @author Juan Romero Collazos
 */
public class PropertyTable {
    
    /**
     * Inserta los encabezados de la tabla y configura la altura de las filas.
     * @param table La tabla a la que se agregarán los encabezados y se configurará la altura de las filas.
     * @param columns Los nombres de las columnas de la tabla.
     */
    public void insertHeaders(JTable table, String... columns) {
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table.setModel(model);
        table.getTableHeader().setResizingAllowed(false);
        table.setRowHeight(155);
    }
    
    /**
     * Configura el color de fondo y otras propiedades de los encabezados de la tabla.
     * @param table La tabla cuyos encabezados se van a configurar.
     * @param color1 Color de fondo para la primera columna.
     * @param color2 Color de fondo para la segunda columna.
     * @param color3 Color de fondo para la tercera columna.
     * @param color4 Color de fondo para la cuarta columna.
     * @param color5 Color de fondo para la quinta columna.
     */
    public void tableHeaderColor(JTable table, String color1, String color2, String color3, String color4, String color5) {
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                // Obtener el componente renderizado por defecto
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Cambiar el color de fondo del encabezado según la columna 
                switch (column) {
                    case 0 -> label.setBackground(Color.decode(color1));
                    case 1 -> label.setBackground(Color.decode(color2));
                    case 2 -> label.setBackground(Color.decode(color3));
                    case 3 -> label.setBackground(Color.decode(color4));
                    case 4 -> label.setBackground(Color.decode(color5));
                    default -> {
                    }
                }

                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(label.getFont().deriveFont(Font.BOLD));
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));

                return label;
            }
        });
    }
    
    /**
    * Este método personaliza el color del encabezado de una tabla.
    *
    * @param table  La JTable cuyo encabezado se va a personalizar.
    * @param color1 El color de fondo para la primera columna en formato hexadecimal (por ejemplo, "#FFFFFF" para blanco).
    * @param color2 El color de fondo para la segunda columna en formato hexadecimal.
    * @param colorCell
    */
    public void tableHeaderColor(JTable table, String color1, String color2, String colorCell) {
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                // Obtener el componente renderizado por defecto
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Cambiar el color de fondo del encabezado según la columna 
                switch (column) {
                    case 0 -> label.setBackground(Color.decode(color1));
                    case 1 -> label.setBackground(Color.decode(color2));
                    default -> {
                    }
                }

                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(label.getFont().deriveFont(Font.BOLD));
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));

                return label;
            }
        });
        // Cambiar el color de fondo de las celdas debajo de la primera columna
        table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                // Obtener el componente renderizado por defecto
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Cambiar el color de fondo de las celdas en la primera columna
                if (column == 0) {
                    label.setBackground(Color.decode(colorCell));
                    label.setFont(label.getFont().deriveFont(Font.BOLD));
                }

                return label;
            }
        });
    }
}
