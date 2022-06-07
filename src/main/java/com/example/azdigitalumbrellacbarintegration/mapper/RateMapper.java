package com.example.azdigitalumbrellacbarintegration.mapper;



import com.example.azdigitalumbrellacbarintegration.client.model.ValCurs;
import com.example.azdigitalumbrellacbarintegration.client.model.Valute;
import com.example.azdigitalumbrellacbarintegration.dao.entity.RateEntity;
import com.example.azdigitalumbrellacbarintegration.model.dto.RateResponseDto;
import com.example.azdigitalumbrellacbarintegration.model.enums.Type;
import com.example.azdigitalumbrellacbarintegration.model.util.BuildHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RateMapper {


    public static RateResponseDto mapEntityToResponseDto(RateEntity rateEntity) {
        return RateResponseDto.builder()
                .nominal(rateEntity.getNominal())
                .name(rateEntity.getName())
                .code(rateEntity.getCode())
                .value(rateEntity.getValue())
                .build();
    }


    public static List<RateResponseDto> mapEntitiesToListResponseDtos(List<RateEntity> rateEntities) {
        return rateEntities.stream()
                .map(RateMapper::mapEntityToResponseDto)
                .collect(Collectors.toList());
    }


    public static List<RateEntity> mapValCursToListRateEntities(ValCurs valCurs) {
        LocalDate localDate = BuildHelper.buildDate(valCurs);
        List<Valute> metals = valCurs.getValType().get(0).getValute();
        List<Valute> currencies = valCurs.getValType().get(1).getValute();

        List<RateEntity> rates = new ArrayList<>();

        for (Valute metal : metals) {
            RateEntity rate = BuildHelper.buildRateEntity(metal, Type.PRECIOUS_METAL, localDate);
            rates.add(rate);
        }
        for (Valute currency : currencies) {
            RateEntity rate = BuildHelper.buildRateEntity(currency, Type.FOREIGN_CURRENCY, localDate);
            rates.add(rate);
        }
        return rates;
    }



    }

    


