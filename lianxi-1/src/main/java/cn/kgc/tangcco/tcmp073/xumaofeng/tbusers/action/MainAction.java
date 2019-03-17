package cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.tcmp073.xumaofeng.comm.base.servlet.BaseServlet;

@WebServlet(name="MainAction",urlPatterns="/main.action")
public class MainAction extends BaseServlet{

	
	public String top(HttpServletRequest request, HttpServletResponse response) {
		return "main/top";
	}
	public String left(HttpServletRequest request, HttpServletResponse response) {
		return "main/left";
	}
	public String right(HttpServletRequest request, HttpServletResponse response) {
		return "main/right";
	}
	public String bottom(HttpServletRequest request, HttpServletResponse response) {
		return "main/bottom";
	}
	
	
	
}
