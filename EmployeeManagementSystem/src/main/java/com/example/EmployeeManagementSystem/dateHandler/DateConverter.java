package com.example.EmployeeManagementSystem.dateHandler;

import com.example.EmployeeManagementSystem.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateConverter {
    public Date convert(String source) {
        for (String format : getAllPossibleDateFormats()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                return sdf.parse(source);
            } catch (ParseException ignored) {
            }
        }
        throw new ResourceNotFoundException("Invalid date format: " + source);
    }

    private static String[] getAllPossibleDateFormats() {

        return new String[]{
                "yyyy-MM-dd",
                "MM/dd/yyyy",
                "dd-MM-yyyy",
                "yyyy.MM.dd"
        };
    }
}




