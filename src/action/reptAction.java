package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.write.WriteException;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.struts.ActionSupport;

import service.customerService;
import service.customerlevelService;
import service.orderService;
import service.serviceService;
import utils.pageBean;

import com.itextpdf.text.DocumentException;
import com.opensymphony.xwork2.ActionContext;

import entity.Customer;
import entity.Orders;

public class reptAction extends ActionSupport {
	private serviceService serviceservice;
	private orderService orderservice;
	private customerService customerservice;
	private Orders orders;
	public Customer customer;
	private int page;
	private int pagesize;
	private pageBean pagebean;
	public String filename;
	public File upload;// 文件
	public String uploadContentType;// 文件格式
	public String uploadFileName;// 文件名

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

	public customerService getCustomerservice() {
		return customerservice;
	}

	public void setCustomerservice(customerService customerservice) {
		this.customerservice = customerservice;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public serviceService getServiceservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (serviceService) ac.getBean("serviceservice");
	}

	public void setServiceservice(serviceService serviceservice) {
		this.serviceservice = serviceservice;
	}

	public customerlevelService getCustomerlevelservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (customerlevelService) ac.getBean("customerlevelservice");
	}

	public orderService getOrderservice() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return (orderService) ac.getBean("orderservice");
	}

	public void setOrderservice(orderService orderservice) {
		this.orderservice = orderservice;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String contr3() {
		return "SUCCESS";
	}

	/**
	 * 客户贡献分析
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public String contr() {
		orderservice = this.getOrderservice();
		HttpServletRequest request = ServletActionContext.getRequest();

		List listorders = orderservice.listOrdersAmount();
		request.setAttribute("listorders", listorders);
		orderservice.reptCustomerAmount(request, listorders);

		return "SUCCESS";
	}

	/**
	 * 客户构成统计
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String cons() {
		orderservice = this.getOrderservice();
		HttpServletRequest request = ServletActionContext.getRequest();
		List listlevel = this.getCustomerlevelservice().countCutstomerlevel();
		request.setAttribute("listlevel", listlevel);
		this.getCustomerlevelservice().drawCountcustomerlevel(request,listlevel);

		return "SUCCESS";
	}

	/**
	 * 客户服务统计
	 */
	@SuppressWarnings("rawtypes")
	public String ser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		serviceservice = this.getServiceservice();
		List listservice = serviceservice.countService();
		request.setAttribute("listservice", listservice);
		serviceservice.drawCountService(request, listservice);

		return "SUCCESS";
	}

	/**
	 * 分页查询客户贡献统计
	 * 
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public String queryListordersamount() throws DocumentException, IOException {
		this.init();
		String hql = "select b.name,sum(amount) from orders a left join customer b on a.customerid=b.id group by b.name";
		pagebean = this.getOrderservice().queryListordersamount(hql, page,
				pagesize);
		pagebean.setAction("queryListordersamount");
		HttpServletRequest request = ServletActionContext.getRequest();
		this.getOrderservice().reptCustomerAmount(request, pagebean.getList());
		request.setAttribute("listorders", pagebean.getList());
		this.getCustomerservice().excelContr(request,pagebean.getList());
		this.getCustomerservice().pdfContr(request, pagebean.getList());

		return "SUCCESS";
	}

	/**
	 * 分页查询客户贡献统计,有查询条件
	 * 
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public String queryContrbyform() throws DocumentException, IOException {
		this.init();
		String hql = "select b.name,sum(amount) from orders a left join customer b on a.customerid=b.id ";
		if (customer.getName() != null && customer.getName().length() > 0) {
			hql += " where b.name like '%" + customer.getName() + "%' ";
		}
		hql += " group by b.name ";

		pagebean = this.getOrderservice().queryListordersamount(hql, page,pagesize);
		pagebean.setAction("queryContrbyform");
		HttpServletRequest request = ServletActionContext.getRequest();
		this.getOrderservice().reptCustomerAmount(request, pagebean.getList());
		request.setAttribute("listorders", pagebean.getList());
		this.getCustomerservice().excelContr(request,pagebean.getList());
		this.getCustomerservice().pdfContr(request, pagebean.getList());
		
		return "SUCCESS";
	}
	
	/**
	 * 下载客户贡献文件
	 * @return
	 */
	public String downLoadContr() {
		return "SUCCESS";
	}

	/**
	 * 下载客户贡献文件流
	 * @return
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("deprecation")
	public InputStream getDownLoadContrStream() throws FileNotFoundException {
		String filepath=ServletActionContext.getRequest().getRealPath("/")+"rept\\"+this.filename;
		return new FileInputStream(filepath);
	}

	/**
	 * 获取客户贡献PDF文件
	 * @return
	 */
	public String downLoadPDFContr(){
		return "SUCCESS";
	}
	/**
	 * 获取客户贡献PDF文件输入流
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public InputStream getDownLoadPDFContrStream() throws FileNotFoundException{
		String filepath=ServletActionContext.getRequest().getRealPath("/")+"rept/"+this.filename;
		FileInputStream fis=new FileInputStream(filepath);
		return fis;
	}
	
	/**
	 * 获取客户服务统计PDF文件，利用客户贡献PDF文件输入流来输出
	 * @return
	 */
	public String downLoadPDFSer(){
		return "SUCCESS";
	}
	
	/**
	 * 获取客户等级统计PDF文件，利用客户贡献PDF文件输入流来输出
	 * @return
	 */
	public String downLoadPDFCountlevel(){
		return "SUCCESS";
	}
	/**
	 * 分页查询服务统计
	 * @return
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws DocumentException 
	 */
	public String queryListservicelistCount() throws WriteException, IOException, DocumentException {
		this.init();
		String hql = "select b.name,count(serviceid) from servicelist a"
				+ " left join service b" + " on a.serviceid=b.id"
				+ " group by b.name";
		pagebean = this.getServiceservice().queryListservicelistCount(hql,
				page, pagesize);
		HttpServletRequest request = ServletActionContext.getRequest();
		this.getServiceservice().drawCountService(request, pagebean.getList());
		request.setAttribute("listservice", pagebean.getList());
		this.serviceservice.excelSer(request, pagebean.getList());
		this.serviceservice.PdfSer(request, pagebean.getList());
		
		return "SUCCESS";
	}

	
	/**
	 * 客户服务分析excel下载
	 * @return
	 */
	public String downLoadSer(){
		return "SUCCESS";
	}
	/**
	 * 客户服务分析excel文件流
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("deprecation")
	public InputStream getDownLoadSerStream() throws FileNotFoundException{
		String filepath=ServletActionContext.getRequest().getRealPath("/")+"rept/"+this.filename;
		FileInputStream fis=new FileInputStream(filepath);
		return fis;
	}

	/**
	 * 分页查询客户构成统计
	 * 
	 * @return
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws DocumentException 
	 */
	public String queryListcustomercount() throws WriteException, IOException, DocumentException {
		this.init();
		pagebean = this.getCustomerlevelservice().queryListcustomercount(page,
				pagesize);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listlevel", pagebean.getList());
		this.getCustomerlevelservice().drawCountcustomerlevel(request,pagebean.getList());
		this.getCustomerlevelservice().excelCountlevel(request, pagebean.getList());
		this.getCustomerlevelservice().pdfCountlevel(request,pagebean.getList());
		
		return "SUCCESS";
	}

	/**
	 * 用来下载客户等级统计excel
	 */
	public String downLoadCountlevel(){
		return "SUCCESS";
	}
	@SuppressWarnings("deprecation")
	public InputStream getDownLoadCountlevelStream() throws FileNotFoundException{
		String filepath=ServletActionContext.getRequest().getRealPath("/")+"rept/"+this.filename;
		FileInputStream fis=new FileInputStream(filepath);
		return fis;
	}
}
