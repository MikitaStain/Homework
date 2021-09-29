package by.it_academy.hibernate.service;

import by.it_academy.hibernate.storage.DepartmentStorage;

import java.util.Random;

public class DepartmentService {
    private static final DepartmentService instance = new DepartmentService();
    private final DepartmentStorage departmentStorage;
    private Random random = new Random();

    public DepartmentService() {
        this.departmentStorage = DepartmentStorage.getInstance();
    }

    public String getDepartmentRandom(){

        return departmentStorage.getDepartments()[random
                .nextInt(departmentStorage
                        .getDepartments()
                        .length)];
    }

    public static DepartmentService getInstance(){
        return instance;
    }
}
