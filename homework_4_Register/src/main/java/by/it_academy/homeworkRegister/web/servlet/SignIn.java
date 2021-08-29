package by.it_academy.homeworkRegister.web.servlet;

import by.it_academy.homeworkRegister.service.UserService;
import by.it_academy.homeworkRegister.service.api.IUseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signIn", urlPatterns = "/enter/signIn")
public class SignIn extends HttpServlet {

    private final IUseService userService;

    public SignIn() {
        this.userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (userService.chekUserLoginAndPassword(login, password)) {

            req.setAttribute("user", userService.getUsers());
            req.setAttribute("login", login);

            resp.sendRedirect(req.getContextPath() + "/views/account.jsp");
        } else {

            req.setAttribute("message", "Неправильно введен логин или пароль");
            req.setAttribute("error", true);

            req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);

        }
    }
}
