/**
 * 
 */
package com.cars.iivmshome.sysmanage.service;

import java.util.List;
import java.util.Map;

import com.cars.iivmshome.sysmanage.model.CameraInfoModel;

/**
 * @author Administrator
 *
 */
public interface CameraService {

	public CameraInfoModel findById(Integer cameraId);

	/*
	 * 根据位置查找该位置下所有摄像头
	 */
	public List<CameraInfoModel> findByPid(Integer locationId);


	public int addCameraInfoModel(CameraInfoModel model);

	public int renewCameraInfoModel(CameraInfoModel model);

	public int removeCameraInfoModel(Integer cameraId);

	/**
	 * 根据ip id 验证该摄像头是否存在
	 * @param map 如果id>0 ， 则查找不等于id的摄像头是否存在该ip
	 * @return
	 */

	public int isValidByIP(Map<String, Object> map);


}
