package com.cars.iivmshome.sysmanage.dao;

import java.util.List;

import com.cars.iivmshome.sysmanage.model.AlarmTypeModel;

public interface AlarmTypeMapper {
	
	List<AlarmTypeModel> selectAll();
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alarm_type
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    int insert(AlarmTypeModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alarm_type
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    int insertSelective(AlarmTypeModel record);
}