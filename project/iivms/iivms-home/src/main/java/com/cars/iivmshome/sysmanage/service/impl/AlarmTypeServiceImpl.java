/**
 * 
 */
package com.cars.iivmshome.sysmanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.cars.iivmshome.base.service.BaseService;
import com.cars.iivmshome.sysmanage.model.AlarmTypeModel;
import com.cars.iivmshome.sysmanage.service.AlarmTypeService;

/**
 * @author Administrator
 *
 */
@Service
public class AlarmTypeServiceImpl implements AlarmTypeService{
	
	private static final String DAO = "com.cars.iivmshome.sysmanage.dao.AlarmTypeMapper";
	@Resource
	BaseService baseDataSourceService;
	
	@Override
	public List<AlarmTypeModel> findAll() {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		List<AlarmTypeModel> res = sqlSessionTemplate.selectList(DAO+".selectAll");
		return res;
	}
	
	
}
