package com.cars.iivmshome.auth.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/auth/authManage")
public class AuthManageController {

	@RequestMapping(params = "method=init")
	public String init(HttpServletRequest request, HttpServletResponse response) {

		return "auth/main";
	}

	@RequestMapping(params = "method=getMainMenus")
	public void getMainMenus(HttpServletRequest request,
			HttpServletResponse response) {

//		List<AppMenu> mainMenus = AppCacheRepository.getAppMenus()
//				.getChildren();
//		if (mainMenus != null) {
//			for (AppMenu m : mainMenus) {
//				if (UserInfoServer.checkSource(m.getAppmenid() + ":view")) {
//					m.setIsshow(true);
//				}
//			}
//		} else {
//			mainMenus = new ArrayList<AppMenu>();
//		}
//		XmlUtil.outputJSON(JSONArray.fromObject(mainMenus).toString(),
//				response, CommonConstant.CHARACTDOCE);
	}

	@RequestMapping(params = "method=getSecMenus")
	public void getSecMenus(HttpServletRequest request,
			HttpServletResponse response) {
//		String s = request.getParameter("menuId");
//		List<AppMenu> mainMenus = AppCacheRepository.getAppMenus()
//				.getChildren();
//		AppMenu sec = new AppMenu();
//		for (AppMenu m : mainMenus) {
//			if (String.valueOf(m.getId()).equals(s)) {
//				sec = m;
//				break;
//			}
//		}
//
//		List<AppMenu> secMenus = sec.getChildren();
//		if (secMenus != null) {
//			for (AppMenu vo : secMenus) {
//				if (UserInfoServer.checkSource(vo.getAppmenid() + ":view")) {
//					vo.setIsshow(true);
//				}
//				if (vo.isHaschildren()) {
//					List<AppMenu> children = vo.getChildren();
//					for (int i = 0; i < children.size(); i++) {
//						if (UserInfoServer.checkSource(children.get(i)
//								.getAppmenid() + ":view")) {
//							children.get(i).setIsshow(true);
//						}
//					}
//				}
//			}
//		} else {
//			secMenus = new ArrayList<AppMenu>();
//		}
//
//		XmlUtil.outputJSON(JSONArray.fromObject(secMenus).toString(), response,
//				CommonConstant.CHARACTDOCE);
	}

}
