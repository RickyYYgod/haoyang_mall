package com.hsbiopharm.mall.pojo;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

/**
 * @Description 
 * @Author Ricky
 * @Date 2022-12-14 
 */

@Entity
@ApiModel(description= "系统用户表")
@Table(name = "t_admin_user")
public class AdminUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 管理员用户id
	 */
	@Id
	@Column(name = "admin_user_id", nullable = false)
	@ApiModelProperty(value = "管理员用户id", required = false, dataType = "int",example = "1")
	private Long adminUserId;

	/**
	 * 昵称
	 */
	@Basic
   	@Column(name = "display_name")
	@ApiModelProperty(value = "昵称", required = false, dataType = "varchar(255)")
	private String displayName;

	/**
	 * 电话
	 */
	@Basic
	@Column(name = "phone")
	@ApiModelProperty(value = "电话", required = false, dataType = "varchar(255)")
	private String phone;

	/**
	 * 密码
	 */
	@Basic
	@Column(name = "password")
	@ApiModelProperty(value = "密码", required = false, dataType = "varchar(255)")
	private String password;

	/**
	 * 状态：
		01-正常；
		99-加锁；
	 */
	@Basic
	@Column(name = "status")
	@ApiModelProperty(value = "状态：01-正常；99-加锁；", required = false, dataType = "int")
	private Long status;

	public Long getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(Long adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
}
