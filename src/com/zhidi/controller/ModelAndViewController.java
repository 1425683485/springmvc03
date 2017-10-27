package com.zhidi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/return")
public class ModelAndViewController {

	/**
	 * 当返回的是ModelMap和Map集合时，会跳转到前缀+当前控制器的路径+当前方法的路径+后缀
	 * @param mm
	 * @return
	 */
	@RequestMapping("/modelView")
	public ModelMap testModelMap(ModelMap mm){
		mm.addAttribute("stuname", "沈鹏");
		mm.addAttribute("sex","不确定");
		return mm;
	}
	
	@RequestMapping("/index")
	public ModelAndView testModelAndView(ModelAndView mv){
		mv.addObject("stuname", "张三");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/map")
	public Map<String,Object> map(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stuname", "沈鹏");
		map.put("sex", "不知道");
		return map;
	}
	
	@RequestMapping("/redirect")
	public String refirect(){
		return "redirect:/return1/index1.do";
	} 
	
	@RequestMapping("/forward")
	public String forward(){
		return "forward:index.do";
	}
}
