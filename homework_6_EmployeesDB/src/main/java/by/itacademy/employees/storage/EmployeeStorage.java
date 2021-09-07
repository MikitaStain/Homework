package by.itacademy.employees.storage;

import by.itacademy.employees.model.Employee;

public class EmployeeStorage {
    private static final EmployeeStorage instance = new EmployeeStorage();
    private final Employee employees;

    public EmployeeStorage() {
        this.employees = instance.employees;
    }

    public Employee getEmployees() {
        return employees;
    }

    public static EmployeeStorage getInstance() {
        return instance;
    }

}
