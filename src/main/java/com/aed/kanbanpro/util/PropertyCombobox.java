package com.aed.kanbanpro.util;

import javax.swing.JComboBox;

/**
 *
 * @author Juan Romero Collazos
 */
public class PropertyCombobox {
    public void putCombobox (JComboBox<String> comboBox) {
        String[] opciones = {"Creada", "Asignada", "En progreso", "Terminada", "Aprobada"};
        
        for (String opcion : opciones) {
            comboBox.addItem(opcion);
        }
    }
}
