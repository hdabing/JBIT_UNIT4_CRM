package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.struts.ActionSupport;

import service.customerService;
import service.serviceService;
import service.userService;
import utils.dateTools;
import utils.pageBean;

import com.opensymphony.xwork2.ActionContext;

import entity.Customer;
import entity.Service;
import entity.Servicelist;
import entity.Servicestate;
import entity.Users;

public class serviceAction extends ActionSupport {
	private serviceService serviceservice;
	private Servicelist servicelist;
	private Service service;
	public List<Service> listservice;// 用来输出服务类型列表
	public Customer customer;
	private Servicestate servicestate;
	private int id;
	private int userid;
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


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Service> getListservice() {
		return listservice;
	}

	public void setListservice(List<Service> listservice) {
		this.listservice = listservice;
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

	public void setServiceservice(serviceService serviceservice) {
		this.serviceservice = serviceservice;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Servicestate getServicestate() {
		return servicestate;
	}

	public void setServicestate(Servicestate servicestate) {
		this.servicestate = servicestate;
	}

	public userService getUserservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (userService) ac.getBean("userservice");
	}

	public Servicelist getServicelist() {
		return servicelist;
	}

	public void setServicelist(Servicelist servicelist) {
		this.servicelist = servicelist;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Service getService() {
		return service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public serviceService getServiceservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (serviceService) ac.getBean("serviceservice");
	}

	public customerService getCustomerservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (customerService) ac.getBean("customerservice");
	}

	/**
	 * 显示服务信息列表
	 * 
	 * @return
	 */
	public String addServicelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listcustomer", this.getCustomerservice()
				.listCustomer());
		request.setAttribute("listservice", this.getServiceservice()
				.listService());

