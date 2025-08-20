package Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelNumberWriter {
    public static void main(String[] args) {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a sheet
        Sheet sheet = workbook.createSheet("Numbers");

        // Create a row (0 = first row)
        Row row = sheet.createRow(0);

        // Create a cell in first column (index 0)
        Cell cell = row.createCell(0);

        // Set the value to the number 9876543210
        cell.setCellValue("9876543210");  // use long literal for large number

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream("NumberData.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file created with number 9876543210!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
