package by.it_academy.hibernate.storage;

import by.it_academy.hibernate.storage.api.IDepartmentStorage;

public class DepartmentStorage implements IDepartmentStorage {
    private static final DepartmentStorage instance = new DepartmentStorage();

    public String[] getDepartments(){
        return departments;
    }

    public static DepartmentStorage getInstance(){
        return instance;
    }
}
