package poi;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import sun.security.acl.WorldGroupImpl;

import javax.swing.border.Border;
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

        //Top Left alignment
        XSSFCellStyle style1 = workbook.createCellStyle();
        spreadSheet.setColumnWidth(0, 8000);
        style1.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        style1.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
        cell.setCellValue("Top Left");
        cell.setCellStyle(style1);

        //Center Align Cell Contents
        row = spreadSheet.createRow(6);
        cell = row.createCell(1);
        row.setHeight((short) 800);
        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cell.setCellValue("Center Aligend");
        cell.setCellStyle(style2);

        // Bottom Right alignment
        row = spreadSheet.createRow(7);
        cell = row.createCell(2);
        row.setHeight((short) 800);
        XSSFCellStyle style3 = workbook.createCellStyle();
        style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
        style3.setVerticalAlignment(XSSFCellStyle.VERTICAL_BOTTOM);
        cell.setCellValue("Bottom right");
        cell.setCellStyle(style3);

        //Justified Alignment
        row = spreadSheet.createRow(8);
        cell = row.createCell(3);
        XSSFCellStyle style4 = workbook.createCellStyle();
        style4.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
        cell.setCellValue("Contents are Justified in Alignment");
        cell.setCellStyle(style4);

        //Cell Border 单元格边框
        row = spreadSheet.createRow(9);
        row.setHeight((short) 800);
        cell = row.createCell(1);
        cell.setCellValue("BORDER");
        XSSFCellStyle style5 = workbook.createCellStyle();
        style5.setBorderBottom(BorderStyle.THICK);
        style5.setBottomBorderColor(IndexedColors.BLUE.getIndex());

        style5.setBorderLeft(BorderStyle.DOUBLE);
        style5.setLeftBorderColor(IndexedColors.GREEN.getIndex());

        style5.setBorderTop(BorderStyle.DASH_DOT);
        style5.setTopBorderColor(IndexedColors.RED.getIndex());
        cell.setCellStyle(style5);

        //Fill color
        //background color
        row = spreadSheet.createRow(10);
        cell = row.createCell(1);
        XSSFCellStyle style6 = workbook.createCellStyle();
        style6.setFillBackgroundColor(HSSFColor.LEMON_CHIFFON.index);
        style6.setAlignment(XSSFCellStyle.ALIGN_FILL);
        style6.setFillPattern(XSSFCellStyle.LESS_DOTS);
        spreadSheet.setColumnWidth(1, 8000);
        cell.setCellValue("Fill Backgroud/ Fill Pattern");
        cell.setCellStyle(style6);

        //Foreground color
        row = spreadSheet.createRow(12);
        cell = row.createCell(1);
        XSSFCellStyle style7 = workbook.createCellStyle();
        style7.setFillForegroundColor(HSSFColor.BLUE.index);
        style7.setFillPattern(XSSFCellStyle.LESS_DOTS);
        style7.setAlignment(XSSFCellStyle.ALIGN_FILL);
        cell.setCellValue("Fill foreground / fill Pattern");
        cell.setCellStyle(style7);






        FileOutputStream out = new FileOutputStream(
                new File("cellstyle.xlsx")
        );
        workbook.write(out);
        out.close();
        System.out.println("cellstyle.xlsx written successfully");

    }
}