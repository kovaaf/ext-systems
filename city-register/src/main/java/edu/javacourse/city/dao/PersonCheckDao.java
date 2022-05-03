package edu.javacourse.city.dao;
/*
 *   Created by Kovalyov Anton 19.04.2022
 */

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;

import java.sql.*;

public class PersonCheckDao {
    public static final String SQL_REQUEST = 
            "select temporal from cr_address_person ap " +
            "inner join cr_person p on p.person_id = ap.person_id " +
            "inner join cr_address a on a.address_id = ap.address_id " +
            "where " +
            "CURRENT_DATE >= ap.start_date and (CURRENT_DATE  <= ap.end_date or ap.end_date is null) " +
            "and upper(p.sur_name) = upper(?) " +
            "and upper(p.given_name) = upper(?) " +
            "and upper(p.patronymic) = upper(?) " +
            "and p.date_of_birth = ? " +
            "and a.street_code = ? " +
            "and upper(a.building) = upper(?) ";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }

    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        PersonResponse response = new PersonResponse();

        String sql = SQL_REQUEST;
        if (request.getExtension() != null) {
            sql += "and upper(a.extension) = upper(?) ";
        } else {
            sql += "and a.extension is null ";
        }
        if (request.getApartment() != null) {
            sql += "and upper(a.apartment) = upper(?) ";
        } else {
            sql += "and a.apartment is null ";
        }

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            int counter = 1;
            statement.setString(counter++, request.getSurName());
            statement.setString(counter++, request.getGivenName());
            statement.setString(counter++, request.getPatronymic());
            statement.setDate(counter++, java.sql.Date.valueOf(request.getDateOfBirth()));
            statement.setInt(counter++, request.getStreetCode());
            statement.setString(counter++, request.getBuilding());
            if (request.getExtension() != null) {
                statement.setString(counter++, request.getExtension());
            }
            if (request.getApartment() != null) {
                statement.setString(counter++, request.getApartment());
            }

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                response.setRegistered(true); // Т.к. мы отобрали только зарегистрированных
                response.setTemporal(resultSet.getBoolean("temporal")); // и устанавливаем фактический тип регистрации
            }
        } catch (SQLException ex) {
            throw new PersonCheckException(ex);
        }

        return response;
    }
}
