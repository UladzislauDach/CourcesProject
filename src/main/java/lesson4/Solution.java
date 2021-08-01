package lesson4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "IsName", urlPatterns = "/isname")
public class Solution extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> allParams = req.getParameterNames();
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.write("<body>");
        while (allParams.hasMoreElements()) {
            String currentValue = req.getParameter(allParams.nextElement());
            if (isName(currentValue)) {
                pw.write("<p>" + currentValue + "</p>");
            }
        }
        pw.write("</body>");
    }

    private boolean isName(String input) {
        for (Names name : Names.values()) {
            if (name.toString().equals(input)) {
                return true;
            }
        }
        return false;
    }
}
