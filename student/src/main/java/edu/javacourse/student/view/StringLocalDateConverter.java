package edu.javacourse.student.view;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Kovalyov Anton 19.05.2022
 */
public class StringLocalDateConverter extends StdConverter<String, LocalDate> {
    @Override
    public LocalDate convert(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return LocalDate.parse(value, DateTimeFormatter.ofPattern(LocalDateStringConverter.DATE_FORMAT));
    }
}
