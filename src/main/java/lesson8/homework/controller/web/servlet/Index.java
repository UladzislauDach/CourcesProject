package lesson8.homework.controller.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainPage", urlPatterns = "/messenger")
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        String password = (String) session.getAttribute("password");
        if (login == null || password == null) {
            req.getRequestDispatcher("/views/messenger/index_un_auth.jsp").forward(req, resp);
        } else  {
            req.getRequestDispatcher("/views/messenger/index_auth.jsp").forward(req, resp);
        }
    }
}
