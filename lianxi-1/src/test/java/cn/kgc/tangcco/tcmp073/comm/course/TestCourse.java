package cn.kgc.tangcco.tcmp073.comm.course;

import org.junit.Test;

import cn.kgc.tangcco.tcmp073.xumaofeng.comm.properties.PropertiesFactory;
import cn.kgc.tangcco.tcmp073.xumaofeng.course.dao.CourseDao;
import cn.kgc.tangcco.tcmp073.xumaofeng.course.dao.impl.CourseDaoImpl;

public class TestCourse {

	private CourseDao dao;
	public TestCourse() {
		dao = new CourseDaoImpl();
	}
	
	@Test
	public void testCourse() {
		System.out.println(dao.deleteCourse(5));
		
	}
	
	
}
