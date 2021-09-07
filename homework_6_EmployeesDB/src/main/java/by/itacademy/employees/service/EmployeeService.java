package by.itacademy.employees.service;

import by.itacademy.employees.service.api.IEmployeeService;
import by.itacademy.employees.storage.EmployeeStorage;

public class EmployeeService implements IEmployeeService {
    private static final EmployeeService instance = new EmployeeService();
    private final EmployeeStorage employeeStorage;

    public EmployeeService() {
        this.employeeStorage = EmployeeStorage.getInstance();
    }
    @Override
    public boolean validationData(String name, String salary) {
        return !name.equals("")
                && !salary.equals("");
    }
    @Override
    public void addEmployee(String name, String salary,long id){
        employeeStorage.getEmployees().setId(id);
        employeeStorage.getEmployees().setName(name);
        employeeStorage.getEmployees().setSalary(Double.valueOf(salary));
    }

    public static EmployeeService getInstance(){
        return instance;
    }

}
