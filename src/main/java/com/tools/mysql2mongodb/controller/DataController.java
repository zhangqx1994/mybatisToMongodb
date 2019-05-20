package com.tools.mysql2mongodb.controller;

import com.alibaba.fastjson.JSON;
import com.mongodb.BasicDBObject;
import com.tools.mysql2mongodb.dao.mongo.AuditAfterDao;
import com.tools.mysql2mongodb.dao.mongo.AuditNowDao;
import com.tools.mysql2mongodb.dao.repository.*;
import com.tools.mysql2mongodb.entity.*;
import com.tools.mysql2mongodb.model.AuditAfterModel;
import com.tools.mysql2mongodb.model.AuditNowModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author cheesezhang
 */
@RestController
public class DataController {
    private final Logger logger = LoggerFactory.getLogger(DataController.class);
    private final ProgramRepository programRepository;
    private final ProgramSeriesRepository programSeriesRepository;
    private final ProgramSeriesRelRepository programSeriesRelRepository;
    private final ProgramAuditRepository programAuditRepository;
    private final ProgramSeriesAuditRepository programSeriesAuditRepository;
    private final AuditNowDao auditNowDao;
    private final AuditAfterDao auditAfterDao;
    private final ProgramUrlRepository programUrlRepository;
    @Value("${data.cpCode}")
    String cpCode;
    @Value("${data.appId}")
    String appId;
    @Value("${data.from}")
    String from;
    @Autowired
    public DataController(ProgramRepository programRepository, ProgramSeriesRepository programSeriesRepository, ProgramSeriesRelRepository programSeriesRelRepository, ProgramSeriesAuditRepository programSeriesAuditRepository, AuditNowDao auditNowDao, AuditAfterDao auditAfterDao, ProgramAuditRepository programAuditRepository,ProgramUrlRepository programUrlRepository) {
        this.programRepository = programRepository;
        this.programSeriesRepository = programSeriesRepository;
        this.programSeriesRelRepository = programSeriesRelRepository;
        this.programSeriesAuditRepository = programSeriesAuditRepository;
        this.auditNowDao = auditNowDao;
        this.auditAfterDao = auditAfterDao;
        this.programAuditRepository = programAuditRepository;
        this.programUrlRepository = programUrlRepository;
    }

    @RequestMapping("/taskSet")
    public void testConn() {
        //导入未审核
//        Page<ProgramSeries> programSeriesPage = programSeriesRepository.findProgramSeriesByStatusAndCpCode("CHECKUP", cpCode, Pageable.unpaged());
//        List<AuditNowModel> auditNowModels = convertNowSet(setProgramIDs(programSeriesPage));
//        logger.info("start task programSet CHECKUP size={}", auditNowModels.size());
//        auditNowDao.instertAuditNowModels(auditNowModels);

        //导入审核通过
        Page<ProgramSeries> programSeriesOnline = programSeriesRepository.findProgramSeriesByStatusAndCpCode("ONLINE", cpCode, PageRequest.of(1, 10000));
        int pagesPass = programSeriesOnline.getTotalPages();
        logger.info("start task programSet ONLINE totalPages={} size=10000", pagesPass);
        for (int i = 1; i <= pagesPass; i++) {
            Page<ProgramSeries> programSeriesOnlinePage = programSeriesRepository.findProgramSeriesByStatusAndCpCode("ONLINE", cpCode, PageRequest.of(i, 10000));
            List<AuditAfterModel> auditAfterPassModels = convertAfterSet(setProgramIDs(programSeriesOnlinePage), "pass");
            logger.info("start task programSet ONLINE page={} size={}",i, auditAfterPassModels.size());
            auditAfterDao.instertAuditAfterModels(auditAfterPassModels);
        }

        //导入审核不通过
//        Page<ProgramSeries> programSeriesNotPass = programSeriesRepository.findProgramSeriesByStatusAndCpCode("CHECKUPFINALNOPASS", cpCode, PageRequest.of(1, 1000));
//        int pagesNotPass = programSeriesNotPass.getTotalPages();
//        logger.info("start task program NOTPASS totalPages={} size=1000", pagesNotPass);
//        for (int i = 1; i <= pagesNotPass; i++) {
//            Page<ProgramSeries> programSeriesNotPassPage = programSeriesRepository.findProgramSeriesByStatusAndCpCode("CHECKUPFINALNOPASS", cpCode, PageRequest.of(i, 1000));
//            List<AuditAfterModel> auditAfterNotPassModels = convertAfterSet(setProgramIDs(programSeriesNotPassPage), "notpass");
//            logger.info("start task programSet page={} NOTPASS size={}", i,auditAfterNotPassModels.size());
//            auditAfterDao.instertAuditAfterModels(auditAfterNotPassModels);
//        }

        //导入审核下线
//        Page<ProgramSeries> programSeriesOffline = programSeriesRepository.findProgramSeriesByStatusAndCpCode("OFFLINE", cpCode, PageRequest.of(1, 1000));
//        int pagesOffline = programSeriesOffline.getTotalPages();
//        logger.info("start task programSet OFFLINE totalPages={} size=1000", pagesOffline);
//        for (int i = 1; i <= pagesOffline; i++) {
//            Page<ProgramSeries> programSeriesOfflinePage = programSeriesRepository.findProgramSeriesByStatusAndCpCode("OFFLINE", cpCode, PageRequest.of(i, 1000));
//
//            List<AuditAfterModel> auditAfterOfflineModels = convertAfterSet(setProgramIDs(programSeriesOfflinePage), "offline");
//            logger.info("start task programSet page={} OFFLINE size={}", i,auditAfterOfflineModels.size());
//            auditAfterDao.instertAuditAfterModels(auditAfterOfflineModels);
//        }
    }

