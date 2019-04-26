package com.hrms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.model.Employee;
import com.hrms.model.Manager;




public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}
	/**
	 * 登录校验
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse) response;
		String url = req.getRequestURI().toString();
		if(url.endsWith("login.jsp")||url.endsWith("login_employee.jsp")||url.endsWith(".eot")||url.endsWith(".woff")||url.endsWith(".woff2")||url.endsWith(".svg")||url.endsWith(".ttf")||url.endsWith("login")||url.endsWith(".css")||url.endsWith(".scss")||url.endsWith(".png")||url.endsWith(".less")||url.endsWith(".json")||url.endsWith(".js")||url.endsWith(".jpg")){
			chain.doFilter(req, res);
		}else{
			HttpSession s=req.getSession();
			Manager m=(Manager) s.getAttribute("manager");
			Employee e=(Employee) s.getAttribute("employee");
			if(m==null & e==null){//重定向到登录页面
				res.sendRedirect(req.getContextPath()+"/login.jsp");
			}
			else{
				chain.doFilter(req, res);
			}
			
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	
}
