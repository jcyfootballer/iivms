/**
 * 
 */
package com.cars.iivmshome.sysmanage.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cars.iivmshome.base.util.ApiResponse;
import com.cars.iivmshome.base.util.XmlUtil;
import com.cars.iivmshome.sysmanage.model.CameraInfoModel;
import com.cars.iivmshome.sysmanage.model.CameraLocationInfoModel;
import com.cars.iivmshome.sysmanage.service.CameraLocationService;
import com.cars.iivmshome.sysmanage.service.CameraService;
import com.dlx.common.constant.CommonConstant;
import com.dlx.common.util.CommonUtil;
import com.google.common.base.Strings;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cameraManage")
public class CameraManageController {
	protected Logger log = Logger.getLogger(CameraManageController.class);

	@Resource
	CameraService cameraService;

	@Resource
	CameraLocationService cameraLocationService;

	/**
	 * init方法用来跳转到其他页面
	 * 
	 */
	@RequestMapping("/init")
	public String init(HttpServletRequest request, HttpServletResponse response) {
		log.info("进入摄像头管理页面");
		return "sysmanage/camera";
	}

	@RequestMapping("/validCameraLoactionName")
	public void validCameraLoactionName(HttpServletRequest request,
			HttpServletResponse response) {
		String cameraLoactionPid = Strings.nullToEmpty(request
				.getParameter("cameraLoactionPid"));
		String name = Strings.nullToEmpty(request.getParameter("name"));
		String result = "";

		XmlUtil.outputJSON(result, response, CommonConstant.CHARACTDOCE);
	}

	@RequestMapping("/getData")
	@ResponseBody
	public String getData(HttpServletRequest request, HttpServletResponse response) {
		String nodeId = Strings.nullToEmpty(request.getParameter("id"));
		String type = Strings.nullToEmpty(request.getParameter("type"));
		if (Strings.isNullOrEmpty(nodeId)) {
			nodeId = CommonConstant.PARENTID.toString();
		}
		String result = (new JSONArray()).toString();
		log.info("访问节点：" + nodeId + "  类型：" + type);
		int id = Integer.valueOf(nodeId);
		if (String.valueOf(CommonConstant.PARENTID).equals(nodeId)) {// 根数据
			List<CameraLocationInfoModel> cameraLoactionInfoList = cameraLocationService
					.findByLocationPid(id);
			List<CameraInfoModel> cameraInfoList = cameraService.findByPid(id);
			result = generateTreeNodes(cameraLoactionInfoList, cameraInfoList);
		} else if ("1".equals(type)) {// 位置数据
			List<CameraLocationInfoModel> cameraLoactionInfoList = cameraLocationService
					.findByLocationPid(id);
			List<CameraInfoModel> cameraInfoList = cameraService.findByPid(id);
			result = generateTreeNodes(cameraLoactionInfoList, cameraInfoList);
		} else if ("2".equals(type)) { // 摄像头
			List<CameraInfoModel> cameraInfoList = cameraService.findByPid(id);
			result = generateTreeNodes(null, cameraInfoList);
		}

//		XmlUtil.outputJSON(result, response, CommonConstant.CHARACTDOCE);
		return result;
	}

	/**
	 * 
	 * @Title: generateDbNodes
	 * @author:jiangcy
	 * @Description: 生成数据库节点
	 * @param result
	 * @return
	 * @return: JSONArray
	 * @throws
	 */
	private String generateTreeNodes(
			List<CameraLocationInfoModel> cameraLoactionInfoList,
			List<CameraInfoModel> cameraInfoList) {
		if (cameraLoactionInfoList == null && cameraInfoList == null) {
			return (new JSONArray()).toString();
		}
		Map<String, Object> submap = null;
		List<Map<String, Object>> sublist = new ArrayList<Map<String, Object>>();
		if (cameraLoactionInfoList != null && cameraLoactionInfoList.size() > 0) {
			for (CameraLocationInfoModel model : cameraLoactionInfoList) {
				submap = new HashMap<String, Object>();
				submap.put("id", model.getId());
				submap.put("pId", model.getPid());
				submap.put("name", model.getName());
				submap.put("title", model.getName());
				submap.put("isParent", true);
				submap.put("iconSkin", (model.getPid() > 0 ? "db1" : "home"));
				submap.put("open", true);
				submap.put("type", "1");
				sublist.add(submap);
			}
		}
		if (cameraInfoList != null && cameraInfoList.size() > 0) {
			for (CameraInfoModel model : cameraInfoList) {
				submap = new HashMap<String, Object>();
				submap.put("id", model.getId());
				submap.put("pId", model.getPid());
				submap.put("name", model.getName());
				submap.put("title", model.getName());
				submap.put("isParent", false);
				submap.put("iconSkin", "tablefact");
				submap.put("open", false);
				submap.put("type", "2");
				submap.put("ip", model.getIp());
				submap.put("port", model.getPort());
				submap.put("username", model.getUsername());
				submap.put("password", model.getPassword());
				submap.put("limitScanNums", model.getLimitScanNums());
				sublist.add(submap);
			}
		}

		return JSONArray.toJSONString(sublist);
	}

