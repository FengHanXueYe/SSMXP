package cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.action;

import java.lang.reflect.InvocationTargetException;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.kgc.tangcco.tcmp073.xumaofeng.comm.base.servlet.BaseServlet;
import cn.kgc.tangcco.tcmp073.xumaofeng.comm.properties.PropertiesFactory;
import cn.kgc.tangcco.tcmp073.xumaofeng.comm.utils.BeanUtil;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.entity.TbUser;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.service.UserService;
@WebServlet(name="TbUserAction",urlPatterns="/tbuser.action")
public class TbUserAction extends BaseServlet{

	private UserService dao;
	public TbUserAction() {
		dao = (UserService) PropertiesFactory.getInstance("userServices");
	}
	
	//登录的方法
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String url = "";
		Map<String,String[]> propertiesMap = request.getParameterMap();
		for(Map.Entry<String, String[]> m : propertiesMap.entrySet() ) {
			String key = m.getKey();
			String[] values=m.getValue();
			for(String v : values) {
				System.out.println(key+"\t"+v);
			}			
		}
		
		TbUser tu = new TbUser();
		try {
			BeanUtils.populate(tu, propertiesMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		TbUser u = this.dao.login(tu);
		System.out.println(u);
		HttpSession session = request.getSession();
		if(u!=null) {
			session.setAttribute("zlj", u);
			url = "main/main";
		}else {
			request.setAttribute("logins", "登录失败，您的用户名或密码错误！");
			url = "index";
		}
		return url; 
	}
	//查询全部的方法
	public String queryAllUser(HttpServletRequest request, HttpServletResponse response) {
		
		TbUser tu = new TbUser();
		String username = request.getParameter("username");
		if(username!=null && !username.isEmpty()) {
			tu.setUsername(request.getParameter("username"));
		}
		tu.setUserroles(request.getParameter("userroles"));
		request.setAttribute("list", dao.queryAll(tu));
		return "user/listUser";
	}
	//查看的方法	
	public String doSelectUser(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("su",dao.queryUserOne(Integer.parseInt(request.getParameter("userid"))));
		return "user/selectUser";
		
	}
	//跳转增加页面的方法
	public String toAddUser(HttpServletRequest request, HttpServletResponse response) {
		return "user/addUser";
	}
	//增加的方法
	public String doAddUser(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String,String[]> parameterMap = request.getParameterMap();
		System.out.println("**********");
		for(Map.Entry<String,String[]> m : parameterMap.entrySet()) {
			String key = m.getKey();
			String[] values = m.getValue();
			for(String v : values) {
				System.out.println(key+"\t"+v);
			}
			
		}
		System.out.println("**********");
		TbUser user = new TbUser();
		BeanUtil.paraMap(user, parameterMap);
		int zhi = dao.insertUser(user);
		request.setAttribute("rows", zhi);
		return "tbuser.action?method=queryAllUser";
	}
	
	
	//跳转修改页面的方法
	public String toUpdateUser(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", dao.queryUserOne(Integer.parseInt(request.getParameter("userid"))));
		return "user/updateUser";
	}
	//修改的方法
	public String doUpdateUser(HttpServletRequest request, HttpServletResponse response) {
		Map<String,String[]> parameterMap = request.getParameterMap();
		for(Map.Entry<String,String[]> m : parameterMap.entrySet()) {
			String key = m.getKey();
			String[] values = m.getValue();
			for(String v : values) {
				System.out.println(key+"\t"+v);
			}
			
		}
		TbUser user = new TbUser();
		BeanUtil.paraMap(user, parameterMap);
		dao.updateUser(user);
		return "tbuser.action?method=queryAllUser";
	}
	//删除的方法
	public String doDeleteUser(HttpServletRequest request, HttpServletResponse response) {
		
		dao.deleteUser(Integer.parseInt(request.getParameter("userid")));
		return "tbuser.action?method=queryAllUser";
	}
	
	
	
}
