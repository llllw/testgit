package com.kingdee.domains;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = -6867082518217912394L;
	@Id
	private ObjectId id;
	private Date createTime; //创建时间
	private Date UpdateTime; // 更新时间
	
	public ObjectId getId() {
		return id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	
	
}
