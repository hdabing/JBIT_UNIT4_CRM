package entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 交往记录表
 * 
 * @author 陈捷
 * 
 */
@SuppressWarnings("serial")
public class Relationship implements Serializable {
	private int id;
	private int customerid;// 客户id
	private Date relationtime;// 交往时间
	private String address;// 地点
	private String summary;// 概要
	private String content;// 备注
	private String detail;// 详细信息

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public Date getRelationtime() {
		return relationtime;
	}

	public void setRelationtime(Date relationtime) {
		this.relationtime = relationtime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
