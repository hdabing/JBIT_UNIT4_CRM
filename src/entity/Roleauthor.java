package entity;

import java.io.Serializable;

/**
 * 角色权限表
 * @author 陈捷
 *
 */
@SuppressWarnings("serial")
public class Roleauthor implements Serializable{
	private int id;
	private int roleid;//角色id
	private int authorid;//权限id
	private int isdel;//是否删除  0未删除，1删除
	private Author author;//权限
	private Role role;//角色
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
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
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	
	
}
