package com.example.azdigitalumbrellacbarintegration.service;

import com.example.azdigitalumbrellacbarintegration.client.CbarClient;
import com.example.azdigitalumbrellacbarintegration.dao.entity.RateEntity;
import com.example.azdigitalumbrellacbarintegration.dao.repository.RateRepository;
import com.example.azdigitalumbrellacbarintegration.mapper.RateMapper;
import com.example.azdigitalumbrellacbarintegration.model.constants.ExceptionConstants;
import com.example.azdigitalumbrellacbarintegration.model.criteria.PageCriteria;
import com.example.azdigitalumbrellacbarintegration.model.criteria.RateCriteria;
import com.example.azdigitalumbrellacbarintegration.model.dto.PageableRateDto;
import com.example.azdigitalumbrellacbarintegration.model.enums.Status;
import com.example.azdigitalumbrellacbarintegration.model.exception.RateException;
import com.example.azdigitalumbrellacbarintegration.service.specification.RateSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RateService {

    private final RateRepository rateRepository;
    private final CbarClient cbarClient;
    
    public void save(LocalDate date){
        
        log.info("ActionLog.save.start date:{} ", date);
        
        ValCurs ratesFromCbarByDate = cbarClient.getRatesByDate(date);
        var dateFromCbar = BuildHelper.buildDate(ratesFromCbarByDate);
            
        List<RateEntity> rates = rateRepository.findAllByDate(dateFromCbar);
        if (rates.isEmpty()) {
        
            var rateEntities = RateMapper.mapValCursToListRateEntities(ratesFromCbarByDate);
            rateRepository.saveAll(rateEntities);
            
            log.info("ActionLog.save.success date: {} ", date);
        } else {
            
            log.error("ActionLog.save.error date: {}", date);
            
            throw new RateException(ExceptionConstants.RATE_EXCEPTION_MESSAGE, ExceptionConstants.RATE_EXCEPTION_CODE);
        }


    public PageableRateDto getRates(RateCriteria rateCriteria, PageCriteria pageCriteria) {

        log.info("ActionLog.getRates.start");

        int pageNumber = pageCriteria.getPage();
        int count = pageCriteria.getCount();

        Pageable pageRequest = PageRequest.of(pageNumber, count);
        var specification = new RateSpecification(rateCriteria);

        Page<RateEntity> ratePage = rateRepository.findAll(specification, pageRequest);
        List<RateEntity> rates = ratePage.getContent();
        int ratePageCounts = ratePage.getTotalPages();

        if (ratePageCounts != 0) {
            ratePageCounts -= 1;
        }
        var pageableDto = PageableRateDto.builder()
                .rates(RateMapper.mapEntitiesToListResponseDtos(rates))
                .lastPageNumber(ratePageCounts)
                .hasNextPage(ratePage.hasNext())
                .build();

        log.info("ActionLog.getRates.start");

        return pageableDto;
    }


    public void deleteByDate(LocalDate date) {
        log.info("ActionLog.deleteByDate.start: date {}", date);

        rateRepository.deleteAllByDate(date);

        log.info("ActionLog.deleteByDate.success: date {}", date);
    }
        
}

