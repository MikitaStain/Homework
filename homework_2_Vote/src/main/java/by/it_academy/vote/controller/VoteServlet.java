package by.it_academy.vote.controller;

import by.it_academy.vote.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    private VoteService service;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset = UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\t<title>Vote</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<form action=\"/Mk-JD2-82-21-0.0.0-SNAPSHOT/\" method=\"POST\">\n" +
                "\t\t<label for=\"artist\">Группа</label>\n" +
                "\t\t<select name=\"artist\">\n" +
                "\t\t\t<option value=\"Ирина Олегрова\">Ирина Олегрова</option>\n" +
                "\t\t\t<option value=\"Каста\">Каста</option>\n" +
                "\t\t\t<option value=\"Луна\">Луна</option>\n" +
                "\t\t\t<option value=\"Иванушки\">Иванушки</option>\n" +
                "\t\t</select><br/>\n" +
                "\t\t<label for=\"genre\">Жанр</label><br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Рок\"/> Рок <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Поп\"/> Поп <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Фолк\"/> Фолк <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Альт\"/> Альт <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Клкассика\"/> Клкассика <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Джаз\"/> Джаз <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Тиктоник\"/> Тиктоник <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Блюз\"/> Блюз <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Рэп\"/> Рэп <br/>\n" +
                "\t\t<input type=\"checkbox\" name=\"genre\" value=\"Опера\"/> Опера <br/>\n" +
                "\t\t<label for=\"about\">О себе</label><br/>\n" +
                "\t\t<textarea name=\"about\"></textarea>\n" +
                "\t\t<input type=\"submit\" name=\"Отправить\">\n" +
                "\t</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artist = req.getParameter("artist");
        String[] genre = req.getParameterValues("genre");
        String about = req.getParameter("about");

        this.service.addVote(artist, genre, about);

        Map<String, Integer> artistResult = this.service.getArtist();
        Map<String, Integer> genreResult = this.service.getGenre();
        List<String> aboutResult = this.service.getAbout();

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();





       artistResult
               .entrySet()
               .stream()
               .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
               .forEach(keyValue -> writer.write("<p><b>" + keyValue.getKey() + "</b>" + " " + "count vote: " + keyValue.getValue() + "</p>"));


        genreResult
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(keyValue -> writer.write("<p><b>" + keyValue.getKey() + "</b>" + " " + "count vote: " + keyValue.getValue() + "</p>"));


        for (String entry : aboutResult) {
            writer.write(entry+"<br><br>");

        }
    }
}
