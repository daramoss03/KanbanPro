package com.aed.kanbanpro.controller;


import com.aed.kanbanpro.command.AddTaskCommand;
import com.aed.kanbanpro.command.CommandTaskInvoker;
import com.aed.kanbanpro.command.DeleteTaskCommand;
import com.aed.kanbanpro.command.ReadTaskCommand;
import com.aed.kanbanpro.command.UpdateTaskCommand;
import com.aed.kanbanpro.util.CustomAlert;
import com.aed.kanbanpro.util.PropertyLocalDateTime;
import com.aed.kanbanpro.util.UniqueIDGenerator;
import com.aed.kanbanpro.view.KanbanPro;
import com.aed.kanbanpro.view.PanelAddTask;
import com.aed.kanbanpro.view.PanelConfigTask;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KanbanProController {
    private final KanbanPro kanbanPro;
    private final PanelAddTask panelAddTask;
    private final PanelConfigTask panelConfigTask;
    private final CommandTaskInvoker invoker;
    private static int row = 0;
    private static int column = 0;

    public KanbanProController(KanbanPro kanbanPro, PanelAddTask panelAddTask, PanelConfigTask panelConfigTask) {
        this.kanbanPro = kanbanPro;
        this.panelAddTask = panelAddTask;
        this.panelConfigTask = panelConfigTask;
        this.invoker = new CommandTaskInvoker(kanbanPro.getBtn_undo(), kanbanPro.getBtn_redo());

        CustomAlert alert = new CustomAlert();

        this.kanbanPro.getBtn_add().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelAddTask.setLocationRelativeTo(null);
                panelAddTask.setVisible(true);
            }
        });

        this.panelAddTask.getBtn_add().addActionListener((ActionEvent e) -> {
            UniqueIDGenerator uniqueIDGenerator = new UniqueIDGenerator();
            if (!panelAddTask.getInput_name().getText().isBlank() && !panelAddTask.getInput_lastname().getText().isBlank() && !panelAddTask.getTxt_description().getText().isBlank()) {
                AddTaskCommand addTask = new AddTaskCommand();
                invoker.addTask(addTask, kanbanPro.getTable(), uniqueIDGenerator.idGenerator(), panelAddTask.getInput_name(), panelAddTask.getInput_lastname(), panelAddTask.getSp_priority(), panelAddTask.getTxt_description());
                alert.successfulAlert("Se agregó la tarea de forma exitosa.");
                panelAddTask.getInput_name().setText("");
                panelAddTask.getInput_lastname().setText("");
                panelAddTask.getTxt_description().setText("");
                panelAddTask.getSp_priority().setValue(1);
                panelAddTask.getInput_name().requestFocus();
            } else {
                alert.warningAlert("Complete los campos antes de agregar una tarea.");
            }
        });

        this.kanbanPro.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = kanbanPro.getTable().rowAtPoint(e.getPoint());
                column = kanbanPro.getTable().columnAtPoint(e.getPoint());

                if (row >= 0 && column >= 0 && kanbanPro.getTable().getValueAt(row, column) != null) {
                    int response = alert.questionAlert("Elige una opción que deseas aplicar a la tarea.");
                    if (response == 0) {
                        // Editar
                        ReadTaskCommand readTask = new ReadTaskCommand();
                        invoker.readTask(readTask, panelConfigTask, row, column, kanbanPro.getTable());
                    } else if (response == 1) {
                        // Eliminar
                        DeleteTaskCommand deleteTask = new DeleteTaskCommand();
                        invoker.deleteTask(deleteTask, row, column, kanbanPro.getTable());
                    }
                }
            }
        });

        this.panelConfigTask.getBtn_update().addActionListener((ActionEvent e) -> {
            PropertyLocalDateTime propertyLocalDateTime = new PropertyLocalDateTime();
            UpdateTaskCommand updateTask = new UpdateTaskCommand();
            invoker.updateTask(updateTask, kanbanPro.getTable(), row, column, panelConfigTask.getId().getText(), panelConfigTask.getInput_name(), panelConfigTask.getInput_lastname(), panelConfigTask.getCb_status(), panelConfigTask.getSp_priority(), panelConfigTask.getText_description(), propertyLocalDateTime.nowLocalDateTime());
            panelConfigTask.dispose();
        });

        this.kanbanPro.getBtn_undo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invoker.undo(kanbanPro.getTable());
            }
        });

        this.kanbanPro.getBtn_redo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invoker.redo(kanbanPro.getTable());
            }
        });
    }
}
