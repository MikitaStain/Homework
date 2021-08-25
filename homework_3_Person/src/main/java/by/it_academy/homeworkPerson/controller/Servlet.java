package by.it_academy.homeworkPerson.controller;

import by.it_academy.homeworkPerson.model.Person;
import by.it_academy.homeworkPerson.service.CreateCookie;
import by.it_academy.homeworkPerson.service.CreateSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet", urlPatterns = "/person23")
public class Servlet extends HttpServlet {
    Person person = new Person();
    private final CreateCookie cookie = new CreateCookie();
    private final CreateSession session = new CreateSession();
    public static final String NAME = "name";
    public static final String LAST_NAME = "lastName";
    public static final String AGE = "age";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html, charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();

        String header = req.getHeader("header");

        if (header.equals("cookie")) {
            String nameValue = cookie.savePersonInCookie(req,resp, NAME);
            String lastNameValue = cookie.savePersonInCookie(req, resp, LAST_NAME);
            String ageValue = cookie.savePersonInCookie(req,resp, AGE);

            writer.write(nameValue + " " + lastNameValue + " " + ageValue);
        }
        if (header.equals("session")) {
            String nameValue = session.savePersonInSession(req,resp, NAME);
            String lastNameValue = session.savePersonInSession(req,resp, LAST_NAME);
            String ageValue = session.savePersonInSession(req,resp, AGE);

            writer.write(nameValue + " " + lastNameValue + " " + ageValue);
        }
        if (header==null){
            throw new IllegalArgumentException("отсутвтвует header");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html, charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(person.getName()+" "+person.getLastName()+" "+person.getAge());

    }
}


