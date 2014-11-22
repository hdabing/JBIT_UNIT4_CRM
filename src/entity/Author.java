package entity;

import java.io.Serializable;

/**
 * 权限表
 * 
 * @author 陈捷
 * 
 */
@SuppressWarnings("serial")
public class Author implements Serializable {
	private int id;
	private String code;//权限编码，对应主页菜单的javascript编码
	private String name;// 权限名称
	private int authorlevel;//权限等级，用来打印空格数

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAuthorlevel() {
		return authorlevel;
	}

	public void setAuthorlevel(int authorlevel) {
		this.authorlevel = authorlevel;
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
