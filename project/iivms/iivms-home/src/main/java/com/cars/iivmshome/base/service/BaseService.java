/**
 * 
 */
package com.cars.iivmshome.base.service;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * @author jiangcy
 *
 */
public interface BaseService {
	
	public SqlSessionTemplate getDefaultSessionTemplate();
}
