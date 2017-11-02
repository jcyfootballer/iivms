<%@ page contentType="text/html; charset=UTF-8" language="java"%>

<%@ include file="/jsp/common/no_cache.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>

<%@ page import="java.io.Serializable"%>
<%@ page import="java.math.BigDecimal"%>

<%@ page import="java.net.InetAddress"%>
<%@ page import="java.net.UnknownHostException"%>

<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.text.Format"%>
<%@ page import="java.text.MessageFormat"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Currency"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.GregorianCalendar"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ page import="java.util.LinkedHashSet"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.MissingResourceException"%>
<%@ page import="java.util.Properties"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Stack"%>
<%@ page import="java.util.TimeZone"%>
<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.TreeSet"%>
<%@ page import="com.cars.iivmshome.base.config.AppConfig"%>

<%
	String commonPath = "/commonutil";
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ contextPath;
	String localPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort();

	String _SYSTITLE = "";
	String defaultTitle = _SYSTITLE;
	String title = _SYSTITLE;
	commonPath = contextPath;
	request.setAttribute("ctx", contextPath);
	request.setAttribute("_sysTitle", _SYSTITLE);
	request.setAttribute("commonPath", commonPath);
	request.setAttribute("SYSTITLE",
			AppConfig.getProperty("sys.title", ""));
	request.setAttribute("COMMONPATH",
			AppConfig.getProperty("sys.commonpath", contextPath));
%>
