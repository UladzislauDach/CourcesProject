package lesson8.homework.controller.web.servlet;

import lesson8.homework.model.Message;
import lesson8.homework.view.Storage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "MyMessage", urlPatterns = "/messenger/mail")
public class MyMessage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Storage storage = Storage.getInstance();
        String currentUserLogin = (String) req.getSession().getAttribute("login");
        List<Message> listMessage = storage.getMessageList(currentUserLogin);
        req.setAttribute("listMessage", listMessage);
        req.getRequestDispatcher("/views/messenger/my_messages.jsp").forward(req, resp);
    }
}
