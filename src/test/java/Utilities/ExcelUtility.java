package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.*;
import java.util.*;

public class ExcelUtility {
    public static ArrayList< ArrayList<String> > getData(String path, String sheetName, int cellCount){
        ArrayList< ArrayList<String> > table = new ArrayList<>();

        Sheet sheet = null;
        try {
            FileInputStream inputStream=new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet=workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());;
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String> cell = new ArrayList<>();
            for (int j = 0; j < cellCount; j++) {
                cell.add(sheet.getRow(i).getCell(j).toString());
            }

            table.add(cell);
        }

        return table;
    }

    public static void writeToExcel(String path, Scenario scenario) {
        File file = new File(path);

        if (!file.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Page1");

            Row newCell = sheet.createRow(0);

            Cell c1 = newCell.createCell(0);
            c1.setCellValue(scenario.getName());

            Cell c2 = newCell.createCell(1);
            c2.setCellValue(scenario.getStatus().toString());

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
        } else {
            FileInputStream inputStream = null;
            Workbook workbook = null;
            Sheet sheet = null;

            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            } catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }

            Row newCell = sheet.createRow(sheet.getPhysicalNumberOfRows());

            Cell c1 = newCell.createCell(0);
            c1.setCellValue(scenario.getName());

            Cell c2 = newCell.createCell(1);
            c2.setCellValue(scenario.getStatus().toString());

            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
        }
    }
}