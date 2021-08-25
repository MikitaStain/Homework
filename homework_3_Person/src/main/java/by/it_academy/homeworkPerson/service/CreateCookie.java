package by.it_academy.homeworkPerson.service;

import by.it_academy.homeworkPerson.model.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class CreateCookie {


    private Person person = new Person();



    public String savePersonInCookie(HttpServletRequest req, HttpServletResponse resp, String name) {

        String nameValue = getPersonInCookie(req, name);
        person.setName(nameValue);
        saveCookie(resp, name,nameValue);

        return nameValue;
    }


    public String getPersonInCookie(HttpServletRequest req, String key) {
        String val = req.getParameter(key);

        if (val == null) {
           Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                val = Arrays.stream(cookies)
                        .filter(c -> key.equalsIgnoreCase(c.getName()))
                        .map(Cookie::getValue)
                        .findFirst()
                        .orElse(null);
            }
        }
        if (val == null) {
            throw new IllegalArgumentException("Не определен один из параметров");
        }
        return val;
    }



    public static void saveCookie(HttpServletResponse resp, String key, String value) {
       Cookie myCookie = new Cookie(key, URLEncoder.encode(value, StandardCharsets.UTF_8));
        myCookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
        resp.addCookie(myCookie);

    }

}