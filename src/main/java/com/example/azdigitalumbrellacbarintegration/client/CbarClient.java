package com.example.azdigitalumbrellacbarintegration.client;

import com.example.azdigitalumbrellacbarintegration.client.model.ValCurs;
import com.example.azdigitalumbrellacbarintegration.model.constants.ExceptionConstants;
import com.example.azdigitalumbrellacbarintegration.model.exception.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class CbarClient {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ValCurs getRatesByDate(LocalDate date) {
        String url = getUrl(date);
        try {
            ValCurs response = restTemplate.getForObject(url, ValCurs.class);
            return response;
        } catch (Exception ex) {
            log.error("ActionLog.getRatesByDate.error: {}", ex);
            throw new ClientException(ExceptionConstants.CLIENT_EXCEPTION_MESSAGE, "500");
        }
    }


   private static String getUrl(LocalDate date) {
        date.format(DateTimeFormatter.BASIC_ISO_DATE);
        var day = date.getDayOfMonth();
        var month = date.getMonthValue();
        var year = date.getYear();

        Object urlDay = day < 10 ? "0" + day : day;
        Object urlMonth = month < 10 ? "0" + month : month;

        return String.format("https://www.cbar.az/currencies/%s.xml", urlDay + "." +   urlMonth + "." + year);
    }

}
