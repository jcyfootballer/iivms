/**
 * <b>项目名：</b>datawork-auth-server<br/>  
 * <b>包名：</b>com.funshion.authserver.auth.service.impl<br/>  
 * <b>文件名：</b>UserServiceImpl.java<br/>  
 * <b>author：</b>jiangcyUserServiceImpl.java<br/>  
 * <b>日期：</b>2015年5月15日-下午8:11:29<br/>  
 * <b>Copyright (c)</b> 2015风行在线-版权所有<br/>   
 */
package com.cars.iivmshome.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.cars.iivmshome.auth.model.AuthUserModel;
import com.cars.iivmshome.auth.service.AuthUserService;
import com.cars.iivmshome.base.service.BaseService;

/**
 * @ClassName:  AuthUserServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangcy
 * @date:   2015年5月15日 下午8:11:29   
 */
@Service
public class AuthUserServiceImpl implements AuthUserService{
	private static final String DAO = "com.cars.iivmshome.auth.dao.AuthUserModelMapper";

	@Resource
	BaseService baseDataSourceService;

	@Override
	public AuthUserModel getAuthUserModel(String userName) {
		SqlSessionTemplate sqlSession = baseDataSourceService
				.getDefaultSessionTemplate();
		
		AuthUserModel  res = new AuthUserModel();
		res = sqlSession.selectOne(DAO + ".selectUserByUserName",userName);
		
		return res; 
	}

	@Override
	public List<AuthUserModel> getAllAuthUser(){
		SqlSessionTemplate sqlSession = baseDataSourceService
				.getDefaultSessionTemplate();
		List<AuthUserModel>  res = new ArrayList<AuthUserModel>();
		res = sqlSession.selectList(DAO + ".select");
		return res;
	}
}