    private List<ProgramSeries> setProgramIDs(Page<ProgramSeries> programSeriesOfflinePage) {
        List<ProgramSeries> programSeriesOfflineList = programSeriesOfflinePage.getContent();
        for (ProgramSeries programSeries : programSeriesOfflineList) {
            List<ProgramSeriesRel> programList = programSeriesRelRepository.findProgramSeriesRelsByProgramSeriesId(programSeries.getId());
            List<Long> programIdList = new ArrayList<>();
            for (ProgramSeriesRel programSeriesRel : programList) {
                programIdList.add(programSeriesRel.getProgramId());
            }
//            programSeries.setVideo_ids(programIdList);
            programSeries.setProgramList(programIdList);
        }
        return programSeriesOfflineList;
    }


    @RequestMapping("/taskProgram")
    public void convertProgram() {
        //待审核状态数据导入
//        Page<Program> programDaoList = programRepository.findProgramsByProgramStatusIdAndCpCode("CHECKUP", cpCode, Pageable.unpaged());
//        List<AuditNowModel> auditNowModels = convertNow(programDaoList.getContent());
//        logger.info("start task program CHECKUP size={}", auditNowModels.size());
//        auditNowDao.instertAuditNowModels(auditNowModels);

        //审核通过状态导入
        Page<Program> programOnline = programRepository.findProgramsByProgramStatusIdAndCpCode("ONLINE", cpCode, PageRequest.of(1, 10000));
        int pagesOnline = programOnline.getTotalPages();
        programOnline = null;
        logger.info("start task program ONLINE totalPages={} size=10000", pagesOnline);
        for (int i = 1; i <= pagesOnline; i++) {
            Page<Program> programOnlineList = programRepository.findProgramsByProgramStatusIdAndCpCode("ONLINE", cpCode, PageRequest.of(i, 10000));
            List<AuditAfterModel> auditAfterModels = convertAfter(programOnlineList.getContent(), "pass");
            logger.info("start task program ONLINE page={} size={} time={}", i, auditAfterModels.size(), new Date());
            auditAfterDao.instertAuditAfterModels(auditAfterModels);
        }
        //审核不通过状态导入
//        Page<Program> programNotPass = programRepository.findProgramsByProgramStatusIdAndCpCode("CHECKUPFINALNOPASS", cpCode, PageRequest.of(1, 1000));
//        int pagesPass = programNotPass.getTotalPages();
//        logger.info("start task program NOTPASS totalPages={} size=1000", pagesPass);
//        for (int i = 1; i <= pagesPass; i++) {
//            Page<Program> programNotPassList = programRepository.findProgramsByProgramStatusIdAndCpCode("CHECKUPFINALNOPASS", cpCode, PageRequest.of(i, 1000));
//            List<AuditAfterModel> auditAfterNotPassModels = convertAfter(programNotPassList.getContent(), "notpass");
//            logger.info("start task program NOTPASS page={} size={} time={}", i, auditAfterNotPassModels.size(), new Date());
//            auditAfterDao.instertAuditAfterModels(auditAfterNotPassModels);
//        }
        //下线状态导入
//        Page<Program> programOffline = programRepository.findProgramsByProgramStatusIdAndCpCode("OFFLINE", cpCode, PageRequest.of(1, 1000));
//        int pagesOffline = programOffline.getTotalPages();
//        logger.info("start task program OFFLINE totalPages={} size=10000", pagesOffline);
//        for (int i = 1; i <= pagesOffline; i++) {
//            Page<Program> programOfflineList = programRepository.findProgramsByProgramStatusIdAndCpCode("OFFLINE", cpCode, PageRequest.of(i, 1000));
//            List<AuditAfterModel> auditAfterOfflineModels = convertAfter(programOfflineList.getContent(), "offline");
//            logger.info("start task program OFFLINE page={} size={} time={}", i, auditAfterOfflineModels.size(), new Date());
//            auditAfterDao.instertAuditAfterModels(auditAfterOfflineModels);
//        }

    }

