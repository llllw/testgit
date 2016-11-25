package com.kingdee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingdee.dao.BaseDao;
import com.kingdee.domains.User;

@Service
public class UserService
{
	@Autowired
	private BaseDao baseDao;

	public void saveUser(User user) {
		baseDao.save(user);
	} 
}
