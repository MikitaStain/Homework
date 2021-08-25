package by.it_academy.homeworkPerson.service;

import by.it_academy.homeworkPerson.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateSession {
    private Person person = new Person();
    public String savePersonInSession(HttpServletRequest req, HttpServletResponse resp, String name) {

        String nameValue = getPersonInSession(req, name);
        person.setName(nameValue);
        saveSession(req, name,nameValue);


        return nameValue;
    }

    public String getPersonInSession(HttpServletRequest req, String key) {
        String val = req.getParameter(key);


        if (val == null) {
            HttpSession session = req.getSession();
            if (session.isNew()) {
                val = (String) session.getAttribute(key);
            }


        }
        if (val == null) {
            throw new IllegalArgumentException("Не создана сессия");
        }
        return val;

    }
    public static void saveSession(HttpServletRequest req, String key, String value) {
        HttpSession session = req.getSession();
        session.setAttribute(key, value);


    }

}