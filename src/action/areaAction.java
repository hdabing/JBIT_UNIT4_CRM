package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.struts.ActionSupport;

import com.opensymphony.xwork2.ActionContext;

import service.areaService;
import utils.pageBean;
import entity.Area;

public class areaAction extends ActionSupport {
	private areaService areaservice;
	private Area area;
	private int id;
	private int page;
	private int pagesize;
	private pageBean pagebean;
	
	/**
	 * 初始化分页信息
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

	public areaService getAreaservice() {
		return areaservice;
	}

	public void setAreaservice(areaService areaservice) {
		this.areaservice = areaservice;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String listArea() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listarea", this.getAreaservice().listArea());

		return "SUCCESS";
	}

	public String addArea() {
		return "SUCCESS";
	}

	public String addAreaOK() {
		this.getAreaservice().addArea(area);

		return "SUCCESS";
	}

	public String editArea() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("area", this.getAreaservice().getArea(id));
		return "SUCCESS";
	}

	public String editAreaOK() {
		this.getAreaservice().editArea(area);

		return "SUCCESS";
	}

	public String delArea() {
		this.getAreaservice().delArea(id);

		return "SUCCESS";
	}
	
	/**
	 * 分页查询地区
	 * @return
	 */
	public String queryListarea(){
		this.init();
		String hql="From Area where isdel=0 order by id";
		pagebean=areaservice.queryListarea(hql, page, pagesize);
		pagebean.setAction("queryListarea");
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listarea", pagebean.getList());
		
		return "SUCCESS";
	}
	
	/**
	 * 根据查询条件查询地区
	 * @return
	 */
	public String queryAreabyform(){
		this.init();
		String hql="From Area where isdel=0 ";
		if(area.getId()!=0){
			hql+=" and id="+area.getId();
		}
		if(area.getName()!=null && area.getName().length()>0){
			hql+=" and name like '%"+area.getName()+"%'";
		}
		hql+=" order by id";
		area.setId(0);//必须要把id清除，要不然下次还会读取上次的id值
		pagebean=areaservice.queryListarea(hql, page, pagesize);
		pagebean.setAction("queryAreabyform");
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listarea", pagebean.getList());
		
		return "SUCCESS";
	}
}
