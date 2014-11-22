package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.struts.ActionSupport;

import service.areaService;
import service.customerService;
import service.customercontactService;
import service.customerlevelService;
import service.relationshipService;
import service.userService;
import utils.pageBean;

import com.opensymphony.xwork2.ActionContext;

import entity.Area;
import entity.Customer;
import entity.Customercontact;
import entity.Customerlevel;
import entity.Relationship;

public class customerAction extends ActionSupport {

	public Customer customer;
	public List<Area> listarea;
	public List<Customerlevel> listcustomerlevel;
	public Relationship relationship;
	public int id;
	public Customercontact customercontact;
	private int page;
	private int pagesize;
	private pageBean pagebean;
	
	
	
	public pageBean getPagebean() {
		return pagebean;
	}


	public void setPagebean(pageBean pagebean) {
		this.pagebean = pagebean;
	}


	public void init(){
		if(ActionContext.getContext().getSession().get("pagesize")==null){
			ActionContext.getContext().getSession().put("pagesize", 5);
		}
		if(pagesize!=0){
			pagesize=(Integer) ActionContext.getContext().getSession().put("pagesize", pagesize);
		}
		pagesize=(Integer) ActionContext.getContext().getSession().get("pagesize");
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

	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	public Customercontact getCustomercontact() {
		return customercontact;
	}

	public void setCustomercontact(Customercontact customercontact) {
		this.customercontact = customercontact;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public relationshipService getRelationshipservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (relationshipService) ac.getBean("relationshipservice");
	}
	
	public userService getUserservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (userService) ac.getBean("userservice");
	}

