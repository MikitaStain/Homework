package by.itacademy.employees.storage.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EDepartmentName {

    SALES_DEPARTMENT("Sales department"),
    PURCHASE_DEPARTMENT("Purchase department"),
    ACCOUNTING_DEPARTMENT("Accounting department"),
    TECHNICAL_SUPPORT_DEPARTMENT("Technical support department"),
    MARKETING_DEPARTMENT("Marketing department");

    public final String DEPARTMENT_NAME;

    public final List<EDepartmentName> eDepartmentNameList = Arrays.asList(EDepartmentName.values());

    EDepartmentName(String departName) {
        this.DEPARTMENT_NAME = departName;
    }

    public List<String> addDepartmentNameInList(List<EDepartmentName> examples) {

        List<String> departmentName = new ArrayList<>();
        for (int i = 0; i < values().length; i++) {
            String name = examples.get(i).DEPARTMENT_NAME;
            departmentName.add(name);
        }
        return departmentName;
    }


}
