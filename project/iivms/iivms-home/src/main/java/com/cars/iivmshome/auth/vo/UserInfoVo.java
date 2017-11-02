/**
 * <b>项目名：</b>datawork-common<br/>  
 * <b>包名：</b>com.funshion.dw.common.security.vo<br/>  
 * <b>文件名：</b>UserInfoVo.java<br/>  
 * <b>author：</b>jiangcyUserInfoVo.java<br/>  
 * <b>日期：</b>2015年4月10日-下午8:25:44<br/>  
 * <b>Copyright (c)</b> 2015风行在线-版权所有<br/>   
 */
package com.cars.iivmshome.auth.vo;

import java.util.List;
import java.util.Map;

import com.cars.iivmshome.auth.model.AuthUserModel;
import com.cars.iivmshome.auth.vo.base.UserBaseInfoVo;

/**
 * @ClassName: UserInfoVo
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jiangcy
 * @date: 2015年4月10日 下午8:25:44
 */
public class UserInfoVo extends UserBaseInfoVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8167855282391328815L;

	private String domain;

	private DepartmentInfoVo depModel;

	private List<RoleInfoVo> roles;

	private  List<AppMenu> mainMenus;
	
	private Map<String, List<AppMenu>> secMenus; 
	
	
	public UserInfoVo(AuthUserModel user){
		super();
		this.setPassword(user.getPassword());
		this.setRealName(user.getRealName());
		this.setDepartmentId(user.getGroupId());
		this.setEmail(user.getAccount());
		this.setUserId(user.getId());
		this.setUserName(user.getAccount());
	}
	
    @Override  
    public String toString() {  
        return this.getRealName();  
    }  
    
    
	public List<RoleInfoVo> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleInfoVo> roles) {
		this.roles = roles;
	}

	public DepartmentInfoVo getDepModel() {
		return depModel;
	}

	public void setDepModel(DepartmentInfoVo depModel) {
		this.depModel = depModel;
	}

	public UserInfoVo() {
		super();
	}

	public Map<String, List<AppMenu>> getSecMenus() {
		return secMenus;
	}


	public void setSecMenus(Map<String, List<AppMenu>> secMenus) {
		this.secMenus = secMenus;
	}


	public List<AppMenu> getMainMenus() {
		return mainMenus;
	}


	public void setMainMenus(List<AppMenu> mainMenus) {
		this.mainMenus = mainMenus;
	}


	public String getDomain() {
		return domain;
	}


	public void setDomain(String domain) {
		this.domain = domain;
	}

}
