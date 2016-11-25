package com.kingdee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingdee.dao.UserDao;
import com.kingdee.domains.User;

@Service
public class UserService
{
	@Autowired
	private UserDao UserDao;

	public void saveUser(User user) {
		UserDao.saveUser(user);
	} 
}
