package com.cars.iivmshome.sysmanage.service;

import java.util.List;
import java.util.Map;

import com.cars.iivmshome.base.vo.BaseCountsVo;
import com.cars.iivmshome.sysmanage.model.AlarmInfoModel;

public interface AlarmInfoService {
   
	public List<AlarmInfoModel>  getData(Map<String,Object> param);

	public BaseCountsVo getTotals(Map<String, Object> param);
	
}
