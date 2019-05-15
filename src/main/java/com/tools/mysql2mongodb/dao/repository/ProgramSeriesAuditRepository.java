package com.tools.mysql2mongodb.dao.repository;

import com.tools.mysql2mongodb.entity.ProgramSeriesAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramSeriesAuditRepository extends JpaRepository<ProgramSeriesAudit,Long> {

    ProgramSeriesAudit findFirstByProgramSeriesIdAndAuditType(Long programSeriesId,Integer type);
}
