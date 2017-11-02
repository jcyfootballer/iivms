/**
 * <b>项目名：</b>datawork-common<br/>  
 * <b>包名：</b>com.funshion.dw.common.security.vo<br/>  
 * <b>文件名：</b>AuthorityInfoVo.java<br/>  
 * <b>author：</b>jiangcyAuthorityInfoVo.java<br/>  
 * <b>日期：</b>2015年5月15日-下午7:07:07<br/>  
 * <b>Copyright (c)</b> 2015风行在线-版权所有<br/>   
 */
package com.cars.iivmshome.auth.vo;

import java.io.Serializable;

/**
 * @ClassName: AuthorityInfoVo
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jiangcy
 * @date: 2015年5月15日 下午7:07:07
 */
public class AuthInfoVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1605061855628890012L;

	private Integer roleId;

	private String moduleCode;

	private String operationCode;

	@Override
	public String toString() {
		return roleId + ":" + moduleCode + ":" + operationCode;
	}

	public String toString2() {
		return  moduleCode + ":" + operationCode;
	}
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

}
