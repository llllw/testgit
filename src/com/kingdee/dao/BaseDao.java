package com.kingdee.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.query.Query;

import com.mongodb.Mongo;

import com.kingdee.domains.BaseEntity;

public class BaseDao extends BasicDAO<BaseEntity, ObjectId> {
	
	private Datastore dt;
	
	protected BaseDao(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);
		dt = morphia.createDatastore(mongo, dbName);
	}
 
	public List<? extends BaseEntity> findAll(Class<? extends BaseEntity> clazz) {
		return dt.find(clazz).asList();
	}
 
 
	public List<? extends BaseEntity> findById(Class<? extends BaseEntity> clazz, Object id) {
		Query<? extends BaseEntity> query = dt.createQuery(clazz);
		query.filter("_id", id);
		return query.asList();
	}
 
	protected Query<? extends BaseEntity> createQuery(Class<? extends BaseEntity> clazz){
		return dt.createQuery(clazz);
	}
 
	public void update(Object object) {
		dt.save(object);
	}
 
	public void deleteAll(Class<? extends BaseEntity> clazz) {
		Query<? extends BaseEntity> query = this.createQuery(clazz);
		dt.delete(query);
	}

}
