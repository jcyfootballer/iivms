package com.cars.iivmshome.sysmanage.model;

public class CameraInfoModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column camera_info.id
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column camera_info.port
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    private Integer port;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column camera_info.ip
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    private String ip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column camera_info.username
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column camera_info.password
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column camera_info.desc
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column camera_info.pid
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    private Integer pid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column camera_info.limit_scan_nums
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    private Integer limitScanNums;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column camera_info.id
     *
     * @return the value of camera_info.id
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column camera_info.id
     *
     * @param id the value for camera_info.id
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column camera_info.port
     *
     * @return the value of camera_info.port
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public Integer getPort() {
        return port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column camera_info.port
     *
     * @param port the value for camera_info.port
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column camera_info.ip
     *
     * @return the value of camera_info.ip
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column camera_info.ip
     *
     * @param ip the value for camera_info.ip
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column camera_info.username
     *
     * @return the value of camera_info.username
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column camera_info.username
     *
     * @param username the value for camera_info.username
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column camera_info.password
     *
     * @return the value of camera_info.password
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column camera_info.password
     *
     * @param password the value for camera_info.password
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column camera_info.desc
     *
     * @return the value of camera_info.desc
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column camera_info.pid
     *
     * @return the value of camera_info.pid
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public Integer getPid() {
        return pid;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column camera_info.pid
     *
     * @param pid the value for camera_info.pid
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column camera_info.limit_scan_nums
     *
     * @return the value of camera_info.limit_scan_nums
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public Integer getLimitScanNums() {
        return limitScanNums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column camera_info.limit_scan_nums
     *
     * @param limitScanNums the value for camera_info.limit_scan_nums
     *
     * @mbggenerated Sat Oct 14 01:31:26 CST 2017
     */
    public void setLimitScanNums(Integer limitScanNums) {
        this.limitScanNums = limitScanNums;
    }
    
    
    public String getRtspCamera(){
    	StringBuffer sb = new StringBuffer("rtsp://");
    	sb.append(this.getUsername()).append(":");
    	sb.append(this.getPassword()).append("@");
    	sb.append(this.getIp()).append(":");
    	sb.append(this.getPort()).append("/h264/ch1/main/av_stream");
    	
    	return sb.toString();
    }
}