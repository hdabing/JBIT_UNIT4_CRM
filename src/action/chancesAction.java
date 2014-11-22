package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.struts.ActionSupport;

import service.areaService;
import service.chanceService;
import service.customerlevelService;
import service.userService;
import utils.pageBean;

import com.opensymphony.xwork2.ActionContext;

import entity.Chances;
import entity.Chancesplan;
import entity.Users;

public class chancesAction extends ActionSupport {

	public chanceService chanceservice;
	public userService userservice;
	public customerlevelService customerlevelservice;
	public areaService areaservice;
	public Chances chances;
	public Chancesplan chancesplan;
	public int id;
	private int page;//页数
	private int pagesize;//页面大小
	private pageBean pagebean;

	/**
	 * 初始化分页信息
	 */
	public void init(){
		//如果接受到pagesize的值，则存入到session中
		if(ActionContext.getContext().getSession().get("pagesize")==null){
			ActionContext.getContext().getSession().put("pagesize", 5);
		}
		if(pagesize!=0){
			ActionContext.getContext().getSession().put("pagesize", pagesize);
		}
		
		pagesize=(Integer) ActionContext.getContext().getSession().get("pagesize");
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public pageBean getPagebean() {
		return pagebean;
	}

	public void setPagebean(pageBean pagebean) {
		this.pagebean = pagebean;
	}

	public Chancesplan getChancesplan() {
		return chancesplan;
	}

	public void setChancesplan(Chancesplan chancesplan) {
		this.chancesplan = chancesplan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Chances getChances() {
		return chances;
	}

	public void setChances(Chances chances) {
		this.chances = chances;
	}

	public chanceService getChanceservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (chanceService) ac.getBean("chanceservice");
	}

	public userService getUserservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (userService) ac.getBean("userservice");
	}