    private List<AuditNowModel> convertNow(List<Program> programDaoList) {
        List<AuditNowModel> auditNowModels = new ArrayList<>();
        for (Program program : programDaoList) {
            program.convert();
            AuditNowModel auditNowModel = new AuditNowModel();
            auditNowModel.setAppId(appId);
            auditNowModel.setCreatedAt(program.getCreateDate());
            auditNowModel.setFrom(from);
            auditNowModel.setId(program.getOutSourceId());
            auditNowModel.setPriority("1");
            auditNowModel.setStatus("waiting");
            if(cpCode.equals("TENCENT")){
                String tags = program.getTag();
                if (tags!=null){
                    auditNowModel.setTags(Arrays.asList(tags.split("\\|")));
                }
            }else {
                auditNowModel.setTags(Arrays.asList(program.getMaterialClass().split("\\|")));
            }
            auditNowModel.setType("program");
            auditNowModel.setContent(BasicDBObject.parse(JSON.toJSONString(program)));
            auditNowModels.add(auditNowModel);
        }
        return auditNowModels;
    }

    private List<AuditNowModel> convertNowSet(List<ProgramSeries> programSeriesList) {
        List<AuditNowModel> auditNowModels = new ArrayList<>();
        for (ProgramSeries programSeries : programSeriesList) {
            programSeries.convert();
            AuditNowModel auditNowModel = new AuditNowModel();
            auditNowModel.setAppId(appId);
//            auditNowModel.setCreatedAt(programSeries.getCreate_time());
            auditNowModel.setCreatedAt(programSeries.getCreateDate());
            auditNowModel.setFrom(from);
            auditNowModel.setId(programSeries.getOutSourceId());
            auditNowModel.setPriority("1");
            auditNowModel.setStatus("waiting");
            if(cpCode.equals("TENCENT")){
//                String tags = programSeries.getTagArray();
                String tags = programSeries.getTag();
                if (tags!=null){
                    auditNowModel.setTags(Arrays.asList(tags.split("\\|")));
                }
            }else {
                auditNowModel.setTags(Arrays.asList(programSeries.getProgramClass().split("\\|")));
            }
            auditNowModel.setType("programset");
            auditNowModel.setContent(BasicDBObject.parse(JSON.toJSONString(programSeries)));
            auditNowModels.add(auditNowModel);
        }
        return auditNowModels;
    }

