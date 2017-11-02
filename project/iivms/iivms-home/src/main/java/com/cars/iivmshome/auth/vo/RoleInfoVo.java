/**
 * <b>项目名：</b>datawork-common<br/>  
 * <b>包名：</b>com.funshion.dw.common.security.vo<br/>  
 * <b>文件名：</b>RoleInfoVo.java<br/>  
 * <b>author：</b>jiangcyRoleInfoVo.java<br/>  
 * <b>日期：</b>2015年5月15日-下午7:02:21<br/>  
 * <b>Copyright (c)</b> 2015风行在线-版权所有<br/>   
 */
package com.cars.iivmshome.auth.vo;

import java.io.Serializable;

/**
 * @ClassName: RoleInfoVo
 * @Description:
 * @author: jiangcy
 * @date: 2015年5月15日 下午7:02:21
 */
public class RoleInfoVo implements Serializable {

	private static final long serialVersionUID = 2310821128793352479L;
	
	private Integer roleId;

	private String roleName;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
