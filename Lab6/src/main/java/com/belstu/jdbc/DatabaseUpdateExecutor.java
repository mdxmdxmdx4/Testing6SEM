package com.belstu.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUpdateExecutor {

    public static void deleteManufacturerAndSouvenirs(String manufacturer) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Souvenirs WHERE manufacturer_id IN (SELECT id FROM Manufacturers WHERE name = ?)");
        statement.setString(1, manufacturer);
        int affectedRows = statement.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Удалено " + affectedRows + " строк из таблицы Souvenirs");
        } else {
            System.out.println("Нет строк для удаления из таблицы Souvenirs");
        }

        statement = connection.prepareStatement("DELETE FROM Manufacturers WHERE name = ?");
        statement.setString(1, manufacturer);
        affectedRows = statement.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Удалено " + affectedRows + " строк из таблицы Manufacturers");
        } else {
            System.out.println("Нет строк для удаления из таблицы Manufacturers");
        }
    }

}
