package cn.kgc.tangcco.tcmp073.xumaofeng.course.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.kgc.tangcco.tcmp073.xumaofeng.comm.JDBCUtils;
import cn.kgc.tangcco.tcmp073.xumaofeng.comm.properties.PropertiesFactory;
import cn.kgc.tangcco.tcmp073.xumaofeng.course.dao.CourseDao;

public class CourseDaoImpl implements CourseDao{

	private QueryRunner qr;
	public CourseDaoImpl() {
		qr = new QueryRunner(JDBCUtils.getDataSource());
	}
	
	@Override
	public int deleteCourse(int pk) {
		Connection conn = JDBCUtils.getConnection();
		QueryRunner qre = new QueryRunner();
		
		try {
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(conn.TRANSACTION_READ_COMMITTED);
			
			String sql_score = "delete from score where courseid=?";
			String sql_course = "delete from course where courseid=?";
			qre.update(conn,sql_course,pk);
			qre.update(conn,sql_score,pk);
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

}
