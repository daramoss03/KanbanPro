package com.aed.kanbanpro.util;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Romero Collazos
 */
public class CustomAlert {
    private final Icon iconError = new ImageIcon(getClass().getResource("/img/error.png"));
    private final Icon iconWarning = new ImageIcon(getClass().getResource("/img/advertencia.png"));
    private final Icon iconSuccessful = new ImageIcon(getClass().getResource("/img/satisfactorio.png"));
    private final Icon iconQuestion = new ImageIcon(getClass().getResource("/img/pregunta.png"));
    
    public void errorAlert(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE, iconError);
    }
    
    public void warningAlert(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE, iconWarning);
    }
    
    public void successfulAlert(String message) {
        JOptionPane.showMessageDialog(null, message, "Successful", JOptionPane.INFORMATION_MESSAGE, iconSuccessful);
    }
    
    public int questionAlert(String message) {
        // Opciones a mostrar en el JOptionPane
        String[] options = {"Editar", "Eliminar"};

        // Mostrar el JOptionPane y obtener la opción seleccionada por el usuario
        int choice = JOptionPane.showOptionDialog(null, message, "Info",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, iconQuestion, options, options[0]);

        return choice;
    }
    
    public int questionYesNo(String message) {
        int response = JOptionPane.showConfirmDialog(null, message, "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, iconQuestion);
        return response;
    }
}
