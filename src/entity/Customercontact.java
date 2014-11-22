package entity;

import java.io.Serializable;

/**
 * 客户联系人表
 * 
 * @author 陈捷
 * 
 */
@SuppressWarnings("serial")
public class Customercontact implements Serializable {
	private int id;
	private String name;// 联系人
	private String gender;// 性别
	private int customerid;// 客户id
	private String position;// 职位
	private String phone;// 办公电话
	private String telephone;// 手机
	private String content;// 备注
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
