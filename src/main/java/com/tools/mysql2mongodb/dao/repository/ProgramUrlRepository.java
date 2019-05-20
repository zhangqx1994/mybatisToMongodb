package com.tools.mysql2mongodb.dao.repository;

import com.tools.mysql2mongodb.entity.ProgramUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramUrlRepository extends JpaRepository<ProgramUrl,Long> {

    ProgramUrl findFirstByProgramId(Long programID);
}
