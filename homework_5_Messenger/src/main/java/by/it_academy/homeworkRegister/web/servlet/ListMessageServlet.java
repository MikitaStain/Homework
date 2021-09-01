package by.it_academy.homeworkRegister.web.servlet;

import by.it_academy.homeworkRegister.model.User;
import by.it_academy.homeworkRegister.service.MessageService;
import by.it_academy.homeworkRegister.service.api.IMessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listMessageServlet", urlPatterns = "/listMessage")
public class ListMessageServlet extends HttpServlet {
        private final IMessageService messageService;

    public ListMessageServlet() {
        this.messageService = MessageService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userSender = (User) req.getSession().getAttribute("user");
        String loginSender = userSender.getLogin();

        List<String> infoMessage = messageService.getInfoMessage(loginSender);
        req.setAttribute("message",infoMessage);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/listMessage.jsp").forward(req, resp);
    }
}