	@RequestMapping("/addCameraLoactionInfo")
	@ResponseBody
	public ApiResponse addCameraLoactionInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String cameraLoactionId = Strings.nullToEmpty(request
				.getParameter("cameraLoactionId"));
		String cameraLoactionPid = Strings.nullToEmpty(request
				.getParameter("cameraLoactionPid"));
		String name = Strings.nullToEmpty(request.getParameter("name"));
		log.info("name:" + name + ",cameraLoactionPid:" + cameraLoactionPid
				+ ",cameraLoactionId:" + cameraLoactionId);
		if (!"".equals(cameraLoactionPid)
				&& CommonUtil.isMatch1(cameraLoactionPid) && !"".equals(name)) {
			CameraLocationInfoModel model = new CameraLocationInfoModel();
			model.setPid(Integer.valueOf(cameraLoactionPid));
			model.setName(name);

			int success = cameraLocationService
					.addCameraLocationInfoModel(model);
			if(success==1){
				return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_SUCCESS_CODE).msg("添加成功").build();
			}
		}
		return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_CODE).msg("添加失败").build();
	}

	@RequestMapping("/renewCameraLoactionInfo")
	@ResponseBody
	public ApiResponse renewCameraLoactionInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String cameraLoactionId = Strings.nullToEmpty(request
				.getParameter("cameraLoactionId"));
//		String cameraLoactionPid = Strings.nullToEmpty(request
//				.getParameter("cameraLoactionPid"));
		String name = Strings.nullToEmpty(request.getParameter("name"));
//		log.info("name:" + name + ",cameraLoactionPid:" + cameraLoactionPid
//				+ ",cameraLoactionId:" + cameraLoactionId);
		
		if (!"".equals(cameraLoactionId)
				&& CommonUtil.isMatch1(cameraLoactionId) && !"".equals(name)) {
			CameraLocationInfoModel model = cameraLocationService
					.findByLocationId(Integer.valueOf(cameraLoactionId));
			model.setName(name);

			int success = cameraLocationService
					.renewCameraLocationInfoModel(model);
			if(success==1){
				return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_SUCCESS_CODE).msg("更新成功").build();
			}
		}
		return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_CODE).msg("更新失败").build();
	}

	@RequestMapping("/removeCameraLoactionInfo")
	@ResponseBody
	public ApiResponse removeCameraLoactionInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String cameraLoactionId = Strings.nullToEmpty(request
				.getParameter("cameraLoactionId"));
