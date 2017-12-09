package poi;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  * 单元格样式
 *  *
 *  * @author xiaoqi
 *  * @since 01 十二月 2017
 *  
 */
public class CellStyle {

    public static void main (String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadSheet = workbook.createSheet("cellStyle");
        XSSFRow row = spreadSheet.createRow(1);
        row.setHeight((short) 800);
        XSSFCell cell = row.createCell(1);
        cell.setCellValue("test of merging");
        //mearging cells
        //this statement for merging cells
        spreadSheet.addMergedRegion(new CellRangeAddress(
                1,      //first row (0-beased)
                1,      //last row (0-based)
                1,      //first column (0-based)
                4       //last cloumn (0-based)
        ));
        //cell alignment
        row = spreadSheet.createRow(5);
        cell = row.createCell(0);
        row.setHeight((short) 800);

        XSSFCellStyle style1 = workbook.createCellStyle();
        spreadSheet.setColumnWidth(0, 8000);
        style1.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        style1.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
        cell.setCellValue("Top Left");


        FileOutputStream out = new FileOutputStream(
                new File("cellstyle.xlsx")
        );
        workbook.write(out);
        out.close();
        System.out.println("cellstyle.xlsx written successfully");

    }
}