package com.challengeeldar.challenge.Utils;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {
    
    public <T> void saveListToExcel(List<T> list, String filePath) throws IOException, IllegalAccessException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        if (list.isEmpty()) {
            workbook.close();
            return;
        }

        // Create header row
        Row headerRow = sheet.createRow(0);
        Field[] fields = list.get(0).getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            headerRow.createCell(i).setCellValue(fields[i].getName());
        }

        // Fill data rows
        int rowNum = 1;
        for (T item : list) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                Object value = fields[i].get(item);
                if (value != null) {
                    row.createCell(i).setCellValue(value.toString());
                }
            }
        }

        // Write to file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }

        workbook.close();
    }

    public <T> List<T> readExcelFileToList(String filePath, Class<T> clazz) throws IOException, InstantiationException, IllegalAccessException {
        try{
            List<T> list = new ArrayList<>();
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Field[] fields = clazz.getDeclaredFields();

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }

                
                T instance = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    Cell cell = row.getCell(i);

                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                if (fields[i].getType() == int.class || fields[i].getType() == Integer.class) {
                                    fields[i].set(instance, Integer.parseInt(cell.getStringCellValue()));
                                } else {
                                    fields[i].set(instance, cell.getStringCellValue());
                                }
                                break;
                            case NUMERIC:
                                if (fields[i].getType() == int.class || fields[i].getType() == Integer.class) {
                                    fields[i].set(instance, (int) cell.getNumericCellValue());
                                } else if (fields[i].getType() == double.class || fields[i].getType() == Double.class) {
                                    fields[i].set(instance, cell.getNumericCellValue());
                                } else if (fields[i].getType() == long.class || fields[i].getType() == Long.class) {
                                    fields[i].set(instance, (long) cell.getNumericCellValue());
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
                list.add(instance);
            }

            workbook.close();
            file.close();
            return list;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
        
    }

    public <T> Boolean deleteById(List<T> list, int id, String filePath) throws IllegalAccessException {
        Iterator<T> iterator = list.iterator();
        try{
            while (iterator.hasNext()) {
                T item = iterator.next();
                Field idField = item.getClass().getDeclaredFields()[0];
                idField.setAccessible(true);

                if (idField.getType() == int.class || idField.getType() == Integer.class) {
                    int itemId = (int) idField.get(item);
                    if (itemId == id) {
                        iterator.remove();
                        return true;
                    }
                }
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
