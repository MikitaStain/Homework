package by.itacademy.employees.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddNewElementInDB {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Ошибка подключения драйвера", e);
        }
    }

    public void addNameInDB(List<String> unique, List<String> addName, String nameDB, String nameTable, String nameColumn) { //добавляет уникальные названия в таблицу
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432"+nameDB,
                "postgres", "7403663")) {

            List<String> strings = compareNameInDB(unique, addName);


            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO "+nameTable+"(\n" +
                    nameColumn+")\n" +
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

    public List<String> getNameInDB( String nameTable) {     //возвращает список в таблице
        List<String> nameInTable = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/cmd",
                "postgres", "7403663");
             //Создаем объект для передачи запросов
             Statement statement = connection.createStatement()) {

            try (ResultSet resultSet = statement.executeQuery("SELECT id FROM "+nameTable+" ORDER BY id ASC ")) {

                while (resultSet.next()) {

                    String name = resultSet.getString(1);
                    nameInTable.add(name);
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с базой данных", e);
        }
        return nameInTable;
    }




    public List<Long> getIDInDB(String nameDB, String nameTable) {     //возвращает список id в таблице
        List<Long> idNumber = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432"+nameDB,
                "postgres", "7403663");
             //Создаем объект для передачи запросов
             Statement statement = connection.createStatement()) {

            try (ResultSet resultSet = statement.executeQuery("SELECT id FROM "+nameTable+" ORDER BY id ASC ")) {

                while (resultSet.next()) {

                    long id = resultSet.getLong(1);
                    idNumber.add(id);
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с базой данных", e);
        }
        return idNumber;
    }



    public List<String> compareNameInDB(List<String> name, List<String> newName) {//сравнивает 2 листа и возвращает лист с уникальными значениями
        List<String> exclusiveDepartmentName = new ArrayList<>(name);
        exclusiveDepartmentName.removeAll(newName);
        return exclusiveDepartmentName;
    }


}
