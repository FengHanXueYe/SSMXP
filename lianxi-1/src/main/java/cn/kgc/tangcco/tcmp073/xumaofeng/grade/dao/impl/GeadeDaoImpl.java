package cn.kgc.tangcco.tcmp073.xumaofeng.grade.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.kgc.tangcco.tcmp073.xumaofeng.comm.JDBCUtils;
import cn.kgc.tangcco.tcmp073.xumaofeng.grade.dao.GeadeDao;
import cn.kgc.tangcco.tcmp073.xumaofeng.grade.entity.Grade;

public class GeadeDaoImpl implements GeadeDao{

	private QueryRunner qr;
	public GeadeDaoImpl() {
		qr = new QueryRunner(JDBCUtils.getDataSource());
	}
	
	@Override
	public List<Grade> queryAllGrade() {
		try {
			return this.qr.query("select * from grade", new BeanListHandler<>(Grade.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Grade> queryAllToStudent() {
		try {
			return this.qr.query("select * from grade", new BeanListHandler<>(Grade.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Grade detailGrade(String gradename) {
		try {
			return this.qr.query("select * from grade where gradeid=?", new BeanHandler<>(Grade.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addGrade(Grade grade) {
		try {
			return this.qr.update("insert into grade value(null,?)",grade.getGradename());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateGrade(Grade grade) {
		try {
			return this.qr.update("update grade set gradename=? where gradeid=?",grade.getGradename(),grade.getGradeid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteGrade(int gradeid) {
		Connection conn = JDBCUtils.getConnection();
		QueryRunner qre = new QueryRunner();
		try {
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(conn.TRANSACTION_READ_COMMITTED);
			String sql_student = "DELETE FROM score WHERE stuid IN(SELECT stuid FROM student WHERE gradeid=? )";
			String sql_source = "DELETE FROM student WHERE gradeid=?";
			String sql_grade = "DELETE FROM grade WHERE gradeid=?";
			qre.update(conn, sql_student, gradeid);
			qre.update(conn, sql_source, gradeid);
			qre.update(conn, sql_grade, gradeid);
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
	public int queryGradeCount() {
		try {
			return ((Long)this.qr.query("select count(*) from grade ", new ScalarHandler<>(1))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
