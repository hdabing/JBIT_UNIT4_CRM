package entity;

import java.io.Serializable;

/**
 * 地区表
 * 
 * @author 陈捷
 * 
 */
@SuppressWarnings("serial")
public class Area  implements Serializable{
	private int id;
	private String name;// 地区名称
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
