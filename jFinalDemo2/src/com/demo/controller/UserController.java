package com.demo.controller;

import java.util.List;

import com.demo.interceptor.UserInterceptor;
import com.demo.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class UserController extends Controller{
	
	public void index(){
		String sql = "select * from t_user";
		List<User> userList = User.userDao.find(sql);
		this.setAttr("userList", userList);
		renderJsp("showUser.jsp");
	}
	
	public void toAddUser(){
		renderJsp("addUser.jsp");
	}
	
	@Before(UserInterceptor.class)
	public void addUser(){
		User user = new User();
		user = this.getModel(User.class);
		boolean flag = user.save();//主键名称不为id时需要再映射时设置主键名
		if(flag){
			this.setAttr("msg", "success!");
		}else {
			this.setAttr("msg", "error!");
		}
		redirect("/user/");
	}
	
	public void toUpdateUser(){
		
	}
	
	public void updateUser(){
	}
	
	public void deleteUser(){
		
	}
}
