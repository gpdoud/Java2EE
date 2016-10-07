package com.ssa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WebsiteController {
	
	String[] messages = {
			"Message 0",
			"Message 1",
			"Message 2",
			"Message 3",
			"Message 4"
	};
	
	@RequestMapping("/help")
	public ModelAndView help(HttpServletRequest request, ModelAndView mv) {
		if(request.getParameter("id") != null) {
			mv.addObject("id", request.getParameter("id"));
			int id = Integer.parseInt(request.getParameter("id"));
			mv.addObject("desc", messages[id]);
		}
		mv.setViewName("help");
		return mv;	
	}	
	
	@RequestMapping("/about")
	public ModelAndView about(HttpServletRequest request, ModelAndView mv) {
//		if(request.getParameter("name") != null) {
//			mv.addObject("name", request.getParameter("name"));
//		}
		mv.setViewName("about");
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView home(HttpServletRequest request, ModelAndView mv) {
		if(request.getParameter("name") != null) {
			mv.addObject("name", request.getParameter("name"));
		}
		mv.setViewName("home");
		return mv;
	}

}
