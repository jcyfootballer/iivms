package com.cars.iivmshome.base.service.impl;

import java.util.Hashtable;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cars.iivmshome.base.service.MultiDataSourceService;
import com.cars.iivmshome.base.spring.ApplicationContextHelper;


@Service("multiDataSourceService")
public class MultiDataSourceServiceImpl implements MultiDataSourceService {

	@Resource
	@Qualifier("defaultJdbcTemplate")
	private JdbcTemplate defaultJdbcTemplate;

	private Hashtable<String, JdbcTemplate> hashtable = new java.util.Hashtable<String, JdbcTemplate>();

	public JdbcTemplate getDefaultJdbcTemplate() {
		return defaultJdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate(String dataSourceId) {
		JdbcTemplate jdbcTemplate = null;
		if (null != dataSourceId && !"".equals(dataSourceId)) {
			jdbcTemplate = hashtable.get(dataSourceId);
			if (null == jdbcTemplate) {
				Object object = ApplicationContextHelper.getBean(dataSourceId);
				if (null != object && (object instanceof DataSource)) {
					jdbcTemplate = new JdbcTemplate((DataSource) object);
					hashtable.put(dataSourceId, jdbcTemplate);
				}
			}
		}
		return jdbcTemplate;
	}
}
