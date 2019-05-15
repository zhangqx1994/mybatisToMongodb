package com.tools.mysql2mongodb.dao.repository;

import com.tools.mysql2mongodb.entity.ProgramSeriesRel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author cheesezhang
 */
public interface ProgramSeriesRelRepository extends JpaRepository<ProgramSeriesRel,Long> {

    List<ProgramSeriesRel> findProgramSeriesRelsByProgramSeriesId(Long programSeriesId);

    ProgramSeriesRel findByProgramId(Long programId);
}
