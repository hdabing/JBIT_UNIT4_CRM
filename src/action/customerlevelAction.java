package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.struts.ActionSupport;

import com.opensymphony.xwork2.ActionContext;

import service.customerlevelService;
import utils.pageBean;
import entity.Customerlevel;

public class customerlevelAction extends ActionSupport {
	private customerlevelService customerlevelservice;
	private int id;
	public Customerlevel customerlevel;
	private int page;
	private int pagesize;
	private pageBean pagebean;
	
	/**
	 *初始化分页信息
	 */
	public void init(){
		if(ActionContext.getContext().getSession().get("pagesize")==null){
			ActionContext.getContext().getSession().put("pagesize", 5);
		}
		if(pagesize!=0){
			ActionContext.getContext().getSession().put("pagesize", pagesize);
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
	public pageBean getPagebean() {
		return pagebean;
	}
	public void setPagebean(pageBean pagebean) {
		this.pagebean = pagebean;
	}
	public customerlevelService getCustomerlevelservice() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		return (customerlevelService) ac.getBean("customerlevelservice");
	}
	public void setCustomerlevelservice(customerlevelService customerlevelservice) {
		this.customerlevelservice = customerlevelservice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customerlevel getCustomerlevel() {
		return customerlevel;
	}
	public void setCustomerlevel(Customerlevel customerlevel) {
		this.customerlevel = customerlevel;
	}
	
	/**
	 * 显示客户等级列表
	 * @return
	 */
	public String listCustomerlevel(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listcustomerlevel", this.getCustomerlevelservice().listCustomerlevel());
		return "SUCCESS";
	}
	
	/**
	 * 添加客户等级
	 * @return
	 */
	public String addCustomerlevel(){
		return "SUCCESS";
	}
	
	/**
	 * 确认添加客户等级
	 * @return
	 */
	public String addCustomerlevelOK(){
		customerlevelservice=this.getCustomerlevelservice();
		customerlevelservice.addCustomerlevel(customerlevel);
		
		return "SUCCESS";
	}
	
	public String editCustomerlevel(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("customerlevel", this.getCustomerlevelservice().getCustomerlevel(id));
		
		return "SUCCESS";
	}
	
	/**
	 * 修改客户等级
	 * @return
	 */
	public String editCustomerlevelOK(){
		this.getCustomerlevelservice().editCustomerlevel(customerlevel);
		
		return "SUCCESS";
	}
	
	/**
	 * 删除客户等级
	 * @return
	 */
	public String delCustomerlevel(){
		this.getCustomerlevelservice().delCustomerlevel(id);
		
		return "SUCCESS";
	}
	
	/**
	 * 分页查询客户等级信息 
	 */
	public String queryListcustomerlevel(){
		this.init();
		String hql="From Customerlevel where isdel=0 order by id";
		pagebean=customerlevelservice.queryListcustomer(hql, page, pagesize);
		pagebean.setAction("queryListcustomerlevel");
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listcustomerlevel", pagebean.getList());
		
		return "SUCCESS";
	}
	
	
	public String queryCustomerlevelbyform(){
		this.init();
		String hql="From Customerlevel where isdel=0 ";
		if(customerlevel.getName()!=null && customerlevel.getName().length()>0){
			hql+=" and name like '%"+customerlevel.getName()+"%' ";
		}

		if(customerlevel.getId()!=0){
			hql+=" and id="+customerlevel.getId();
		}
		hql+=" order by id";
		pagebean=customerlevelservice.queryListcustomer(hql, page, pagesize);
		pagebean.setAction("queryCustomerlevelbyform");
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listcustomerlevel", pagebean.getList());
		customerlevel.setId(0);//必须要把id清除掉，要不然会原来的id值会存在这个上面
		
		return "SUCCESS";
	}
}
