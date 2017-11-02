/**
 * 
 */
package com.cars.iivmshome.sysmanage.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.cars.iivmshome.base.service.BaseService;
import com.cars.iivmshome.base.vo.BaseCountsVo;
import com.cars.iivmshome.sysmanage.model.AlarmInfoModel;
import com.cars.iivmshome.sysmanage.service.AlarmInfoService;

/**
 * @author Administrator
 *
 */
@Service
public class AlarmInfoServiceImpl implements AlarmInfoService{
	private static final String DAO = "com.cars.iivmshome.sysmanage.dao.AlarmInfoMapper";
	@Resource
	BaseService baseDataSourceService;
	
	@Override
	public List<AlarmInfoModel> getData(Map<String, Object> param) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		List<AlarmInfoModel> res = sqlSessionTemplate.selectList(DAO+".selectAll",param);
		return res;
	}

	@Override
	public BaseCountsVo getTotals(Map<String, Object> param) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		BaseCountsVo res = sqlSessionTemplate.selectOne(DAO+".selectTotals",param);
		return res;
	}

}
