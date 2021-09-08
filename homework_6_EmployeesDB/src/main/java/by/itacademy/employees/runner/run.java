package by.itacademy.employees.runner;

import by.itacademy.employees.service.DBService;

public class run {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        dbService.addInDB();
    }
}
