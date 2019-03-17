package cn.kgc.tangcco.tcmp073.xumaofeng.student.dao;

import java.util.List;

import cn.kgc.tangcco.tcmp073.xumaofeng.student.entity.Student;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.vo.StudentVO;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.vo.StudentVO1;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.vo.StudentVO2;

public interface StudentDao {

	List<Student> queryAllStudent();
	
	List<StudentVO> queeryAllStudentVO();
	
	List<StudentVO1> queryAllStudentVO1();
	
	List<StudentVO2> queryAllStudentVO2();
	
	Student detailStudent(int pk);

	int addStudennt(Student stu);
	
	int updateStudent(Student stu);
	
	int deleteStudent(int pk);
	
	int queryCountStudent();
	
	
}