//		log.info("cameraLoactionId:" + cameraLoactionId);
		if (!"".equals(cameraLoactionId)
				&& CommonUtil.isMatch1(cameraLoactionId)) {
			Integer id = Integer
					.valueOf(cameraLoactionId);
			List<CameraLocationInfoModel> cameraLoactionInfoList = cameraLocationService
					.findByLocationPid(id);
			List<CameraInfoModel> cameraInfoList = cameraService.findByPid(id);
			
			if(cameraLoactionInfoList.size()>0 || cameraInfoList.size()>0){
				return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_CODE).msg("删除失败,有子节点").build();
			}else{
				int success = cameraLocationService
						.removeCameraLocationInfoModel(Integer
								.valueOf(cameraLoactionId));
				if(success==1){
					return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_SUCCESS_CODE).msg("删除成功").build();
				}
			}
		}
		return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_SUCCESS_CODE).msg("删除失败").build();
	}
	
	@RequestMapping("/isValidByIP")
	@ResponseBody
	public JSONObject isValidByIP(HttpServletRequest request,
			HttpServletResponse response) {
		String cameraId = Strings.nullToEmpty(request
				.getParameter("id"));
		String ip = Strings.nullToEmpty(request.getParameter("ip"));
//		String port = Strings.nullToEmpty(request.getParameter("port"));
		
		Map<String,Object> map = new HashMap<String,Object>();
		JSONObject result = new JSONObject();
		if (!"".equals(cameraId)
				&& CommonUtil.isMatch1(cameraId) ){
			map.put("id",Integer.valueOf(cameraId));
		}
		if(!"".equals(ip)
				&& CommonUtil.isMatchIP(ip) ) {
			map.put("ip",ip);
		}	
		if(map.size()<1){
			result.put("valid", true);
		}else{
			int res = cameraService.isValidByIP(map);
			if(res<1)
				result.put("valid", true);
			else 
				result.put("valid", false);
		}
		return result;
	}
	
	
	@RequestMapping("/addCamera")
	@ResponseBody
	public ApiResponse addCamera(HttpServletRequest request,
			HttpServletResponse response) {
		String cameraPid = Strings.nullToEmpty(request
				.getParameter("cameraPid"));
		String ip = Strings.nullToEmpty(request.getParameter("ip"));
		String port = Strings.nullToEmpty(request.getParameter("port"));
		String username = Strings.nullToEmpty(request.getParameter("username"));
		String password = Strings.nullToEmpty(request.getParameter("password"));
		String name = Strings.nullToEmpty(request.getParameter("name"));
		String limitscannum = Strings.nullToEmpty(request.getParameter("limitscannum"));
		
		if (!"".equals(cameraPid)
				&& CommonUtil.isMatch1(cameraPid) 
				&&
			!"".equals(ip)
				&& CommonUtil.isMatchIP(ip) 	
				&&
			!"".equals(port)
				&& CommonUtil.isMatch1(port) 
				&& !"".equals(username)
				&& !"".equals(password)
				&& !"".equals(name)
				) {
			CameraInfoModel model = new CameraInfoModel();
			model.setPid(Integer.valueOf(cameraPid));
			model.setIp(ip);
			model.setPort(Integer.valueOf(port));
			model.setUsername(username);
			model.setPassword(password);
			model.setName(name);
			if(Strings.isNullOrEmpty(limitscannum)){
				model.setLimitScanNums(100);
			}else if(CommonUtil.isMatch1(limitscannum)){
				model.setLimitScanNums(Integer.valueOf(limitscannum));
			}else {
				model.setLimitScanNums(100);
			}
			int success = cameraService.addCameraInfoModel(model);
			if(success==1){
				return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_SUCCESS_CODE).msg("添加成功").build();
			}
		}
		return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_CODE).msg("添加失败").build();
	}

	@RequestMapping("/renewCamera")
	@ResponseBody
	public ApiResponse renewCamera(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
//		String cameraPid = Strings.nullToEmpty(request
//				.getParameter("cameraPid"));
		String cameraId = Strings.nullToEmpty(request
				.getParameter("cameraId"));
		String ip = Strings.nullToEmpty(request.getParameter("ip"));
		String port = Strings.nullToEmpty(request.getParameter("port"));
		String username = Strings.nullToEmpty(request.getParameter("username"));
		String password = Strings.nullToEmpty(request.getParameter("password"));
		String name = Strings.nullToEmpty(request.getParameter("name"));
		String limitscannum = Strings.nullToEmpty(request.getParameter("limitscannum"));
		
//		System.out.println(name);
		if (!"".equals(cameraId)
				&& CommonUtil.isMatch1(cameraId) &&
//				!"".equals(cameraPid)
//				&& CommonUtil.isMatch1(cameraPid) 
//				&&
			!"".equals(ip)
				&& CommonUtil.isMatchIP(ip) 	
				&&
			!"".equals(port)
				&& CommonUtil.isMatch1(port) 
				&& !"".equals(username)
				&& !"".equals(password)
				&& !"".equals(name)
				) {
			CameraInfoModel model = cameraService.findById(Integer.valueOf(cameraId));
//			model.setPid(Integer.valueOf(cameraPid));
			model.setIp(ip);
			model.setPort(Integer.valueOf(port));
			model.setUsername(username);
			model.setPassword(password);
			model.setName(name);
			if(Strings.isNullOrEmpty(limitscannum)){
				model.setLimitScanNums(100);
			}else if(CommonUtil.isMatch1(limitscannum)){
				model.setLimitScanNums(Integer.valueOf(limitscannum));
			}else {
				model.setLimitScanNums(100);
			}

			int success = cameraService.renewCameraInfoModel(model);
			if(success==1){
				return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_SUCCESS_CODE).msg("修改成功").build();
			}
		}
		return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_CODE).msg("修改失败").build();
	}
	
	@RequestMapping("/removeCamera")
	@ResponseBody
	public ApiResponse removeCamera(HttpServletRequest request,
			HttpServletResponse response) {
		String cameraId = Strings.nullToEmpty(request
				.getParameter("cameraId"));
		
		if (!"".equals(cameraId)
				&& CommonUtil.isMatch1(cameraId) 
				) {
			int success = cameraService.removeCameraInfoModel(Integer.valueOf(cameraId));
			if(success==1){
				return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_SUCCESS_CODE).msg("删除成功").build();
			}
		}
		return new ApiResponse.ApiResponseBuilder().status(ApiResponse.DEFAULT_CODE).msg("删除失败").build();
	}
}
