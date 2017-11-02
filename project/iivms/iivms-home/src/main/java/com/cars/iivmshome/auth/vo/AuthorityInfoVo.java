/**
 * <b>项目名：</b>datawork-common<br/>  
 * <b>包名：</b>com.funshion.dw.common.security.vo<br/>  
 * <b>文件名：</b>AuthorityInfoVo.java<br/>  
 * <b>author：</b>jiangcyAuthorityInfoVo.java<br/>  
 * <b>日期：</b>2015年5月15日-下午7:07:07<br/>  
 * <b>Copyright (c)</b> 2015风行在线-版权所有<br/>   
 */
package com.cars.iivmshome.auth.vo;

/**
 * @ClassName: AuthorityInfoVo
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jiangcy
 * @date: 2015年5月15日 下午7:07:07
 */
public class AuthorityInfoVo  {

	private Integer authId;

	private String authName;

	private String operationCode;

	public Integer getAuthId() {
		return authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

}