	public customerlevelService getCustomerlevelservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (customerlevelService) ac.getBean("customerlevelservice");
	}

	public areaService getAreaservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (areaService) ac.getBean("areaservice");
	}

	/**
	 * 显示销售机会列表
	 * 
	 * @return
	 */
	public String listChances() {
		HttpServletRequest request = ServletActionContext.getRequest();
		chanceservice = this.getChanceservice();
		request.setAttribute("listchances", chanceservice.listChances());
		return "SUCCESS";
	}

	/**
	 * 显示添加销售机会页面
	 * 
	 * @return
	 */
	public String addChances() {
		areaservice = this.getAreaservice();
		customerlevelservice = this.getCustomerlevelservice();
		userservice = this.getUserservice();

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listarea", areaservice.listArea());
		request.setAttribute("listcustomerlevel",
				customerlevelservice.listCustomerlevel());
		request.setAttribute("listusers", userservice.getUserslist());
		return "SUCCESS";
	}

	/**
	 * 确认添加销售机会
	 * 
	 * @return
	 */
	public String addChancesOK() {
		chanceservice = this.getChanceservice();
		chances.setUserid(1);
		chances.setState(1);
		chances.setIssuccess(0);
		Users user = (Users) ActionContext.getContext().getSession()
				.get("user");
		chances.setCreateuserid(user.getId());
		chances.setChancestime(chances.getCreatetime());
		chanceservice.addChances(chances);
		return "SUCCESS";
	}

	/**
	 * 显示修改销售机会页面
	 * 
	 * @return
	 */
	public String editChances() {
		chanceservice = this.getChanceservice();
		areaservice = this.getAreaservice();
		customerlevelservice = this.getCustomerlevelservice();
		userservice = this.getUserservice();
		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("listarea", areaservice.listArea());
		request.setAttribute("listcustomerlevel",
				customerlevelservice.listCustomerlevel());
		request.setAttribute("listusers", userservice.getUserslist());
		request.setAttribute("chances", chanceservice.getChances(id));
		return "SUCCESS";
	}

	/**
	 * 修改销售机会
	 * 
	 * @return
	 */
	public String editChancesOK() {
		chanceservice = this.getChanceservice();
		chances.setUserid(1);
		chances.setState(1);// 状态1，未指派
		chances.setIssuccess(0);
		chanceservice.editChances(chances);
		return "SUCCESS";
	}

	/**
	 * 删除销售机会
	 * 
	 * @return
	 */
	public String delChances() {
		chanceservice = this.getChanceservice();
		chanceservice.delChances(id);
		return "SUCCESS";
	}

	/**
	 * 显示指派页面
	 * 
	 * @return
	 */
	public String grantChances() {
		chanceservice = this.getChanceservice();
		areaservice = this.getAreaservice();
		customerlevelservice = this.getCustomerlevelservice();
		userservice = this.getUserservice();
		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("listarea", areaservice.listArea());
		request.setAttribute("listcustomerlevel",
				customerlevelservice.listCustomerlevel());
		request.setAttribute("listusers", userservice.getUserslist());
		request.setAttribute("chances", chanceservice.getChances(id));
		return "SUCCESS";
	}

	/**
	 * 确认指派
	 * 
	 * @return
	 */
	public String grantChancesOK() {
		chanceservice = this.getChanceservice();
		Chances chances2 = chanceservice.getChances(chances.getId());
		chances2.setState(2);// 状态2已指派
		chances2.setUserid(chances.getUserid());
		chances2.setChancestime(chances.getChancestime());
		chanceservice.editChances(chances2);
		return "SUCCESS";
	}

	/**
	 * 显示客户开发计划列表
	 */
	public String listChancesplan() {
		chanceservice = this.getChanceservice();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listchancesplan",
				chanceservice.listChancesOfplan());

		return "SUCCESS";
	}

	/**
	 * 显示指定计划页面
	 */
	public String addChancesplan() {
		chanceservice = this.getChanceservice();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("chances", chanceservice.getChances(id));
		request.setAttribute("listchancesplan",
				chanceservice.listChancesplan(id));

		return "SUCCESS";
	}

	/**
	 * 添加开发计划
	 * 
	 * @return
	 */
	public String addChancesplanOK() {
		chanceservice = this.getChanceservice();
		chancesplan.setEffect("");
		chanceservice.addChancesplan(chancesplan);
		
		return "SUCCESS";
	}

	/**
	 * 删除开发计划
	 * 
	 * @return
	 */
	public String delChancesplanOK() {
		chanceservice = this.getChanceservice();
		chanceservice.delChancesplan(id);

		return "SUCCESS";
	}

	/**
	 * 执行计划
	 * 
	 * @return
	 */
	public String executeChancesplan() {
		chanceservice = this.getChanceservice();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("chances", chanceservice.getChances(id));
		request.setAttribute("listchancesplan",
				chanceservice.listChancesplan(id));

		return "SUCCESS";
	}

	/**
	 * 确认执行计划
	 * 
	 * @return
	 */
	public String executeChancesplanOK() {
		chanceservice = this.getChanceservice();
		chanceservice.executeChancesplan(chancesplan);

		return "SUCCESS";
	}

	/**
	 * 开发成功
	 * 
	 * @return
	 */
	public String successChances() {
		chanceservice = this.getChanceservice();
		chanceservice.successChances(id);

		return "SUCCESS";
	}

	/**
	 * 开发失败
	 * 
	 * @return
	 */
	public String failChances() {
		chanceservice = this.getChanceservice();
		chanceservice.failChances(id);

		return "SUCCESS";
	}

	/**
	 * 查询开发计划
	 * 
	 * @return
	 */
	public String queryChancesplan() {
		chanceservice = this.getChanceservice();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("chances", chanceservice.getChances(id));
		request.setAttribute("listchancesplan",
				chanceservice.listChancesplan(id));

		return "SUCCESS";
	}
	
	/**
	 * 分页查询状态为1的记录
	 * @return
	 */
	public String queryListchances(){
		this.init();//初始化分页信息
		String hql="From Chances where state=1 order by id";
		pagebean=this.getChanceservice().queryListchances(hql,page,pagesize);
		pagebean.setAction("queryListchances");
		return "SUCCESS";
	}
	
	/**
	 * 查询状态为2，3，4的记录
	 * @return
	 */
	public String queryListchancesofplan(){
		this.init();//初始化分页信息
		String hql="From Chances where state in(2,3,4) order by id";
		pagebean=this.getChanceservice().queryListchances(hql,page, pagesize);
		pagebean.setAction("queryListchancesofplan");
		return "SUCCESS";
	}
	
	/**
	 * 根据输入来查询销售机会
	 * @return
	 */
	public String queryChancesbyform(){
		this.init();//初始化分页信息
		String hql="From Chances where state=1 ";
		if(chances.getName()!=null && chances.getName().length()>0){
			hql+=" and name like '%"+chances.getName()+"%' ";
		}
		if(chances.getContent()!=null && chances.getContent().length()>0){
			hql+=" and content like '%"+chances.getContent()+"%'";
		}
		pagebean=this.getChanceservice().queryListchances(hql,page,pagesize);
		
		return "SUCCESS";
	}
	
	public String queryChancesplanbyform(){
		this.init();//初始化分页信息
		String hql="From Chances where state in(2,3,4) ";
		if(chances.getName()!=null && chances.getName().length()>0){
			hql+=" and name like '%"+chances.getName()+"%' ";
		}
		if(chances.getContent()!=null && chances.getContent().length()>0){
			hql+=" and content like '%"+chances.getContent()+"%'";
		}
		if(chances.getManagername()!=null && chances.getManagername().length()>0){
			hql+=" and managername like '%"+chances.getManagername()+"%' ";
		}
		pagebean=this.getChanceservice().queryListchances(hql,page,pagesize);
		
		return "SUCCESS";
	}
}
