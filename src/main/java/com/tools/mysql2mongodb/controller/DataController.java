package com.tools.mysql2mongodb.controller;

import com.tools.mysql2mongodb.dao.mongo.AuditNowDao;
import com.tools.mysql2mongodb.dao.repository.ProgramRepository;
import com.tools.mysql2mongodb.dao.repository.ProgramSeriesRepository;
import com.tools.mysql2mongodb.model.AuditNowModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cheesezhang
 */
@RestController
public class DataController {
    @Autowired
    ProgramRepository programRepository;
    @Autowired
    ProgramSeriesRepository programSeriesRepository;
    @Autowired
    AuditNowDao auditNowDao;
    @RequestMapping("/testconn")
    public void testConn(){
//        List<Program> programDaoList = programRepository.findAll();
//        List<ProgramSeries> programSeries = programSeriesRepository.findAll();
//        System.out.println(programDaoList.size()+" "+programSeries.size());
        List<AuditNowModel> auditNowModels = auditNowDao.findAll();
        System.out.println(auditNowModels.size());
    }

}
