package xlsx;

import entities.*;
import java.io.FileOutputStream;
import java.util.Collection;
import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.xssf.usermodel.*;
public class XlsxWriter {

    public static void adressesWrite(String excelFileName, Collection<AddresAndro> entities) throws Exception {

        String sheetName = "Sheet1";//name of sheet
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFCreationHelper helper = wb.getCreationHelper();
        XSSFSheet sheet = wb.createSheet(sheetName);
        int index = 0;
        XSSFRow r1 = sheet.createRow(index);
        r1.createCell(0).setCellValue("Id");
        r1.createCell(1).setCellValue("Страна");
        r1.createCell(2).setCellValue("Град");
        r1.createCell(3).setCellValue("Квартал");
        r1.createCell(4).setCellValue("Улица");
        r1.createCell(5).setCellValue("Номер");
        r1.createCell(6).setCellValue("Вход");
        r1.createCell(7).setCellValue("Статус");
        r1.createCell(8).setCellValue("Широчина");
        r1.createCell(9).setCellValue("Дължина");
        r1.createCell(10).setCellValue("Детайли");
        r1.createCell(11).setCellValue("Телефонен_номер");
        r1.createCell(12).setCellValue("Протребители");
        r1.createCell(13).setCellValue("Заключен");
        //iterating r number of rows
        for (AddresAndro entity : entities) {
            index++;
            XSSFRow row = sheet.createRow(index);
            row.createCell(1).setCellValue(entity.Id);

            row.createCell(0).setCellValue(entity.Id);
            row.createCell(1).setCellValue(entity.Страна);
            row.createCell(2).setCellValue(entity.Град);
            row.createCell(3).setCellValue(entity.Квартал);
            row.createCell(4).setCellValue(entity.Улица);
            row.createCell(5).setCellValue(entity.Номер);
            row.createCell(6).setCellValue(entity.Вход);
            row.createCell(7).setCellValue(entity.Статус);
            row.createCell(8).setCellValue(entity.Широчина);
            row.createCell(9).setCellValue(entity.Дължина);
            row.createCell(10).setCellValue(entity.Детайли);
            row.createCell(11).setCellValue(entity.Телефонен_номер);
            row.createCell(12).setCellValue(entity.Протребители);
            row.createCell(13).setCellValue(entity.Заключен);

        }
        FileOutputStream fileOut = new FileOutputStream(excelFileName);
        //write this workbook to an Outputstream.
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

    public static void companiesToXlsx(String excelFileName, Collection<Company> companies) throws Exception {

        String sheetName = "Sheet1";//name of sheet
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFCreationHelper helper = wb.getCreationHelper();
        XSSFSheet sheet = wb.createSheet(sheetName);
        int index = 0;
        XSSFRow r1 = sheet.createRow(index);
        r1.createCell(1).setCellValue("Название");
        r1.createCell(2).setCellValue("Сайты");
        r1.createCell(3).setCellValue("Гугл_поиск");
        r1.createCell(4).setCellValue("Перепроверить");
        //iterating r number of rows
        for (Company company : companies) {
            index++;
            XSSFRow row = sheet.createRow(index);
            row.createCell(1).setCellValue(company.name);
            XSSFCell sitesCell = row.createCell(2);
            if (company.sites.size() == 1) {
                try {
                    for (String site : company.sites) {
                        sitesCell.setCellValue(site);
                        XSSFHyperlink url_link1 = helper.createHyperlink(Hyperlink.LINK_URL);
                        url_link1.setAddress(site);
                        sitesCell.setHyperlink(url_link1);
                    }
                } catch (Exception ex) {
                    sitesCell.setCellValue(" ошибка!");
                }
            } else {
                sitesCell.setCellValue(company.getFormattedSites());
            }

            XSSFCell google = row.createCell(3);
            google.setCellValue("поиск в Google");
            try {
                XSSFHyperlink url_link = helper.createHyperlink(Hyperlink.LINK_URL);
                url_link.setAddress("http://www.google.com/?ion=1&espv=2#safe=off&q=" + company.name.replaceAll(" ", "+"));
                url_link.setTooltip("поиск в Google");
                google.setHyperlink(url_link);
            } catch (Exception ex) {
                sitesCell.setCellValue(" ошибка!");
            }
            row.createCell(4).setCellValue(company.sites.size() == 1 ? "" : "+");
        }
        FileOutputStream fileOut = new FileOutputStream(excelFileName);
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }
}
