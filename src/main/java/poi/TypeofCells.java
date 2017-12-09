package poi;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 *  *
 *  *
 *  * @author xiaoqi
 *  * @since 01 十二月 2017
 *  
 */
public class TypeofCells {

    public static void main (String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadSheet = workbook.createSheet("cell types");
        //第3行，rownum 代表行号，0 为第一行
        XSSFRow row = spreadSheet.createRow(2);
        row.createCell(0).setCellValue("Type of Cell");
        row.createCell(1).setCellValue("cell value");

        //第4行， 创建一个空单元格
        row = spreadSheet.createRow(3);
        row.createCell(0).setCellValue("set cell type Blank");
        row.createCell(1);

        //第五行，创建一个Boolean类型单元格
        row = spreadSheet.createRow(4);
        row.createCell(0).setCellValue("set cell type Boolean");
        row.createCell(1).setCellValue(true);

        //第6行，创建一个XSSFCell.CELL_TYPE_ERROR的单元格
        row = spreadSheet.createRow(5);
        row.createCell(0).setCellValue("set cell type Error");
        row.createCell(1).setCellValue(XSSFCell.CELL_TYPE_ERROR);

        row = spreadSheet.createRow(6);
        row.createCell(0).setCellValue("set cell type date");
        row.createCell(1).setCellValue(new Date());

        row = spreadSheet.createRow(7);
        row.createCell(0).setCellValue("set cell type numeric");
        row.createCell(1).setCellValue(20);

        row = spreadSheet.createRow(8);
        row.createCell(0).setCellValue("set cell type string");
        row.createCell(1).setCellValue("A String");


        FileOutputStream out = new FileOutputStream(new File("typeofcells.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("typeofcell.xlxs written successfully");
    }
}
