package by.it_academy.homeworkRegister.web.servlet;

import by.it_academy.homeworkRegister.model.User;
import by.it_academy.homeworkRegister.service.UserService;
import by.it_academy.homeworkRegister.service.api.IUseService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUp", urlPatterns = "/enter/signUp")
public class SignUp extends HttpServlet {

    private final IUseService userService;

    public SignUp() {
        this.userService = UserService.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String birthDay = req.getParameter("birthDay");

        if (userService.validationData(login, name, birthDay, password)) {

            User user = new User(login, password, name, birthDay);

            userService.addUser(login, user);

            req.getSession().setAttribute("user", user);

            resp.sendRedirect(req.getContextPath() + "/views/account.jsp");

        } else {
            req.setAttribute("message", "Введены не все данные");
            req.setAttribute("error", true);
            req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
        }
    }

}
