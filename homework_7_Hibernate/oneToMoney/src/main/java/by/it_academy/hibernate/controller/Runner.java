package by.it_academy.hibernate.controller;

import by.it_academy.hibernate.dao.DepartmentDAO;
import by.it_academy.hibernate.dao.EmployeeDAO;
import by.it_academy.hibernate.model.Department;
import by.it_academy.hibernate.model.Employee;
import by.it_academy.hibernate.service.EmployeeService;
import by.it_academy.hibernate.storage.DepartmentStorage;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();



        if (departmentDAO.read(Long.valueOf(DepartmentStorage.departments.length)) == null) {

            for (String depart : DepartmentStorage.departments) {

                List<Employee> employeeList = new ArrayList<>();

                for (int i = 0; i < 10; i++) {
                    Employee employee = new Employee();

                    employee.setName(EmployeeService.getInstance().randomEmployeeName());
                    employee.setSalary(EmployeeService.getInstance().randomEmployeeSalary());

                    employeeList.add(employee);

                    employeeDAO.create(employee);
                }
                Department department = new Department();

                department.setName(depart);
                department.setEmployees(employeeList);

                System.out.println(department);

                departmentDAO.create(department);
            }


        }


    }
}
