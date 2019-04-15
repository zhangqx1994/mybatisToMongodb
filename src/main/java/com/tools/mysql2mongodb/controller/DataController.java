package com.tools.mysql2mongodb.controller;

import com.alibaba.fastjson.JSON;
import com.mongodb.BasicDBObject;
import com.tools.mysql2mongodb.dao.mongo.AuditNowDao;
import com.tools.mysql2mongodb.dao.repository.ProgramRepository;
import com.tools.mysql2mongodb.dao.repository.ProgramSeriesRelRepository;
import com.tools.mysql2mongodb.dao.repository.ProgramSeriesRepository;
import com.tools.mysql2mongodb.entity.Program;
import com.tools.mysql2mongodb.entity.ProgramSeries;
import com.tools.mysql2mongodb.entity.ProgramSeriesRel;
import com.tools.mysql2mongodb.model.AuditNowModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
    ProgramSeriesRelRepository programSeriesRelRepository;
    @Autowired
    AuditNowDao auditNowDao;
    @RequestMapping("/testconn")
    public void testConn(){

        List<ProgramSeries> programSeries = programSeriesRepository.findAll();
        Map<String,Integer>  stringIntegerMap = new HashMap<>();
        for(ProgramSeries programSeries1 : programSeries){
            List<ProgramSeriesRel> programList = programSeriesRelRepository.findProgramSeriesRelsByProgramSeriesId(programSeries1.getId());
            if (programList.size()!=0){
                stringIntegerMap.put(programSeries1.getProgramSeriesName(),programList.size());
            }
        }
        System.out.println(stringIntegerMap.toString());
//        List<Program> programDaoList = programRepository.findProgramsByProgramStatusId("CHECKUP");
//        List<ProgramSeries> programSeries = programSeriesRepository.findProgramSeriesByStatus("CHECKUP");
//        System.out.println(programDaoList.size()+" "+programSeries.size());
//        List<AuditNowModel> auditNowModels = auditNowDao.findAll();
//        System.out.println(auditNowModels.size());
    }
    @RequestMapping("/taskProgram")
    public void convertProgram(){
        //待审核状态数据导入
        List<Program> programDaoList = programRepository.findProgramsByProgramStatusId("CHECKUP");
        List<AuditNowModel> auditNowModels = convert(programDaoList,"waiting");
        auditNowDao.instertAuditNowModels(auditNowModels);
    }

    private List<AuditNowModel> convert(List<Program> programDaoList,String status) {
        List<AuditNowModel> auditNowModels = new ArrayList<>();
        for(Program program : programDaoList){
            AuditNowModel auditNowModel = new AuditNowModel();
            auditNowModel.setAppId("5cb035dba40ed");
            auditNowModel.setCreatedAt(program.getCreateDate());
            auditNowModel.setAuditor("MGSPOLD");
            auditNowModel.setFrom(program.getUpdateUser());
            auditNowModel.setId(program.getProgramId().toString());
            auditNowModel.setPriority("1");
            auditNowModel.setStatus(status);
            auditNowModel.setTags(Arrays.asList(program.getMaterialClass().split("\\|")));
            auditNowModel.setType("program");
            auditNowModel.setContent(BasicDBObject.parse(JSON.toJSONString(program)));
            auditNowModels.add(auditNowModel);
        }
        return auditNowModels;
    }
}
