package lesson7.homework;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        EStorageType storageType = EStorageType.valueOfIgnoreCase(req.getHeader("saveTo"));
        IStorageHandler storageHandler;
        try {
            storageHandler = storageType.getHandler();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Нет обязательного заголовка", e);
        }
        PersonDto person = PersonFromReqParam.getPersonDtoFromRequest(req);
        storageHandler.savePerson(resp, req, person);
        writer.write("success");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        PersonDto person;
        EStorageType storageType = EStorageType.valueOfIgnoreCase(req.getHeader("readFrom"));
        person = storageType.getHandler().getPerson(req);
        writer.write("Writ from " + req.getHeader("saveTo") + " </br>");
        writer.write("p : " + person.getFirstName() + "</br>");
        writer.write("p : " + person.getLastName() + "</br>");
        writer.write("p : " + person.getAge() + "</br>");

    }
}
