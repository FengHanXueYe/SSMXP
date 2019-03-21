package cn.kgc.tangcco.tcmp073.xumaofeng.tbuser.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.xumaofeng.entity.TbUser;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbuser.mapper.TbUserMapper;
import cn.kgc.tangcco.tcmp073.xumaofeng.tbuser.service.TbUserService;
@Service
public class TbUserServiceImpl implements TbUserService{
	
	@Resource
	private TbUserMapper tbuser;
	
	@Override
	public TbUser login(TbUser user) {
		return tbuser.login(user);
	}
	
}
