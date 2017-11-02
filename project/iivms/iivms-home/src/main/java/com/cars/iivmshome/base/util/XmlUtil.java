package com.cars.iivmshome.base.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtil {

	public static String UTF8BOM = "";

	static {
		byte[] utf8Bom = new byte[] { (byte) 0xef, (byte) 0xbb, (byte) 0xbf };
		try {
			UTF8BOM = new String(utf8Bom, "UTF-8");// 定义BOM标记
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 格式化XML文档
	 * 
	 * @param document
	 *            xml文档
	 * @param charset
	 *            字符串的编码
	 * @return 格式化后XML字符串
	 */
	public static String formatXML(Document document, String charset) {
		OutputFormat format = OutputFormat.createCompactFormat();
		format.setSuppressDeclaration(true);
		StringWriter sw = new StringWriter();
		XMLWriter xw = new XMLWriter(sw, format);
		try {
			xw.write(document);
			xw.flush();
		} catch (IOException e) {

		} finally {
			try {
				if (null != xw) {
					xw.close();
				}
			} catch (IOException e) {
			}
		}
		return sw.toString();
	}

	public static Document getDocument(String fileName) {
		if (StringUtils.isBlank(fileName)) {
			return null;
		}
		File file = new File(fileName);
		if (file.isFile()) {
			return getDocument(file);
		}
		return null;
	}

	public static Document getDocument(File file) {
		if (null == file || !file.isFile()) {
			return null;
		}
		SAXReader reader = new SAXReader();
		reader.setStripWhitespaceText(true);
		Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}

	public static Document getDocument(InputStream inputstream) {
		if (null == inputstream) {
			return null;
		}
		SAXReader reader = new SAXReader();
		reader.setStripWhitespaceText(true);
		Document document = null;
		try {
			document = reader.read(inputstream);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}

	public static boolean storeXmlFile(final Document document,
			final String filePath) {
		if (null == document) {
			return false;
		}
		if (null == filePath || "".equals(filePath)) {
			return false;
		}
		File xmlFile = new File(filePath);
		if (!xmlFile.exists()) {
			try {
				xmlFile.createNewFile();
			} catch (IOException e) {
				return false;
			}
		}
		if (!xmlFile.isFile()) {
			return false;
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		format.setSuppressDeclaration(false);
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream(xmlFile), format);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (null != writer) {
			try {
				writer.write(document);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @Title: outputXml   
	 * @author:jiangcy    
	 * @Description: 发送xml数据
	 * @param xml
	 * @param response
	 * @param encoding   
	 * @return: void
	 * @throws
	 */
	public static void outputXml(String xml, HttpServletResponse response,
			String encoding) {
		response.setCharacterEncoding(encoding);
		response.setContentType("text/xml");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (out != null) {
			if (null != xml && !"".equals(xml)) {
				out.println(xml);
			}
			out.flush();
			out.close();
		}
	}
	
	/**
	 * 
	 * @Title: outputPlain   
	 * @author:jiangcy    
	 * @Description: 发送txt数据  
	 * @param xml
	 * @param response   
	 * @return: void
	 * @throws
	 */
	public static void outputPlain(String xml, HttpServletResponse response) {
		try {
			response.setContentType("text/plain");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			PrintWriter out = response.getWriter();
			if (out != null) {
				if (null != xml && !"".equals(xml)) {
					out.println(xml);
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title: outputJSON   
	 * @author:jiangcy    
	 * @Description: 发送json数据
	 * @param xml
	 * @param response   
	 * @return: void
	 * @throws
	 */
	public static void outputJSON(String xml, HttpServletResponse response,String encoding) {
		try {
			response.setCharacterEncoding(encoding);
			response.setContentType("text/javascript");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			PrintWriter out = response.getWriter();
			if (out != null) {
				if (null != xml && !"".equals(xml)) {
					out.println(xml);
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
