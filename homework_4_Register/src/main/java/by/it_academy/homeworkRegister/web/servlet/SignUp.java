package by.it_academy.homeworkRegister.web.servlet;

import by.it_academy.homeworkRegister.model.User;
import by.it_academy.homeworkRegister.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SignUp", urlPatterns = "/enter/signUp")
public class SignUp extends HttpServlet {

    UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/views/signUp.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String birthDay = req.getParameter("birthDay");






        if (userService.validationData(login, name, birthDay, password)) {

            if (userService.chekUserLoginAndPassword(login,password)) {
                req.setAttribute("message", "Логин занят");
                req.setAttribute("error", true);
                req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
            }

            User user = new User(login,password,name,birthDay);

            userService.addUser(login, user);
            HttpSession session = req.getSession();
            session.setAttribute("user", userService.getUser(login));
            String path = req.getContextPath() + "/views/account.jsp";
            resp.sendRedirect(path);

        } else {
            req.setAttribute("message", "Введены не все данные");
            req.setAttribute("error", true);
            req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
        }
    }

}
