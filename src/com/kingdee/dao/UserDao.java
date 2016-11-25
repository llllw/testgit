package com.kingdee.dao;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

public class UserDao extends BaseDao{

	protected UserDao(Mongo mongo, Morphia morphia, String dbName)
	{
		super(mongo, morphia, dbName);
	}


}
