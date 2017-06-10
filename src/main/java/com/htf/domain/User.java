package com.htf.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.htf.model.DataStatus;

@Entity
@Table(name="user")
public class User  extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String password;
	@Column(name="code",nullable = false)
	private String code;
	
	private String salt;
	
	@Column(name="last_login_time")
	private Date lastLoginTime;

	
	@Enumerated(EnumType.STRING)
	private DataStatus status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_info")
	private UserInfo userInfo;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public DataStatus getStatus() {
		return status;
	}

	public void setStatus(DataStatus status) {
		this.status = status;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
