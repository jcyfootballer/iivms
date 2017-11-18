/**
 * 
 */
package com.cars.iivmshome.realtimeview.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cars.iivmshome.base.util.ApiResponse;
import com.cars.iivmshome.sysmanage.controller.CameraManageController;
import com.cars.iivmshome.sysmanage.model.CameraInfoModel;
import com.cars.iivmshome.sysmanage.service.CameraService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/realtimepreview")
public class RealTimePreviewController {
	protected Logger log = Logger.getLogger(CameraManageController.class);
	
	@Resource
	CameraService cameraService;
	
	@RequestMapping("/init")
	public String init(HttpServletRequest request, HttpServletResponse response){
		
		return  "/realtimeview/realtimepreview";
	}
	
	@RequestMapping(value="/vediomanage/{cameraId}", method = RequestMethod.GET)
	@ResponseBody
	public ApiResponse vediomanage(HttpServletRequest request, HttpServletResponse response, @PathVariable  Integer cameraId) {
		log.info("访问节点：" + cameraId );

		CameraInfoModel model = cameraService.findById(cameraId);
		if(model == null){
			return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_CODE).msg("亲，未找到该摄像头").build();
		}else{
			
			//cameraId 未注册则注册
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("cameraId", model.getId());
			map.put("rtsp", model.getRtspCamera());
			
			return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_SUCCESS_CODE).data(JSONObject.toJSON(map)).build();
		}
	}
	
}
