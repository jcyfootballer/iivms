package com.cars.iivmshome.auth.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cars.iivmshome.base.util.ApiResponse;
import com.dlx.common.util.MD5;



@Controller
@RequestMapping("/main")
public class LoginController {
	private static final Log log = LogFactory.getLog(LoginController.class);

	@RequestMapping("/login")
	@ResponseBody
	public ApiResponse login(HttpServletRequest request,
			HttpServletResponse response) throws SecurityException,
			UnsupportedEncodingException {
			return validateLogin(request);
	}

	public ApiResponse validateLogin(HttpServletRequest request)
			throws SecurityException {
		String userid = StringUtils.defaultString(request
				.getParameter("username"));
		String password = StringUtils.defaultString(request
				.getParameter("password"));
		return validateLogin2(request,userid, password);
	}

	private ApiResponse validateLogin2(HttpServletRequest request,String userid, String password) {
	        
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = null;
			try {
				token = new UsernamePasswordToken(userid, MD5.encode(password));
				token.setRememberMe(true);
				currentUser.login(token);
				return ApiResponse.SUCCESS;
			} catch (UnknownAccountException uae) {
				log.info("用户名不正确,There is no user with username of "
						+ token.getPrincipal());
				return new ApiResponse.ApiResponseBuilder().status(0).msg("用户名不正确").build();
			} catch (IncorrectCredentialsException ice) {
				log.info("Password for account " + token.getPrincipal()
						+ " was incorrect!");
				return new ApiResponse.ApiResponseBuilder().status(0).msg("密码不正确").build();
			} catch (LockedAccountException lae) {
				log.info("The account for username " + token.getPrincipal()
						+ " is locked.  "
						+ "Please contact your administrator to unlock it.");
				return new ApiResponse.ApiResponseBuilder().status(0).msg("账户被锁").build();
			}catch(Exception e){
				e.printStackTrace();
				return new ApiResponse.ApiResponseBuilder().status(0).msg("账户异常").build();
			}
		}
		return ApiResponse.SUCCESS;
	}
	
	@RequestMapping("/init")
	public String init(HttpServletRequest request,
			HttpServletResponse response) throws SecurityException,
			UnsupportedEncodingException {
		
			return "main/main";
	}
}