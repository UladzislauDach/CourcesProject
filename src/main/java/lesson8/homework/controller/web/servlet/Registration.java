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

@WebServlet(name = "Registration", urlPatterns = "/messenger/registration")
public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.getRequestDispatcher("/views/messenger/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Storage storage = Storage.getInstance();
        storage.addUser(new User(login, password, req.getParameter("name"), req.getParameter("birth")));
        HttpSession session = req.getSession();
        session.setAttribute("login", login);
        session.setAttribute("password", password);
        resp.sendRedirect("/app/messenger");
    }
}
