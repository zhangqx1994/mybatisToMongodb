package com.tools.mysql2mongodb.entity;


import com.tools.mysql2mongodb.common.Definiton;
import com.tools.mysql2mongodb.common.LanguageType;
import com.tools.mysql2mongodb.common.MaterialType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cms_program_series")
public class ProgramSeries implements Serializable
{
    
    private static final long serialVersionUID = 8587689177279529711L;
    
    @Id
    @Column(name = "PROGRAM_SERIES_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // 节目集名称
    private String programSeriesName;
    
    // 节目集状态
    private String status;
    
    // 节目集拼音
    private String programPinyin;
    
    // 节目集别名
    private String programSeriesAlias;
    
    // 节目集英文名
    private String programSeriesEnName;
    
    // 主海报地址
    private String poster;
    
    // 小海报地址
    private String smallPosterAddr;
    
    // 大海报地址
    private String bigPosterAddr;
    
    // 节目集简介
    private String programSeriesDesc;
    
    // 分类
    @Column(name = "PROGRAM_TYPE_ID")
    private Integer programTypeId;
    
    // 分类名（添加，修改节目集页面）
    @Transient
    private String programTypeName;
    
    // 二级分类
    private String programClass;
    
    // 节目最新集数
    private Integer programCount;
    
    // 节目总数量
    private Integer programTotalCount;
    
    // 内容的类型
    private String programContentType;
    
    // 标签
    private String tag;
    
    // 清晰度
    private String definitionCode;
    
    // 导演
    private String director;
    
    // 编剧
    private String scriptWriter;
    
    // 主演
    private String leadingRole;
    
    // 主演拼音
    private String leadingRolePinyin;
    
    // 年份
    private String years;
    
    // 年份（添加，修改节目集页面）
    @Transient
    private String yearsName;
    
    // 语言
    private Integer languageId;
    
    // 语言名称（添加，修改节目集页面）
    @Transient
    private String languageName;
    
    // 赛事
    private String competition;
    
    // 受众
    private String targetAudience;
    
    // 首播时间
    private Date premiereDate;
    
    // 发行时间
    private Date publishDate;
    
    // 首播频道
    private String premiereChannel;
    
    // 首播频道名称（添加，修改节目集页面）
    @Transient
    private String premiereChannelName;
    
    // 同步直播频道
    private String syncLiveChannel;
    
    // 同步直播频道名称（添加，修改节目集页面）
    @Transient
    private String syncLiveChannelName;
    
    // 节目集下节目排序方式
    private String sortType;
    
    // 节目集下节目播放顺序
    private String playSort;
    
    // 状态修改时间
    private Date statusTime;
    
    // 最后更新时间
    private Date lastModifyDate;
    
    // 创建时间
    private Date createDate;
    
    // 是否3D 0--否|1--是
    private Integer is3D;
    
    // 时长(分钟)
    private Integer timeLength;
    
    // 是否会员片
    private Integer isCustomer;
    
    // 推荐星级
    private Integer starRating;
    
    // 蒙版描述
    private String maskDescription;
    
    // 数据提供商
    private String dataProvider;
    
    // 外部数据标识
    private String outSourceId;
    
    // 地区
    private String zone;
    
    // 内容提供商编码
    private String cpCode;
    
    // 版权开始日期
    private Date copyrightStartDate;
    
    // 版权结束日期
    private Date copyrightEndDate;
    
    // 版权信息
    private Integer copyrightId;
    
    // 版权分级
    private Integer crClassId;
    
    // 片单版权
    private Long filmCpId;
    
    // 节目价格标签
    @Column(name = "PPV_CODE")
    private String ppvCode;
    
    //@Formula(value = "(select t.PPV_NAME from boss_ppv_info t where t.PPV_CODE = PPV_CODE)")
    @Transient
    private String ppvName;

    //@Formula(value = "(select t.PPV_PRICE from boss_ppv_info t where t.PPV_CODE = PPV_CODE)")
    @Transient
    private String ppvPrice;

    //@Formula(value = "(select t.PROGRAME_PRICE_STATUS from cms_program_series_price t where t.PROGRAM_SERIES_ID = PROGRAM_SERIES_ID)")
    @Transient
    private Integer programePriceStatus;
    
    // 发布平台IDS
    private String publishPlatformIds;
    
    // 分发完成平台IDS
    private String finishPlatformIds;
    
    // 发布平台IDS(节目集高级检索时使用)
    //@Formula(value = "(select CONCAT('$',REPLACE(t.PUBLISH_PLATFORM_IDS,';','$$'),'$') from cms_program_series t where t.PROGRAM_SERIES_ID=PROGRAM_SERIES_ID)")
    @Transient
    private String publishPlatformIdsForQuery;
    
    @Transient
    private String publishPlatformNames;
    
    // 删除原因
    private String delReason;
    
    // @Transient
    // private List<Program> programs = new ArrayList<Program>();
    
    // 手工评分
    @Transient
    private BigDecimal manualScore;
    
    // 手工播放次数
    @Transient
    private Long manualPlayTimes;
    
/*    @OneToOne(fetch = FetchType.LAZY, mappedBy = "programSeries")
    @NotFound(action = NotFoundAction.IGNORE)
    private ProgramSeriesExt programSeriesExt;*/
    
 /*   @OneToOne(fetch = FetchType.LAZY, mappedBy = "programSeries")
    @NotFound(action = NotFoundAction.IGNORE)
    private ProgramSeriesDynamic programSeriesDynamic;*/
    
/*    @OneToOne(fetch = FetchType.LAZY, mappedBy = "programSeries")
    @NotFound(action = NotFoundAction.IGNORE)
    private ProgramSeriesPrice programSeriesPrice;*/
    
    // 是否CDN
    private Integer isCdn;
    
    // 审核意见
    @Transient
    private String auditDesc;
    
    // 重新上线原因
    private String reOnReason;
    
    // 首次上线时间
    @Column(name = "FIRST_ONLINE_TIME")
    private Date firstOnlineTime;
    
    // 回退原因
    @Column(name = "BACK_REASON")
    private String backReason;
    
    // 下线原因
    @Column(name = "OFF_REASON")
    private String offReason;
    
    // 副标题
    @Column(name = "SUB_CAPTION")
    private String subCaption;
    
    // 期数
    @Column(name = "PROGRAM_NO")
    private String programNo;
    
    // 出品方
    @Column(name = "PRODUCER")
    private String producer;
    
    // 出品方名称（添加，修改节目集页面）
    @Transient
    private String producerName;
    
    // 人物
    @Column(name = "`CHARACTER`")
    private String character;
    
    // 课时
    @Column(name = "HOURS")
    private String hours;
    
    // 发布方
    @Column(name = "PUBLISHER")
    private String publisher;
    
    // 科目
    @Column(name = "SUBJECT")
    private String subject;
    
    // 风格
    @Column(name = "STYLE")
    private String style;
    
    // 内容
    @Column(name = "CONTENT")
    private String content;
    
    // 主持人
    @Column(name = "PRESENTER")
    private String presenter;
    
    // 嘉宾
    @Column(name = "GUESTS")
    private String guests;
    
    // 内容时间
    @Column(name = "CONTENT_DATE")
    private Date contentDate;
    
    // 默认播放清晰度
    @Column(name = "DEFAULT_DEFIINITION")
    private String defaultDefinition;
    
    // 是否被第三方删除
    @Column(name = "IS_CP_DELETE")
    private Integer isCpDelete;
    
    // 第三方操作时间
    @Column(name = "THIRD_MODIFY_TIME")
    private Date thirdModifyTime;
    
    @Transient
    private Long catgSeriesRelId;
    
    @Transient
    private Long taxis;
    
    // 上传海报
    @Column(name = "UPLOAD_POSTER")
    private String uploadPoster;
    
    // 内容提供商
    @Column(name = "CP_ID")
    private Long cpId;
    
    // 是否设置 0--否|1--是
    @Column(name = "IS_SET_OFFLINE")
    private Integer isSetOffline;
    
    // 生效时间
    @Column(name = "OFFLINE_EFFECT_TIME")
    private Date offlineEffectTime;
    
    // 权重值
    @Column(name = "WEIGHT")
    private Integer weight;
    
    // EPG分组IDS，分号分隔
    @Column(name = "EPG_GROUP_IDS")
    private String epgGroupIds;
    
    @Transient
    private String epgGroupNames;
    
    // 栏目名称
    @Column(name = "CATG_NAME")
    private String catgName;
    
    // 奖项
    @Column(name = "AWARDS")
    private String awards;
    
    @Transient
    private String catgItemNames;
    
    //@Formula(value = "(select group_concat(t.CATG_ITEM_ID) from cms_catg_series t where t.PROGRAM_SERIES_ID = PROGRAM_SERIES_ID and t.STATUS=1)")
    @Transient
    private String catgItemIds;
    
    @Transient
    private String relProgramNames;
    
    @Transient
    private String relProgramIds;
    
    @Transient
    private String oldRelProgramIds;
    
    @Transient
    private List<Long> programList;

    public List<Long> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Long> programList) {
        this.programList = programList;
    }

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
        this.materialType = MaterialType.getMaterialType().get(this.programTypeId);
    }

    public String getLanguage() {
        return language;
    }

    private void setLanguage() {
        language = LanguageType.getLanguage().get(this.languageId);
    }

    public String getDefinition() {
        return definition;
    }

    private void setDefinition() {
        this.definition = Definiton.getDefiniton().get(this.definitionCode);
    }
    
    public ProgramSeries()
    {
        super();
    }
    
    public ProgramSeries(Long id, String programSeriesName, String status)
    {
        super();
        this.id = id;
        this.programSeriesName = programSeriesName;
        this.status = status;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getProgramSeriesName()
    {
        return programSeriesName;
    }
    
    public void setProgramSeriesName(String programSeriesName)
    {
        this.programSeriesName = programSeriesName;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getProgramPinyin()
    {
        return programPinyin;
    }
    
    public void setProgramPinyin(String programPinyin)
    {
        this.programPinyin = programPinyin;
    }
    
    public String getProgramSeriesAlias()
    {
        return programSeriesAlias;
    }
    
    public void setProgramSeriesAlias(String programSeriesAlias)
    {
        this.programSeriesAlias = programSeriesAlias;
    }
    
    public String getProgramSeriesEnName()
    {
        return programSeriesEnName;
    }
    
    public void setProgramSeriesEnName(String programSeriesEnName)
    {
        this.programSeriesEnName = programSeriesEnName;
    }
    
    public String getPoster()
    {
        return poster;
    }
    
    public void setPoster(String poster)
    {
        this.poster = poster;
    }
    
    public String getSmallPosterAddr()
    {
        return smallPosterAddr;
    }
    
    public void setSmallPosterAddr(String smallPosterAddr)
    {
        this.smallPosterAddr = smallPosterAddr;
    }
    
    public String getBigPosterAddr()
    {
        return bigPosterAddr;
    }
    
    public void setBigPosterAddr(String bigPosterAddr)
    {
        this.bigPosterAddr = bigPosterAddr;
    }
    
    public String getProgramSeriesDesc()
    {
        return programSeriesDesc;
    }
    
    public void setProgramSeriesDesc(String programSeriesDesc)
    {
        this.programSeriesDesc = programSeriesDesc;
    }
    
    public Integer getProgramTypeId()
    {
        return programTypeId;
    }
    
    public void setProgramTypeId(Integer programTypeId)
    {
        this.programTypeId = programTypeId;
    }
    
    public String getProgramClass()
    {
        return programClass;
    }
    
    public void setProgramClass(String programClass)
    {
        this.programClass = programClass;
    }
    
    public Integer getProgramCount()
    {
        return programCount;
    }
    
    public void setProgramCount(Integer programCount)
    {
        this.programCount = programCount;
    }
    
    public Integer getProgramTotalCount()
    {
        return programTotalCount;
    }
    
    public void setProgramTotalCount(Integer programTotalCount)
    {
        this.programTotalCount = programTotalCount;
    }
    
    public String getProgramContentType()
    {
        return programContentType;
    }
    
    public void setProgramContentType(String programContentType)
    {
        this.programContentType = programContentType;
    }
    
    public String getTag()
    {
        return tag;
    }
    
    public void setTag(String tag)
    {
        this.tag = tag;
    }
    
    public String getDefinitionCode()
    {
        return definitionCode;
    }
    
    public void setDefinitionCode(String definitionCode)
    {
        this.definitionCode = definitionCode;
    }
    
    public String getDirector()
    {
        return director;
    }
    
    public void setDirector(String director)
    {
        this.director = director;
    }
    
    public String getScriptWriter()
    {
        return scriptWriter;
    }
    
    public void setScriptWriter(String scriptWriter)
    {
        this.scriptWriter = scriptWriter;
    }
    
    public String getLeadingRole()
    {
        return leadingRole;
    }
    
    public void setLeadingRole(String leadingRole)
    {
        this.leadingRole = leadingRole;
    }
    
    public String getLeadingRolePinyin()
    {
        return leadingRolePinyin;
    }
    
    public void setLeadingRolePinyin(String leadingRolePinyin)
    {
        this.leadingRolePinyin = leadingRolePinyin;
    }
    
    public String getYears()
    {
        return years;
    }
    
    public void setYears(String years)
    {
        this.years = years;
    }
    
    public Integer getLanguageId()
    {
        return languageId;
    }
    
    public void setLanguageId(Integer languageId)
    {
        this.languageId = languageId;
    }
    
    public String getCompetition()
    {
        return competition;
    }
    
    public void setCompetition(String competition)
    {
        this.competition = competition;
    }
    
    public String getTargetAudience()
    {
        return targetAudience;
    }
    
    public void setTargetAudience(String targetAudience)
    {
        this.targetAudience = targetAudience;
    }
    
    public Date getPremiereDate()
    {
        return premiereDate;
    }
    
    public void setPremiereDate(Date premiereDate)
    {
        this.premiereDate = premiereDate;
    }
    
    public Date getPublishDate()
    {
        return publishDate;
    }
    
    public void setPublishDate(Date publishDate)
    {
        this.publishDate = publishDate;
    }
    
    public String getPremiereChannel()
    {
        return premiereChannel;
    }
    
    public void setPremiereChannel(String premiereChannel)
    {
        this.premiereChannel = premiereChannel;
    }
    
    public String getSyncLiveChannel()
    {
        return syncLiveChannel;
    }
    
    public void setSyncLiveChannel(String syncLiveChannel)
    {
        this.syncLiveChannel = syncLiveChannel;
    }
    
    public String getSortType()
    {
        return sortType;
    }
    
    public void setSortType(String sortType)
    {
        this.sortType = sortType;
    }
    
    public String getPlaySort()
    {
        return playSort;
    }
    
    public void setPlaySort(String playSort)
    {
        this.playSort = playSort;
    }
    
    public Date getStatusTime()
    {
        return statusTime;
    }
    
    public void setStatusTime(Date statusTime)
    {
        this.statusTime = statusTime;
    }
    
    public Date getLastModifyDate()
    {
        return lastModifyDate;
    }
    
    public void setLastModifyDate(Date lastModifyDate)
    {
        this.lastModifyDate = lastModifyDate;
    }
    
    public Date getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
    
    public Integer getIs3D()
    {
        return is3D;
    }
    
    public void setIs3D(Integer is3d)
    {
        is3D = is3d;
    }
    
    public Integer getTimeLength()
    {
        return timeLength;
    }
    
    public void setTimeLength(Integer timeLength)
    {
        this.timeLength = timeLength;
    }
    
    public Integer getIsCustomer()
    {
        return isCustomer;
    }
    
    public void setIsCustomer(Integer isCustomer)
    {
        this.isCustomer = isCustomer;
    }
    
    public Integer getStarRating()
    {
        return starRating;
    }
    
    public void setStarRating(Integer starRating)
    {
        this.starRating = starRating;
    }
    
    public String getMaskDescription()
    {
        return maskDescription;
    }
    
    public void setMaskDescription(String maskDescription)
    {
        this.maskDescription = maskDescription;
    }
    
    public String getDataProvider()
    {
        return dataProvider;
    }
    
    public void setDataProvider(String dataProvider)
    {
        this.dataProvider = dataProvider;
    }
    
    public String getOutSourceId()
    {
        return outSourceId;
    }
    
    public void setOutSourceId(String outSourceId)
    {
        this.outSourceId = outSourceId;
    }
    
    public String getZone()
    {
        return zone;
    }
    
    public void setZone(String zone)
    {
        this.zone = zone;
    }
    
    public String getCpCode()
    {
        return cpCode;
    }
    
    public void setCpCode(String cpCode)
    {
        this.cpCode = cpCode;
    }
    
    public Date getCopyrightStartDate()
    {
        return copyrightStartDate;
    }
    
    public void setCopyrightStartDate(Date copyrightStartDate)
    {
        this.copyrightStartDate = copyrightStartDate;
    }
    
    public Date getCopyrightEndDate()
    {
        return copyrightEndDate;
    }
    
    public void setCopyrightEndDate(Date copyrightEndDate)
    {
        this.copyrightEndDate = copyrightEndDate;
    }
    
    public Integer getCopyrightId()
    {
        return copyrightId;
    }
    
    public void setCopyrightId(Integer copyrightId)
    {
        this.copyrightId = copyrightId;
    }
    
    public String getPpvCode()
    {
        return ppvCode;
    }
    
    public void setPpvCode(String ppvCode)
    {
        this.ppvCode = ppvCode;
    }
    
    public String getPublishPlatformIds()
    {
        return publishPlatformIds;
    }
    
    public void setPublishPlatformIds(String publishPlatformIds)
    {
        this.publishPlatformIds = publishPlatformIds;
    }
    
    public String getFinishPlatformIds()
    {
        return finishPlatformIds;
    }
    
    public void setFinishPlatformIds(String finishPlatformIds)
    {
        this.finishPlatformIds = finishPlatformIds;
    }
    
    public String getPublishPlatformNames()
    {
        return publishPlatformNames;
    }
    
    public void setPublishPlatformNames(String publishPlatformNames)
    {
        this.publishPlatformNames = publishPlatformNames;
    }
    
    public Integer getCrClassId()
    {
        return crClassId;
    }
    
    public void setCrClassId(Integer crClassId)
    {
        this.crClassId = crClassId;
    }
    
    public Long getFilmCpId()
    {
        return filmCpId;
    }
    
    public void setFilmCpId(Long filmCpId)
    {
        this.filmCpId = filmCpId;
    }
    
    public String getDelReason()
    {
        return delReason;
    }
    
    public void setDelReason(String delReason)
    {
        this.delReason = delReason;
    }
    
    public BigDecimal getManualScore()
    {
        return manualScore;
    }
    
    public void setManualScore(BigDecimal manualScore)
    {
        this.manualScore = manualScore;
    }
    
    public Long getManualPlayTimes()
    {
        return manualPlayTimes;
    }
    
    public void setManualPlayTimes(Long manualPlayTimes)
    {
        this.manualPlayTimes = manualPlayTimes;
    }
    
    public Integer getIsCdn()
    {
        return isCdn;
    }
    
    public void setIsCdn(Integer isCdn)
    {
        this.isCdn = isCdn;
    }
    
    public String getAuditDesc()
    {
        return auditDesc;
    }
    
    public void setAuditDesc(String auditDesc)
    {
        this.auditDesc = auditDesc;
    }
    
    public String getReOnReason()
    {
        return reOnReason;
    }
    
    public void setReOnReason(String reOnReason)
    {
        this.reOnReason = reOnReason;
    }
    
    public Date getFirstOnlineTime()
    {
        return firstOnlineTime;
    }
    
    public void setFirstOnlineTime(Date firstOnlineTime)
    {
        this.firstOnlineTime = firstOnlineTime;
    }
    
    public String getBackReason()
    {
        return backReason;
    }
    
    public void setBackReason(String backReason)
    {
        this.backReason = backReason;
    }
    
    public String getOffReason()
    {
        return offReason;
    }
    
    public void setOffReason(String offReason)
    {
        this.offReason = offReason;
    }
    
    public String getSubCaption()
    {
        return subCaption;
    }
    
    public void setSubCaption(String subCaption)
    {
        this.subCaption = subCaption;
    }
    
    public String getProgramNo()
    {
        return programNo;
    }
    
    public void setProgramNo(String programNo)
    {
        this.programNo = programNo;
    }
    
    public String getProducer()
    {
        return producer;
    }
    
    public void setProducer(String producer)
    {
        this.producer = producer;
    }
    
    public String getCharacter()
    {
        return character;
    }
    
    public void setCharacter(String character)
    {
        this.character = character;
    }
    
    public String getHours()
    {
        return hours;
    }
    
    public void setHours(String hours)
    {
        this.hours = hours;
    }
    
    public String getPublisher()
    {
        return publisher;
    }
    
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    public String getSubject()
    {
        return subject;
    }
    
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    public String getStyle()
    {
        return style;
    }
    
    public void setStyle(String style)
    {
        this.style = style;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public String getPresenter()
    {
        return presenter;
    }
    
    public void setPresenter(String presenter)
    {
        this.presenter = presenter;
    }
    
    public String getGuests()
    {
        return guests;
    }
    
    public void setGuests(String guests)
    {
        this.guests = guests;
    }
    
    public Date getContentDate()
    {
        return contentDate;
    }
    
    public void setContentDate(Date contentDate)
    {
        this.contentDate = contentDate;
    }
    
    public String getDefaultDefinition()
    {
        return defaultDefinition;
    }
    
    public void setDefaultDefinition(String defaultDefinition)
    {
        this.defaultDefinition = defaultDefinition;
    }
    
    public Integer getIsCpDelete()
    {
        return isCpDelete;
    }
    
    public void setIsCpDelete(Integer isCpDelete)
    {
        this.isCpDelete = isCpDelete;
    }
    
    public Date getThirdModifyTime()
    {
        return thirdModifyTime;
    }
    
    public void setThirdModifyTime(Date thirdModifyTime)
    {
        this.thirdModifyTime = thirdModifyTime;
    }
    
    public Long getCatgSeriesRelId()
    {
        return catgSeriesRelId;
    }
    
    public void setCatgSeriesRelId(Long catgSeriesRelId)
    {
        this.catgSeriesRelId = catgSeriesRelId;
    }
    
    public Long getTaxis()
    {
        return taxis;
    }
    
    public void setTaxis(Long taxis)
    {
        this.taxis = taxis;
    }
    
    public String getUploadPoster()
    {
        return uploadPoster;
    }
    
    public void setUploadPoster(String uploadPoster)
    {
        this.uploadPoster = uploadPoster;
    }
    
    public Long getCpId()
    {
        return cpId;
    }
    
    public void setCpId(Long cpId)
    {
        this.cpId = cpId;
    }
    
    public Integer getIsSetOffline()
    {
        return isSetOffline;
    }
    
    public void setIsSetOffline(Integer isSetOffline)
    {
        this.isSetOffline = isSetOffline;
    }
    
    public Date getOfflineEffectTime()
    {
        return offlineEffectTime;
    }
    
    public void setOfflineEffectTime(Date offlineEffectTime)
    {
        this.offlineEffectTime = offlineEffectTime;
    }
    
    public Integer getWeight()
    {
        return weight;
    }
    
    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }
    
    public String getEpgGroupIds()
    {
        return epgGroupIds;
    }
    
    public void setEpgGroupIds(String epgGroupIds)
    {
        this.epgGroupIds = epgGroupIds;
    }
    
    public String getEpgGroupNames()
    {
        return epgGroupNames;
    }
    
    public void setEpgGroupNames(String epgGroupNames)
    {
        this.epgGroupNames = epgGroupNames;
    }
    
    public String getCatgName()
    {
        return catgName;
    }
    
    public void setCatgName(String catgName)
    {
        this.catgName = catgName;
    }
    
    public String getAwards()
    {
        return awards;
    }
    
    public void setAwards(String awards)
    {
        this.awards = awards;
    }
    
    public void setPublishPlatformIdsForQuery(String publishPlatformIdsForQuery)
    {
        this.publishPlatformIdsForQuery = publishPlatformIdsForQuery;
    }
    
    public String getCatgItemNames()
    {
        return catgItemNames;
    }
    
    public void setCatgItemNames(String catgItemNames)
    {
        this.catgItemNames = catgItemNames;
    }
    
    public String getCatgItemIds()
    {
        return catgItemIds;
    }
    
    public void setCatgItemIds(String catgItemIds)
    {
        this.catgItemIds = catgItemIds;
    }
    
    public String getPpvName()
    {
        return ppvName;
    }
    
    public void setPpvName(String ppvName)
    {
        this.ppvName = ppvName;
    }
    
    public String getPpvPrice()
    {
        return ppvPrice;
    }
    
    public void setPpvPrice(String ppvPrice)
    {
        this.ppvPrice = ppvPrice;
    }

    public Integer getProgramePriceStatus() {
        return programePriceStatus;
    }

    public void setProgramePriceStatus(Integer programePriceStatus) {
        this.programePriceStatus = programePriceStatus;
    }

    public String getRelProgramNames()
    {
        return relProgramNames;
    }
    
    public void setRelProgramNames(String relProgramNames)
    {
        this.relProgramNames = relProgramNames;
    }
    
    public String getRelProgramIds()
    {
        return relProgramIds;
    }
    
    public void setRelProgramIds(String relProgramIds)
    {
        this.relProgramIds = relProgramIds;
    }
    
    public String getOldRelProgramIds()
    {
        return oldRelProgramIds;
    }
    
    public void setOldRelProgramIds(String oldRelProgramIds)
    {
        this.oldRelProgramIds = oldRelProgramIds;
    }
    
    public String getPublishPlatformIdsForQuery()
    {
        return publishPlatformIdsForQuery;
    }
    

    public String getProgramTypeName()
    {
        return programTypeName;
    }
    
    public void setProgramTypeName(String programTypeName)
    {
        this.programTypeName = programTypeName;
    }
    
    public String getLanguageName()
    {
        return languageName;
    }
    
    public void setLanguageName(String languageName)
    {
        this.languageName = languageName;
    }
    
    public String getYearsName()
    {
        return yearsName;
    }
    
    public void setYearsName(String yearsName)
    {
        this.yearsName = yearsName;
    }
    
    public String getPremiereChannelName()
    {
        return premiereChannelName;
    }
    
    public void setPremiereChannelName(String premiereChannelName)
    {
        this.premiereChannelName = premiereChannelName;
    }
    
    public String getSyncLiveChannelName()
    {
        return syncLiveChannelName;
    }
    
    public void setSyncLiveChannelName(String syncLiveChannelName)
    {
        this.syncLiveChannelName = syncLiveChannelName;
    }
    
    public String getProducerName()
    {
        return producerName;
    }
    
    public void setProducerName(String producerName)
    {
        this.producerName = producerName;
    }
    
}
