
import entities.AddresAndro;
import entities.Car;
import entities.Zone;
import http.HTTPClient;
import java.util.*;

public class Parser {

    private static String[] storedRaw;
    private static int rawPointer = 0;

    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();
        /*
        HTTPClient http = new HTTPClient();

        List<AddresAndro> values = new ArrayList<>();
        int max = 57356;
        for (int i = 1; i <= max; i++) {
           // System.out.println("http://eco.andromix.eu/address/edit/id/" + i);
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
            System.out.println("remaning " + (max - i));
           // System.out.println("");
        }
         */
        int max = 259;
        List<Car> values = parseCars(max);
        long parsed = System.nanoTime();
        xlsx.XlsxWriter.carsWrite("cars_" + System.nanoTime() + "_.xlsx", values);
        long fileCreated = System.nanoTime();
        System.out.println("processed " + max + " pages");
        System.out.println("in seconds");
        System.out.println("parsing: " + (parsed - start) / 1000000000d);
        System.out.println("file creating: " + (fileCreated - parsed) / 1000000000d);
        System.out.println("total: " + (fileCreated - start) / 1000000000d);
//        System.out.println("57356 / "+max+" = "+((57356d/max)*((fileCreated-start)/1000000000d)));
    }

    private static List<Zone> parseZones(int max) throws Exception {
        HTTPClient http = new HTTPClient();
        List<Zone> values = new ArrayList<>();

        long start = System.nanoTime();
        for (int i = 1; i <= max; i++) {
            String result = http.sendGet("http://eco.andromix.eu/zones/edit/id/" + i);
            if (!result.contains("Редактиране")) {
                System.out.println("SKIPPED");
                continue;
            }
            Zone z = new Zone();
            z.Id = i;

            String[] itemsRaw = result.split("form id=\"formzones")[1].split("</form>")[0].split("<div class=\"controls\">");
            if (itemsRaw.length != 12) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!itemsRaw.length!=12 but" + itemsRaw.length);
                continue;
            }
            z.Име = fromRaw(itemsRaw[1]);
            z.Опашка = fromRaw(itemsRaw[2]);
            z.Приоритетна_опашка = fromRaw(itemsRaw[3]);
            z.Следваща_опашка_1 = fromRaw(itemsRaw[4]);
            z.Следваща_опашка_2 = fromRaw(itemsRaw[5]);
            z.Позиция = fromRaw(itemsRaw[6]);
            z.Точки = fromRaw(itemsRaw[7]);
            z.Активна_от = fromRaw(itemsRaw[8]);
            z.Активна_до = fromRaw(itemsRaw[9]);
            z.IDта_на_разрешени_зони = fromRaw(itemsRaw[10]);
            z.Статус = fromRaw(itemsRaw[11]);
            values.add(z);
            System.out.println(/*"remaning " +*/(max - i));
        }
        return values;
    }

    private static List<Car> parseCars(int max) throws Exception {
        HTTPClient http = new HTTPClient();
        List<Car> values = new ArrayList<>();

        long start = System.nanoTime();
        for (int i = 1; i <= max; i++) {
            String result = http.sendGet("http://eco.andromix.eu/cars/edit/id/" + i);
            if (!result.contains("Редактиране")) {
                System.out.println("SKIPPED");
                continue;
            }
            Car c = new Car();
            c.Id = i;

            String[] itemsRaw = result.split("form id=\"formacars")[1].split("</form>")[0].split("<div class=\"controls\">");
            if (itemsRaw.length != 30) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!itemsRaw.length!=30 but" + itemsRaw.length);
                continue;
            }
            storedRaw = itemsRaw;
            rawPointer = 1;
            c.Номер = fromNextRaw();
            c.Модел = fromNextRaw();
            c.Места = fromNextRaw();
            c.Година = fromNextRaw();
            c.Климатик = fromNextRaw();
            c.Пушачи = fromNextRaw();
            c.Състояние = fromNextRaw();
            c.Винетка = fromNextRaw();
            c.Може_да_мине_граница = fromNextRaw();
            c.Услуги = fromNextRaw();
            c.Drink_and_drive = fromNextRaw();
            c.Черен_път = fromNextRaw();
            c.Ел_кабел = fromNextRaw();
            c.Въже = fromNextRaw();
            c.Фактура = fromNextRaw();
            c.Товарно_пространство_литри = fromNextRaw();
            c.Приема_животни = fromNextRaw();
            c.Гориво = fromNextRaw();
            c.Тип = fromNextRaw();
            c.Wifi = fromNextRaw();
            c.Връзка_с_апарата = fromNextRaw();
            c.Допълнителна_информация = fromNextRaw();
            c.Индивидуални_цени = fromNextRaw();
            c.Индивидуална_начална_сума = fromNextRaw();
            c.Индивидуална_дневна_тарифа = fromNextRaw();
            c.Индивидуална_дневна_престой = fromNextRaw();
            c.Индивидуална_нощна_тарифа = fromNextRaw();
            c.Индивидуална_нощна_престой = fromNextRaw();
            c.Допълнителни_данни = fromNextRaw();
            values.add(c);
            System.out.println(/*"remaning " +*/(max - i));
        }
        return values;
    }

    private static String fromNextRaw() {
        return fromRaw(storedRaw[rawPointer++]);
    }

    private static String fromRaw(String raw) {
        if (raw.contains("<select")) {
            if (raw.contains("multiple")) {
                return fromMultiSelect(raw);
            }
            return fromSelect(raw);
        }
        if (raw.contains("<input")) {
            return fromInput(raw);
        }
        if (raw.contains("<textarea")) {
            return fromTextarea(raw);
        }
        return "??????????????????";
    }

    private static String fromTextarea(String raw) {
        return raw.split("cols=\"80\">")[1].split("</textarea>")[0].replace("&quot;", "\"");
    }

    private static String fromInput(String raw) {
        return raw.split("\" value=\"")[1].split("\"></div>")[0];
    }

    private static String fromSelect(String raw) {
        for (String c : raw.split("<option value")) {
            if (c.contains("selected=\"selected\"")) {
                return c.split("selected=\"selected\">")[1].split("</optio")[0];
            }
        }
        return "";
    }
    private static String fromMultiSelect(String raw) {
        String r = "";
        for (String c : raw.split("<option value")) {
            if (c.contains("selected=\"selected\"")) {
                r += c.split(">")[1].split("<")[0] + "\n";
            }
        }
        return r;
    }

//    private static Set<String> parseSites(String sitesRaw) {
//        Set<String> sites = new LinkedHashSet<>();
//        for (String site : sitesRaw.split(" ")) {
//            if (site.contains(".")) {
//                sites.add(site.endsWith("/") ? site : site + "/");
//            }
//        }
//        return sites;
//    }
}
