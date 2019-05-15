package com.tools.mysql2mongodb.dao.repository;

import com.tools.mysql2mongodb.entity.ProgramSeries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author cheesezhang
 */
public interface ProgramSeriesRepository extends JpaRepository<ProgramSeries,Long> {

    Page<ProgramSeries> findProgramSeriesByStatusAndCpCode(String status, String cpCode,Pageable pageable);


}
