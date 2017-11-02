package com.cars.iivmshome.auth.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.cars.iivmshome.auth.vo.UserInfoVo;


/**
 * 
 * @ClassName: UserInfoServer
 * @Description:用户服务
 * @author: jiangcy
 * @date: 2015年4月28日 上午10:01:03
 */
public class UserInfoServer {

	/**
	 * 
	 * @Title: getUserInfo
	 * @author:jiangcy
	 * @Description: 获取用户信息
	 * @return
	 * @return: UserInfoVo
	 * @throws
	 */
	public static UserInfoVo getUserInfo() {
		Subject currentUser = SecurityUtils.getSubject();
		return currentUser.getPrincipals().oneByType(UserInfoVo.class);
	}

	public static boolean checkSource(String per) {
		return SecurityUtils.getSubject().isPermitted(per);
	}

//	public static UserInfoVo getUserInfoVo(String userName) {
//		UserInfoVo vo = new UserInfoVo();
//		StringBuffer sb = new StringBuffer();
//
//		sb.append(AppConfig.getProperty("authRoot"));
//		sb.append(AppConfig.getProperty("authContext"));
//		sb.append(AppConfig.getProperty("auth.getUser"));
//		sb.append(userName);
//		String Url = sb.toString();
//		// System.out.println("获取用户为：" + Url);
//		try {
//			String res = HttpClientBaseService.get(Url);
//			JSONObject json = JSONObject.fromObject(res);
//			vo = (UserInfoVo) JSONObject.toBean(json, UserInfoVo.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return vo;
//	}

	/**
	 * 
	 * @Title: getAllUserInfo   
	 * @author:jiangcy    
	 * @Description: 获取所有用户信息
	 * @return   
	 * @return: List<UserInfoVo>
	 * @throws
	 */
//	public static List<UserInfoVo> getAllUserInfo(){
//		List<UserInfoVo> list = new ArrayList<UserInfoVo>();
//		StringBuffer sb = new StringBuffer();
//
//		sb.append(AppConfig.getProperty("authRoot"));
//		sb.append(AppConfig.getProperty("authContext"));
//		sb.append(AppConfig.getProperty("auth.getUsers"));
//
//		String Url = sb.toString();
//		try {
//			String res = HttpClientBaseService.get(Url);
//			JSONArray json = JSONArray.fromObject(res);
//			list = (List) JSONArray.toList(json, UserInfoVo.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	
	
//	private static List<ModuleInfoVo> getUserMenusVo(Integer userId) {
//		List<ModuleInfoVo> vo = new ArrayList<ModuleInfoVo>();
//		StringBuffer sb = new StringBuffer();
//
//		sb.append(AppConfig.getProperty("authRoot"));
//		sb.append(AppConfig.getProperty("authContext"));
//		sb.append(AppConfig.getProperty("auth.getMenus"));
//		sb.append(userId);
//
//		String Url = sb.toString();
//		try {
//			String res = HttpClientBaseService.get(Url);
//			JSONArray json = JSONArray.fromObject(res);
//			vo = (List) JSONArray.toList(json, ModuleInfoVo.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return vo;
//	}

//	public static List<AppMenu> genmenu(Integer userId) {
//		List<ModuleInfoVo> modules = UserInfoServer.getUserMenusVo(userId);
//
//		List<AppMenu> mainMenus = new ArrayList<AppMenu>();
//		Map<String, List<AppMenu>> secMenus = new HashMap<String, List<AppMenu>>();
//		for (ModuleInfoVo vo : modules) {
//			AppMenu menu = new AppMenu(vo);
//			List<AppMenu> list = secMenus
//					.get(String.valueOf(menu.getParentid()));
//			if (list == null) {
//				list = new ArrayList<AppMenu>();
//				list.add(menu);
//			} else {
//				list.add(menu);
//			}
//			secMenus.put(String.valueOf(menu.getParentid()), list);
//		}
//
//		mainMenus = secMenus.get("2");
//		Collections.sort(mainMenus);
//		return mainMenus;
//	}

	
	/**
	 * 
	 * @Title: getAllMenusVo
	 * @author:jiangcy
	 * @Description: 远程获取菜单
	 * @return
	 * @return: AppMenu
	 * @throws
	 */
//	public static AppMenu getAllMenusVo() {
//		StringBuffer sb = new StringBuffer();
//		String index = AppConfig.getProperty("rootProject");
//		sb.append(AppConfig.getProperty("authRoot"));
//		sb.append(AppConfig.getProperty("authContext"));
//		sb.append(AppConfig.getProperty("auth.getMenus"));
//		sb.append(index);
//
//		String Url = sb.toString();
//		List<ModuleInfoVo> moduleList = new ArrayList<ModuleInfoVo>();
//		AppMenu rootmenu = new AppMenu();
//		try {
//			String res = HttpClientBaseService.get(Url);
//			JSONArray json = JSONArray.fromObject(res);
//			moduleList = (List) JSONArray.toList(json, ModuleInfoVo.class);
//System.out.println(moduleList.size());
//			if (null != moduleList) {
//				Map<String, List<AppMenu>> secMenus = new HashMap<String, List<AppMenu>>();
//				for (ModuleInfoVo module : moduleList) {
//					AppMenu vo = new AppMenu(module);
//					if (index.equals(vo.getAppmenid())) {
//						rootmenu = vo;
//					}
//					List<AppMenu> list = secMenus.get(String.valueOf(vo
//							.getParentid()));
//					if (list == null) {
//						list = new ArrayList<AppMenu>();
//						list.add(vo);
//					} else {
//						list.add(vo);
//					}
//					secMenus.put(String.valueOf(vo.getParentid()), list);
//				}
//				creatRootMenu(rootmenu, secMenus);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return rootmenu;
//
//	}
//
//	private static void creatRootMenu(AppMenu rootMenu,
//			Map<String, List<AppMenu>> secMenus) {
//		if (rootMenu.isHaschildren()) {
//			List<AppMenu> children = secMenus.get(String.valueOf(rootMenu
//					.getId()));
//			if (children != null) {
//				for (AppMenu vo : children) {
//					creatRootMenu(vo, secMenus);
//				}
//				rootMenu.setChildren(children);
//			} else {
//				return;
//			}
//		} else {
//			return;
//		}
//	}

	/**
	 * 
	 * @Title: getAuths
	 * @author:jiangcy
	 * @Description: 远程获取权限
	 * @param userId
	 * @return
	 * @return: List<AuthInfoVo>
	 * @throws
	 */
//	public static List<AuthInfoVo> getAuths(Integer userId) {
//		List<AuthInfoVo> vo = new ArrayList<AuthInfoVo>();
//		StringBuffer sb = new StringBuffer();
//
//		sb.append(AppConfig.getProperty("authRoot"));
//		sb.append(AppConfig.getProperty("authContext"));
//		sb.append(AppConfig.getProperty("auth.getAuths"));
//		sb.append(AppConfig.getProperty("rootProject"));
//		sb.append("/" + userId);
//
//		String Url = sb.toString();
//		try {
//			String res = HttpClientBaseService.get(Url);
//			JSONArray json = JSONArray.fromObject(res);
//			vo = (List) JSONArray.toList(json, AuthInfoVo.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return vo;
//	}
}
