package com.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * 如何获得 整个spring容器  因为spring 容器是由litener启动的 项目启动相应的类就保存了获得容器的方法
 */
@Component
public class ContextUtils implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (ContextUtils.applicationContext == null) {
			ContextUtils.applicationContext = applicationContext;
		}
	}
	//获取applicationContext
	public static ApplicationContext getSpringMVCContext() {
		return applicationContext;
	}

//	public static WebApplicationContext getSpringMVCContext() {
//		WebApplicationContext rootWac = ContextLoader.getCurrentWebApplicationContext();
//		// 获取servletContext
//		System.out.println(rootWac+"ddddd");
//		ServletContext servletContext = rootWac.getServletContext();
//		// 获取子容器，名字最后对应servlet名字
//		// 1.查看spring容器中的对象名称
//		String[] beannames = rootWac.getBeanDefinitionNames();
//		for (String beanname : beannames) {
//			// System.out.println(beanname);
//		}
//		// System.out.println(servletContext);
//
//		// 2.查看servlet中容器列表
//		Enumeration<String> servletnames = servletContext.getAttributeNames();
//		while (servletnames.hasMoreElements()) {
//			System.out.println(servletnames.nextElement());
//		}
//		WebApplicationContext springmvc = WebApplicationContextUtils.getWebApplicationContext(servletContext,
//				"org.springframework.web.servlet.FrameworkServlet.CONTEXT.SpringMVC");
//		System.out.println(springmvc + "eee");
//		return springmvc;
//	}

	public static ServletContext getSpringContext() {
		WebApplicationContext rootWac = ContextLoader.getCurrentWebApplicationContext();
		// 获取servletContext
		// System.out.println(rootWac+"ddddd");
		ServletContext servletContext = rootWac.getServletContext();
		return servletContext;
	}

}
