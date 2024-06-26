package com.aed.kanbanpro.view;

import com.aed.kanbanpro.util.PropertyCombobox;
import com.aed.kanbanpro.util.PropertySpinner;
import com.aed.kanbanpro.util.PropertyTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Juan Romero Collazos
 */
public class PanelConfigTask extends javax.swing.JFrame {
    private final PropertyCombobox PROPERTY_COMBOBOX;
    private final PropertySpinner PROPERTY_SPINNER;
    private final PropertyTextArea PROPERTY_TEXT_AREA;
    /**
     * Creates new form PanelConfigTask
     */
    public PanelConfigTask() {
        initComponents();
        PROPERTY_COMBOBOX = new PropertyCombobox();
        PROPERTY_SPINNER = new PropertySpinner();
        PROPERTY_TEXT_AREA = new PropertyTextArea();
        setIconImage(new ImageIcon(getClass().getResource("/img/favicon.png")).getImage());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        input_name.putClientProperty( "JComponent.roundRect", true );
        input_name.putClientProperty( "JTextField.placeholderText", "Escribe tus nombres..." );
        input_lastname.putClientProperty( "JComponent.roundRect", true );
        input_lastname.putClientProperty( "JTextField.placeholderText", "Escribe tus apellidos..." );
        sp_priority.putClientProperty( "JComponent.roundRect", true );
        length_words.setHorizontalAlignment(SwingConstants.RIGHT);
        PROPERTY_COMBOBOX.putCombobox(cb_status);
        PROPERTY_SPINNER.property(sp_priority, 1, 1, 5, 1);
        PROPERTY_TEXT_AREA.limitTextArea(100, text_description, length_words);
    }

    public JComboBox<String> getCb_status() {
        return cb_status;
    }

    public JLabel getId() {
        return id;
    }

    public JTextField getInput_lastname() {
        return input_lastname;
    }

    public JTextField getInput_name() {
        return input_name;
    }

    public JSpinner getSp_priority() {
        return sp_priority;
    }

    public JTextArea getText_description() {
        return text_description;
    }

    public JButton getBtn_update() {
        return btn_update;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_name = new javax.swing.JLabel();
        label_id = new javax.swing.JLabel();
        input_name = new javax.swing.JTextField();
        label_lastname = new javax.swing.JLabel();
        input_lastname = new javax.swing.JTextField();
        id = new javax.swing.JLabel();
        label_status = new javax.swing.JLabel();
        cb_status = new javax.swing.JComboBox<>();
        label_priority = new javax.swing.JLabel();
        sp_priority = new javax.swing.JSpinner();
        label_description = new javax.swing.JLabel();
        length_words = new javax.swing.JLabel();
        content_text_description = new javax.swing.JScrollPane();
        text_description = new javax.swing.JTextArea();
        btn_update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kanban Pro | Config");
        setPreferredSize(new java.awt.Dimension(500, 560));
        setResizable(false);

        label_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_name.setForeground(new java.awt.Color(31, 137, 201));
        label_name.setText("Nombres:");

        label_id.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_id.setForeground(new java.awt.Color(31, 137, 201));
        label_id.setText("ID:");

        label_lastname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_lastname.setForeground(new java.awt.Color(31, 137, 201));
        label_lastname.setText("Apellidos:");

        id.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        id.setForeground(new java.awt.Color(238, 0, 119));
        id.setText("xxxxxxxxxxxxxxxxxxx");

        label_status.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_status.setForeground(new java.awt.Color(31, 137, 201));
        label_status.setText("Estado:");

        label_priority.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_priority.setForeground(new java.awt.Color(31, 137, 201));
        label_priority.setText("Prioridad:");

        label_description.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_description.setForeground(new java.awt.Color(31, 137, 201));
        label_description.setText("Descripción:");

        length_words.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        length_words.setForeground(new java.awt.Color(255, 212, 0));
        length_words.setText("0/100");

        text_description.setColumns(20);
        text_description.setLineWrap(true);
        text_description.setRows(5);
        text_description.setWrapStyleWord(true);
        content_text_description.setViewportView(text_description);

        btn_update.setBackground(new java.awt.Color(31, 137, 201));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btn_update.setText("Actualizar");
        btn_update.setBorderPainted(false);
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_description)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(length_words, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(content_text_description, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(label_status)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label_priority)
                                .addGap(18, 18, 18)
                                .addComponent(sp_priority))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(label_lastname)
                                .addGap(18, 18, 18)
                                .addComponent(input_lastname))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(label_name)
                                        .addGap(18, 18, 18)
                                        .addComponent(input_name, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(label_id)
                                        .addGap(18, 18, 18)
                                        .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btn_update, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_id)
                    .addComponent(id))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_name)
                    .addComponent(input_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_lastname)
                    .addComponent(input_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_status)
                    .addComponent(cb_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_priority)
                    .addComponent(sp_priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(label_description)
                .addGap(18, 18, 18)
                .addComponent(content_text_description, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(length_words)
                .addGap(18, 18, 18)
                .addComponent(btn_update)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cb_status;
    private javax.swing.JScrollPane content_text_description;
    private javax.swing.JLabel id;
    private javax.swing.JTextField input_lastname;
    private javax.swing.JTextField input_name;
    private javax.swing.JLabel label_description;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_lastname;
    private javax.swing.JLabel label_name;
    private javax.swing.JLabel label_priority;
    private javax.swing.JLabel label_status;
    private javax.swing.JLabel length_words;
    private javax.swing.JSpinner sp_priority;
    private javax.swing.JTextArea text_description;
    // End of variables declaration//GEN-END:variables
}
