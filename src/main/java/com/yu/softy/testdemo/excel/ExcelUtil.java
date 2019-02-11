package com.yu.softy.testdemo.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExcelUtil {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static XSSFWorkbook generateExcel(Class<?> c, List<?> dataList){
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        Row row = sheet.createRow(0);
        generateTitles(c, row);
        generateContent(sheet, c, dataList);
        return wb;
    }

    private static void generateContent(XSSFSheet sheet, Class<?> c, List<?> dataList) {
        List<String> fieldNames = getFiledNames(c);
        for (int i = 0; i < dataList.size(); i++) {
            Row newRow = sheet.createRow(i + 1);
            for (int j = 0; j < fieldNames.size(); j++){
                newRow.createCell(j);
                String value = getFieldValue(c, dataList.get(i), fieldNames.get(j));
                newRow.getCell(j).setCellValue(value);
            }
        }
    }

    private static void generateTitles(Class<?> c, Row row) {
        List<String> titles = Stream.of(c.getDeclaredFields())
                .map(field -> field.getAnnotation(ExcelResources.class))
                .sorted(Comparator.comparing(ExcelResources::order))
                .map(ExcelResources::title)
                .collect(Collectors.toList());
        for (int col = 0; col < titles.size(); col++) {
            row.createCell(col);
            row.getCell(col).setCellValue(titles.get(col));
        }
    }

    private static List<String> getFiledNames(Class<?> c) {
        return Stream.of(c.getDeclaredFields())
                .map(field -> field.getAnnotation(ExcelResources.class))
                .sorted(Comparator.comparing(ExcelResources::order))
                .map(ExcelResources::fieldName)
                .collect(Collectors.toList());
    }

    private static String getFieldValue(Class<?> c, Object o, String filedName) {
        try {
            Field nameField = c.getDeclaredField(filedName);
            nameField.setAccessible(true);
            return Optional.ofNullable(nameField.get(o))
                    .map(obj -> {
                        if (obj instanceof Date) {
                            return dateFormatYYYYMMDDHHMMSS((Date) obj);
                        } else {
                            return String.valueOf(obj);
                        }
                    }).orElse("");
        } catch (Exception e) {

        }
        return "";
    }

    private static String dateFormatYYYYMMDDHHMMSS(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        return simpleDateFormat.format(date);
    }
}
