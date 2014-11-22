package entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 客户流失表
 * 
 * @author 陈捷
 * 
 */
@SuppressWarnings("serial")
public class Customerlost implements Serializable {
	private int id;
	private int customerid;//客户id
	private Date lastorder;//最后下单日期
	private Date lostday;//确认流失日期
	private String content;//暂缓流措施
	private String lostcause;//流失原因
	private String state;//状态
	private Customer customer;//客户类
	
	
	public Date getLostday() {
		return lostday;
	}

	public void setLostday(Date lostday) {
		this.lostday = lostday;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

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

	public Date getLastorder() {
		return lastorder;
	}

	public void setLastorder(Date lastorder) {
		this.lastorder = lastorder;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLostcause() {
		return lostcause;
	}

	public void setLostcause(String lostcause) {
		this.lostcause = lostcause;
	}

}
