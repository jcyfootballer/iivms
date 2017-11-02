/**
 * 
 */
package com.cars.iivmshome.realtimeview.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cars.iivmshome.base.vo.BaseCountsVo;
import com.cars.iivmshome.sysmanage.model.AlarmInfoModel;
import com.cars.iivmshome.sysmanage.model.AlarmTypeModel;
import com.cars.iivmshome.sysmanage.model.CameraInfoModel;
import com.cars.iivmshome.sysmanage.service.AlarmInfoService;
import com.cars.iivmshome.sysmanage.service.AlarmTypeService;
import com.cars.iivmshome.sysmanage.service.CameraService;
import com.dlx.common.util.CommonUtil;
import com.google.common.base.Strings;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/realtimealarm")
public class RealTimeAlarmController {

	@Resource
	CameraService cameraService;
	@Resource
	AlarmTypeService alarmTypeService;
	@Resource
	AlarmInfoService alarmInfoService;
	
	
	@RequestMapping("/init")
	public String init(HttpServletRequest request, HttpServletResponse response){
		
		List<AlarmTypeModel> alarmTypeList = alarmTypeService.findAll();
		request.setAttribute("alarmTypeList", alarmTypeList);
		
//		request.setAttribute("alarmTypeArray", JSONArray.toJSON(alarmTypeList));
		
		return  "/realtimeview/realtimealarm";
	}
	
	@RequestMapping("/getData")
	@ResponseBody
	public JSONObject getData(HttpServletRequest request, HttpServletResponse response){
		String limit = Strings.nullToEmpty(request.getParameter("limit"));
		String offset = Strings.nullToEmpty(request.getParameter("offset"));
		String cameraId = Strings.nullToEmpty(request.getParameter("cameraId"));
		String alerm_type = Strings.nullToEmpty(request.getParameter("alarm_type"));
		String start_time = Strings.nullToEmpty(request.getParameter("start_time"));
		String end_time = Strings.nullToEmpty(request.getParameter("end_time"));
		
		Map<String,Object> param = new HashMap<String,Object>();
		Integer _limit = 10;
		if(!"".equals(limit) && CommonUtil.isMatch1(limit)){
			_limit = Integer.valueOf(limit);
		}
		param.put("limit", _limit);
		
		Integer _start_point = 0;
		if(!"".equals(offset) && CommonUtil.isMatch1(offset)){
			_start_point = Integer.valueOf(offset);
		}
		param.put("start_point", _start_point);
		
		if(!"".equals(alerm_type)){
			param.put("alarm_type", alerm_type);
		}
		if(!"".equals(cameraId) && CommonUtil.isMatch1(cameraId)){
			CameraInfoModel camera = cameraService.findById(Integer.valueOf(cameraId));
			if(camera!=null){
				param.put("ip", camera.getIp());
			}
		}
		
		if(!"".equals(start_time)){
			try{
				param.put("alarm_starttime", CommonUtil.sdf2.parse(start_time).getTime()/1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(!"".equals(end_time)){
			try{
				param.put("alarm_endtime", CommonUtil.sdf2.parse(end_time).getTime()/1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		List<AlarmInfoModel> list = alarmInfoService.getData(param);
		
		BaseCountsVo total = alarmInfoService.getTotals(param);
		
		 JSONObject jsonObject=new JSONObject();
	        jsonObject.put("rows", JSONArray.toJSON(list));//JSONArray
	        jsonObject.put("total",total.getCounts());//总记录数
		
		return jsonObject;
	}
	
}
