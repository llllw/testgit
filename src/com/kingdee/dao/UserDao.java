package com.kingdee.dao;

import com.google.code.morphia.Morphia;
import com.kingdee.domains.User;
import com.mongodb.Mongo;

public class UserDao extends BaseDao<User>{
	
	protected UserDao(Mongo mongo, Morphia morphia, String dbName)
	{
		super(mongo, morphia, dbName);
	}
	
	public void saveUser(User user) {
		this.save(user);
	}
}
