package by.itacademy.employees.service;

import java.sql.*;

public class DBInit {
    //Загрузка класса драйвера базы данных
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Ошибка подключения драйвера", e);
        }
    }

    public void addInDb() {

        //Установка соединения с базой данных
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/crm",         //передаем Тип БД, физическое месторасположение, имя БД
                "postgres", "7403663");                //логин   , пароль от БД
             //Создаем объект для передачи запросов
             Statement statement = connection.createStatement();)/**-Statement используется для выполнения запросов и команд SQL,
         а так же для установки некоторых ограничений на запросы;
         -Один и тот же объект Statement может быть использован многократно для различных запросов*/ {

            String name = "Антон";
            Double salary = -250.0;

            //Добавляем данны в базу данных (ДЕЛАТЬ ТОЛЬКО ТАК)!!!!!!
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO application.employees(\n" +
                    "name, salary)\n" +
                    "VALUES (?, ?);")) {
                preparedStatement.setString(1, name);//указываем что помещать (1 - колонка)(вместо вопроиков)
                preparedStatement.setDouble(2, salary);//2 колонка

                preparedStatement.executeUpdate();

            }
            /**Добавляет данные в базу данных (ПЛОХОЙ МЕТОД)!!!!
             statement.executeUpdate("INSERT INTO application.employers(\n" +
             "\tname, salary)\n" +
             "\tVALUES ('" + name + "'," + salary + "); ");*/


            //Получаем все данные из таблицы в базе данных!!!
           //try (ResultSet resultSet = statement.executeQuery("SELECT id, name, salary FROM application.employees ORDER BY id ASC ");) {

           //    System.out.printf("id\tИмя\tЗарплата\n");

           //    while (resultSet.next()) {
           //        System.out.printf("%s\t%s\t%,.2f\n",
           //                resultSet.getLong(1),
           //                resultSet.getString(2),
           //                resultSet.getDouble(3));
           //    }
            //}

        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с базой данных", e);
        }


    }
}