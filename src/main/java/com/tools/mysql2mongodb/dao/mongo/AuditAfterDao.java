package com.tools.mysql2mongodb.dao.mongo;

import com.tools.mysql2mongodb.model.AuditAfterModel;
import com.tools.mysql2mongodb.model.AuditNowModel;

import java.util.List;

/**
 * @author cheesezhang
 */
public interface AuditAfterDao {
    /**
     * 获取所有的正在审核的节目
     * @return List<AuditNowModel>
     */
    List<AuditAfterModel> findAll();
    void instertAuditAfterModels(List<AuditAfterModel> auditAfterModels);

}
