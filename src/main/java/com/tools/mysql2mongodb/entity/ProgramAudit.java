package com.tools.mysql2mongodb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cms_program_final_audit")
public class ProgramAudit implements Serializable {

    @Id
    @Column(name = "AUDIT_LOG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditLogId;
    @Column(name = "PROGRAM_ID")
    private Long programId;
    @Column(name = "PROGRAM_NAME")
    private String programName;
    @Column(name = "AUDIT_TYPE")
    private int auditType;
    @Column(name = "STATUS")
    private int status;
    @Column(name = "AUDIT_TIME")
    private Date auditTime;
    @Column(name = "AUDIT_USER")
    private String auditUser;
    @Column(name = "AUDIT_DESC")
    private String auditDesc;
    @Column(name = "CP_CODE")
    private String cpCode;

    public Long getAuditLogId() {
        return auditLogId;
    }

    public void setAuditLogId(Long auditLogId) {
        this.auditLogId = auditLogId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getAuditType() {
        return auditType;
    }

    public void setAuditType(int auditType) {
        this.auditType = auditType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }
}
