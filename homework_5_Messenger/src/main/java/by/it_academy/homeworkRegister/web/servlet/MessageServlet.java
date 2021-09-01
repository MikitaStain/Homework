package by.it_academy.homeworkRegister.web.servlet;

import by.it_academy.homeworkRegister.model.Message;
import by.it_academy.homeworkRegister.model.User;
import by.it_academy.homeworkRegister.service.MessageService;
import by.it_academy.homeworkRegister.service.UserService;
import by.it_academy.homeworkRegister.service.api.IMessageService;
import by.it_academy.homeworkRegister.service.api.IUseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "messageServlet", urlPatterns = "/messageAcc")
public class MessageServlet extends HttpServlet {

    private final IUseService userService;
    private final IMessageService messageService;

    public MessageServlet() {
        this.userService = UserService.getInstance();
        this.messageService = MessageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String recipient = req.getParameter("login");
        String textMessage = req.getParameter("message");

        if (!userService.chekUserLogin(recipient)) {

            req.setAttribute("message", "такого пользователя не существует");
            req.setAttribute("error", true);

            req.getRequestDispatcher("/views/message.jsp").forward(req, resp);

        } else if (messageService.chekMessage(textMessage)) {

            req.setAttribute("message", "текст сообщения отсутсвует");
            req.setAttribute("error", true);

            req.getRequestDispatcher("/views/message.jsp").forward(req, resp);

        } else {

            Date date = new Date();

            User userSender = (User) req.getSession().getAttribute("user");
            String loginSender = userSender.getLogin();

            Message message = new Message(textMessage, loginSender, recipient, date);

            messageService.addMessage(recipient, message);

            req.getRequestDispatcher("/views/account.jsp").forward(req, resp);;
        }

    }
}
