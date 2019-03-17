package cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.service;

import java.util.List;

import cn.kgc.tangcco.tcmp073.xumaofeng.tbusers.entity.TbUser;

public interface UserService {

	List<TbUser> queryAll(TbUser tu);

	int insertUser(TbUser tu);

	int updateUser(TbUser tu);

	int deleteUser(int userid);

	TbUser queryUserOne(int pk);

	int queryCount();

	TbUser login(TbUser tu);
}
