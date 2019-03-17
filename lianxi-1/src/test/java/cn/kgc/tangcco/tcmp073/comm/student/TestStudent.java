package cn.kgc.tangcco.tcmp073.comm.student;

import org.junit.Test;

import cn.kgc.tangcco.tcmp073.xumaofeng.student.dao.StudentDao;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.dao.impl.StudentDaoImpl;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.entity.Student;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.vo.StudentVO1;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.vo.StudentVO2;

public class TestStudent {

	private StudentDao dao;
	public TestStudent() {
		dao = new StudentDaoImpl();
	}
	
	@Test
	public void testQueryAllStudentVO1() {
		//System.out.println(dao.queryAllStudentVO1());
		for(StudentVO1 v : dao.queryAllStudentVO1()) {
			System.out.println(v);
		}
	}
	
	
	@Test
	public void testQueryAllStudentVO2() {
		for(StudentVO2 v : dao.queryAllStudentVO2()) {
			System.out.println(v);
		}
	}
	
	@Test
	public void testQA() {
		System.out.println(dao.queryAllStudent());
	}
	
	
	@Test
	public void testAddS() {
		System.out.println(dao.addStudennt(new Student(null,1,111,"张三","01","123")));
	}
	
	@Test
	public void testCount() {
		System.out.println(dao.queryCountStudent());
	}
	
	@Test
	public void testUpdS() {
		System.out.println(dao.updateStudent(new Student(15,1,123,"哈啊","02","123123")));
	}
	@Test
	public void testDelS() {
		System.out.println(dao.deleteStudent(21));
	}
}
