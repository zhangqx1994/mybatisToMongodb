package com.tools.mysql2mongodb.dao.mongo.impl;

import com.tools.mysql2mongodb.dao.mongo.AuditAfterDao;
import com.tools.mysql2mongodb.dao.mongo.AuditNowDao;
import com.tools.mysql2mongodb.model.AuditAfterModel;
import com.tools.mysql2mongodb.model.AuditNowModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author cheesezhang
 */
@Component
public class AuditAfterImpl implements AuditAfterDao {
    private final Logger logger = LoggerFactory.getLogger("operationLog");
    private final MongoTemplate mongoTemplate;

    @Autowired
    public AuditAfterImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<AuditAfterModel> findAll() {
        return mongoTemplate.findAll(AuditAfterModel.class);
    }

    @Override
    public void instertAuditAfterModels(List<AuditAfterModel> auditAfterModels) {
        mongoTemplate.insertAll(auditAfterModels);
    }
}
