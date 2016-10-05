
import entities.*;
import http.HTTPClient;
import java.util.*;

public class Parser {

    private static String[] storedRaw;
    private static int rawPointer = 0;

    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();
        int max = 303;
        List<User> values = parseUsers(max);
        long parsed = System.nanoTime();
        xlsx.XlsxWriter.usersWrite("user_" + System.nanoTime() + "_.xlsx", values);
        long fileCreated = System.nanoTime();
        System.out.println("processed " + max + " pages");
        System.out.println("in seconds");
        System.out.println("parsing: " + (parsed - start) / 1000000000d);
        System.out.println("file creating: " + (fileCreated - parsed) / 1000000000d);
        System.out.println("total: " + (fileCreated - start) / 1000000000d);
//        System.out.println("57356 / "+max+" = "+((57356d/max)*((fileCreated-start)/1000000000d)));
    }

    private static List<AddresAndro> parseAdresses(int max) throws Exception {
        HTTPClient http = new HTTPClient();
        List<AddresAndro> values = new ArrayList<>();

        long start = System.nanoTime();
        for (int i = 1; i <= max; i++) {
            String result = http.sendGet("http://eco.andromix.eu/address/edit/id/" + i);
            if (!result.contains("Редактиране")) {
                System.out.println("SKIPPED");
                continue;
            }
            AddresAndro a = new AddresAndro();
            a.Id = i;

            String[] itemsRaw = result.split("form id=\"formaddress")[1].split("</form>")[0].split("<div class=\"controls\">");
            if (itemsRaw.length != 14) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!itemsRaw.length!=14 but" + itemsRaw.length);
                continue;
            }
            storedRaw = itemsRaw;
            rawPointer = 1;
            a.Страна = fromNextRaw();
            a.Град = fromNextRaw();
            a.Квартал = fromNextRaw();
            a.Улица = fromNextRaw();
            a.Номер = fromNextRaw();
            a.Вход = fromNextRaw();
            a.Статус = fromNextRaw();
            a.Широчина = fromNextRaw();
            a.Дължина = fromNextRaw();
            a.Детайли = fromNextRaw();
            a.Телефонен_номер = fromNextRaw();
            a.Протребители = fromNextRaw();
            a.Заключен = fromNextRaw();
            values.add(a);
            System.out.println(/*"remaning " +*/(max - i));
        }
        return values;
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
            storedRaw = itemsRaw;
            rawPointer = 1;
            z.Име = fromNextRaw();
            z.Опашка = fromNextRaw();
            z.Приоритетна_опашка = fromNextRaw();
            z.Следваща_опашка_1 = fromNextRaw();
            z.Следваща_опашка_2 = fromNextRaw();
            z.Позиция = fromNextRaw();
            z.Точки = fromNextRaw();
            z.Активна_от = fromNextRaw();
            z.Активна_до = fromNextRaw();
            z.IDта_на_разрешени_зони = fromNextRaw();
            z.Статус = fromNextRaw();
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

    private static List<User> parseUsers(int max) throws Exception {
        HTTPClient http = new HTTPClient();
        List<User> values = new ArrayList<>();

        long start = System.nanoTime();
        for (int i = 1; i <= max; i++) {
            String result = http.sendGet("http://eco.andromix.eu/users/edit/id/" + i);
            if (!result.contains("Настройки на потребителя")) {
                System.out.println("SKIPPED");
                continue;
            }
            User u = new User();
            u.Id = i;

            String[] itemsRaw = result.split("form id=\"formcards")[1].split("</form>")[0].split("<div class=\"controls\">");
            if (itemsRaw.length != 25) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!itemsRaw.length!=25 but" + itemsRaw.length);
                continue;
            }
            storedRaw = itemsRaw;
            rawPointer = 1;
            u.Име = fromNextRaw();
            u.Пълно_име = fromNextRaw();
            u.Език = fromNextRaw();
            u.Парола = fromNextRaw();
            u.Потвърдете_паролата = fromNextRaw();
            //u.Снимка =
            fromNextRaw();
            u.Група = fromNextRaw();
            u.Статус = fromNextRaw();
            u.Кола = fromNextRaw();
            u.Пол = fromNextRaw();
            u.Говорими_езици = fromNextRaw();
            fromNextRaw(); // sooome shift
            u.Обновява_адреси = fromNextRaw();
            u.Активен_само_от_таблет_с_ID = fromNextRaw();
            u.Индивидуални_изисквания = fromNextRaw();
            u.Климатик = fromNextRaw();
            u.Пушачи = fromNextRaw();
            u.Може_да_мине_граница = fromNextRaw();
            u.Приема_животни = fromNextRaw();
            u.Wifi = fromNextRaw();
            u.Услуги = fromNextRaw();
            u.Drink_and_drive = fromNextRaw();
            u.Фактура = fromNextRaw();
            u.Допълнителна_информация = fromNextRaw();
            u.Говорими_езици = parseJSArray(result);
            values.add(u);
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
        if (raw.contains("<textarea")) {
            return fromTextarea(raw);
        }
        if (raw.contains("<input")) {
            return fromInput(raw);
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

    private static String parseJSArray(String result) {
     return result.split("var jsArray = \\[")[1].split("\\]")[0];
    }
}
