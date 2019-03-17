package cn.kgc.tangcco.tcmp073.xumaofeng.comm.base.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="BaseServlet",urlPatterns="/base.action")
public class BaseServlet extends HttpServlet{

	public String prefix() {
		return "/WEB-INF/jsp/";
	}
	public String suffix() {
		return ".jsp";
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		System.out.println(methodName);
		String forward = "index"+suffix();
		String result = "";
		if(methodName==null || methodName.isEmpty()) {
			request.getRequestDispatcher(forward).forward(request, response);
		}else {
			Method method;
			try {
				method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
				System.out.println(method+"*********");
				forward = (String) method.invoke(this, request,response);
				
				if(methodName.startsWith("doAdd")||methodName.startsWith("doUpdate")||methodName.startsWith("doDelete")) {
					response.sendRedirect(forward);
				}else {
					result = prefix()+forward+suffix();
					request.getRequestDispatcher(result).forward(request, response);
				}
				
				
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
