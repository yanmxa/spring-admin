package com.nood.hrm.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import java.awt.Color;

public class ExcelUtil {

    private final static String xls = "xls";
    private final static String xlsx = "xlsx";


    public static void exportExcel(HttpServletResponse response, ExcelData data) throws Exception {

        String fileName = data.getFileName();

        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8"));

        Workbook workbook = getWorkBook(fileName);

        writeToWorkbook(workbook, data);

        workbookToOutputStream(workbook, response.getOutputStream());

    }

    private static void workbookToOutputStream(Workbook workbook, OutputStream out) throws Exception{
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            workbook.close();
        }
    }

    private static void writeToWorkbook(Workbook workbook, ExcelData data) {
        String sheetName = "sheet1";
        if (null != data && null != data.getSheetName()) {
            sheetName = data.getSheetName();
        }

        Sheet sheet = workbook.createSheet(sheetName);
        //设置行高、列宽为自适应（应用于整个工作表）
        int rowIndex = writeHeadsToExcel(workbook, sheet, data.getHeads());
        if (null != data && null != data.getRows()) {
            writeRowsToExcel(workbook, sheet, data.getRows(), rowIndex);
        }
        autoSizeColumns(sheet, data.getHeads().size() + 1);
    }


    private static int writeHeadsToExcel(Workbook workbook, Sheet sheet, List<String> heads) {
        int rowIndex = 0;
        int colIndex = 0;

        Font titleFont = workbook.createFont();
        titleFont.setFontName("simsun");
        //titleFont.setBoldweight(Short.MAX_VALUE);
        // titleFont.setFontHeightInPoints((short) 14);
        titleFont.setColor(IndexedColors.BLACK.index);

        XSSFCellStyle titleStyle = (XSSFCellStyle) workbook.createCellStyle();
        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        titleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        titleStyle.setFont(titleFont);
        setBorder(titleStyle, BorderStyle.THIN, new XSSFColor(new Color(0, 0, 0)));

        Row titleRow = sheet.createRow(rowIndex);
        // titleRow.setHeightInPoints(25);

        for (String field : heads) {
            Cell cell = titleRow.createCell(colIndex);
            cell.setCellValue(field);
            cell.setCellStyle(titleStyle);
            sheet.autoSizeColumn(colIndex);
            colIndex++;
        }
        rowIndex++;
        return rowIndex;
    }


    private static int writeRowsToExcel(Workbook wb, Sheet sheet, List<List<Object>> rows, int rowIndex) {

        Font dataFont = wb.createFont();
        dataFont.setFontName("simsun");
        // dataFont.setFontHeightInPoints((short) 14);
        dataFont.setColor(IndexedColors.BLACK.index);

        CellStyle dataStyle = wb.createCellStyle();
        dataStyle.setAlignment(CellStyle.ALIGN_CENTER);
        dataStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        dataStyle.setFont(dataFont);
//        setBorder(dataStyle, BorderStyle.THIN, new XSSFColor(new Color(0, 0, 0)));
        for (List<Object> rowData : rows) {
            Row dataRow = sheet.createRow(rowIndex);
            // dataRow.setHeightInPoints(25);
            int colIndex = 0;
            for (Object cellData : rowData) {
                Cell cell = dataRow.createCell(colIndex);
                if (cellData != null) {
                    cell.setCellValue(cellData.toString());
                } else {
                    cell.setCellValue("");
                }

                cell.setCellStyle(dataStyle);
                colIndex++;
            }
            rowIndex++;
        }
        return rowIndex;
    }


    private static void autoSizeColumns(Sheet sheet, int columnNumber) {

        for (int i = 0; i < columnNumber; i++) {
            int orgWidth = sheet.getColumnWidth(i);
            sheet.autoSizeColumn(i, true);
            int newWidth = (int) (sheet.getColumnWidth(i) + 100);
            if (newWidth > orgWidth) {
                sheet.setColumnWidth(i, newWidth);
            } else {
                sheet.setColumnWidth(i, orgWidth);
            }
        }
    }

    private static void setBorder(XSSFCellStyle style, BorderStyle border, XSSFColor color) {
        style.setBorderTop(border);
        style.setBorderLeft(border);
        style.setBorderRight(border);
        style.setBorderBottom(border);
        style.setBorderColor(XSSFCellBorder.BorderSide.TOP, color);
        style.setBorderColor(XSSFCellBorder.BorderSide.LEFT, color);
        style.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, color);
        style.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, color);
    }



    private static Workbook getWorkBook(String fileName) {
        Workbook workbook = null;
        if(fileName.endsWith(xls)){
            workbook = new HSSFWorkbook();
        } else if (fileName.endsWith(xlsx)){
            workbook = new XSSFWorkbook();
        }
        return workbook;
    }




}
