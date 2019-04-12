package com.tools.mysql2mongodb.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(collection = "audit_now")
public class AuditNowModel implements Serializable {

    @Field("status")
    private String status;
    @Field("id")
    private String id;
    @Field("original_id")
    private String originalId;
    @Field("app_id")
    private String appId;
    @Field("from")
    private String from;
    @Field("type")
    private String type;
    @Field("priority")
    private String priority;
    @Field("content")
    private BasicDBObject content;
    @Field("updated_at")
    private Date updatedAt;
    @Field("created_at")
    private Date createdAt;
    @Field("tags")
    private List<String> tags;
    @Field("auditor")
    private String auditor;
    @Field("expiredAt")
    private Date expired_at;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public BasicDBObject getContent() {
        return content;
    }

    public void setContent(BasicDBObject content) {
        this.content = content;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Date getExpired_at() {
        return expired_at;
    }

    public void setExpired_at(Date expired_at) {
        this.expired_at = expired_at;
    }
}
