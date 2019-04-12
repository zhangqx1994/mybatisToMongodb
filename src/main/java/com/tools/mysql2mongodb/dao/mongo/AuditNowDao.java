package com.tools.mysql2mongodb.dao.mongo;

import com.tools.mysql2mongodb.model.AuditNowModel;

import java.util.List;

/**
 * @author cheesezhang
 */
public interface AuditNowDao {
    /**
     * 获取所有的正在审核的节目
     * @return List<AuditNowModel>
     */
    List<AuditNowModel> findAll();

}
