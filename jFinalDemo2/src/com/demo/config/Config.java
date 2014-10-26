package com.demo.config;

import com.demo.controller.UserController;
import com.demo.model.User;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;

public class Config extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		loadPropertyFile("a_little_config.txt");
		me.setDevMode(getPropertyToBoolean("devMode", true));
		me.setViewType(ViewType.JSP);
	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("contextPath"));
	}

	@Override
	public void configInterceptor(Interceptors me) {
		
	}

	@Override
	public void configPlugin(Plugins me) {
		String username = getProperty("user");
		String password = getProperty("password");
		DruidPlugin druidPlugin = new DruidPlugin(getProperty("jdbcUrl"), username, password);
		me.add(druidPlugin);//添加连接池
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		me.add(arp);//添加插件
		arp.addMapping("t_user","user_id", User.class);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/user", UserController.class);
	}

}
