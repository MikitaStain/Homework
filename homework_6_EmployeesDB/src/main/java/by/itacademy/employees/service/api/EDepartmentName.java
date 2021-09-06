package by.itacademy.employees.service.api;

import java.util.List;
import java.util.Random;

public enum EDepartmentName {

    SALES_DEPARTMENT("Sales department"),
    PURCHASE_DEPARTMENT("Purchase department"),
    ACCOUNTING_DEPARTMENT("Accounting department"),
    TECHNICAL_SUPPORT_DEPARTMENT("Technical support department"),
    MARKETING_DEPARTMENT("Marketing department");

    private final String DEPARTMENT_NAME;

    EDepartmentName(String departName) {
        this.DEPARTMENT_NAME = departName;
    }

    private static final List<EDepartmentName> VALUES =
            List.of(values());

    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static EDepartmentName randomLetter() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static void main(String[] args) {
        System.out.println(randomLetter().DEPARTMENT_NAME);
    }
}
