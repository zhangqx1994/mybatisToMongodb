package com.tools.mysql2mongodb.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <节目集与节目关系实体对象><br />
 * <功能详细描述>
 * 
 * @author wangdx
 * @version [版本号1.0, 2014年9月22日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity
@Table(name = "cms_program_series_rel")
public class ProgramSeriesRel implements Serializable
{

	/** 
	 * 
	 */
	private static final long serialVersionUID = -8297389619184346349L;

	@Id
	@Column(name = "REL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long relId;

	@Column(name = "PROGRAM_SERIES_ID")
	private Long programSeriesId;

	@Column(name = "PROGRAM_ID")
	private Long programId;

	@Column(name = "REL_TIME")
	private Date relTime;

	@Column(name = "REL_USER")
	private String relUser;

	@Column(name = "UPDATE_TIME")
	private Date updateTime;

	@Column(name = "UPDATE_USER")
	private String updateUser;

	@Column(name = "TAXIS")
	private Integer taxis;

	@Column(name = "STATUS")
	private Integer status;

	@Column(name = "LAST_MODIFY_DATE")
	private Date lastModifyDate;

	public Long getRelId()
	{
		return relId;
	}

	public void setRelId(Long relId)
	{
		this.relId = relId;
	}

	public Long getProgramSeriesId()
	{
		return programSeriesId;
	}

	public void setProgramSeriesId(Long programSeriesId)
	{
		this.programSeriesId = programSeriesId;
	}

	public Long getProgramId()
	{
		return programId;
	}

	public void setProgramId(Long programId)
	{
		this.programId = programId;
	}

	public Date getRelTime()
	{
		return relTime;
	}

	public void setRelTime(Date relTime)
	{
		this.relTime = relTime;
	}

	public String getRelUser()
	{
		return relUser;
	}

	public void setRelUser(String relUser)
	{
		this.relUser = relUser;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public String getUpdateUser()
	{
		return updateUser;
	}

	public void setUpdateUser(String updateUser)
	{
		this.updateUser = updateUser;
	}

	public Integer getTaxis()
	{
		return taxis;
	}

	public void setTaxis(Integer taxis)
	{
		this.taxis = taxis;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Date getLastModifyDate()
	{
		return lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate)
	{
		this.lastModifyDate = lastModifyDate;
	}

}