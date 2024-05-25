package com.aed.kanbanpro.util;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Esta clase proporciona métodos para configurar las propiedades de un componente JSpinner.
 *
 * Permite establecer el valor inicial, el valor mínimo, el valor máximo y el paso del JSpinner.
 * 
 * @author Juan Romero Collazos
 */
public class PropertySpinner {

    /**
     * Configura las propiedades de un JSpinner con un valor inicial, un valor mínimo,
     * un valor máximo y un paso específicos.
     *
     * @param spinner El JSpinner al que se le aplicarán las propiedades.
     * @param initial El valor inicial del JSpinner.
     * @param min El valor mínimo permitido para el JSpinner.
     * @param max El valor máximo permitido para el JSpinner.
     * @param step El incremento o decremento aplicado al JSpinner con cada cambio.
     */
    public void property(JSpinner spinner, int initial, int min, int max, int step) {
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(initial, min, max, step);
        spinner.setModel(spinnerModel);
    }
}
