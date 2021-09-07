package by.itacademy.employees.service.api;

public interface IEmployeeService {

    boolean validationData(String name, String salary);

    void addEmployee(String name, String salary,long id);
}
