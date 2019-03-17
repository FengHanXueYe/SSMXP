package cn.kgc.tangcco.tcmp073.xumaofeng.comm;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.util.Properties;



import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	private static  DataSource datasource;
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	static {
		datasource = new ComboPooledDataSource("myc3p0xml");
	}
	public static DataSource getDataSource() {
		return datasource;
	}
	public static Connection getConnection() {
		Connection conn = tl.get();
		if(conn==null) {
			try {
				conn = datasource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			tl.set(conn);
		}
		
		return conn;
	}
	
	
	
	
	
	private Properties properties;
	private static JDBCUtils jdbcutils;
	private JDBCUtils(){
		InputStream in = this.getClass().getResourceAsStream("/applicationContext.propersties");
		properties = new Properties();
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static JDBCUtils getInstance() {
		if(jdbcutils==null) {
			jdbcutils = new JDBCUtils();
		}
		return jdbcutils;
	}
	public String getValue(String key) {
		return properties.getProperty(key);
	}
	
	
	
	
}
