package lesson6.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        PersonDto personDto = null;
        if (Repository.getUserFromSession(req) != null) {
            personDto = Repository.getUserFromSession(req);
            writer.write("<p> Person write from session");
        }
        if (Repository.getUserFromCookies(req) != null) {
            personDto = Repository.getUserFromCookies(req);
            writer.write("<p> Person write from cookies");
        }
        if (personDto == null) {
            writer.write("One of the required parameters from session or cookies is missing");
        } else {
            writer.write("<p> Firstname : " + personDto.getFirstName() + "</p>");
            writer.write("<p> Lastname : " + personDto.getLastName() + "<p>");
            writer.write("<p> Age : " + personDto.getAge() + "<p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String saveTo = req.getHeader("saveTo");
        switch (saveTo) {
            case "cookies": {
                Repository.saveUserToCookies(resp, req);
                break;
            }
            case "session": {
                Repository.saveUserToSession(req);
                break;
            }
            default: {
                throw new IllegalArgumentException("Неверно указано мето хранилища");
            }
        }
        PrintWriter writer = resp.getWriter();
        writer.write("<p> Successful save to " + saveTo + "</p>");
    }
}
