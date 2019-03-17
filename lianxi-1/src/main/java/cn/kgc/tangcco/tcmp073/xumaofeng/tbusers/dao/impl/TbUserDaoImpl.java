package cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.kgc.tangcco.tcmp073.xumaofeng.comm.JDBCUtils;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.dao.TbUserDao;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.entity.TbUser;

public class TbUserDaoImpl  implements TbUserDao{
	//创建QueryRunner 对象
	private QueryRunner qr;
	//得到数据源
	public TbUserDaoImpl() {
		qr =new QueryRunner(JDBCUtils.getDataSource());
	}
	
	//查询全部的方法
	@Override
	public List<TbUser> queryAll(TbUser tu) {
		String sql = "select * from tbuser where 1=1";
		List<Object> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		sb.append(sql);
		if(tu.getUsername()!=null && !tu.getUsername().isEmpty()) {
			sb.append(" and username like ?");
			list.add("%"+tu.getUsername()+"%");
		}
		if(tu.getUserroles()!=null && !tu.getUserroles().isEmpty()) {
			sb.append(" and userroles = ?");
			list.add(tu.getUserroles());
		}
		sb.append(" order by userid desc");
		sql = sb.toString();
		System.err.println("=========>"+sql);
		try {
			return this.qr.query(sql,new BeanListHandler<>(TbUser.class),list.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//增加的方法；
	@Override
	public int insertUser(TbUser tu) {
		//"insert into tbuser value(null,?,?,?,?,?,?,?)", new Object[] {tu.getUsername(),tu.getPassword(),tu.getUserroles(),tu.getNickname(),tu.getRgtime(),tu.getEmail(),tu.getTel()}
		try {
			return this.qr.update("insert into tbuser value(null,?,?,?,?)", new Object[] {tu.getUsername(),tu.getPassword(),tu.getUserroles(),tu.getNickname()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//修改的方法
	@Override
	public int updateUser(TbUser tu) {
		try {
			
			//return this.qr.update("update tbuser set username=?,password=?,userroles=?,nickname=?,regtime=?,email=?,tel=? where userid=?",new Object[] {tu.getUsername(),tu.getPassword(),tu.getUserroles(),tu.getNickname(),tu.getRgtime(),tu.getEmail(),tu.getTel(),tu.getUserid()});
			return this.qr.update("update tbuser set username=?,password=?,userroles=?,nickname=? where userid=?",new Object[] {tu.getUsername(),tu.getPassword(),tu.getUserroles(),tu.getNickname(),tu.getUserid()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//删除的方法
	@Override
	public int deleteUser(int userid) {
		try {
			return this.qr.update("delete from tbuser where userid=?",userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//查询一个
	@Override
	public TbUser queryUserOne(int pk) {
		try {
			return this.qr.query("select * from tbuser where userid=?",new BeanHandler<>(TbUser.class),pk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//查询数据的数量
	@Override
	public int queryCount() {
		try {
			return ((Long)this.qr.query("select count(*) from tbuser",new ScalarHandler<>(1))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//登陆的方法
	@Override
	public TbUser login(TbUser tu) {
		try {
			return this.qr.query("select * from tbuser where username=? and password=?",new BeanHandler<>(TbUser.class),tu.getUsername(),tu.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
