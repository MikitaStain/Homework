package by.itacademy.employees.service;

import by.itacademy.employees.service.api.EDepartmentName;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {


    private EDepartmentName eDepartmentName;
    private int countDeportment = EDepartmentName.values().length;

    public List<String> forEnum(List<EDepartmentName> examples) {//Перебор отделов

        List<String> departmentName = new ArrayList<>();
        for (int i = 0; i < EDepartmentName.values().length; i++) {
            String name = examples.get(i).DEPARTMENT_NAME;
            departmentName.add(name);
        }
        return departmentName;
    }


}


