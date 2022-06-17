package com.example.azdigitalumbrellacbarintegration.dao.repository;

import com.example.azdigitalumbrellacbarintegration.dao.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface RateRepository extends JpaRepository<RateEntity, Long>, JpaSpecificationExecutor<RateEntity> {

    List<RateEntity> findAllByDate(LocalDate date);

}
