package entity;

import java.io.Serializable;

/**
 * 服务类型表
 * @author 陈捷
 *
 */
@SuppressWarnings("serial")
public class Service implements Serializable {
	private int id;
	private String name;//服务类型名称
	private int isdel;//是否删除  0未删除，1删除
	
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
