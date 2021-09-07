package by.itacademy.employees.service.api;

import java.util.Arrays;
import java.util.List;

public enum EDepartmentName {


    SALES_DEPARTMENT("Sales department"),
    PURCHASE_DEPARTMENT("Purchase department"),
    ACCOUNTING_DEPARTMENT("Accounting department"),
    TECHNICAL_SUPPORT_DEPARTMENT("Technical support department"),
    MARKETING_DEPARTMENT("Marketing department");

    public final String DEPARTMENT_NAME;

    public final List<EDepartmentName> examples = Arrays.asList(EDepartmentName.values());

    EDepartmentName(String departName) {
        this.DEPARTMENT_NAME = departName;
    }


}
