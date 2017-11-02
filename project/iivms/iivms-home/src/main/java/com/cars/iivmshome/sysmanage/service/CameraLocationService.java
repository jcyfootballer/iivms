/**
 * 
 */
package com.cars.iivmshome.sysmanage.service;

import java.util.List;

import com.cars.iivmshome.sysmanage.model.CameraLocationInfoModel;

/**
 * @author Administrator
 *
 */
public interface CameraLocationService {


	public CameraLocationInfoModel findByLocationId(Integer locationId);

	/*
	 * 根据位置查找该位置下所有子位置
	 */
	public List<CameraLocationInfoModel> findByLocationPid(Integer locationId);


	public int addCameraLocationInfoModel(CameraLocationInfoModel model);

	public int renewCameraLocationInfoModel(CameraLocationInfoModel model);

	public int removeCameraLocationInfoModel(Integer locationId);

}
