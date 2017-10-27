package com.zhidi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 除了modelAndView和String外，其他的不能设置视图（即路径）
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/return1")
public class ModelAndViewController1 {

	@RequestMapping("/index1")
	public ModelAndView testModelAndView(ModelAndView mv){
		mv.addObject("stuname", "张三");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/map1")
	public Map<String,Object> map(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stuname", "沈鹏");
		map.put("sex", "不知道");
		return map;
	}
	
	@RequestMapping("/redirect1")
	public String refirect(){
		return "redirect:index.do";
	} 
}
