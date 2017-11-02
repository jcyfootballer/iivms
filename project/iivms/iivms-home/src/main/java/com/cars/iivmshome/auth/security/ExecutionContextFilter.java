package com.cars.iivmshome.auth.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ExecutionContextFilter implements Filter {

	private static final Log log = LogFactory.getLog(ExecutionContextFilter.class);
	
	public void init(FilterConfig filterConfig) {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String servletPath = request.getServletPath();
		String contextPath = request.getContextPath();

		String contentType = request.getContentType();
		Subject currentUser = SecurityUtils.getSubject();
		if ((!"/main/index.do".equals(servletPath))
				&& (!"/main/login.do".equals(servletPath))) {
			if (!currentUser.isAuthenticated()) {
				if (contentType == null) {
					response.getWriter().println("<script>");
					response.getWriter().println(
							"top.location.href='" + contextPath
									+ "/index.jsp';");
					response.getWriter().println("</script>");
					return;
				} else {
					PrintWriter out = response.getWriter();
					out.print("EXPIRED");
					out.flush();
					return;
				}
			}
		}
		
		/*
		 * if (!"/main/index.do".equals(servletPath)) { boolean unAuth = false;
		 * UserModuleMenu userModuleMenu = sessioncontext.getModuleMap();
		 * List<AppMenu> unAuthAppMenus = null; if (null != userModuleMenu) {
		 * unAuthAppMenus = userModuleMenu.getUnAuthAppMenus(); }
		 * 
		 * if (null != unAuthAppMenus) { for (int i = 0, count =
		 * unAuthAppMenus.size(); i < count; i++) { String url =
		 * unAuthAppMenus.get(i).getUrl(); if (null != url &&
		 * url.indexOf(servletPath) > 0) { unAuth = true; } } }
		 * 
		 * if (unAuth) { response.getWriter().println("<script>");
		 * response.getWriter().println( "top.location.href='" + contextPath +
		 * "/index.jsp';"); response.getWriter().println("</script>"); return; }
		 * }
		 * 
		 * String pathName = null; String funcid =
		 * request.getParameter("funcid"); request.setAttribute("funcid",
		 * funcid);
		 * 
		 * String topMenuKey = null; if (StringUtils.isNotEmpty(funcid)) {
		 * 
		 * String[] idSections = funcid.split("\\|"); topMenuKey =
		 * idSections[0]; String curMenuKey = idSections[idSections.length - 1];
		 * Integer menuKey = null;
		 * 
		 * try { menuKey = Integer.valueOf(curMenuKey); } catch (Exception e) {
		 * 
		 * }
		 * 
		 * if (null != menuKey) { // AppMenu appMenu = //
		 * AppMenuRepository.getAppMenus().get(menuId); AppMenu appMenu =
		 * AppMenuRepository.getModuleMenus().get( menuKey); if (null !=
		 * appMenu) { pathName = appMenu.getTreepath(); } } }
		 * 
		 * if (null != pathName) { request.setAttribute("_pathName", pathName);
		 * } if (null != topMenuKey) { request.setAttribute("_topMenuKey",
		 * topMenuKey); }
		 */
		try {
			chain.doFilter(request, response);
		} finally {
		}
	}

	public void destroy() {
	}

}
