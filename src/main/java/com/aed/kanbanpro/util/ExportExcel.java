package com.aed.kanbanpro.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Color;

public class ExportExcel {
    public static void exportToExcel(JTable table) {
        // Pedir al usuario el nombre del archivo
        String fileName = JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo:");

        // Si el usuario cancela, salir del método
        if (fileName == null || fileName.isEmpty()) {
            return;
        }

        // Crear un nuevo libro de Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Tabla");

        // Estilos para las cabeceras de la tabla principal
        String[] columnColors = {"#156082", "#007d38", "#008abd", "#c00000", "#997200"};

        // Crear las filas y celdas para las cabeceras de la tabla principal
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < table.getColumnCount(); i++) {
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(hexToColor(columnColors[i], workbook));
            // Configurar el alineamiento horizontal
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            // Configurar el alineamiento vertical
            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.WHITE.getIndex());
            headerStyle.setFont(headerFont);

            Cell cell = headerRow.createCell(i * 2);
            cell.setCellValue(table.getColumnName(i));
            cell.setCellStyle(headerStyle);

            // Fusionar las celdas
            sheet.addMergedRegion(new CellRangeAddress(0, 0, i * 2, i * 2 + 1));
        }

        // Acceder a los datos de la subtabla si existe
        int rowIndex = 1; // Empezar desde la segunda fila (después de las cabeceras principales)
        for (int rows = 0; rows < table.getRowCount(); rows++) {
            for (int columns = 0; columns < table.getColumnCount(); columns++) {
                if (table.getValueAt(rows, columns) instanceof JTable subTable) {
                    // Procesar los datos de la subtabla
                    for (int i = 0; i < subTable.getRowCount(); i++) {
                        Row row = sheet.getRow(i + rowIndex); // Obtener la fila correspondiente en la hoja de cálculo
                        if (row == null) {
                            row = sheet.createRow(i + rowIndex); // Si la fila no existe, créala
                        }
                        for (int j = 0; j < subTable.getColumnCount(); j++) {
                            Object value = subTable.getValueAt(i, j);
                            Cell cell = row.createCell(columns * subTable.getColumnCount() + j); // Calcular el índice de la columna
                            if (value != null) {
                                cell.setCellValue(value.toString());
                            }
                            if (j == 0) {
                                // Aplicar estilos solo a la primera columna si es necesario
                                CellStyle cellStyle = workbook.createCellStyle();
                                cellStyle.setFillForegroundColor(hexToColor("#414141", workbook)); // Color salmón
                                cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                                Font font = workbook.createFont();
                                font.setBold(true);
                                font.setColor(IndexedColors.WHITE.getIndex());
                                cellStyle.setFont(font);
                                cell.setCellStyle(cellStyle);
                            }
                        }
                    }
                    // Incrementar el índice de fila para la siguiente subtabla
                    rowIndex += subTable.getRowCount();
                }
            }
        }


        // Pedir al usuario la ubicación del archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione la carpeta donde guardar el archivo");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String savePath = fileChooser.getSelectedFile().getPath() + "/" + fileName + ".xlsx";

            // Guardar el libro de Excel en el archivo
            try (FileOutputStream outputStream = new FileOutputStream(savePath)) {
                workbook.write(outputStream);
                JOptionPane.showMessageDialog(null, "El archivo se ha guardado exitosamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo.");
            }
        }
    }

    private static Color hexToColor(String hex, Workbook workbook) {
        byte[] rgb = hexToRGB(hex);
        XSSFColor color = new XSSFColor();
        color.setRGB(rgb);
        return color;
    }

    private static byte[] hexToRGB(String hex) {
        byte[] rgb = new byte[3];
        rgb[0] = (byte) Integer.parseInt(hex.substring(1, 3), 16);
        rgb[1] = (byte) Integer.parseInt(hex.substring(3, 5), 16);
        rgb[2] = (byte) Integer.parseInt(hex.substring(5, 7), 16);
        return rgb;
    }
}
