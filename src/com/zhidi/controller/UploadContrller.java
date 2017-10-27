package com.zhidi.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadContrller {

	@RequestMapping("/upload")
	public String upload(){
		return "upload/upload";
	}
	
	@RequestMapping("/success")
	public String uploadSuccess(MultipartFile file) throws IllegalStateException, IOException{
		if (file != null){
			
			String name = file.getName();
			System.out.println(name);
			//获取文件格式、类型
			String contentType = file.getContentType();
			System.out.println(contentType);
			//获取文件真实名称
			String realName = file.getOriginalFilename();
			System.out.println(realName);
			
			File file1 = new File("E:/upload");
			//如果该文件夹存在就不创建，否则创建一个新的文件夹
			if (!file1.exists()){
				file1.mkdir();
			}
			//将上传的文件保存到本地地址中
			file.transferTo(new File(file1, realName));
		}
		return "upload/upload_success";
	}
	
	@RequestMapping("/success1")
	public String success(MultipartFile file ,HttpServletRequest req) throws IllegalStateException, IOException{
		if (file != null){
			
			//获取文件类型
			String type = file.getContentType();

			//获取文件真实名称
			String realName = file.getOriginalFilename();
			
			String savePath = req.getServletContext().getRealPath("/upload");
			
			File file1 = new File(savePath);
			
			if (!file1.exists()){
				file1.mkdirs();
			}
			//保存文件
			file.transferTo(new File(file1,realName));
			
			//将上传下来的文件路径传到前台并在前台获取
			req.setAttribute("path", req.getContextPath()+"/upload/"+realName);
		}
		return "upload/upload_success";
	}
}
