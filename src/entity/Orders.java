package entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 历史订单表(主表)
 * 
 * @author 陈捷
 * 
 */
@SuppressWarnings("serial")
public class Orders implements Serializable {
	private int id;
	private int customerid;//客户id
	private Date ordertime;// 订单日期
	private String address;// 送货地址
	private String state;// 状态
	private float amount;// 总净额
	private Customer customer;//客户类
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
