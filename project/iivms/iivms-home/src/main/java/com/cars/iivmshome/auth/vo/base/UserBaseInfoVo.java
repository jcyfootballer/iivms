/**
 * <b>项目名：</b>datawork-common<br/>  
 * <b>包名：</b>com.funshion.dw.common.security.vo<br/>  
 * <b>文件名：</b>UserInfoVo.java<br/>  
 * <b>author：</b>jiangcyUserInfoVo.java<br/>  
 * <b>日期：</b>2015年4月10日-下午8:25:44<br/>  
 * <b>Copyright (c)</b> 2015风行在线-版权所有<br/>   
 */
package com.cars.iivmshome.auth.vo.base;

import java.io.Serializable;


/**
 * @ClassName: UserInfoVo
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jiangcy
 * @date: 2015年4月10日 下午8:25:44
 */
public class UserBaseInfoVo  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3735523686283199630L;

	private Integer userId;

	private String userName;

	private String password;

	private String realName;

	private String email;

	private Boolean isvalid;

	private Integer departmentId;
	
	public UserBaseInfoVo() {
		super();
	}

	@Override 
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBaseInfoVo other = (UserBaseInfoVo) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getUserName();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Boolean isvalid) {
		this.isvalid = isvalid;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

}
