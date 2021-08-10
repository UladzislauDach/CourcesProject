package lesson6.classwork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "CookiesTest", urlPatterns = "/cookies")
public class CookiesTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstNameVal = getValueFromAnywhere(req, "firstName");
        saveCookies(resp, "firstName", firstNameVal);

        String lastNameVal  = getValueFromAnywhere(req, "secondName");
        saveCookies(resp, "secondName", lastNameVal);

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style= 'color: blue;'> Hello, " + firstNameVal + " " + lastNameVal + "!</span></p>");


    }

    private static String getValueFromAnywhere(HttpServletRequest req, String paramName) {
        String val = req.getParameter(paramName);
        if (val == null) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null){
                val = Arrays.stream(cookies).filter(c -> paramName.equals(c.getName()))
                        .map(Cookie::getValue).findFirst().orElse(null);
            }
        }
        if (val == null) {
            throw new IllegalArgumentException("Не передан один из обязательных параметров");
        }
        return val;
    }

    private static void saveCookies(HttpServletResponse resp, String key, String value) {
        Cookie cookie = new Cookie(key, URLEncoder.encode(value, StandardCharsets.UTF_8));
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
    }
}
