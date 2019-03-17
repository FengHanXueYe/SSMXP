package cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.service.impl;

import java.util.List;

import cn.kgc.tangcco.tcmp073.xumaofeng.comm.properties.PropertiesFactory;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.dao.TbUserDao;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.entity.TbUser;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.service.UserService;

public class UserServiceImpl implements UserService{

	private TbUserDao dao ;

	public UserServiceImpl() {
		dao = (TbUserDao) PropertiesFactory.getInstance("userDao");
	}
	@Override
	public List<TbUser> queryAll(TbUser tu) {
		return dao.queryAll(tu);
	}

	@Override
	public int insertUser(TbUser tu) {
		return dao.insertUser(tu);
	}

	@Override
	public int updateUser(TbUser tu) {
		return dao.updateUser(tu);
	}

	@Override
	public int deleteUser(int userid) {
		return dao.deleteUser(userid);
	}

	@Override
	public TbUser queryUserOne(int pk) {
		return dao.queryUserOne(pk);
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TbUser login(TbUser tu) {
		return dao.login(tu);
	}

}
