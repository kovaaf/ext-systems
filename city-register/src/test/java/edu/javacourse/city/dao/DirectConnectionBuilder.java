package edu.javacourse.city.dao;
/*
 *   Created by Kovalyov Anton 26.04.2022
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DirectConnectionBuilder implements ConnectionBuilder{

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/city_register",
                "postgres",
                "postgres");
    }
}
