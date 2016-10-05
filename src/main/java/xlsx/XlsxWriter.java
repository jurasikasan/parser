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

    public static void zonesWrite(String excelFileName, Collection<Zone> entities) throws Exception {

        String sheetName = "Sheet1";//name of sheet
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFCreationHelper helper = wb.getCreationHelper();
        XSSFSheet sheet = wb.createSheet(sheetName);
        int index = 0;
        XSSFRow r1 = sheet.createRow(index);
        r1.createCell(0).setCellValue("Id");
        r1.createCell(1).setCellValue("Име");
        r1.createCell(2).setCellValue("Опашка");
        r1.createCell(3).setCellValue("Приоритетна_опашка");
        r1.createCell(4).setCellValue("Следваща_опашка_1");
        r1.createCell(5).setCellValue("Следваща_опашка_2");
        r1.createCell(6).setCellValue("Позиция");
        r1.createCell(7).setCellValue("Точки");
        r1.createCell(8).setCellValue("Активна_от");
        r1.createCell(9).setCellValue("Активна_до");
        r1.createCell(10).setCellValue("IDта_на_разрешени_зони");
        r1.createCell(11).setCellValue("Статус");
        //iterating r number of rows
        for (Zone entity : entities) {
            index++;
            XSSFRow row = sheet.createRow(index);
            row.createCell(1).setCellValue(entity.Id);

            row.createCell(0).setCellValue(entity.Id);
            row.createCell(1).setCellValue(entity.Име);
            row.createCell(2).setCellValue(entity.Опашка);
            row.createCell(3).setCellValue(entity.Приоритетна_опашка);
            row.createCell(4).setCellValue(entity.Следваща_опашка_1);
            row.createCell(5).setCellValue(entity.Следваща_опашка_2);
            row.createCell(6).setCellValue(entity.Позиция);
            row.createCell(7).setCellValue(entity.Точки);
            row.createCell(8).setCellValue(entity.Активна_от);
            row.createCell(9).setCellValue(entity.Активна_до);
            row.createCell(10).setCellValue(entity.IDта_на_разрешени_зони);
            row.createCell(11).setCellValue(entity.Статус);

        }
        FileOutputStream fileOut = new FileOutputStream(excelFileName);
        //write this workbook to an Outputstream.
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

    public static void carsWrite(String excelFileName, Collection<Car> entities) throws Exception {

        String sheetName = "Sheet1";//name of sheet
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFCreationHelper helper = wb.getCreationHelper();
        XSSFSheet sheet = wb.createSheet(sheetName);
        int index = 0;
        XSSFRow r1 = sheet.createRow(index);
        r1.createCell(0).setCellValue("Id");
        r1.createCell(1).setCellValue("Номер");
        r1.createCell(2).setCellValue("Модел");
        r1.createCell(3).setCellValue("Места");
        r1.createCell(4).setCellValue("Година");
        r1.createCell(5).setCellValue("Климатик");
        r1.createCell(6).setCellValue("Пушачи");
        r1.createCell(7).setCellValue("Състояние");
        r1.createCell(8).setCellValue("Винетка");
        r1.createCell(9).setCellValue("Може_да_мине_граница");
        r1.createCell(10).setCellValue("Услуги");
        r1.createCell(11).setCellValue("Drink_and_drive");
        r1.createCell(12).setCellValue("Черен_път");
        r1.createCell(13).setCellValue("Ел_кабел");
        r1.createCell(14).setCellValue("Въже");
        r1.createCell(15).setCellValue("Фактура");
        r1.createCell(16).setCellValue("Товарно_пространство_литри");
        r1.createCell(17).setCellValue("Приема_животни");
        r1.createCell(18).setCellValue("Гориво");
        r1.createCell(19).setCellValue("Тип");
        r1.createCell(20).setCellValue("Wifi");
        r1.createCell(21).setCellValue("Връзка_с_апарата");
        r1.createCell(22).setCellValue("Допълнителна_информация");
        r1.createCell(23).setCellValue("Индивидуални_цени");
        r1.createCell(24).setCellValue("Индивидуална_начална_сума");
        r1.createCell(25).setCellValue("Индивидуална_дневна_тарифа");
        r1.createCell(26).setCellValue("Индивидуална_дневна_престой");
        r1.createCell(27).setCellValue("Индивидуална_нощна_тарифа");
        r1.createCell(28).setCellValue("Индивидуална_нощна_престой");
        r1.createCell(29).setCellValue("Допълнителни_данни");
        //iterating r number of rows
        for (Car entity : entities) {
            index++;
            XSSFRow row = sheet.createRow(index);
            row.createCell(0).setCellValue(entity.Id);
            row.createCell(1).setCellValue(entity.Номер);
            row.createCell(2).setCellValue(entity.Модел);
            row.createCell(3).setCellValue(entity.Места);
            row.createCell(4).setCellValue(entity.Година);
            row.createCell(5).setCellValue(entity.Климатик);
            row.createCell(6).setCellValue(entity.Пушачи);
            row.createCell(7).setCellValue(entity.Състояние);
            row.createCell(8).setCellValue(entity.Винетка);
            row.createCell(9).setCellValue(entity.Може_да_мине_граница);
            row.createCell(10).setCellValue(entity.Услуги);
            row.createCell(11).setCellValue(entity.Drink_and_drive);
            row.createCell(12).setCellValue(entity.Черен_път);
            row.createCell(13).setCellValue(entity.Ел_кабел);
            row.createCell(14).setCellValue(entity.Въже);
            row.createCell(15).setCellValue(entity.Фактура);
            row.createCell(16).setCellValue(entity.Товарно_пространство_литри);
            row.createCell(17).setCellValue(entity.Приема_животни);
            row.createCell(18).setCellValue(entity.Гориво);
            row.createCell(19).setCellValue(entity.Тип);
            row.createCell(20).setCellValue(entity.Wifi);
            row.createCell(21).setCellValue(entity.Връзка_с_апарата);
            row.createCell(22).setCellValue(entity.Допълнителна_информация);
            row.createCell(23).setCellValue(entity.Индивидуални_цени);
            row.createCell(24).setCellValue(entity.Индивидуална_начална_сума);
            row.createCell(25).setCellValue(entity.Индивидуална_дневна_тарифа);
            row.createCell(26).setCellValue(entity.Индивидуална_дневна_престой);
            row.createCell(27).setCellValue(entity.Индивидуална_нощна_тарифа);
            row.createCell(28).setCellValue(entity.Индивидуална_нощна_престой);
            row.createCell(29).setCellValue(entity.Допълнителни_данни);

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
