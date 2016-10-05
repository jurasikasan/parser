import entities.AddresAndro;
import http.HTTPClient;
import java.util.*;

public class Parser {

    public static void main(String[] args) throws Exception {

        HTTPClient http = new HTTPClient();

        List<AddresAndro> values = new ArrayList<>();
        int max = 2;
        long start = System.nanoTime();
        for (int i = 1; i <= max; i++) {
            String result = http.sendGet("http://eco.andromix.eu/address/edit/id/" + i);
            if (!result.contains("Редактиране")) {
                System.out.println("SKIPPED");
                continue;
            }
            AddresAndro a = new AddresAndro();
            a.Id = i;

            String[] itemsRaw = result.split("form id=\"formaddress\"")[1].split("</form>")[0].split("<div class=\"controls\">");
            if (itemsRaw.length != 14) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!itemsRaw.length!=14");
                continue;
            }
            for (String c : itemsRaw[1].split("<option value")) {
                if (c.contains("selected=\"selected\"")) {
                    a.Страна = c.split("selected=\"selected\">")[1].split("</optio")[0];
                    break;
                }
            }
            for (String c : itemsRaw[2].split("<option value")) {
                if (c.contains("selected=\"selected\"")) {
                    a.Град = c.split("selected=\"selected\">")[1].split("</optio")[0];
                    break;
                }
            }
            for (String c : itemsRaw[3].split("<option value")) {
                if (c.contains("selected=\"selected\"")) {
                    a.Квартал = c.split("selected=\"selected\">")[1].split("</optio")[0];
                    break;//57351
                }
            }
            a.Улица = itemsRaw[4].split("\" value=\"")[1].split("\"></div>")[0];
            a.Номер = itemsRaw[5].split("\" value=\"")[1].split("\"></div>")[0];
            a.Вход = itemsRaw[6].split("\" value=\"")[1].split("\"></div>")[0];
            for (String c : itemsRaw[7].split("<option value")) {
                if (c.contains("selected=\"selected\"")) {
                    a.Статус = c.split("selected=\"selected\">")[1].split("</optio")[0];
                    break;
                }
            }
            a.Широчина = itemsRaw[8].split("\" value=\"")[1].split("\" ")[0];
            a.Дължина = itemsRaw[9].split("\" value=\"")[1].split("\" ")[0];
            a.Детайли = itemsRaw[10].split("cols=\"80\">")[1].split("</textarea>")[0];
            a.Телефонен_номер = itemsRaw[11].split("\" value=\"")[1].split("\"></div>")[0];
            a.Протребители = itemsRaw[12].split("cols=\"80\">")[1].split("</textarea>")[0];
            for (String c : itemsRaw[13].split("<option value")) {
                if (c.contains("selected=\"selected\"")) {
                    a.Заключен = c.split("selected=\"selected\">")[1].split("</optio")[0];
                    break;
                }
            }
            values.add(a);
            System.out.println(/*"remaning " +*/(max - i));
            // System.out.println("");
        }
        long parsed = System.nanoTime();
        xlsx.XlsxWriter.adressesWrite("addreses_" + System.nanoTime() + "_.xlsx", values);
        long fileCreated = System.nanoTime();
        System.out.println("processed " + max + " pages");
        System.out.println("in seconds");
        System.out.println("parsing: " + (parsed - start) / 1000000000d);
        System.out.println("file creating: " + (fileCreated - parsed) / 1000000000d);
        System.out.println("total: " + (fileCreated - start) / 1000000000d);
    }

}
