package by.itacademy.employees.web.servlet;

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


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String salary = req.getParameter("salary");

        if(employeeService.validationData(name,salary)){

            //employeeService.addEmployee(name,salary);
        }






    }
}
