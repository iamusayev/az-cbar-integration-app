package com.example.azdigitalumbrellacbarintegration.model.util;


import com.example.azdigitalumbrellacbarintegration.client.model.ValCurs;
import com.example.azdigitalumbrellacbarintegration.client.model.Valute;
import com.example.azdigitalumbrellacbarintegration.dao.entity.RateEntity;
import com.example.azdigitalumbrellacbarintegration.model.enums.Status;
import com.example.azdigitalumbrellacbarintegration.model.enums.Type;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BuildHelper {

    public static LocalDate buildDate(ValCurs valCurs) {
        String date = valCurs.getLocalDate();
        var parseDate = date.replace(".", "/");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(parseDate, formatter);
        return localDate;
    }


    public static RateEntity buildRateEntity(Valute valute, Type type, LocalDate date) {
        valute.getNominal();
        return RateEntity.builder()
                .name(valute.getName())
                .code(valute.getCode())
                .nominal(valute.getNominal())
                .date(date)
                .type(type)
                .value(valute.getValue())
                .build();
    }
}
