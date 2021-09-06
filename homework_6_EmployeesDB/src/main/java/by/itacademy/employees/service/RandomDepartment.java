package by.itacademy.employees.service;

import by.itacademy.employees.service.api.EDepartmentName;

import java.util.Random;

public class RandomDepartment {

    private static final EDepartmentName[] VALUES = EDepartmentName.values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static String getRandomDepartmentName() {
        return VALUES[RANDOM.nextInt(SIZE)].DEPARTMENT_NAME;
    }
}
