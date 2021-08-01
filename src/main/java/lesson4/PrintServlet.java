package lesson4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "PrintServlet", urlPatterns = "/print")
public class PrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.write("<body>");
        Enumeration<String> params = req.getParameterNames();
        while (params.hasMoreElements()) {
            String currentParam = params.nextElement();
            pw.write("<p>" + currentParam);
            pw.write(" - ");
            pw.write(req.getParameter(currentParam) + "</p>");
        }
        pw.write("</body>");
    }
}
