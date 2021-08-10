package lesson6.classwork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionTest", urlPatterns = "/session")
public class SessionTest extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = getValueFromAnywhere(req, "firstName");
        saveSession(req, "firstName", firstName);
        String lastName = getValueFromAnywhere(req, "lastName");
        saveSession(req, "lastName", lastName);


        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style= 'color: blue;'> Hello, " + firstName + " " + lastName + "!</span></p>");

    }

    private static String getValueFromAnywhere(HttpServletRequest request, String valueName) {
        String result = request.getParameter(valueName);
        if (result == null) {
            HttpSession session = request.getSession();
            if (!session.isNew())
                result = (String) session.getAttribute(valueName);
        }
        if (result == null) {
            throw new IllegalArgumentException("Не передан обязательный параметр");
        }
        return result;
    }

    private static void saveSession(HttpServletRequest request, String key, String value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }


}
