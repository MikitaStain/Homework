package by.it_academy.homeworkRegister;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "signUp", urlPatterns = "/signUp")
public class SignUp extends HttpServlet {
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("info", "");
        req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String birthDay = req.getParameter("birthDay");

        user.setLogin(login);
        user.setName(name);
        user.setBirthDay(birthDay);
        user.setPassword(password);

        if (userService.checkLogin(login)) {
            req.setAttribute("message", "Логин занят");
            req.setAttribute("error", true);
            req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
        } else if (userService.validationData(login, user)) {
            userService.addUser(login, user);
            HttpSession session = req.getSession();
            session.setAttribute("user", userService.getUser(login));
            resp.sendRedirect("//акаунт");
        } else {
            req.setAttribute("message", "Введены не все данные");
            req.setAttribute("error", true);
            req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
        }
    }

}
