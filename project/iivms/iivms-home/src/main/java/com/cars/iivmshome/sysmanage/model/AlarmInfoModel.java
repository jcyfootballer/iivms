package com.cars.iivmshome.sysmanage.model;

public class AlarmInfoModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_info.id
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_info.alarm_type
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    private String alarmType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_info.alarm_title
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    private String alarmTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_info.alarm_starttime
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    private Long alarmStarttime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_info.alarm_endtime
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    private Long alarmEndtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_info.alarm_desc
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    private String alarmDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column alarm_info.ip
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    private String ip;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_info.id
     *
     * @return the value of alarm_info.id
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_info.id
     *
     * @param id the value for alarm_info.id
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_info.alarm_type
     *
     * @return the value of alarm_info.alarm_type
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public String getAlarmType() {
        return alarmType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_info.alarm_type
     *
     * @param alarmType the value for alarm_info.alarm_type
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_info.alarm_title
     *
     * @return the value of alarm_info.alarm_title
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public String getAlarmTitle() {
        return alarmTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_info.alarm_title
     *
     * @param alarmTitle the value for alarm_info.alarm_title
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public void setAlarmTitle(String alarmTitle) {
        this.alarmTitle = alarmTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_info.alarm_starttime
     *
     * @return the value of alarm_info.alarm_starttime
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public Long getAlarmStarttime() {
        return alarmStarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_info.alarm_starttime
     *
     * @param alarmStarttime the value for alarm_info.alarm_starttime
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public void setAlarmStarttime(Long alarmStarttime) {
        this.alarmStarttime = alarmStarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_info.alarm_endtime
     *
     * @return the value of alarm_info.alarm_endtime
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public Long getAlarmEndtime() {
        return alarmEndtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_info.alarm_endtime
     *
     * @param alarmEndtime the value for alarm_info.alarm_endtime
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public void setAlarmEndtime(Long alarmEndtime) {
        this.alarmEndtime = alarmEndtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_info.alarm_desc
     *
     * @return the value of alarm_info.alarm_desc
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public String getAlarmDesc() {
        return alarmDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_info.alarm_desc
     *
     * @param alarmDesc the value for alarm_info.alarm_desc
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public void setAlarmDesc(String alarmDesc) {
        this.alarmDesc = alarmDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column alarm_info.ip
     *
     * @return the value of alarm_info.ip
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column alarm_info.ip
     *
     * @param ip the value for alarm_info.ip
     *
     * @mbggenerated Sun Oct 29 11:12:39 CST 2017
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
}