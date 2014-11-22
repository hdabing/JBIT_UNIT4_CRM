package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.struts.ActionSupport;

import service.customerService;
import service.orderService;
import utils.pageBean;

import com.opensymphony.xwork2.ActionContext;

import entity.Customer;
import entity.Orderlist;
import entity.Orders;

public class ordersAction extends ActionSupport {
	private Customer customer;
	private Orders orders;
	private Orderlist orderlist;
	private int id;
	private int page;
	private int pagesize;
	private pageBean pagebean;
	
	/**
	 * 初始化分页信息
	 */
	public void init(){
		//初始化分页信息
		if(ActionContext.getContext().getSession().get("pagesize")==null){
			ActionContext.getContext().getSession().put("pagesize", 5);
		}
		if(pagesize!=0){
			ActionContext.getContext().getSession().put("pagesize", pagesize);
		}
		pagesize=(Integer) ActionContext.getContext().getSession().get("pagesize");
		
		//初始化客户id
		if(ActionContext.getContext().getSession().get("customerid")==null){
			ActionContext.getContext().getSession().put("customerid", id);
		}
		if(id!=0){
			if(id!=(Integer)ActionContext.getContext().getSession().get("customerid")){
				ActionContext.getContext().getSession().put("customerid", id);
			}
		}
		id=(Integer) ActionContext.getContext().getSession().get("customerid");
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public pageBean getPagebean() {
		return pagebean;
	}

	public void setPagebean(pageBean pagebean) {
		this.pagebean = pagebean;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public orderService getOrderservice() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		return (orderService) ac.getBean("orderservice");
	}
	
	public customerService getCustomerservice() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		return (customerService) ac.getBean("customerservice");
	}
	
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Orderlist getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(Orderlist orderlist) {
		this.orderlist = orderlist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * 显示客户订单
	 * @return
	 */
	public String listOrders(){
		HttpServletRequest request=ServletActionContext.getRequest();
		customer=this.getCustomerservice().getCustomer(id);
		request.setAttribute("customer", customer);
		
		request.setAttribute("listorders", this.getOrderservice().listOrders(customer.getId()));
		
		return "SUCCESS";
	}
	
	/**
	 * 显示订单明细
	 * @return
	 */
	public String listOrderlist(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("orders", this.getOrderservice().getOrders(id));
		request.setAttribute("listorderlist", this.getOrderservice().getOrderlist(id));
		
		return "SUCCESS";
	}
	
	/**
	 * 分页查询订单主表
	 * @return
	 */
	public String queryListorders(){
		this.init();
		String hql="From Orders where customerid="+id;
		customer=this.getCustomerservice().getCustomer(id);
		pagebean=this.getOrderservice().queryListorders(hql, page, pagesize);
		return "SUCCESS";
	}
	
}
