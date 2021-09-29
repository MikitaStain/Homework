package by.it_academy.hibernate.service;

import by.it_academy.hibernate.service.api.IEmployeeService;
import by.it_academy.hibernate.storage.EmployeeStorage;

import java.util.Random;

public class EmployeeService implements IEmployeeService {
    private static final EmployeeService instance = new EmployeeService();
    private static EmployeeStorage employeeStorage;
    private Random random = new Random();

    public EmployeeService() {
        this.employeeStorage = EmployeeStorage.getInstance();
    }

    @Override
    public String randomEmployeeName() {

        return employeeStorage.getEmployees()[random
                .nextInt(employeeStorage
                        .getEmployees()
                        .length)];
    }

    @Override
    public String randomEmployeeSalary(){

        return String.valueOf(random.nextInt(99999));
    }


    public static EmployeeService getInstance() {
        return instance;
    }
}
