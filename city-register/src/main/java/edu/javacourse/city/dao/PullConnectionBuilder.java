package edu.javacourse.city.dao;
/*
 *   Created by Kovalyov Anton 26.04.2022
 */

import edu.javacourse.city.web.CheckPersonServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PullConnectionBuilder implements ConnectionBuilder {
    private DataSource dataSource;
    private static final Logger logger = LoggerFactory.getLogger(PullConnectionBuilder.class);

    public PullConnectionBuilder() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/cityRegister");
        } catch (NamingException e) {
            logger.error("", e);
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
