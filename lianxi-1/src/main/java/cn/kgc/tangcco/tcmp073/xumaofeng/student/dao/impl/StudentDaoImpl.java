package cn.kgc.tangcco.tcmp073.xumaofeng.student.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.kgc.tangcco.tcmp073.xumaofeng.comm.JDBCUtils;
import cn.kgc.tangcco.tcmp073.xumaofeng.grade.entity.Grade;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.dao.StudentDao;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.entity.Student;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.vo.StudentVO;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.vo.StudentVO1;
import cn.kgc.tangcco.tcmp073.xumaofeng.student.vo.StudentVO2;

public class StudentDaoImpl implements StudentDao{

	
	private QueryRunner qr;
	public StudentDaoImpl() {
		qr = new QueryRunner(JDBCUtils.getDataSource());
	}
	
	@Override
	public List<Student> queryAllStudent() {
		try {
			return this.qr.query("select * from student", new BeanListHandler<>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<StudentVO1> queryAllStudentVO1() {
		try {
			return this.qr.query("SELECT g.`gradename`,s.* FROM student s,grade g WHERE s.`gradeid`=g.`gradeid`",new BeanListHandler<>(StudentVO1.class));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public List<StudentVO2> queryAllStudentVO2() {
		try {
			return this.qr.query("SELECT g.`gradename`,s.* FROM student s,grade g WHERE s.`gradeid`=g.`gradeid`", new BeanListHandler<>(StudentVO2.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student detailStudent(int pk) {
		try {
			return this.qr.query("select * from student where stuid=?", new BeanHandler<>(Student.class),1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		return null;
	}

	@Override
	public int addStudennt(Student stu) {
		try {
			return this.qr.update("insert into student value(null,?,?,?,?,?)",new Object[] {stu.getGradeid(),stu.getStuname(),stu.getGender(),stu.getStuname(),stu.getAge()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudent(Student stu) {
		try {
			return this.qr.update("update student set gradeid=?,stuname=?,gender=?,stunum=?,age=? where stuid=?",new Object[] {stu.getGradeid(),stu.getStuname(),stu.getGender(),stu.getStuname(),stu.getAge(),stu.getStuid()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteStudent(int pk) {
		Connection conn = JDBCUtils.getConnection();
		QueryRunner qre = new QueryRunner();
		try {
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(conn.TRANSACTION_READ_COMMITTED);
			String sql_score = "delete from score where stuid=?";
			String sql_student = "delete from student where stuid=?";
			qre.update(conn, sql_score, pk);
			qre.update(conn, sql_student, pk);
			conn.commit();
			return 1;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int queryCountStudent() {
		try {
			return ((Long)this.qr.query("select count(*) from student",new ScalarHandler<>(1))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//最正确的方法
	@Override
	public List<StudentVO> queeryAllStudentVO() {
		List<StudentVO> voList = new ArrayList<>();
		String sql_student = "select * from student order by stuid";
		String sql_grade = "select * from grade where gradeid=?";
		try {
			List<Student> stu = this.qr.query(sql_student, new BeanListHandler<>(Student.class) );
			StudentVO stuVo = null;
			for(Student s : stu) {
				stuVo = new StudentVO();
				stuVo.setStudent(s);
				Grade grade = this.qr.query(sql_grade, new BeanHandler<>(Grade.class),s.getGradeid());
				stuVo.setGradename(grade.getGradename());
				voList.add(stuVo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	
}
