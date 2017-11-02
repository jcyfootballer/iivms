/**
 * <b>项目名：</b>datawork-auth-server<br/>  
 * <b>包名：</b>com.funshion.authserver.auth.service<br/>  
 * <b>文件名：</b>UserService.java<br/>  
 * <b>author：</b>jiangcyUserService.java<br/>  
 * <b>日期：</b>2015年5月15日-下午8:06:56<br/>  
 * <b>Copyright (c)</b> 2015风行在线-版权所有<br/>   
 */
package com.cars.iivmshome.auth.service;

import java.util.List;

import com.cars.iivmshome.auth.model.AuthUserModel;


public interface AuthUserService {
    
	public AuthUserModel  getAuthUserModel(String userName);

	/**
	 * 
	 * @Title: getAllUser   
	 * @author:jiangcy    
	 * @Description: 获取所有用户
	 * @return   
	 * @return: List<UserInfoVo>
	 * @throws
	 */
	public List<AuthUserModel> getAllAuthUser();
	
}
