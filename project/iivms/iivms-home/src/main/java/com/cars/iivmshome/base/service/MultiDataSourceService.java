package com.cars.iivmshome.base.service;

import org.springframework.jdbc.core.JdbcTemplate;

public interface MultiDataSourceService {

	/**
	 * 获取默认数据库的spring的JdbcTemplate
	 * 
	 * @return 默认数据库对应JdbcTemplate对象
	 */
	public JdbcTemplate getDefaultJdbcTemplate();


	/**
	 * 
	 * 获取指定数据源对应的spring的JdbcTemplate
	 * 
	 * @param dataSourceId
	 *            数据源标识，在spring配置文件中设定
	 * 
	 * @return 数据源对应JdbcTemplate对象，如果不存在对应数据源则返回null
	 */
	public JdbcTemplate getJdbcTemplate(String dataSourceId);

}
