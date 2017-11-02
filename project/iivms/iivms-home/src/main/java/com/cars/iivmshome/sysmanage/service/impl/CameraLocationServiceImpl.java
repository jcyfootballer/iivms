/**
 * 
 */
package com.cars.iivmshome.sysmanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.cars.iivmshome.base.service.BaseService;
import com.cars.iivmshome.sysmanage.model.CameraLocationInfoModel;
import com.cars.iivmshome.sysmanage.service.CameraLocationService;

/**
 * @author Administrator
 *
 */
@Service
public class CameraLocationServiceImpl implements CameraLocationService{

	private static final String DAO = "com.cars.iivmshome.sysmanage.dao.CameraLocationInfoMapper";
	@Resource
	BaseService baseDataSourceService;
	
	@Override
	public CameraLocationInfoModel findByLocationId(Integer locationId) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		CameraLocationInfoModel res = sqlSessionTemplate.selectOne(DAO+".selectByPrimaryKey", locationId);
		return res;
	}

	@Override
	public List<CameraLocationInfoModel> findByLocationPid(Integer locationId) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		List<CameraLocationInfoModel> res = sqlSessionTemplate.selectList(DAO+".selectByPid", locationId);
		return res;
	}

	@Override
	public int addCameraLocationInfoModel(CameraLocationInfoModel model) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		int res = sqlSessionTemplate.insert(DAO+".insert", model);
		return res;
	}

	@Override
	public int renewCameraLocationInfoModel(CameraLocationInfoModel model) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		int res = sqlSessionTemplate.update(DAO+".updateByPrimaryKeySelective", model);
		return res;
	}

	@Override
	public int removeCameraLocationInfoModel(Integer locationId) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		int res = sqlSessionTemplate.delete(DAO+".deleteByPrimaryKey", locationId);
		return res;
	}

}
