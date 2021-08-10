package lesson5.controller;

import lesson5.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "QuizServlet", urlPatterns = "/quiz")
public class QuizServlet extends HttpServlet {

    private final VoteService service;

    public QuizServlet() {
        this.service = VoteService.getInstance();
    }

    @Override

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\t<title>Квиз</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<form action=\"/app/quiz\" method=\"POST\">\n" +
                "\t\t<label for=\"artist\">Лучший исполнитель</label>\n" +
                "\t\t<select name=\"artist\">\n" +
                "\t\t\t<option value=\"1\">Ирина Олегрова</option>\n" +
                "\t\t\t<option value=\"2\">Каста</option>\n" +
                "\t\t\t<option value=\"3\">Луна</option>\n" +
                "\t\t\t<option value=\"4\">Иванушки</option>\n" +
                "\t\t</select><br/>\n" +
                "\t\t<label for=\"genre\">Ваш любимый жанр</label><br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"1\"/> Рок <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"2\"/> Поп <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"3\"/> Фолк <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"4\"/> Альт <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"5\"/> Клкассика <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"6\"/> Джаз <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"7\"/> Тиктоник <br/>\n" +
                "\t\t<label for=\"about\">О себе</label><br/>\n" +
                "\t\t<textarea name=\"about\"></textarea>\n" +
                "\t\t<input type=\"submit\" name=\"Отправить\">\n" +
                "\t</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artist = req.getParameter("artist");
        String[] genres = req.getParameterValues("genre");
        String about = req.getParameter("about");

        this.service.addVote(artist, genres, about);

        Map<String, Integer> artistResult = this.service.getArtistResult();
        Map<String, Integer> genreResult = this.service.getGenreResult();
        List<String> aboutResult = this.service.getAboutResult();

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write("<b>Лучший исполнитель</b>");
        for (Map.Entry<String, Integer> entry : artistResult.entrySet()) {
            switch (entry.getKey()) {
                case "1":
                    writer.write("<p>Ирина Олегрова ");
                    break;
                case "2":
                    writer.write("<p>Каста ");
                    break;
                case "3":
                    writer.write("<p>Луна ");
                    break;
                case "4":
                    writer.write("<p>Иванушки ");
                    break;
            }
            writer.write(entry.getValue() + "</p>");
        }
        writer.write("<b>Лучший жанр</b>");
        for (Map.Entry<String, Integer> entry : genreResult.entrySet()) {
            switch (entry.getKey()) {
                case "1":
                    writer.write("<p>Рок ");
                    break;
                case "2":
                    writer.write("<p>Поп ");
                    break;
                case "3":
                    writer.write("<p>Фолк ");
                    break;
                case "4":
                    writer.write("<p>Альт ");
                    break;
                case "5":
                    writer.write("<p>Классика ");
                    break;
                case "6":
                    writer.write("<p>Джаз ");
                    break;
                case "7":
                    writer.write("<p>Тиктоник ");
                    break;
            }
            writer.write(entry.getValue() + "</p>");
        }
        writer.write("<b>О себе: </b>");
        for (String s : aboutResult) {
            writer.write("<p>" + s + "</p>");
            writer.write("<p>=========================================</p>");
        }

    }
}
