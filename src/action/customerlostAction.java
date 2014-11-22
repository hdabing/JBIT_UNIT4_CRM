package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.struts.ActionSupport;

import service.customerService;
import service.customerlostService;
import utils.dateTools;
import utils.pageBean;

import com.opensymphony.xwork2.ActionContext;

import entity.Customer;
import entity.Customerlost;

public class customerlostAction extends ActionSupport {
	private Customer customer;
	private Customerlost customerlost;
	private int id;
	private String oldcontent;// 老的暂缓措施
	private int page;
	private int pagesize;
	private pageBean pagebean;

	/**
	 * 初始化分页信息
	 */
	public void init() {
		if (ActionContext.getContext().getSession().get("pagesize") == null) {
			ActionContext.getContext().getSession().put("pagesize", 5);
		}
		if (pagesize != 0) {
			ActionContext.getContext().getSession().put("pagesize", pagesize);
		}
		pagesize = (Integer) ActionContext.getContext().getSession()
				.get("pagesize");
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

	public String getOldcontent() {
		return oldcontent;
	}

	public void setOldcontent(String oldcontent) {
		this.oldcontent = oldcontent;
	}

	public customerlostService getCustomerlostservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (customerlostService) ac.getBean("customerlostservice");
	}
	
	public customerService getCustomerservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (customerService) ac.getBean("customerservice");
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customerlost getCustomerlost() {
		return customerlost;
	}

	public void setCustomerlost(Customerlost customerlost) {
		this.customerlost = customerlost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 显示客户流失列表
	 * 
	 * @return
	 */
	public String listCustomerlost() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listcustomerlost", this.getCustomerlostservice()
				.listCustomerlost());

		return "SUCCESS";
	}

	public String listAgreelost() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listcustomerlost", this.getCustomerlostservice()
				.listAgreelost());

		return "SUCCESS";
	}

	/**
	 * 显示确认流失页面
	 */
	public String agreeLost() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("customerlost", this.getCustomerlostservice()
				.getCustomerlost(id));

		return "SUCCESS";
	}

	/**
	 * 确认流失
	 * 
	 * @return
	 */
	public String agreeLostOK() {
		dateTools dt = new dateTools();
		customerlost.setLostday(dt.getSqlDate());
		customerlost.setState("确认流失");
		Customer customer=this.getCustomerservice().getCustomer(customerlost.getId());
		this.getCustomerlostservice().editLost(customerlost);
		customer.setIsdel(1);
		this.getCustomerservice().editCustomer(customer);
		return "SUCCESS";
	}

	/**
	 * 显示暂缓流失页面
	 */
	public String delayLost() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("customerlost", this.getCustomerlostservice()
				.getCustomerlost(id));

		return "SUCCESS";
	}

	/**
	 * 暂缓流失
	 * 
	 * @return
	 */
	public String delayLostOK() {
		dateTools dt = new dateTools();

		customerlost.setLostday(dt.getSqlDate());
		customerlost.setState("暂缓流失");
		customerlost.setContent(customerlost.getContent());
		this.getCustomerlostservice().editLost(customerlost);

		return "SUCCESS";
	}

	/**
	 * 分页查询客户流失列表（未确认流失）
	 * 
	 * @return
	 */
	public String queryListcustomerlost() {
		this.init();
		String hql = "From Customerlost";
		pagebean = this.getCustomerlostservice().queryListcustomerlost(hql,
				page, pagesize);
		pagebean.setAction("queryListcustomerlost");

		return "SUCCESS";
	}

	/**
	 * 分页查询已流失的客户
	 * 
	 * @return
	 */
	public String queryListcustomeragreelost() {
		this.init();
		String hql = "From Customerlost where state='确认流失'";
		pagebean = this.getCustomerlostservice().queryListcustomerlost(hql,
				page, pagesize);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listcustomerlost", pagebean.getList());
		pagebean.setAction("queryListcustomeragreelost");

		return "SUCCESS";
	}

	/**
	 * 分页查询已流失的客户,增加查询条件
	 * 
	 * @return
	 */
	public String queryAgreelostbyform() {
		this.init();
		String hql = "From Customerlost where state='确认流失' ";

		if (customer.getName() != null && customer.getName().length() > 0) {
			hql += " and customerid in (select id from Customer where name like '%"
					+ customer.getName() + "%') ";
		}
		if (customer.getUsers().getUsername() != null
				&& customer.getUsers().getUsername().length() > 0) {
			hql += " and customerid in (select id from Customer "
					+ "where userid in(select id from Users where "
					+ "username like '%" + customer.getUsers().getUsername()
					+ "%'))";
		}

		pagebean = this.getCustomerlostservice().queryListcustomerlost(hql,
				page, pagesize);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listcustomerlost", pagebean.getList());
		pagebean.setAction("queryAgreelostbyform");

		return "SUCCESS";
	}

	/**
	 * 分页查询指定的客户流失信息
	 * 
	 * @return
	 */
	public String queryCustomerlostbyform() {
		this.init();
		String hql = "From Customerlost ";
		int hqllen = hql.length();// 用来判断是否没有and
		if (customer.getName() != null && customer.getName().length() > 0) {
			hql += "where customerid in (select id from Customer where name like '%"
					+ customer.getName() + "%' )";
		}
		if (customer.getUsers().getUsername() != null
				&& customer.getUsers().getUsername().length() > 0) {
			if (hql.length() > hqllen) {
				hql += " or customerid in (select id from Customer where userid in (select id from Users where username like'%"
						+ customer.getUsers().getUsername() + "%'))";
			} else {
				hql += " where customerid in (select id from Customer where userid in (select id from Users where username like'%"
						+ customer.getUsers().getUsername() + "%'))";
			}
		}
		if (!customerlost.getState().equals("0")) {
			if (hql.length() > hqllen) {
				hql += " and state='" + customerlost.getState() + "' ";
			} else {
				hql += " where state='" + customerlost.getState() + "' ";
			}
		}

		pagebean = this.getCustomerlostservice().queryListcustomerlost(hql,
				page, pagesize);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listcustomerlost", pagebean.getList());
		pagebean.setAction("queryCustomerlostbyform");

		return "SUCCESS";
	}
}