    private List<AuditAfterModel> convertAfter(List<Program> programList, String status) {
        List<AuditAfterModel> auditAfterModels = new ArrayList<>();
        for (Program program : programList) {
            program.convert();
            ProgramUrl programUrl = programUrlRepository.findFirstByProgramId(program.getProgramId());
            if (programUrl!=null){
                program.setUrl(programUrl.getPlayUrl());
            }
            AuditAfterModel auditAfterModel = new AuditAfterModel();
            auditAfterModel.setAppId(appId);
            Date create = program.getCreateDate();
            Date update = program.getStatusDate();
            if (create!=null){
                auditAfterModel.setCreatedAt(create);
            }
            if (update!=null){
                auditAfterModel.setUpdatedAt(update);
            }
            switch (status) {

                case "pass":
                    auditAfterModel.setAuditor("机器审核");
                    break;
                case "offline":
                    ProgramAudit programAuditOffline = programAuditRepository.findFirstByProgramIdAndAuditType(program.getProgramId(), 2);
                    ProgramAudit programAuditReason = programAuditRepository.findFirstByProgramIdAndAuditType(program.getProgramId(), 1);
                    if (programAuditReason != null) {
                        auditAfterModel.setAuditor(programAuditReason.getAuditUser());
                        auditAfterModel.setReason(programAuditReason.getAuditDesc());
                    }
                    if (programAuditOffline != null) {
                        auditAfterModel.setOfflineAuditor(programAuditOffline.getAuditUser());
                        auditAfterModel.setOfflineReason(programAuditOffline.getAuditDesc());
                    }
                    auditAfterModel.setOffline(true);
                    break;
                default:
                    ProgramAudit programAudit = programAuditRepository.findFirstByProgramIdAndAuditType(program.getProgramId(), 1);
                    if (programAudit != null) {
                        auditAfterModel.setAuditor(programAudit.getAuditUser());
                        auditAfterModel.setReason(programAudit.getAuditDesc());
                    }
                    break;

            }
            auditAfterModel.setFrom(from);
            auditAfterModel.setId(program.getOutSourceId());
            auditAfterModel.setPriority("1");
            auditAfterModel.setStatus(status);
            if(cpCode.equals("TENCENT")){
                String tags = program.getTag();
                if (tags!=null){
                    auditAfterModel.setTags(Arrays.asList(tags.split("\\|")));
                }
            }else {
                auditAfterModel.setTags(Arrays.asList(program.getMaterialClass().split("\\|")));
            }
            auditAfterModel.setType("program");
            auditAfterModel.setContent(BasicDBObject.parse(JSON.toJSONString(program)));
            auditAfterModels.add(auditAfterModel);
        }
        return auditAfterModels;
    }

    private List<AuditAfterModel> convertAfterSet(List<ProgramSeries> programSeriesList, String status) {
        List<AuditAfterModel> auditAfterModels = new ArrayList<>();
        for (ProgramSeries programSeries : programSeriesList) {
            programSeries.convert();
            AuditAfterModel auditAfterModel = new AuditAfterModel();
            auditAfterModel.setAppId(appId);
//            Date create = programSeries.getCreate_time();
            Date create = programSeries.getCreateDate();
            Date update = programSeries.getStatusTime();
            if (create!=null){
                auditAfterModel.setCreatedAt(create);
            }
            if (update!=null){
                auditAfterModel.setUpdatedAt(update);
            }
            switch (status) {
                case "pass":
                    auditAfterModel.setAuditor("机器审核");
                    break;
                case "offline":
                    ProgramSeriesAudit programSeriesAuditOffline = programSeriesAuditRepository.findFirstByProgramSeriesIdAndStatus(programSeries.getId(), 2);
                    ProgramSeriesAudit programSeriesAuditReason = programSeriesAuditRepository.findFirstByProgramSeriesIdAndStatus(programSeries.getId(), 0);
                    if (programSeriesAuditReason != null) {
                        auditAfterModel.setAuditor(programSeriesAuditReason.getAuditUser());
                        auditAfterModel.setReason(programSeriesAuditReason.getAuditDesc());
                    }
                    if (programSeriesAuditOffline != null) {
                        auditAfterModel.setOfflineAuditor(programSeriesAuditOffline.getAuditUser());
                        auditAfterModel.setOfflineReason(programSeriesAuditOffline.getAuditDesc());
                    }
                    auditAfterModel.setOffline(true);
                    break;
                default:
                    ProgramSeriesAudit programSeriesAudit = programSeriesAuditRepository.findFirstByProgramSeriesIdAndStatus(programSeries.getId(), 0);
                    if (programSeriesAudit != null) {
                        auditAfterModel.setAuditor(programSeriesAudit.getAuditUser());
                        auditAfterModel.setReason(programSeriesAudit.getAuditDesc());
                    }
                    break;

            }
            auditAfterModel.setFrom(from);
            auditAfterModel.setId(programSeries.getOutSourceId());
            auditAfterModel.setPriority("1");
            auditAfterModel.setStatus(status);
            if(cpCode.equals("TENCENT")){
//                String tags = programSeries.getTagArray();
                String tags = programSeries.getTag();
                if (tags!=null){
                    auditAfterModel.setTags(Arrays.asList(tags.split("\\|")));
                }
            }else {
                auditAfterModel.setTags(Arrays.asList(programSeries.getProgramClass().split("\\|")));
            }            auditAfterModel.setType("programset");
            auditAfterModel.setContent(BasicDBObject.parse(JSON.toJSONString(programSeries)));
            auditAfterModels.add(auditAfterModel);
        }
        return auditAfterModels;
    }
}
