package com.belstu.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryExecutor {

    public static ResultSet getSouvenirsByManufacturer(String manufacturer) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Souvenirs WHERE" +
                " manufacturer_id IN (SELECT id FROM Manufacturers WHERE name = ?)");
        statement.setString(1, manufacturer);
        return statement.executeQuery();
    }
    public static ResultSet getSouvenirsByCountry(String country) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Souvenirs WHERE " +
                "manufacturer_id IN (SELECT id FROM Manufacturers WHERE country = ?)");
        statement.setString(1, country);
        return statement.executeQuery();
    }

    public static ResultSet getManufacturersByPrice(double price) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Manufacturers WHERE id IN " +
                "(SELECT manufacturer_id FROM Souvenirs WHERE price < ?)");
        statement.setDouble(1, price);
        return statement.executeQuery();
    }

    public static ResultSet getManufacturersBySouvenirAndYear(String souvenir, String year) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Manufacturers WHERE " +
                "id IN (SELECT manufacturer_id FROM Souvenirs WHERE name = ? " +
                "AND strftime('%Y', SUBSTR(release_date, 7, 4) || '-' || SUBSTR(release_date, 4, 2) || '-' || SUBSTR(release_date, 1, 2)) = ?)");
        statement.setString(1, souvenir);
        statement.setString(2, year);
        return statement.executeQuery();
    }

}