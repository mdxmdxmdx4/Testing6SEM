package com.belstu.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Вывести информацию о сувенирах заданного производителя.
            ResultSet rs = DatabaseQueryExecutor.getSouvenirsByManufacturer("LEGO");
            System.out.println("Сувениры LEGO:");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            // Вывести информацию о сувенирах, произведенных в заданной стране.
            System.out.println("\nСувениры из России:");
            rs = DatabaseQueryExecutor.getSouvenirsByCountry("Russia");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            // Вывести информацию о производителях, чьи цены на сувениры меньше заданной.
            System.out.println("\nПроизводители с сувенирами дешевле 500:");
            rs = DatabaseQueryExecutor.getManufacturersByPrice(500.0);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            // Вывести информацию о производителях заданного сувенира, произведенного в заданном году.
            System.out.println("\nПроизвоитель сувенира \"Adrenaline Rush Year Supply\" 2024-ого года");
            rs = DatabaseQueryExecutor.getManufacturersBySouvenirAndYear("Adrenaline Rush Year Supply", "2024");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            System.out.println();
            DatabaseUpdateExecutor.deleteManufacturerAndSouvenirs("LEGO");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


