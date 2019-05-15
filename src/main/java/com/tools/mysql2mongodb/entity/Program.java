package com.tools.mysql2mongodb.entity;


import com.tools.mysql2mongodb.common.Definiton;
import com.tools.mysql2mongodb.common.LanguageType;
import com.tools.mysql2mongodb.common.MaterialType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <节目实体对象><br />
 * <功能详细描述>
 * 
 * @author wangdx
 * @version [版本号1.0, 2014年9月22日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity
@Table(name = "cms_program")
public class Program implements Serializable
{

	/** 
	 * 
	 */
	private static final long serialVersionUID = -4297604452944372217L;

	@Id
	@Column(name = "PROGRAM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long programId;

	@Column(name = "PROGRAM_NAME")
	private String programName;

	@Column(name = "ENGLISH_NAME")
	private String englishName;

	@Column(name = "ALIAS")
	private String alias;

	@Column(name = "MATERIAL_TYPE_ID")
	private Integer materialTypeId;

	@Column(name = "MATERIAL_CLASS")
	private String materialClass;

	@Column(name = "DEFINITION_CODE")
	private String definitionCode;

	@Column(name = "ZONE")
	private String zone;

	@Column(name = "DIRECTOR")
	private String director;

	@Column(name = "LEADING_ROLE")
	private String leadingRole;

	@Column(name = "YEARS")
	private String years;
	
	@Column(name = "LANGUAGE_ID")
	private Integer languageId;
	
	@Transient
	private String languageName;

	@Column(name = "SET_NUMBER")
	private Integer setNumber;

	@Column(name = "BITRATE_ID")
	private Integer bitrateId;

	@Column(name = "TRIAL_DURA")
	private Integer trialDura;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "PLAN_TIME")
	private Date planTime;

	@Column(name = "PLAN_USER")
	private String planUser;

	@Column(name = "OFF_LINE_TIME")
	private Date offLineTime;

	@Column(name = "PROGRAM_STATUS_ID")
	private String programStatusId;

	@Column(name = "RESOLUTION_ID")
	private Integer resolutionId;

	@Column(name = "PROGRAM_LENGTH")
	private Integer programLength;

	@Column(name = "PREMIERE_CHANNEL")
	private String premiereChannel;
	
	@Column(name = "PREMIERE_DATE")
	private String premiereDate;

	@Column(name = "SOUND_CHANNEL")
	private String soundChannel;

	@Column(name = "STATUS_DATE")
	private Date statusDate;

	@Column(name = "LAST_MODIFY_DATE")
	private Date lastModifyDate;

	@Column(name = "UPDATE_USER")
	private String updateUser;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "POSTER")
	private String poster;

	@Column(name = "SORT_NUM")
	private Integer sortNum;

	@Column(name = "ENCRYPTED_TYPE")
	private String encryptedType;

	@Column(name = "ADDR_TYPE")
	private String addrType;

	@Column(name = "PRIORITY")
	private Integer priority;

	@Column(name = "ORG_URL")
	private String orgUrl;

	@Column(name = "IS3D")
	private Integer is3d;

	@Column(name = "OUT_SOURCE_ID")
	private String outSourceId;

	@Column(name = "PPV_CODE")
	private String ppvCode;

	@Column(name = "CP_CODE")
	private String cpCode;

	@Column(name = "DATA_PROVIDER")
	private String dataProvider;

	@Column(name = "START_TIME")
	private Integer startTime;

	@Column(name = "END_TIME")
	private Integer endTime;

	@Column(name = "SPECIAL_REQUEST")
	private String specialRequest;

	@Column(name = "OFF_REASON")
	private String offReason;

	@Column(name = "RE_ON_REASON")
	private String reOnReason;

	@Column(name = "DEL_REASON")
	private String delReason;

	@Column(name = "IS_RE_CONVERT")
	private Integer isReConvert;

	@Column(name = "IS_RE_DRM")
	private Integer isReDrm;

	@Column(name = "IS_RE_CND")
	private Integer isReCnd;

	@Column(name = "BACK_REASON")
	private String backReason;

	@Column(name = "PUBLISH_PLATFORM_IDS")
	private String publishPlatformIds;

	@Column(name = "TAG")
	private String tag;

	@Column(name = "FINISH_PLATFORM_IDS")
	private String finishPlatformIds;

	@Column(name = "IS_CP_DELETE")
	private Integer isCpDelete;

	@Column(name = "THIRD_MODIFY_TIME")
	private Date thirdModifyTime;

	@Column(name = "CP_IS_DRM")
	private Integer cpIsDrm;

	@Column(name = "CP_DRM_TYPE")
	private String cpDrmType;

	@Column(name = "PROGRAM_DESC")
	private String programDesc;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Transient
	private String materialType;
	@Transient
	private String language;
	@Transient
	private String definition;

	public void convert(){
		setMaterialType();
		setLanguage();
		setDefinition();
	}
	public String getMaterialType() {
		return materialType;
	}

	private void setMaterialType() {
		this.materialType = MaterialType.getMaterialType().get(this.materialTypeId);
	}

	public String getLanguage() {
		return language;
	}

	private void setLanguage() {
		this.language = LanguageType.getLanguage().get(this.languageId);
	}

	public String getDefinition() {
		return definition;
	}

	private void setDefinition() {
		this.definition = Definiton.getDefiniton().get(this.definitionCode);
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
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

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Integer getMaterialTypeId() {
		return materialTypeId;
	}

	public void setMaterialTypeId(Integer materialTypeId) {
		this.materialTypeId = materialTypeId;
	}

	public String getMaterialClass() {
		return materialClass;
	}

	public void setMaterialClass(String materialClass) {
		this.materialClass = materialClass;
	}

	public String getDefinitionCode() {
		return definitionCode;
	}

	public void setDefinitionCode(String definitionCode) {
		this.definitionCode = definitionCode;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLeadingRole() {
		return leadingRole;
	}

	public void setLeadingRole(String leadingRole) {
		this.leadingRole = leadingRole;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Integer getSetNumber() {
		return setNumber;
	}

	public void setSetNumber(Integer setNumber) {
		this.setNumber = setNumber;
	}

	public Integer getBitrateId() {
		return bitrateId;
	}

	public void setBitrateId(Integer bitrateId) {
		this.bitrateId = bitrateId;
	}

	public Integer getTrialDura() {
		return trialDura;
	}

	public void setTrialDura(Integer trialDura) {
		this.trialDura = trialDura;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getPlanTime() {
		return planTime;
	}

	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}

	public String getPlanUser() {
		return planUser;
	}

	public void setPlanUser(String planUser) {
		this.planUser = planUser;
	}

	public Date getOffLineTime() {
		return offLineTime;
	}

	public void setOffLineTime(Date offLineTime) {
		this.offLineTime = offLineTime;
	}

	public String getProgramStatusId() {
		return programStatusId;
	}

	public void setProgramStatusId(String programStatusId) {
		this.programStatusId = programStatusId;
	}

	public Integer getResolutionId() {
		return resolutionId;
	}

	public void setResolutionId(Integer resolutionId) {
		this.resolutionId = resolutionId;
	}

	public Integer getProgramLength() {
		return programLength;
	}

	public void setProgramLength(Integer programLength) {
		this.programLength = programLength;
	}

	public String getPremiereChannel() {
		return premiereChannel;
	}

	public void setPremiereChannel(String premiereChannel) {
		this.premiereChannel = premiereChannel;
	}

	public String getPremiereDate() {
		return premiereDate;
	}

	public void setPremiereDate(String premiereDate) {
		this.premiereDate = premiereDate;
	}

	public String getSoundChannel() {
		return soundChannel;
	}

	public void setSoundChannel(String soundChannel) {
		this.soundChannel = soundChannel;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public Date getLastModifyDate() {
		return lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public String getEncryptedType() {
		return encryptedType;
	}

	public void setEncryptedType(String encryptedType) {
		this.encryptedType = encryptedType;
	}

	public String getAddrType() {
		return addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getOrgUrl() {
		return orgUrl;
	}

	public void setOrgUrl(String orgUrl) {
		this.orgUrl = orgUrl;
	}

	public Integer getIs3d() {
		return is3d;
	}

	public void setIs3d(Integer is3d) {
		this.is3d = is3d;
	}

	public String getOutSourceId() {
		return outSourceId;
	}

	public void setOutSourceId(String outSourceId) {
		this.outSourceId = outSourceId;
	}

	public String getPpvCode() {
		return ppvCode;
	}

	public void setPpvCode(String ppvCode) {
		this.ppvCode = ppvCode;
	}

	public String getCpCode() {
		return cpCode;
	}

	public void setCpCode(String cpCode) {
		this.cpCode = cpCode;
	}

	public String getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(String dataProvider) {
		this.dataProvider = dataProvider;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public String getSpecialRequest() {
		return specialRequest;
	}

	public void setSpecialRequest(String specialRequest) {
		this.specialRequest = specialRequest;
	}

	public String getOffReason() {
		return offReason;
	}

	public void setOffReason(String offReason) {
		this.offReason = offReason;
	}

	public String getReOnReason() {
		return reOnReason;
	}

	public void setReOnReason(String reOnReason) {
		this.reOnReason = reOnReason;
	}

	public String getDelReason() {
		return delReason;
	}

	public void setDelReason(String delReason) {
		this.delReason = delReason;
	}

	public Integer getIsReConvert() {
		return isReConvert;
	}

	public void setIsReConvert(Integer isReConvert) {
		this.isReConvert = isReConvert;
	}

	public Integer getIsReDrm() {
		return isReDrm;
	}

	public void setIsReDrm(Integer isReDrm) {
		this.isReDrm = isReDrm;
	}

	public Integer getIsReCnd() {
		return isReCnd;
	}

	public void setIsReCnd(Integer isReCnd) {
		this.isReCnd = isReCnd;
	}

	public String getBackReason() {
		return backReason;
	}

	public void setBackReason(String backReason) {
		this.backReason = backReason;
	}

	public String getPublishPlatformIds() {
		return publishPlatformIds;
	}

	public void setPublishPlatformIds(String publishPlatformIds) {
		this.publishPlatformIds = publishPlatformIds;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getFinishPlatformIds() {
		return finishPlatformIds;
	}

	public void setFinishPlatformIds(String finishPlatformIds) {
		this.finishPlatformIds = finishPlatformIds;
	}

	public Integer getIsCpDelete() {
		return isCpDelete;
	}

	public void setIsCpDelete(Integer isCpDelete) {
		this.isCpDelete = isCpDelete;
	}

	public Date getThirdModifyTime() {
		return thirdModifyTime;
	}

	public void setThirdModifyTime(Date thirdModifyTime) {
		this.thirdModifyTime = thirdModifyTime;
	}

	public Integer getCpIsDrm() {
		return cpIsDrm;
	}

	public void setCpIsDrm(Integer cpIsDrm) {
		this.cpIsDrm = cpIsDrm;
	}

	public String getCpDrmType() {
		return cpDrmType;
	}

	public void setCpDrmType(String cpDrmType) {
		this.cpDrmType = cpDrmType;
	}

	public String getProgramDesc() {
		return programDesc;
	}

	public void setProgramDesc(String programDesc) {
		this.programDesc = programDesc;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}