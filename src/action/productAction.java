package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.struts.ActionSupport;

import service.productService;
import utils.pageBean;

import com.opensymphony.xwork2.ActionContext;

import entity.Product;

public class productAction extends ActionSupport {
	public Product product;
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
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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


	public productService getProductservice() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		return (productService) ac.getBean("productservice");
	}


	public String listProduct(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listproduct", this.getProductservice().listProduct());
		return "SUCCESS";
	}

	
	/**
	 * 分页查询商品信息
	 */
	public String queryListproduct(){
		this.init();
		HttpServletRequest request=ServletActionContext.getRequest();
		String hql="From Product order by id";
		pagebean=this.getProductservice().queryListproduct(hql, page, pagesize);
		pagebean.setAction("queryListproduct");
		request.setAttribute("listproduct", pagebean.getList());
		
		return "SUCCESS";
	}
	
	/**
	 * 分页查询商品信息
	 */
	public String queryListstore(){
		this.init();
		HttpServletRequest request=ServletActionContext.getRequest();
		String hql="From Product order by id";
		pagebean=this.getProductservice().queryListproduct(hql, page, pagesize);
		pagebean.setAction("queryListstore");
		request.setAttribute("listproduct", pagebean.getList());
		
		return "SUCCESS";
	}
	
	public String queryProductbyform(){
		this.init();
		HttpServletRequest request=ServletActionContext.getRequest();
		String hql="From Product ";
		int hqllen=hql.length();//用于对比hql是否为原始串
		if(product.getName()!=null && product.getName().length()>0){
			hql+=" where name like '%"+product.getName()+"%' ";
		}
		if(product.getModel()!=null && product.getModel().length()>0){
			if(hql.length()>hqllen){
				hql+=" and model like '%"+product.getModel()+"%' ";
			}else{
				hql+=" where model like '%"+product.getModel()+"%' ";
			}
		}
		if(product.getBatch()!=null && product.getBatch().length()>0){
			if(hql.length()>hqllen){
				hql+=" and batch like '%"+product.getBatch()+"%'";
			}else{
				hql+=" where batch like '%"+product.getBatch()+"%'";
			}
		}
		hql+=" order by id";
		pagebean=this.getProductservice().queryListproduct(hql, page, pagesize);
		pagebean.setAction("queryProductbyform");
		request.setAttribute("listproduct", pagebean.getList());
		
		return "SUCCESS";
	}
	
	public String queryStorebyform(){
		this.init();
		HttpServletRequest request=ServletActionContext.getRequest();
		String hql="From Product ";
		int hqllen=hql.length();//用于对比hql是否为原始串
		if(product.getName()!=null && product.getName().length()>0){
			hql+=" where name like '%"+product.getName()+"%' ";
		}
		if(product.getStorename()!=null && product.getStorename().length()>0){
			if(hql.length()>hqllen){
				hql+=" and storename like '%"+product.getStorename()+"%' ";
			}else{
				hql+=" where storename like '%"+product.getStorename()+"%' ";
			}
		}
		hql+=" order by id";
		pagebean=this.getProductservice().queryListproduct(hql, page, pagesize);
		pagebean.setAction("queryStorebyform");
		request.setAttribute("listproduct", pagebean.getList());
		
		return "SUCCESS";
	}
}
