package com.cars.iivmshome.auth.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/index")
public class IndexController {

	@RequestMapping
	public String start(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws Exception {
		/*
		 * 日期
		 */
		String dateDispString = getDateDisp();
		request.setAttribute("date", dateDispString);
System.out.println(dateDispString);
//		SessionContext sessionContext = SessionContext
//				.getSessionContext(request);
//		if (null != sessionContext) {
//			if (sessionContext.isLogged()) {
//				return "workmanage/MyJsp";
//			}
//		}
		return "main/login";
	}

	private String getDateDisp() {
		String displayString = null;
		SimpleDateFormat formatter = new java.text.SimpleDateFormat("M月d日 EEEE");
		displayString = formatter.format(new Date());
		return displayString;
	}

}
