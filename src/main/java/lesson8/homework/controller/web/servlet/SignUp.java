package lesson8.homework.controller.web.servlet;

import lesson8.homework.view.Storage;
import lesson8.homework.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Registration", urlPatterns = "/messenger/signUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("info", "");
        req.getRequestDispatcher("/views/messenger/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Storage storage = Storage.getInstance();
        if (storage.existUserLogin(login)) {
            req.setAttribute("info", "Логин уже занят");
            req.getRequestDispatcher("/views/messenger/signUp.jsp").forward(req, resp);
        } else {
            storage.addUser(new User(login, password, req.getParameter("name"), req.getParameter("birth")));
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("password", password);
            resp.sendRedirect("/app/messenger");
        }
    }
}
