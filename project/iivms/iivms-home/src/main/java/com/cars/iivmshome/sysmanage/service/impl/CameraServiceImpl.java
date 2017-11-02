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
import com.cars.iivmshome.sysmanage.model.CameraInfoModel;
import com.cars.iivmshome.sysmanage.service.CameraService;

/**
 * @author Administrator
 *
 */
@Service
public class CameraServiceImpl implements CameraService{

	private static final String DAO = "com.cars.iivmshome.sysmanage.dao.CameraInfoMapper";
	@Resource
	BaseService baseDataSourceService;
	
	@Override
	public CameraInfoModel findById(Integer cameraId) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		CameraInfoModel res = sqlSessionTemplate.selectOne(DAO+".selectByPrimaryKey", cameraId);
		return res;
	}

	@Override
	public List<CameraInfoModel> findByPid(Integer locationId) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		List<CameraInfoModel> res = sqlSessionTemplate.selectList(DAO+".selectByPid", locationId);
		return res;
	}

	@Override
	public int addCameraInfoModel(CameraInfoModel model) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		int res = sqlSessionTemplate.insert(DAO+".insert", model);
		return res;
	}

	@Override
	public int renewCameraInfoModel(CameraInfoModel model) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		int res = sqlSessionTemplate.update(DAO+".updateByPrimaryKeySelective", model);
		return res;
	}

	@Override
	public int removeCameraInfoModel(Integer cameraId) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		int res = sqlSessionTemplate.delete(DAO+".deleteByPrimaryKey", cameraId);
		return res;
	}

	@Override
	public int isValidByIP(Map<String, Object> map) {
		SqlSessionTemplate sqlSessionTemplate = baseDataSourceService.getDefaultSessionTemplate();
		List<CameraInfoModel> list = sqlSessionTemplate.selectList(DAO+".isValidByIP", map);
		return list.size();
	}

}
