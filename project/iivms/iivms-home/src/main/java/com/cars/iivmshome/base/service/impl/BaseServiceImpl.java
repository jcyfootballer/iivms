/**
 * 
 */
package com.cars.iivmshome.base.service.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.cars.iivmshome.base.service.BaseService;

/**
 * @author jiangcy
 *
 */
@Service("baseDataSourceService")
public class BaseServiceImpl implements BaseService {

	@Resource
	private  SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getDefaultSessionTemplate() {
		return sqlSessionTemplate;
	}
}
