/**
 * 
 */
package com.cars.iivmshome.sysmanage.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import rtsp.sdk.HCNetSDK;
import rtsp.sdk.HCUtility;

import com.cars.iivmshome.sysmanage.model.CameraInfoModel;

/**
 * @author Administrator
 *摄像头播放管理
 */
public class VedioManage {
	
	//摄像头注册管理
	public static Map vedioMap = new ConcurrentHashMap();	
	
	//hc sdk
	public final static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;
	
	public final static HCUtility hcu = new HCUtility();
	
	Object obj = new Object();
	//注册
	public boolean registeCamera(CameraInfoModel model ){
		
		if(vedioMap.containsKey(model.getId())){
			//已注册
		}else{
			//进行注册
	    	hcu.register(model.getIp(),model.getPort().toString(),model.getUsername(),model.getPassword(),hCNetSDK);
			vedioMap.put(model.getId(), model);
		}
		
		
		return true;
	}
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
