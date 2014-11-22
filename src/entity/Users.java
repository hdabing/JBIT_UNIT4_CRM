package entity;

import java.io.Serializable;

/**
 * 用户表
 * 
 * @author 陈捷
 * 
 */
@SuppressWarnings("serial")
public class Users implements Serializable {
	private int id;
	private String username;// 用户名
	private String password;// 密码
	private int roleid;// 角色id
	private int isdel;//是否删除  0未删除，1删除
	
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}
	

	public Role role;//角色类型

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

}
