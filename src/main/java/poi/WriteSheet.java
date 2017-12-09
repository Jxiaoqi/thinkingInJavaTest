package poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *  *  写一个sheet
 *  *  
 *  * @author xiaoqi  
 *  * @since 30 十一月 2017  
 */
public class WriteSheet {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet spreadSheet = workbook.createSheet("Employee Info");
        XSSFSheet spreadSheet1 = workbook.createSheet("第二个sheet");

        Map<String, Object[]> empinfo = new TreeMap<>();
        empinfo.put("1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
        empinfo.put("2", new Object[] { "tp01", "Gopal", "Technical Manager" });
        empinfo.put("3", new Object[] { "tp02", "Manisha", "Proof Reader" });
        empinfo.put("4", new Object[] { "tp03", "Masthan", "Technical Writer" });
        empinfo.put("5", new Object[] { "tp04", "Satish", "Technical Writer" });

        XSSFRow row;
        Set<String> keyid = empinfo.keySet();
        int rowid = 0;
        for (String key : keyid) {
            row = spreadSheet.createRow(rowid++);
            Object[] objectArr = empinfo.get(key);
            int cellid = 0;
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        FileOutputStream out = new FileOutputStream("Writesheet.xlsx");
        workbook.write(out);
        out.close();
        System.out.println("writesheet.xlsx written successfully");

    }
}