		return "SUCCESS";
	}

	/**
	 * 添加服务信息
	 * 
	 * @return
	 */
	public String addServicelistOK() {
		dateTools dt = new dateTools();
		servicelist.setState(1);
		servicelist.setUserid(1);
		servicelist.setOperatorid(1);
		servicelist.setGranttime(dt.getSqlDate());
		servicelist.setOperatortime(dt.getSqlDate());
		this.getServiceservice().addServicelist(servicelist);

		return "SUCCESS";
	}

	/**
	 * 修改服务信息
	 * 
	 * @return
	 */
	public String editServicelist() {
		serviceservice.editService(service);

		return "SUCCESS";
	}

	/**
	 * 显示服务列表
	 * 
	 * @return
	 */
	public String listServicelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listservicelist", this.getServiceservice()
				.listServicelist());
		request.setAttribute("listusers", this.getUserservice().getUserslist());

		return "SUCCESS";
	}

	/**
	 * 显示服务分配列表
	 * 
	 * @return
	 */
	public String grantServicelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listservicelist", this.getServiceservice()
				.listServicelistUnGrant());
		request.setAttribute("listusers", this.getUserservice().getUserslist());

		return "SUCCESS";
	}

	/**
	 * 确认分配服务列表
	 * 
	 * @return
	 */
	public String grantServicelistOK() {
		dateTools dt = new dateTools();
		serviceservice = this.getServiceservice();
		servicelist = serviceservice.getServicelist(id);
		servicelist.setState(2);
		servicelist.setUserid(userid);
		servicelist.setGranttime(dt.getSqlDate());
		serviceservice.editServicelist(servicelist);

		return "SUCCESS";
	}

	/**
	 * 删除服务列表
	 * 
	 * @return
	 */
	public String delServicelist() {
		this.getServiceservice().delServicelist(id);

		return "SUCCESS";
	}

	/**
	 * 显示已分配的服务列表
	 * 
	 * @return
	 */
	public String listOperatorservicelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listservicelist", this.getServiceservice()
				.listServicelistGrant());
		request.setAttribute("listusers", this.getUserservice().getUserslist());

		return "SUCCESS";
	}

	/**
	 * 显示操作服务信息
	 * 
	 * @return
	 */
	public String operatorServicelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("servicelist", this.getServiceservice()
				.getServicelist(id));
		return "SUCCESS";
	}

	/**
	 * 确认操作服务信息
	 */
	public String operatorServicelistOK() {
		Servicelist tmpservicelist = this.getServiceservice().getServicelist(
				servicelist.getId());
		tmpservicelist.setOperatortime(servicelist.getOperatortime());
		tmpservicelist.setOperatorcontent(servicelist.getOperatorcontent());
		tmpservicelist.setOperatorid(servicelist.getOperatorid());
		tmpservicelist.setState(3);
		this.getServiceservice().editServicelist(tmpservicelist);

		return "SUCCESS";
	}

	/**
	 * 显示服务反馈列表
	 */
	public String listBackservicelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listservicelist", this.getServiceservice()
				.listServicelistOperator());

		return "SUCCESS";
	}

	/**
	 * 显示服务反馈页面
	 */
	public String backServicelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("servicelist", this.getServiceservice()
				.getServicelist(id));

		return "SUCCESS";
	}

	/**
	 * 确认服务反馈
	 */
	public String backServicelistOK() {
		serviceService serviceservice = this.getServiceservice();
		Servicelist tmpservicelist = serviceservice.getServicelist(servicelist
				.getId());
		tmpservicelist.setAgreelevel(servicelist.getAgreelevel());
		tmpservicelist.setResultcontent(servicelist.getResultcontent());
		if (servicelist.getAgreelevel() >= 3) {
			tmpservicelist.setState(4);
		} else {
			tmpservicelist.setState(2);
		}
		serviceservice.editServicelist(tmpservicelist);
		return "SUCCESS";
	}

	/**
	 * 显示已归档的服务列表
	 */
	public String listArchservicelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listservicelist", this.getServiceservice()
				.listArchservicelist());
		return "SUCCESS";

	}

	/**
	 * 显示已归档的服务明细
	 */
	public String archServicelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("servicelist", this.getServiceservice()
				.getServicelist(id));

		return "SUCCESS";
	}

	/**
	 * 显示服务类型列表
	 */
	public String listService() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listservice", this.getServiceservice()
				.listService());
		return "SUCCESS";
	}

	/**
	 * 添加服务类型
	 */
	public String addService() {
		return "SUCCESS";
	}

	public String addServiceOK() {
		this.getServiceservice().addService(service);
		return "SUCCESS";
	}

	/**
	 * 修改服务类型
	 */
	public String editService() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("service", this.getServiceservice().getService(id));
		return "SUCCESS";
	}

	public String editServiceOK() {
		this.getServiceservice().editService(service);
		return "SUCCESS";
	}

	/**
	 * 删除服务类型
	 */
	public String delService() {
		this.getServiceservice().delService(id);
		return "SUCCESS";
	}

	/**
	 * 分页查询服务明细分配
	 * 
	 * @return
	 */
	public String queryListgrantservicelist() {
		this.init();
		List<Users> listusers = this.getUserservice().getUserslist();
		HttpServletRequest request = ServletActionContext.getRequest();
		listservice=this.getServiceservice().listService();
		request.setAttribute("listusers", listusers);
		String hql = "From Servicelist where state=1";
		pagebean = this.getServiceservice().queryListservicelist(hql, page,
				pagesize);
		pagebean.setAction("queryListgrantservicelist");

		return "SUCCESS";
	}

	/**
	 * 分页查询服务明细处理
	 * 
	 * @return
	 */
	public String queryListoperatorservicelist() {
		this.init();
		String hql = "From Servicelist where state=2 order by id";
		listservice=this.getServiceservice().listService();
		pagebean = this.getServiceservice().queryListservicelist(hql, page,
				pagesize);
		pagebean.setAction("queryListoperatorservicelist");

		return "SUCCESS";
	}

	/**
	 * 分页查询服务明细反馈
	 * 
	 * @return
	 */
	public String queryListbackservicelist() {
		this.init();
		String hql = "From Servicelist where state=3 order by id";
		listservice=this.getServiceservice().listService();
		pagebean = this.getServiceservice().queryListservicelist(hql, page,
				pagesize);
		pagebean.setAction("queryListbackservicelist");

		return "SUCCESS";
	}

	/**
	 * 分页查询服务明细归档
	 * 
	 * @return
	 */
	public String queryListarchservicelist() {
		this.init();
		listservice=this.getServiceservice().listService();
		String hql = "From Servicelist where state=4 order by id";
		pagebean = this.getServiceservice().queryListservicelist(hql, page,
				pagesize);
		pagebean.setAction("queryListarchservicelist");

		return "SUCCESS";
	}

	/**
	 * 分页查询服务信息
	 * 
	 * @return
	 */
	public String queryListservice() {
		this.init();
		String hql = "From Service where isdel=0 order by id";
		listservice=this.getServiceservice().listService();
		pagebean = this.getServiceservice().queryListservicelist(hql, page,
				pagesize);
		pagebean.setAction("queryListservice");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listservice", pagebean.getList());

		return "SUCCESS";
	}

	/**
	 * 查询服务列表
	 * @return
	 */
	public String queryServicelistbyform(){
		this.init();
		String hql="From Servicelist ";
		listservice=this.getServiceservice().listService();
		int hqllen=hql.length();
		if(customer.getName()!=null && customer.getName().length()>0){
			hql+=" where customerid in (select id from Customer where name like '%"+customer.getName()+"%') ";
		}
		if(servicelist.getSummary()!=null && servicelist.getSummary().length()>0){
			if(hql.length()>hqllen){
				hql+=" and summary like '%"+servicelist.getSummary()+"%'";
			}else{
				hql+=" where summary like '%"+servicelist.getSummary()+"%'";
			}
		}
		if(servicelist.getServiceid()!=0){
			if(hql.length()>hqllen){
				hql+=" and serviceid="+servicelist.getServiceid();
			}else{
				hql+=" where serviceid="+servicelist.getServiceid();
			}
		}
		hql+=" order by id";
		pagebean = this.getServiceservice().queryListservicelist(hql, page,pagesize);
		pagebean.setAction("queryServicelistbyform");
		
		return "SUCCESS";
	}
	
	/**
	 * 查询服务类型
	 * @return
	 */
	public String queryServicebyform(){
		this.init();
		String hql="From Service where isdel=0 ";
		if(service.getName()!=null && service.getName().length()>0){
			hql+=" and name like '%"+service.getName()+"%' ";
		}
		if(service.getId()!=0){
			hql+=" and id="+service.getId();
		}
		hql+=" order by id";
		service.setId(0);//必须要把id清除，要不然下次还会读取上次的id值
		pagebean=this.getServiceservice().queryListservicelist(hql, page, pagesize);
		pagebean.setAction("queryServicebyform");
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listservice", pagebean.getList());
		
		return "SUCCESS";
	}
}
