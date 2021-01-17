package com.exception;

import com.dto.BaseDto;
import com.dto.MessageEnum;


import org.springframework.dao.RecoverableDataAccessException;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

//import org.apache.shiro.authz.UnauthorizedException;

//import org.apache.shiro.authz.UnauthorizedException;

//spring会在容器中找 那个bean实现了HandlerExceptionResolver 异常解析器  把所有的异常都交给他处理
//处理就是将认识的异常的信息 转换成对应中文的 自定义异常 再处理
@ControllerAdvice
public class CustomExceptionResolver{
	static Map<Class,String> exceptionMap = new HashMap<Class,String>();
	static Map<Class,String> redirectExceptionMap = new HashMap<>();
	//如果认识一些系统异常，将异常转换为自定义异常输出，目的是将异常的提示信息换成中文输出
	static{
		exceptionMap.put(CustomException.class,"");
		//exceptionMap.put(MySQLIntegrityConstraintViolationException.class,"添加失败，已存在");
		exceptionMap.put(RecoverableDataAccessException.class,"数据库异常，请联系管理员");
		//exceptionMap.put(CommunicationsException.class,"数据库异常，请联系管理员");
		exceptionMap.put(ConnectException.class,"数据库异常，请联系管理员");
		exceptionMap.put(NumberFormatException.class,"数字不正确，非法操作");
		//exceptionMap.put(UnauthorizedException.class,"权限不足");

	}
	//spring 获取到异常就会 调用 下面的resolveException 来处理异常

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public BaseDto resolveExceptionProcess(HttpServletRequest request, HttpServletResponse response, Object obj,
										   Exception ex) {
		CustomException ce = changeToCustomException(ex);
		System.out.println(ce.getMessage());//服务器查看一下异常信息，后面换成日志输出
		BaseDto dto = new BaseDto(409,ce.getMessage(),"error");//返回的dto对象的msg由自定义exception提供
		return dto;

	}

	/**
	 * 将系统异常转为自定义异常就是在  我们的方法 可能抛出2种异常一种 其它框架提供的异常（IOException，MyBatisSystemException） 还有我们已经自定义的异常（PWDEXCEPTION 密码错误异常）  首先判断跑出来的是不是自定异常，尝试转换为自定异常 尝试失败说明是 其它框架提供的异常然后在预先认识的map找 找到了 生成自定义异常 提示信息为 预先设置好的，找不到 也生成自定义异常只不过，提示信息为未知异常
	 * @param ex
	 * @return
	 */
	public CustomException  changeToCustomException(Exception ex){
//		for(Map.Entry<Class,String> entry:exceptionMap.entrySet()){
//			System.out.println(entry.getKey().getName() +  "   "+ ex.getClass().getName());
//		}
//		System.out.println("-----------------------------");
//       ex.printStackTrace();
//		System.out.println("-----------------------------");
		CustomException ce;
		if(ex instanceof CustomException){//instanceof 尝试转换是不是自定义异常 如果是 直接转换 如果不是说明是其它框架提供的异常 所以 需要到map中去匹配换成中文提示
			ex.printStackTrace();
			ce = (CustomException)ex;
			System.out.println("custom");
		}else {//else成立说明 不是自定义异常 是其它框架提供的异常所以 异常信息需要转换
			ex.printStackTrace();
			String msg = exceptionMap.get(ex.getClass());//如果在map中找到了对应的异常类型，得到中文提示信息
			System.out.println(msg+"------------------------");
			msg = Optional.ofNullable(msg).orElse("未知异常");
			ce = new CustomException(msg);
		}
		return ce;
	}



	//自定义条件表达式 可以传参比较
	static class MyPredicate implements Predicate<MessageEnum> {
		String msg;
		public MyPredicate(String msg) {// 利用构造 传递自己相传的参数
			super();
			this.msg = msg;
		}
		@Override
		public boolean test(MessageEnum messageEnum) {// 集合循环产生 自动填入
			System.out.println(msg+ "  "+ messageEnum.getMessage());
			return msg.indexOf(messageEnum.getMessage()) >= 0 ? true : false;
		}

	}
}