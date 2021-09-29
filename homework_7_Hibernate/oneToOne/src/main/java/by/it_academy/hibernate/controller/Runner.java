package by.it_academy.hibernate.controller;

import by.it_academy.hibernate.dao.DepartmentDAO;
import by.it_academy.hibernate.dao.EmployeeDAO;
import by.it_academy.hibernate.model.Department;
import by.it_academy.hibernate.model.Employee;
import by.it_academy.hibernate.service.EmployeeService;
import by.it_academy.hibernate.storage.DepartmentStorage;


import java.util.Random;

public class Runner {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        Random random = new Random();

        if (departmentDAO.read(Long.valueOf(DepartmentStorage.departments.length)) == null) {
            for (String depart : DepartmentStorage.departments) {
                Department department = new Department();
                department.setName(depart);
                departmentDAO.create(department);
            }
        }


        for (int i = 0; i < 111; i++) {
            Employee employee = new Employee();
            Department department = departmentDAO.read(Long.valueOf(random.nextInt(DepartmentStorage.departments.length) + 1));

            employee.setName(EmployeeService.getInstance().randomEmployeeName());
            employee.setSalary(EmployeeService.getInstance().randomEmployeeSalary());
            employee.setDepartment(department);

            System.out.println(employee);


            employeeDAO.create(employee);
        }




    }
}
