package xlsx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class XlsxReader {
       public static List<String> readBooksFromExcelFile(String excelFilePath) throws IOException {
        List<String> names = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new HSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        int roww = 0;
        while (iterator.hasNext()) {
            roww++;
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            if (roww <= 5) {
                continue;
            }
            int celll = 0;
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                celll++;
                if (celll == 1) {
                    continue;
                }
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                     //   System.out.print(cell.getStringCellValue() + "\t");
                        names.add(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                      //  System.out.print(cell.getNumericCellValue() + "\t");
                        names.add(String.valueOf(cell.getNumericCellValue()));
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                     //   System.out.print(cell.getBooleanCellValue() + "\t");
                        names.add(String.valueOf(cell.getBooleanCellValue()));
                        break;
                    default:
                }

            }
//            System.out.println();
        }

        workbook.close();
        inputStream.close();

        return names;
    }
}
