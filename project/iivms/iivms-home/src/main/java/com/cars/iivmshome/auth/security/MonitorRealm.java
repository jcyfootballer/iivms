/**
 * 
 */
package com.cars.iivmshome.auth.security;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.MutablePrincipalCollection;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.cars.iivmshome.auth.model.AuthUserModel;
import com.cars.iivmshome.auth.service.AuthUserService;
import com.cars.iivmshome.auth.vo.UserInfoVo;


/**
 * 
 * @Title  MonitorRealm.java
 * @author jiangchy
 * @date   2017年7月19日
 */
public class MonitorRealm extends AuthorizingRealm {

	private static final Log log = LogFactory.getLog(MonitorRealm.class);

	public MonitorRealm() {
		super();
	}

	@Resource
	AuthUserService authUserService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		SimpleAuthorizationInfo result = new SimpleAuthorizationInfo();
		MutablePrincipalCollection principalInfo = (MutablePrincipalCollection) principals;
		/* 这里编写授权代码 */
		
		String loginName = (String) principals.fromRealm(getName()).iterator()
				.next();
			log.info("已登陆用户：" + loginName );
		UserInfoVo user =(UserInfoVo) principals.fromRealm(getName()).iterator()
				.next(); //UserInfoServer.getUserInfoVo(loginName) ;
//		if (user != null) {
//			List<AuthInfoVo> auths = UserInfoServer.getAuths(user.getUserId());
//			if(auths!=null){
//				for(AuthInfoVo vo :auths){
//					result.addStringPermission(vo.toString2());
//				}
//			}
//		}
		return result;

	}

	/*
	 * (non-Javadoc)用户登录时访问
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org
	 * .apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String userName = token.getUsername();
//		String passWord = token.getPassword().toString();
		
		if (StringUtils.isNotBlank(userName)) {
			AuthUserModel model = authUserService.getAuthUserModel(userName);
			UserInfoVo user = new UserInfoVo(model);
			
			log.info("登陆用户：" + user.getUserName() +"  mima ："+user.getPassword());
			if (user != null) {
				user.setRoles(null);
				AuthenticationInfo info = new SimpleAuthenticationInfo(
						user, user.getPassword(), getName());
				return info;
			}
		}
		return null;
	}

	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			System.out.println("Session 的默认超时时间为：" + session.getTimeout()
					+ "毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(Object principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
}