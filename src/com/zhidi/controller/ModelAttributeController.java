package com.zhidi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhidi.entity.Student;

@Controller
@RequestMapping("/model")
public class ModelAttributeController {

	@ModelAttribute("stu")
	public Student getStudent(){
		Student stu = new Student();
		stu.setId(1);
		stu.setName("张三");
		return stu;
	}
	
	@RequestMapping("/index")
	public String testModel(@ModelAttribute("stu1") Student stu1){
		stu1.setName("沈鹏");
		return "index";
	}
}
