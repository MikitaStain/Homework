package by.itacademy.employees.service;

import by.itacademy.employees.service.api.EDepartmentName;

public class DepartmentService {

    
    private EDepartmentName eDepartmentName;
    private int countDeportment = EDepartmentName.values().length;


    public boolean validationName(String name) {
        return !name.equals(EDepartmentName.SALES_DEPARTMENT.getDepartmentName()) &&
                !name.equals(EDepartmentName.PURCHASE_DEPARTMENT.getDepartmentName()) &&
                !name.equals(EDepartmentName.ACCOUNTING_DEPARTMENT.getDepartmentName()) &&
                !name.equals(EDepartmentName.TECHNICAL_SUPPORT_DEPARTMENT.getDepartmentName()) &&
                !name.equals(EDepartmentName.MARKETING_DEPARTMENT.getDepartmentName());
    }
}


