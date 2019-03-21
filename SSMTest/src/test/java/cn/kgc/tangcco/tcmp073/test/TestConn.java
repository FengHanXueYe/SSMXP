package cn.kgc.tangcco.tcmp073.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class TestConn {
	
	@Resource
	private DataSource dataSource;
	
	@Test
	public void testConn() {
		try {
			Connection conn = dataSource.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
