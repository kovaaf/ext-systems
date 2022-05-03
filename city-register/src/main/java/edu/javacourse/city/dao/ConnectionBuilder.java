package edu.javacourse.city.dao;
/*
 *   Created by Kovalyov Anton 26.04.2022
 */

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionBuilder {
    Connection getConnection() throws SQLException;
}
