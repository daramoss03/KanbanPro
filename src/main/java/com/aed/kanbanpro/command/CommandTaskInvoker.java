package com.aed.kanbanpro.command;

import com.aed.kanbanpro.model.AddCommand;
import com.aed.kanbanpro.model.DeleteCommand;
import com.aed.kanbanpro.model.ReadCommand;
import com.aed.kanbanpro.model.UndoRedoCommand;
import com.aed.kanbanpro.model.UpdateCommand;
import com.aed.kanbanpro.util.stack.CustomStack;
import com.aed.kanbanpro.view.PanelConfigTask;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CommandTaskInvoker {
    private final CustomStack<UndoRedoCommand> undoStack = new CustomStack<>();
    private final CustomStack<UndoRedoCommand> redoStack = new CustomStack<>();

    private final JMenu btn_undo;
    private final JMenu btn_redo;

    public CommandTaskInvoker(JMenu btn_undo, JMenu btn_redo) {
        this.btn_undo = btn_undo;
        this.btn_redo = btn_redo;
        updateButtons();
    }

    public void addTask(AddCommand task, JTable table, String id, JTextField name, JTextField lastName, JSpinner priority, JTextArea description) {
        task.addTask(table, id, name, lastName, priority, description);
        if (task instanceof UndoRedoCommand undoRedoCommand) {
            undoStack.push(undoRedoCommand);
            redoStack.clear();
        }
        updateButtons();
    }

    public void deleteTask(DeleteCommand task, int row, int column, JTable table) {
        task.deleteTask(row, column, table);
        if (task instanceof UndoRedoCommand undoRedoCommand) {
            undoStack.push(undoRedoCommand);
            redoStack.clear();
        }
        updateButtons();
    }

    public void updateTask(UpdateCommand task, JTable table, int row, int column, String id, JTextField name, JTextField lastName, JComboBox<String> status, JSpinner priority, JTextArea description, String dateTime) {
        task.updateTask(table, row, column, id, name, lastName, status, priority, description, dateTime);
        if (task instanceof UndoRedoCommand undoRedoCommand) {
            undoStack.push(undoRedoCommand);
            redoStack.clear();
        }
        updateButtons();
    }
    
    public void readTask(ReadCommand task, PanelConfigTask panelConfigTask, int row, int column, JTable table) {
        task.readTask(panelConfigTask, row, column, table);
        if (task instanceof UndoRedoCommand undoRedoCommand) {
            undoStack.push(undoRedoCommand);
            redoStack.clear();
        }
        updateButtons();
    }

    public void undo(JTable table) {
        if (!undoStack.isEmpty()) {
            UndoRedoCommand lastCommand = undoStack.pop();
            lastCommand.undo(table);
            redoStack.push(lastCommand);
            updateButtons();
        }
    }

    public void redo(JTable table) {
        if (!redoStack.isEmpty()) {
            UndoRedoCommand lastUndoneCommand = redoStack.pop();
            lastUndoneCommand.redo(table);
            undoStack.push(lastUndoneCommand);
            updateButtons();
        }
    }

    private void updateButtons() {
        btn_undo.setEnabled(!undoStack.isEmpty());
        btn_redo.setEnabled(!redoStack.isEmpty());
    }
}
