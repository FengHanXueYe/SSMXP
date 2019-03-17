package cn.kgc.tangcco.tcmp073.comm.grade;

import org.junit.Before;
import org.junit.Test;

import cn.kgc.tangcco.tcmp073.xumaofeng.comm.JDBCUtils;
import cn.kgc.tangcco.tcmp073.xumaofeng.grade.dao.GeadeDao;
import cn.kgc.tangcco.tcmp073.xumaofeng.grade.dao.impl.GeadeDaoImpl;
import cn.kgc.tangcco.tcmp073.xumaofeng.grade.entity.Grade;

public class TestGrade {

	private GeadeDao dao;
	


	@Before
	public void init() {
		dao = new GeadeDaoImpl();
	}
	
	
	@Test
	public void testQueryAllG() {
		System.out.println(dao.queryAllGrade());
	}
	@Test
	public void testQueryAllGTS() {
		System.out.println(dao.queryAllToStudent());
	}
	
	@Test
	public void testQueryGC() {
		System.out.println(dao.queryGradeCount());
	}
	@Test
	public void testAddG() {
		System.out.println(dao.addGrade(new Grade(null,"哈哈班")));
	}
	
	@Test
	public void testUpdG() {
		System.out.println(dao.updateGrade(new Grade(11,"嘻嘻")));
	}
	
	@Test
	public void testDelG() {
		System.out.println(dao.deleteGrade(13));
		
	}
	
	
	
}
