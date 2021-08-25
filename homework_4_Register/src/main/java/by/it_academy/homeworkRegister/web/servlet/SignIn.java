package by.it_academy.homeworkRegister.web.servlet;

import by.it_academy.homeworkRegister.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "signIn", urlPatterns = "/enter/signIn")
public class SignIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (userService.chekUserLoginAndPassword(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", userService.getUsers());
            session.setAttribute("login", login);
            req.setAttribute("user", userService.getUsers());
            req.getRequestDispatcher("views/account.jsp").forward(req, resp);
        } else {
            req.setAttribute("login", "Неправильно введен логин или пароль");
            req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);

        }
    }
}
