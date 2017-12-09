package poi;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

/**
 *  * 创建空白工作薄
 *  *
 *  * @author xiaoqi
 *  * @since 29 十一月 2017
 *  
 */
public class CreateWorkBook {

    public static void main (String[] args) throws Exception {
        // create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        // create file system using specific name
        FileOutputStream out = new FileOutputStream(
                new File("createworkbook.xlsx"));
        //write operation workbook using file out object
        workbook.write(out);
        out.close();
        System.out.println("createworkbook.xlsx written successfully");

    }
}
