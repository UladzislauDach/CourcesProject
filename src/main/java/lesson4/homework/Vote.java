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
import java.util.*;

@WebServlet(name = "Vote", urlPatterns = "/vote")
public class Vote extends HttpServlet {

    private static Map<String, Integer> valuesAnswer1 = new LinkedHashMap<>();
    private static Map<String, Integer> valuesAnswer2 = new LinkedHashMap<>();
    private static Map<String, String> comment = new LinkedHashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        Map<String, String[]> paramMap = req.getParameterMap();
        voteCounterAnswer1(paramMap);
        pw.write("<body><p>");
        for (Map.Entry<String, Integer> entry : valuesAnswer1.entrySet()) {
            pw.write("" + entry.getKey() + " : " + entry.getValue() + "<br>");
        }
        for (Map.Entry<String, Integer> entry : valuesAnswer2.entrySet()) {
            pw.write("" + entry.getKey() + " : " + entry.getValue() + "<br>");
        }
        for (Map.Entry<String, String> entry : comment.entrySet()) {
            pw.write("" + entry.getKey() + " : " + entry.getValue() + "<br>");
        }
        pw.write("<p><a href=\"vote.jsp\">Vote again</a></p>");
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
        // вторая форма
        for (String chose : mapValue.get("answer2"))
            if (!valuesAnswer2.containsKey(chose)) {
                valuesAnswer2.put(chose, 1);
            } else {
                int oldValue = valuesAnswer2.get(chose);
                valuesAnswer2.put(chose, ++oldValue);
            }
        // третья
        LocalDateTime localDateTime = LocalDateTime.now();
        String now = localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        for (String text : mapValue.get("comment"))
            if (!comment.containsKey(now)) {
                comment.put(now, text);
            }
    }
}