package com.zhidi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.zhidi.entity.User;

@Controller
@RequestMapping("/session")
//使用该注解要开始mvc注解驱动
@SessionAttributes("user")
public class SessionAttributeController {

	@RequestMapping("/login")
	public String login(Model model,User user){
		if (user != null && "asd".equals(user.getUsername()) && "123".equals(user.getPassword())){
			model.addAttribute(user);
			return "success";
		}
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/edit")
	public String edit(SessionStatus status){
		status.setComplete();
		return "success";
	}
}