	public areaService getAreaservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (areaService) ac.getBean("areaservice");
	}

	public customerlevelService getCustomerlevelservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (customerlevelService) ac.getBean("customerlevelservice");
	}

	public customerService getCustomerservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (customerService) ac.getBean("customerservice");
	}

	public customercontactService getCustomercontactservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (customercontactService) ac.getBean("customercontactservice");
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 显示客户列表
	 * 
	 * @return
	 */
	public String listCustomer() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listcustomer", this.getCustomerservice().listCustomer());
		return "SUCCESS";
	}

	/**
	 * 显示编辑客户界面
	 * 
	 * @return
	 */
	public String editCustomer() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("customer",this.getCustomerservice().getCustomer(id));
		request.setAttribute("listusers", this.getUserservice().getUserslist());
		request.setAttribute("listarea", this.getAreaservice().listArea());
		request.setAttribute("listcustomerlevel", this.getCustomerlevelservice().listCustomerlevel());
		
		return "SUCCESS";
	}
	
	/**
	 * 确认编辑客户
	 */
	public String editCustomerOK(){
		customer.setUserid(1);
		this.getCustomerservice().editCustomer(customer);
		
		return "SUCCESS";
	}
	
	/**
	 * 删除客户,将客户的isdel置为0 
	 * @return
	 */
	public String delCustomer(){
		this.getCustomerservice().delCustomer(id);
		
		return "SUCCESS";
	}
	
	/**
	 * 显示添加客户界面
	 * @return
	 */
	public String addCustomer(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("listcustomerlevel", this.getCustomerlevelservice().listCustomerlevel());
		request.setAttribute("listarea", this.getAreaservice().listArea());
		request.setAttribute("listusers", this.getUserservice().getUserslist());
		
		return "SUCCESS";
	}
	
	/**
	 * 确认添加客户
	 * @return
	 */
	public String addCustomerOK(){
		this.getCustomerservice().addCustomer(customer);
		return "SUCCESS";
	}
	
	/**
	 * 显示联系人列表
	 * @return
	 */
	public String listCustomercontact(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("listcustomercontact", this.getCustomercontactservice().listCustomercontact(id));
		request.setAttribute("customer", this.getCustomerservice().getCustomer(id));
		
		return "SUCCESS";
	}
	/**
	 * 编辑客户联系人
	 */
	public String editCustomercontact(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("customercontact",this.getCustomercontactservice().getCustomercontact(id));
		return "SUCCESS";
	}
	
	/**
	 * 确认修改客户联系人
	 */
	public String editCustomercontactOK(){
		this.getCustomercontactservice().editCustomercontact(customercontact);
		
		return "SUCCESS";
	}
	
	/**
	 * 显示添加客户联系人页面 
	 */
	public String addCustomercontact(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("customerid", id);
		
		return "SUCCESS";
	}
	
	/**
	 * 添加客户联系人
	 */
	public String addCustomercontactOK(){
		this.getCustomercontactservice().addCustomercontact(customercontact);
		return "SUCCESS";
	}
	
	/**
	 *删除客户联系人，将联系人isdel置为1
	 */
	public String delCustomercontact(){
		customercontact=this.getCustomercontactservice().getCustomercontact(id);
		this.getCustomercontactservice().delCustomercontact(id);
		return "SUCCESS";
	}
	
	/**
	 * 显示客户交往记录
	 */
	public String listRelationship(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("listrelationship", this.getRelationshipservice().listRelationship(id));
		request.setAttribute("customer", this.getCustomerservice().getCustomer(id));
		
		return "SUCCESS";
	}
	
	/**
	 * 显示添加客户交往记录
	 */
	public String addRelationship(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("customerid", id);
		
		return "SUCCESS";
	}
	
	/**
	 * 确认添加客户交往记录
	 */
	public String addRelationshipOK(){
		this.getRelationshipservice().addRelationship(relationship);
		
		return "SUCCESS";
	}
	
	/**
	 * 显示编辑客户交往记录页面
	 */
	public String editRelationship(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("relationship", this.getRelationshipservice().getRelationship(id));
		
		return "SUCCESS";
	}
	
	/**
	 * 确认编辑客户交往记录
	 */
	public String editRelationshipOK(){
		this.getRelationshipservice().editRelationship(relationship);
		
		return "SUCCESS";
	}
	
	/**
	 * 删除客户交往记录
	 */
	public String delRelationship(){
		relationship=this.getRelationshipservice().getRelationship(id);
		this.getRelationshipservice().delRelationship(id);
		
		return "SUCCESS";
	}
	
	/**
	 * 分页查询客户
	 * @return
	 */
	public String queryListcustomer(){
		this.init();
		String hql="From Customer where isdel=0 order by id";
		pagebean=this.getCustomerservice().queryListcustomer(hql, page, pagesize);
		pagebean.setAction("queryListcustomer");
		listarea=this.getAreaservice().listArea();
		listcustomerlevel=this.getCustomerlevelservice().listCustomerlevel();
		
		return "SUCCESS";
	}
	
	/**
	 * 根据输入内容查找对应的客户
	 * @return
	 */
	public String queryCustomerbyform(){
		this.init();
		listarea=this.getAreaservice().listArea();
		listcustomerlevel=this.getCustomerlevelservice().listCustomerlevel();
		String hql="From Customer where isdel=0 ";
		if(customer.getName()!=null && customer.getName().length()>0){
			hql+=" and name like '%"+customer.getName()+"%' ";
		}
		if(customer.getCode()!=null && customer.getCode().length()>0){
			hql+=" and code like '%"+customer.getCode()+"%' ";
		}
		if(customer.getManagername()!=null && customer.getManagername().length()>0){
			hql+=" and managername like '%"+customer.getManagername()+"%' ";
		}
		if(customer.getAreaid()!=0){
			hql+=" and areaid="+customer.getAreaid()+" ";
		}
		if(customer.getLevelid()!=0){
			hql+=" and levelid="+customer.getLevelid();
		}
		
		hql+=" order by id";
		pagebean=this.getCustomerservice().queryListcustomer(hql, page, pagesize);
		pagebean.setAction("queryCustomerbyform");
		
		return "SUCCESS";
	}
}
