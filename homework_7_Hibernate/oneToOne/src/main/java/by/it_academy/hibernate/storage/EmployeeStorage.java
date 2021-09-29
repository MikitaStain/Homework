package by.it_academy.hibernate.storage;

import by.it_academy.hibernate.storage.api.IEmployeeStorage;

public class EmployeeStorage implements IEmployeeStorage {
    private static final EmployeeStorage instance = new EmployeeStorage();

    public String[] getEmployees(){
        return employees;
    }


    public static EmployeeStorage getInstance(){
        return instance;
    }
}
