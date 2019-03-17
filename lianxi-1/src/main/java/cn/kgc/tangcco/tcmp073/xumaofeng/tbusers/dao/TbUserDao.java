package cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.dao;

import java.util.List;

import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.entity.TbUser;

public interface TbUserDao {

	List<TbUser> queryAll(TbUser tu);
	
	int insertUser(TbUser tu);
	
	int updateUser(TbUser tu);
	
	int deleteUser(int userid);
	
	TbUser queryUserOne(int pk);
	
	int queryCount();
	
	TbUser login(TbUser tu);
	
}
