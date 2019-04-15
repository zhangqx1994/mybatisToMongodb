package com.tools.mysql2mongodb.dao.mongo.impl;

import com.tools.mysql2mongodb.dao.mongo.AuditNowDao;
import com.tools.mysql2mongodb.model.AuditNowModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author cheesezhang
 */
@Component
public class AuditDaoImpl implements AuditNowDao {
    private final Logger logger = LoggerFactory.getLogger("operationLog");
    private final MongoTemplate mongoTemplate;

    @Autowired
    public AuditDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<AuditNowModel> findAll() {
        return mongoTemplate.findAll(AuditNowModel.class);
    }

    @Override
    public void instertAuditNowModels(List<AuditNowModel> auditNowModels) {
        mongoTemplate.insertAll(auditNowModels);
    }
}
