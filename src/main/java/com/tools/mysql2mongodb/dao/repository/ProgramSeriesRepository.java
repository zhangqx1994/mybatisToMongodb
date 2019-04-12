package com.tools.mysql2mongodb.dao.repository;

import com.tools.mysql2mongodb.entity.ProgramSeries;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author cheesezhang
 */
public interface ProgramSeriesRepository extends JpaRepository<ProgramSeries,Long> {

}
