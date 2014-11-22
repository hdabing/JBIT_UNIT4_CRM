package entity;

import java.io.Serializable;

/**
 * 历史订单（子表）
 * 
 * @author 陈捷
 * 
 */
@SuppressWarnings("serial")
public class Orderlist implements Serializable {
	private int id;
	private int orderid;// 订单id
	private int productid;// 商品id
	private int quantity;// 数量
	private float price;// 单价
	private float amount;// 金额
	private Product product;//商品
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
