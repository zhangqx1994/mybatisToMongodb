package com.tools.mysql2mongodb.dao.repository;


import com.tools.mysql2mongodb.entity.Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author cheesezhang
 */
public interface ProgramRepository extends JpaRepository<Program, Long> {

    Page<Program> findProgramsByProgramStatusIdAndCpCode(String statusId,String cpCode, Pageable pageable);

}
