package com.aed.kanbanpro.util;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Clase para limitar el número de palabras en un JTextArea y mostrar un contador de palabras.
 * @author Juan Romero Collazos
 */
public class PropertyTextArea {
    
    /**
     * Limita el número de palabras en un JTextArea y muestra un contador de palabras.
     * @param limit El límite máximo de palabras.
     * @param textArea El JTextArea donde se ingresará el texto.
     * @param labelLimit El JLabel donde se mostrará el contador de palabras.
     */
    public void limitTextArea(int limit, JTextArea textArea, JLabel labelLimit) {
        labelLimit.setHorizontalAlignment(SwingConstants.RIGHT);
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(this::checkWordLimit);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(this::checkWordLimit);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            private void checkWordLimit() {
                String text = textArea.getText();
                String[] words = text.split("\\s+"); // Dividir el texto en palabras
                int wordCount = words.length;

                // Si la cantidad de palabras excede el límite, eliminar las palabras adicionales
                if (wordCount > limit) {
                    // Actualizar el contador de palabras
                    labelLimit.setText(String.format("%d/%d", limit, limit));
                    StringBuilder newText = new StringBuilder();
                    for (int i = 0; i < limit; i++) {
                        newText.append(words[i]).append(" ");
                    }
                    // Establecer el nuevo texto en el JTextArea
                    SwingUtilities.invokeLater(() -> textArea.setText(newText.toString()));
                } else {
                    // Actualizar el contador de palabras si no excede el límite
                    labelLimit.setText(String.format("%d/%d", wordCount, limit));
                }
            }
        });
    }
}
