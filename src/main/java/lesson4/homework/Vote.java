package lesson4.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Vote", urlPatterns = "/vote")
public class Vote extends HttpServlet {

    private static Map<String, Integer> valuesAnswer1 = new LinkedHashMap<>();
    private static Map<String, Integer> valuesAnswer2 = new LinkedHashMap<>();
    private static Map<String, String> comment = new LinkedHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.write("<html>\n" +
                "<head>\n" +
                "    <title>Vote</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/app/vote\" method=\"post\">\n" +
                "    <table border=\"0\">\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <p><b>Who is the best artist?</b></p>\n" +
                "                <p><input type=\"radio\" name=\"answer1\" value=\"Selena Gomes\" checked>Селена Гомес</p>\n" +
                "                <p><input type=\"radio\" name=\"answer1\" value=\"Katty Parry\">Кэти Перри</p>\n" +
                "                <p><input type=\"radio\" name=\"answer1\" value=\"Eminem\">Эминем</p>\n" +
                "                <p><input type=\"radio\" name=\"answer1\" value=\"Decl\">Дэцл</p>\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <p><b>What is your favorite genre of music?</b></p>\n" +
                "                <p><input type=\"checkbox\" name=\"answer2\" value=\"Flock-music\">Фолк-музыка</p>\n" +
                "                <p><input type=\"checkbox\" name=\"answer2\" value=\"Country\">Кантри</p>\n" +
                "                <p><input type=\"checkbox\" name=\"answer2\" value=\"American music\">Латиноамериканская музыка</p>\n" +
                "                <p><input type=\"checkbox\" name=\"answer2\" value=\"Blues\">Блюз</p>\n" +
                "                <p><input type=\"checkbox\" name=\"answer2\" value=\"Rhythm and Blues\">Ритм-н-блюз</p>\n" +
                "                <p><input type=\"checkbox\" name=\"answer2\" value=\"Jazz\">Джаз</p>\n" +
                "                <p><input type=\"checkbox\" name=\"answer2\" value=\"Electric music\">Электронная музыка</p>\n" +
                "                <p><input type=\"checkbox\" name=\"answer2\" value=\"Rock\">Рок</p>\n" +
                "                <p><input type=\"checkbox\" name=\"answer2\" value=\"Hip-Hop\">Хип-хоп</p>\n" +
                "                <p><input type=\"checkbox\" name=\"answer2\" value=\"Ticktonik\">Тиктоник</p>\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <p><b>Tell us about yourself</b></p>\n" +
                "                <textarea name=\"comment\" cols=\"50\" rows=\"6\"></textarea>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "                <td>\n" +
                "                <p><input align=\"center\" type=\"reset\" value=\"Clear\">\n" +
                "                    <input type=\"submit\" value=\"Send my vote!\"></p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        Map<String, String[]> paramMap = req.getParameterMap();
        voteCounterAnswer1(paramMap);
        pw.write("<body><p>");
        pw.write("<h4> Top artist: </h4>");
        for (Map.Entry<String, Integer> entry : valuesAnswer1.entrySet()) {
            pw.write("<p>" + entry.getKey() + " : " + entry.getValue() + " voices</p>");
        }
        pw.write("<br>");
        pw.write("<h4> Top musical genre: </h4>");
        for (Map.Entry<String, Integer> entry : valuesAnswer2.entrySet()) {
            pw.write("<p>" + entry.getKey() + " : " + entry.getValue() + " voices</p>");
        }
        pw.write("<br>");
        pw.write("<h4> Text \"About me\" : </h4>");
        for (Map.Entry<String, String> entry : comment.entrySet()) {
            pw.write("<p>" + entry.getKey() + " : " + entry.getValue());
        }
        pw.write("<p><a href=\"vote\">Vote again</a></p>");
        pw.write("<p></body>");


    }

    private static void voteCounterAnswer1(Map<String, String[]> mapValue) {
        //считаем голоса на первую форму
        for (String chose : mapValue.get("answer1"))
            if (!valuesAnswer1.containsKey(chose)) {
                valuesAnswer1.put(chose, 1);
            } else {
                int oldValue = valuesAnswer1.get(chose);
                valuesAnswer1.put(chose, ++oldValue);
            }
        valuesAnswer1 = sortByValue(valuesAnswer1);
        // вторая форма
        for (String chose : mapValue.get("answer2"))
            if (!valuesAnswer2.containsKey(chose)) {
                valuesAnswer2.put(chose, 1);
            } else {
                int oldValue = valuesAnswer2.get(chose);
                valuesAnswer2.put(chose, ++oldValue);
            }
        valuesAnswer2 = sortByValue(valuesAnswer2);
        // третья
        LocalDateTime localDateTime = LocalDateTime.now();
        String now = localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        for (String text : mapValue.get("comment"))
            if (!comment.containsKey(now)) {
                comment.put(now, text);
            }
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> unSortedMap) {
        Map<String, Integer> result = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unSortedMap.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}