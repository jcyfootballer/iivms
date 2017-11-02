package com.cars.iivmshome.base.listener;


import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cars.iivmshome.base.config.AppConfig;




/**
 * 初始化Web应用程序上下文
 */
public class AppContextListener implements ServletContextListener {

	private static ServletContext servletContext = null;

	private static WebApplicationContext springContext;

	public AppContextListener() {
		super();
	}

	public static ServletContext getServletContext() {
		return servletContext;
	}

	public static ApplicationContext getApplicationContext() {
		return springContext;
	}

	public void contextInitialized(ServletContextEvent sce) {
		servletContext = sce.getServletContext();
		springContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		String ctxPath = servletContext.getRealPath("/");
		if (!ctxPath.endsWith(File.separator))
			ctxPath += File.separator + "file";
		else
			ctxPath += "file";

		AppConfig.setUploadsDir(ctxPath);
		AppConfig.setTempDir(servletContext.getRealPath("/") + "temp");
		AppConfig.setFtpLocalPath(servletContext.getRealPath("/"));
		AppConfig.setRootDir(servletContext.getRealPath("/"));
//
//		AppServer.start();
	}

	public void contextDestroyed(ServletContextEvent sce) {
		try {
//			AppServer.getAppServer().destroy();
		} catch (Throwable throwable) {
		}
	}
}
