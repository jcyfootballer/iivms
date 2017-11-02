package com.cars.iivmshome.sysmanage.dao;

import java.util.List;

import com.cars.iivmshome.sysmanage.model.CameraLocationInfoModel;

public interface CameraLocationInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table camera_location_info
     *
     * @mbggenerated Sat Oct 14 01:34:17 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table camera_location_info
     *
     * @mbggenerated Sat Oct 14 01:34:17 CST 2017
     */
    int insert(CameraLocationInfoModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table camera_location_info
     *
     * @mbggenerated Sat Oct 14 01:34:17 CST 2017
     */
    int insertSelective(CameraLocationInfoModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table camera_location_info
     *
     * @mbggenerated Sat Oct 14 01:34:17 CST 2017
     */
    CameraLocationInfoModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table camera_location_info
     *
     * @mbggenerated Sat Oct 14 01:34:17 CST 2017
     */
    int updateByPrimaryKeySelective(CameraLocationInfoModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table camera_location_info
     *
     * @mbggenerated Sat Oct 14 01:34:17 CST 2017
     */
    int updateByPrimaryKey(CameraLocationInfoModel record);
    
    List<CameraLocationInfoModel>  selectByPid(Integer pid);
}