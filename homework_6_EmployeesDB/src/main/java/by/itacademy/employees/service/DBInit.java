package by.itacademy.employees.service;

import by.itacademy.employees.service.api.EDepartmentName;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBInit {
    private DepartmentService departmentService;
    private EDepartmentName eDepartmentName;

    //Загрузка класса драйвера базы данных
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Ошибка подключения драйвера", e);
        }
    }

    public void addEmployeeAndGetId(String name, Double salary) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/testDataBase",
                "postgres", "7403663");
             Statement statement = connection.createStatement()) {


            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.test(\n" +
                    "abcd)\n" +
                    "VALUES (?);")) {

                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, salary);
                preparedStatement.executeUpdate();


            }


        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с базой данных", e);
        }

    }

    public void addDepartmentName() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/testDataBase",
                "postgres", "7403663")) {
            List<String> department = new ArrayList<>(departmentService.forEnum(eDepartmentName.examples));
            List<String> departmentName = getDepartmentName();
            List<String> strings = compareName(department, departmentName);


            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.test(\n" +
                    "abcd)\n" +
                    "VALUES (?);")) {
                if (strings.size() > 0) {
                    for (String string : strings) {
                        preparedStatement.setString(1, string);
                        preparedStatement.executeUpdate();
                    }


                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с базой данных", e);
        }
    }


    public List<String> getDepartmentName() {
        List<String> departNames = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/testDataBase",
                "postgres", "7403663");
             //Создаем объект для передачи запросов
             Statement statement = connection.createStatement()) {

            try (ResultSet resultSet = statement.executeQuery("SELECT abcd FROM public.test ORDER BY id ASC ")) {

                while (resultSet.next()) {

                    String string = resultSet.getString(1);
                    departNames.add(string);
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с базой данных", e);
        }
        return departNames;
    }


    public List<String> compareName(List<String> name, List<String> newName) {
        List<String> exclusiveDepartmentName = new ArrayList<>(name);
        exclusiveDepartmentName.removeAll(newName);
        return exclusiveDepartmentName;
    }

}

