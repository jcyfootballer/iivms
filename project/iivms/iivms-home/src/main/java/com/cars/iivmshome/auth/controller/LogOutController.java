package com.cars.iivmshome.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/logout")
public class LogOutController {

	@RequestMapping
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Subject subject = SecurityUtils.getSubject();
//		Session session = subject.getSession(false);
//		if (session != null) {
//            session.removeAttribute("userInfo");
//        }
		subject.logout();
		return "main/login";
	}
}
 