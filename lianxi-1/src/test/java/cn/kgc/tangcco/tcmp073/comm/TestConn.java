package cn.kgc.tangcco.tcmp073.comm;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import cn.kgc.tangcco.tcmp073.xumaofeng.comm.JDBCUtils;
import cn.kgc.tangcco.tcmp073.xumaofeng.comm.properties.PropertiesFactory;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.dao.TbUserDao;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.dao.impl.TbUserDaoImpl;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.entity.TbUser;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.service.UserService;

public class TestConn {
	
	//private TbUserDao tbuser;
	private UserService us;
	@Before
	public void init() {
		us = (UserService) PropertiesFactory.getInstance("userServices");
	}
	
	@Test
	public void getConn() {
		if(JDBCUtils.getConnection()==null)System.out.println("错了");
		else System.out.println(JDBCUtils.getConnection());
			
	}
	
	/*	@Test
	public void testQueryAll() {
		for(TbUser t : us.queryAll()) {
			System.out.println(t);
			
		}
	}
	*/
	@Test
	public void testInsert() {
		Date time=Date.valueOf("2015-11-11");
		System.out.println(us.insertUser(new TbUser("哈哈","123","01","哈哈哈","123@qq.com","15833333333",time)));
	}
	
	@Test
	public void updateUser() {
		Date time=Date.valueOf("2015-11-11");
		System.out.println(us.updateUser(new TbUser(1,"嘻嘻","111","11","11","11","11",time)));
	}
	
	@Test
	public void testDel() {
		System.out.println(us.deleteUser(5));
	}
	
	
	@Test
	public void queryOne() {
		System.out.println(us.queryUserOne(7));
	}
	
	
	@Test
	public void userCount() {
		System.out.println(us.queryCount());
	}
	
	@Test
	public void login() {
		TbUser tb = new TbUser("chashuo","1234");
		System.out.println(us.login(tb));
	}
}
