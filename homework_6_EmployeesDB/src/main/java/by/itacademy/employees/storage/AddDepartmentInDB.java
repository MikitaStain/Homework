package by.itacademy.employees.storage;

import java.sql.*;

public class AddDepartmentInDB {

    //Загрузка класса драйвера базы данных
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Ошибка подключения драйвера", e);
        }
    }


    public long addEmployeeAndGetId(String name, Double salary) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/crm",
                "postgres", "7403663")) {


            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.test(\n" +
                    "abcd)\n" +
                    "VALUES (?,?);", Statement.RETURN_GENERATED_KEYS)) {


                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, salary);
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                generatedKeys.next();

                return generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с базой данных", e);
        }
    }
}

