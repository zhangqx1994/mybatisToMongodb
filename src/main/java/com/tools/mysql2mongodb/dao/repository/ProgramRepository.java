package com.tools.mysql2mongodb.dao.repository;


import com.tools.mysql2mongodb.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author cheesezhang
 */
public interface ProgramRepository extends JpaRepository<Program, Long> {

    List<Program> findProgramsByProgramStatusId(String statusId);

}
