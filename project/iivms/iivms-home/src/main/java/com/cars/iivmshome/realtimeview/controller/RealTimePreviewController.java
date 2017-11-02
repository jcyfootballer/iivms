/**
 * 
 */
package com.cars.iivmshome.realtimeview.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/realtimepreview")
public class RealTimePreviewController {

	@RequestMapping("/init")
	public String init(HttpServletRequest request, HttpServletResponse response){
		
		return  "/realtimeview/realtimepreview";
	}
	
	
	
}
