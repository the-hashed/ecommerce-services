package com.ecommerce.theHashed.service.UserServices;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        if (value != null) {
            if (value) {
                return "true";
            } else {
                return "false";
            }

        }
        return null;
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        if (value != null) {
            return !value.equals("false");
        }
        return null;
    }

}