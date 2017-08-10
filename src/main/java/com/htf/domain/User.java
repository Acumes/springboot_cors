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
	
	private String salt;
	
	@Column(name="last_login_time")
	private Date lastLoginTime;

	
	@Column(name = "mobile",length = 15, nullable = false)
	private String mobile;
	@Column(name = "email",length = 30, nullable = false)
	private String email;
	@Column(name = "offer_phone",length = 30, nullable = true)
	private String offerPhone;
	@Column(name = "code",length = 18, nullable = false)
	private String code;
	@Column(name = "nick_name",length = 30, nullable = true)
	private String nickName;
	@Column(name = "password",length = 50, nullable = true)
	private String password;
	@Column(name = "status",length = 2, nullable = false)
	private String status = "0";
	@Column(name = "english_name",length = 20, nullable = true)
	private String englishName;
	@Column(name = "photo",length = 50, nullable = true)
	private String photo;
	@Column(name = "gender",length = 2, nullable = false)
	private String gender;
	private String remark;

	

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfferPhone() {
		return offerPhone;
	}

	public void setOfferPhone(String offerPhone) {
		this.offerPhone = offerPhone;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
