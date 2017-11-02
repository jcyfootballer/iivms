/**
 * 
 */
package com.cars.iivmshome.historyview.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/historyplayback")
public class HistoryPlayBackController {

	@RequestMapping("/init")
	public String init(HttpServletRequest request, HttpServletResponse response){
		
		return  "/historyview/playback";
	}
	
	
	
}
