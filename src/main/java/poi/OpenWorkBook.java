package poi;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *  * 打开现有工作薄
 *  *
 *  * @author xiaoqi
 *  * @since 30 十一月 2017
 *  
 */
public class OpenWorkBook {
    public static void main (String[] args) throws IOException {
        File file = new File("createworkbook.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
        if (file.isFile() && file.exists()) {
            System.out.println("createworkbook.xlsx file open successfully");
        } else {
            System.out.println("Error open createworkbook.xlsx file");
        }

    }
}
