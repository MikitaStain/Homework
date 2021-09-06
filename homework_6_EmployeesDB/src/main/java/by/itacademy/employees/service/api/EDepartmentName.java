package by.itacademy.employees.service.api;

import by.itacademy.employees.service.DepartmentService;

public enum EDepartmentName {


    SALES_DEPARTMENT("Sales department"),
    PURCHASE_DEPARTMENT("Purchase department"),
    ACCOUNTING_DEPARTMENT("Accounting department"),
    TECHNICAL_SUPPORT_DEPARTMENT("Technical support department"),
    MARKETING_DEPARTMENT("Marketing department");

    public final  String DEPARTMENT_NAME;
    private static final int LENGTH = EDepartmentName.values().length;
    private static final EDepartmentName[] VALUES = EDepartmentName.values() ;



    EDepartmentName(String departName) {
        this.DEPARTMENT_NAME = departName;
    }
    public String getDepartmentName(){
        return DEPARTMENT_NAME;
    }



    public static void forEnum(EDepartmentName [] eDepartmentNames, int length) {//Перебор отделов

        for (int i = 0; i < length; i++) {

            String department_name = eDepartmentNames[i].DEPARTMENT_NAME;



        }


    }

    public static void main(String[] args) {
       // forEnum(VALUES, LENGTH);


    }

}
