package by.itacademy.employees.web.servlet;

import by.itacademy.employees.model.Employee;
import by.itacademy.employees.service.EmployeeService;
import by.itacademy.employees.service.api.IEmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "employeesServlet", urlPatterns = "/employee")
public class EmployeesServlet extends HttpServlet {
    private final IEmployeeService employeeService;

    public EmployeesServlet() {
        this.employeeService = EmployeeService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/EmployesDB-1.0-SNAPSHOT/views/index.jsp").forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String salary = req.getParameter("salary");

        if (employeeService.validationData(name, salary)) {

            Employee employee = new Employee();
            employeeService.addEmployee(name, salary);

            req.getSession().setAttribute("employee", employee);
            resp.sendRedirect(req.getContextPath() + "/EmployesDB-1.0-SNAPSHOT/views/index.jsp");

        } else {

            req.setAttribute("message", "Введены не все данные");
            req.setAttribute("error", true);
            req.getRequestDispatcher("/EmployesDB-1.0-SNAPSHOT/views/index.jsp").forward(req, resp);

        }


    }
}
