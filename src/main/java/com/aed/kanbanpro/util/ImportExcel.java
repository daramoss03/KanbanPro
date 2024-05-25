package com.aed.kanbanpro.util;

import com.aed.kanbanpro.util.arrayList.CustomArrayList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Juan Romero Collazos
 */
public class ImportExcel {
    public static void importFromExcel(JTable table) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione un archivo Excel");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos Excel", "xlsx")); // Filtro para mostrar solo archivos .xlsx

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {
                Sheet sheet = workbook.getSheetAt(0);

                DefaultTableModel model = (DefaultTableModel) table.getModel();

                boolean isInsideTable = false;

                for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);
                    if (row != null) {
                        // Buscar la celda "ID" y verificar si la celda adyacente contiene su valor
                        for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                            Cell cell = row.getCell(cellIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                            if (cell.getStringCellValue().equalsIgnoreCase("ID")) {
                                Cell adjacentCell = row.getCell(cellIndex + 1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                                if (adjacentCell.getCellType() == CellType.STRING) {
                                    String idValue = adjacentCell.getStringCellValue();
                                    // Verificar si el valor es un número
                                    if (idValue.matches("\\d+")) {
                                        isInsideTable = true;
                                        break;
                                    }
                                }
                            }
                        }

                        if (isInsideTable) {
                            // Insertar las siguientes 6 filas como una tabla
                            Object[][] tableData = new Object[6][row.getLastCellNum()];
                            for (int i = 0; i < 6; i++) {
                                Row tableRow = sheet.getRow(rowIndex + i);
                                if (tableRow != null) {
                                    for (int j = 0; j < tableRow.getLastCellNum(); j++) {
                                        Cell tableCell = tableRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                                        switch (tableCell.getCellType()) {
                                            case STRING:
                                                tableData[i][j] = tableCell.getStringCellValue();
                                                break;
                                            case NUMERIC:
                                                tableData[i][j] = tableCell.getNumericCellValue();
                                                break;
                                            case BOOLEAN:
                                                tableData[i][j] = tableCell.getBooleanCellValue();
                                                break;
                                            default:
                                                tableData[i][j] = "";
                                        }
                                    }
                                }
                            }

                            // Crear la subtabla
                            JTable subTableData = new JTable(tableData, getColumnIdentifiers(model));
                            PropertyTable propertyTable = new PropertyTable();
                            propertyTable.tableHeaderColor(subTableData, "#AF0404", "#AF0404", "#414141");

                            // Asegurar que las columnas tengan el ancho preferido
                            TableColumnModel subColumnModel = subTableData.getColumnModel();
                            subColumnModel.getColumn(0).setPreferredWidth(80);
                            subColumnModel.getColumn(1).setPreferredWidth(150);

                            // Crear un contenedor para la subtabla
                            JScrollPane scrollPane = new JScrollPane(subTableData);

                            // Agregar el contenedor al modelo de la tabla principal
                            CustomArrayList<Object> rowData = new CustomArrayList<>();
                            rowData.add(scrollPane);
                            for (int i = 1; i < model.getColumnCount(); i++) {
                                rowData.add(""); // Llenar las celdas vacías en la fila principal
                            }
                            model.addRow(rowData.toArray());

                            // Reiniciar la bandera
                            isInsideTable = false;

                            // Saltar las próximas 5 filas
                            rowIndex += 5;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para obtener los identificadores de columna del modelo de tabla
    private static Object[] getColumnIdentifiers(DefaultTableModel model) {
        Object[] columnIdentifiers = new Object[model.getColumnCount()];
        for (int i = 0; i < model.getColumnCount(); i++) {
            columnIdentifiers[i] = model.getColumnName(i);
        }
        return columnIdentifiers;
    }
}
