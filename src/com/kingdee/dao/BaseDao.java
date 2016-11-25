package com.kingdee.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.query.Query;
import com.mongodb.Mongo;
import com.kingdee.domains.BaseEntity;

public class BaseDao<T extends BaseEntity> extends BasicDAO<BaseEntity, ObjectId> {
	
	private Datastore dt;
	
	protected BaseDao(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);
		dt = morphia.createDatastore(mongo, dbName);
	}
 
	public List<T> findAll(Class<T> clazz) {
		return dt.find(clazz).asList();
	}
 
	@SuppressWarnings("all")
	public Class<BaseEntity> getEntityClass() {
		Class<? extends BaseDao> c = this.getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            return (Class<BaseEntity>) p[0];
		}
		return null;
	}
	
	public List<T> findById(Class<T> clazz, Object id) {
		Query<T> query = dt.createQuery(clazz);
		query.filter("_id", id);
		return query.asList();
	}
 
	protected Query<T> createQuery(Class<T> clazz){
		return dt.createQuery(clazz);
	}
 
	public void update(Object object) {
		dt.save(object);
	}
 
	public void deleteAll(Class<T> clazz) {
		Query<T> query = this.createQuery(clazz);
		dt.delete(query);
	}

}
