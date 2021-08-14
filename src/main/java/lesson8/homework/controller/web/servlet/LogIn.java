package lesson8.homework.controller.web.servlet;

import lesson8.homework.view.Storage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogIn", urlPatterns = "/messenger/login")
public class LogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("info", "");
        req.getRequestDispatcher("/views/messenger/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Storage storage = Storage.getInstance();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (storage.getUser(login, password) != null){
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("password", password);
            resp.sendRedirect("/app/messenger");
        } else {
            req.setAttribute("info", "Неверный логин или пароль");
            req.getRequestDispatcher("/views/messenger/login.jsp").forward(req,resp);
        }
    }
}
