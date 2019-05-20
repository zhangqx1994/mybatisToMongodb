package com.tools.mysql2mongodb.dao.repository;

import com.tools.mysql2mongodb.entity.ProgramAudit;
import com.tools.mysql2mongodb.entity.ProgramSeriesAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramAuditRepository extends JpaRepository<ProgramAudit,Long> {

    ProgramAudit findFirstByProgramIdAndAuditType(Long programId,int auditType);
    ProgramAudit findFirstByProgramIdAndStatus(Long programId,int status);
}
